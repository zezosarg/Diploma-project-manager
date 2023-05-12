package diplomaProjectManager.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import diplomaProjectManager.model.Student;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
    private WebApplicationContext context;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	StudentController studentController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testSaveProfile() throws Exception {

		Student student = new Student(100);

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("id", Integer.toString(student.getId()));
	    
		mockMvc.perform(
				post("/student/save")
			    .params(multiValueMap))
				.andExpect(status().isFound())
				.andExpect(view().name("redirect:/student/dashboard"));
		
	}//TODO

}
