package com.example.workflow.workmanagementapp.controllers;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;
import com.example.workflow.workmanagementapp.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ProjectsController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProjectControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc; 
	
	@MockitoBean //instead ofMockBean
	ProjectService projectService;
	
	@Test
    @DisplayName("Create Project")
    void testCreate() {
		//Arrange 
//		ProjectsEntity testProject = new ProjectsEntity();
//		testProject.setProject_id(UUID.randomUUID());
//		
//		
//		MockMvcRequestBuilders.post("/projects")
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON)
//					.content(new ObjectMapper().writeValueAsString(getClass()));
	}
}
