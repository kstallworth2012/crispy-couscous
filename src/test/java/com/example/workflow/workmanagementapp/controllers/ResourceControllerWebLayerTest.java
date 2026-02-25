package com.example.workflow.workmanagementapp.controllers;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.workflow.workmanagementapp.domain.dto.ResourcesDTO;
import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;
import com.example.workflow.workmanagementapp.services.ResourceService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ResourcesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ResourceControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc; 
	
	@MockitoBean //instead ofMockBean
	ResourceService resourceService;
	
	
	@Test
    @DisplayName("Create Resource")
    void testCreate() throws Exception {
		//Arrange 
		ResourcesEntity testResource = new ResourcesEntity();
		testResource.setResource_id(UUID.randomUUID());
		testResource.setResource_name("John Dojo");
		testResource.setResource_type("Labor");
		testResource.setAvailability("Today");
		testResource.setCost_per_day(299.99);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/resources")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(testResource));
		
		//Act
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String responseBodyAsString = mvcResult.getResponse().getContentAsString(); 
		ResourcesDTO createdResource = new ObjectMapper().
						readValue(responseBodyAsString, ResourcesDTO.class);
	
	   //Assert
		Assertions.assertEquals(testResource.getResource_name(),
				createdResource.getResource_name(),"THE NAMES DON'T MATCH");
		Assertions.assertFalse(createdResource.getResource_id().equals(null),"Should not be false");
	}
}
