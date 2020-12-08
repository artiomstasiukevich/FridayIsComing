import com.alcoproj.controllers.LoginController;
import com.alcoproj.model.User;
import com.alcoproj.service.UserCredentialsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = LoginController.class)
public class DBControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserCredentialsService userCredentialsService;

    @Test
    public void TestUserRegistration() throws Exception {
        mvc.perform(post("/registration")
                .contentType(objectMapper
                        .writeValueAsString(
                                new User())))
                .andExpect(status().isCreated());
    }
}