package org.example.ex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionTest {
    //@Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void should_return_400_if_param_not_valid() throws Exception {
        mvc.perform(get("/api/illegalArgumentException"))
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("参数错误!"));
    }

    @Test
    public void should_return_404_if_resourse_not_found() throws Exception {
        mvc.perform(get("/api/resourceNotFoundException"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.message").value("Sorry, the resourse not found!"));
    }
}
