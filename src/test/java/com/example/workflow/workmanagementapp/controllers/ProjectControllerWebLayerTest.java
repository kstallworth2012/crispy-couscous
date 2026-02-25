package com.example.workflow.workmanagementapp.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ProjectsController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProjectControllerWebLayerTest {

	
	
	@Test
    @DisplayName("Create Project")
    void testCreate() {
		//Arrange 
		MockMvcRequestBuilders.post("/projects")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(getClass()));
}
