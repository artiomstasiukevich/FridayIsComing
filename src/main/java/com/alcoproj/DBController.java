package com.alcoproj;

import com.alcoproj.model.User;
import com.alcoproj.model.UserCredentials;
import com.alcoproj.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DBController {
    private final UserCredentialsService userCredentialsService;

    @Autowired
    public DBController(UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<?> create(@RequestBody User user) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setEmail(user.getEmail());
        userCredentials.setPassword(user.getPassword().hashCode());
        userCredentials.setUser(user);
        userCredentialsService.add(userCredentials);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> read(@RequestParam(name = "email") String email,
                                  @RequestParam(name = "password") String password) {
        try {
            authorization(email, password.hashCode());
            return new ResponseEntity<>(userCredentialsService.getByEmail(email).getUser(), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PutMapping(value = "/users/update")
    public ResponseEntity<?> update(@RequestBody User user,
                                    @RequestParam(name = "email") String email,
                                    @RequestParam(name = "password") String password) {
        try {
            authorization(email, password.hashCode());
            UserCredentials userCredentials = userCredentialsService.getByEmail(email);
            userCredentials.setPassword(user.getPassword().hashCode());
            userCredentials.updateUser(user);
            userCredentialsService.edit(userCredentials);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(value = "/users/delete")
    public ResponseEntity<?> delete(@RequestParam(name = "email") String email,
                                    @RequestParam(name = "password") String password) {
        try {
            authorization(email, password.hashCode());
            userCredentialsService.delete(
                    userCredentialsService.getByEmail(email));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    private void authorization(String email, int hashPassword) {
        try {
            UserCredentials userCred = userCredentialsService.getByEmail(email);
            if (hashPassword != userCred.getPassword()) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }
}
