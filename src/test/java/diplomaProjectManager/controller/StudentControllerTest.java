package diplomaProjectManager.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
    private WebApplicationContext context;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	StudentController studentController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testListStudentSubjects() throws Exception {
		Mockito.when(studentController.getCurrentPrincipal()).thenReturn("liakos");
		
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		
		mockMvc.perform(
				get("/student/subjects")
			    .params(multiValueMap))
				.andExpect(status().isOk())
				.andExpect(view().name("student/subjects"));

	}

}
