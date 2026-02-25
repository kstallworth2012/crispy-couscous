package com.example.workflow.workmanagementapp.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.workflow.workmanagementapp.domain.entities.TeamsEntity;
import com.example.workflow.workmanagementapp.services.TeamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = TeamsController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TeamControllerWebLayerTest {
	
	@Autowired
	private MockMvc mockMvc; 
	
	@MockitoBean //instead ofMockBean
	TeamService teamService;
	
	@Test
    @DisplayName("Create Team")
    void testCreate() throws JsonProcessingException {
		//Arrange 
		
		TeamsEntity testTeams = new TeamsEntity();
		testTeams.setTeam_name("Test Team One");
		
		
		MockMvcRequestBuilders.post("/teams")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(getClass()));
		//Act
		
		
		//Assert
	}

}
