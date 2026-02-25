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

import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;
import com.example.workflow.workmanagementapp.services.AssignmentsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = AssignmentsController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AssignmentControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc; 
	
	@MockitoBean //instead ofMockBean
	AssignmentsService assignmentService;
	
	@Test
    @DisplayName("Create Team")
    void testCreate() {
		//Arrange
		AssignmentsEntity testAssignments =new AssignmentsEntity();
		testAssignments.setAssignment_id(UUID.randomUUID());
		
		
		MockMvcRequestBuilders.post("/assignments")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(getClass()));
		}
	}
