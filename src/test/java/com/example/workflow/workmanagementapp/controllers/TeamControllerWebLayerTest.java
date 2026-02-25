package com.example.workflow.workmanagementapp.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = TeamsController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TeamControllerWebLayerTest {
	
	
	
	@Test
    @DisplayName("Create Team")
    void testCreate() {
		//Arrange 
		MockMvcRequestBuilders.post("/teams")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(getClass()));
		//Act
		
		
		//Assert
	}

}
