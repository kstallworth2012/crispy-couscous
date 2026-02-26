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

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.services.ActivitiesService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@WebMvcTest(controllers = ActivitiesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ActivitiesControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc; 
	
//	@MockitoBean //instead ofMockBean
//	ActivitiesService activityService;
	
	@Test
    @DisplayName("Create Activity")
    void testCreate() {
		//Arrange 
//		
//		ActivitiesEntity testActivity = new ActivitiesEntity();
//		testActivity.setActivity_id(UUID.randomUUID());
//		
//		MockMvcRequestBuilders.post("/activities")
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON)
//					.content(new ObjectMapper().writeValueAsString(getClass()));
		
	}
}
