package spittr.web;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import spittr.Spitter;
import spittr.data.SpitterRepository;


public class SpitterControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/register"))
		.andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception{
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		Spitter unsaved = new Spitter("sushant", "24hours", "Sushant", "Agrawal","sushant@gmail.com");
		Spitter saved  = new Spitter(24L, "sushant", "24hours", "Sushant", "Agrawal","sushant@gmail.com");
		when(mockRepository.save(unsaved)).thenReturn(saved);
		
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/spitter/register")
				.param("firstName", "Sushant")
				.param("lastName", "Agrawal")
				.param("username", "sushant")
				.param("password", "24hours")
				.param("email", "sushant@gmail.com"))
		.andExpect(redirectedUrl("/spitter/sushant"));
		
		verify(mockRepository, atLeastOnce()).save(unsaved);
	}
}
