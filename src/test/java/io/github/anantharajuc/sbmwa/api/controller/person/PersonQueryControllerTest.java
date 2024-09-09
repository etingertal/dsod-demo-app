package io.github.anantharajuc.sbmwa.api.controller.person;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.infra.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.service.impl.PersonServiceImpl;

import static org.mockito.ArgumentMatchers.anyLong;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonQueryControllerTest 
{
	@Autowired
	private MockMvc mockMvc; 
	
	@MockBean
	private PersonServiceImpl personServiceImpl;
	
	@Test
	void getPerson_forSavedPerson_isReurned() throws Exception
	{
		//given
		BDDMockito.given(personServiceImpl.getPersonById(anyLong())).willReturn(Person.builder().name("john controller").build());
		
		//when //then
		mockMvc
		.perform(get("/api/persons/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("name").value("john controller"));		
	} 
	
	@Test
	void getPerson_forMissingPerson_status404() throws Exception
	{
		//given
		BDDMockito.given(personServiceImpl.getPersonById(anyLong())).willThrow(ResourceNotFoundException.class);
		
		//when //then
		mockMvc
		.perform(get("/api/persons/1"))
		.andDo(print())
		.andExpect(status().isNotFound());
	}
}
