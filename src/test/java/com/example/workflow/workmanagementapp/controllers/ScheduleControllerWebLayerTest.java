package com.example.workflow.workmanagementapp.controllers;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.workflow.workmanagementapp.domain.dto.ResourcesDTO;
import com.example.workflow.workmanagementapp.domain.dto.SchedulesDTO;
import com.example.workflow.workmanagementapp.domain.entities.SchedulesEntity;
import com.example.workflow.workmanagementapp.services.ScheduleService;
import com.example.workflow.workmanagementapp.services.impl.ScheduleServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = SchedulesController.class)
@AutoConfigureMockMvc(addFilters = false)
//@MockitoBean(ScheduleServiceImpl.class)
public class ScheduleControllerWebLayerTest {
	
	@Autowired
	private MockMvc mockMvc; 
	
	@MockitoBean //instead ofMockBean
	ScheduleService scheduleService;
	
	
	@Test
    @DisplayName("Create Schedule")
    void testCreate() throws Exception { // NOT A GOOD IDEA TO THROW GENERIC EXCEPTIONS
		//Arrange 
		SchedulesEntity testSchedule = new SchedulesEntity();
		testSchedule.setSchedule_id(UUID.randomUUID());
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/schedules")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(testSchedule));
		
		//Act
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String responseBodyAsString = mvcResult.getResponse().getContentAsString(); 
		SchedulesDTO createdResource = new ObjectMapper().
						readValue(responseBodyAsString, SchedulesDTO.class);
		
	}
	
	
	
}
