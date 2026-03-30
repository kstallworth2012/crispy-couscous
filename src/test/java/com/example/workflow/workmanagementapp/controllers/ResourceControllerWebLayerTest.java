package com.example.workflow.workmanagementapp.controllers;

import static org.assertj.core.api.Assertions.fail;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.workflow.workmanagementapp.domain.dto.ResourcesDTO;
import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;
import com.example.workflow.workmanagementapp.services.ResourceService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ResourcesController.class,
excludeAutoConfiguration = {SecurityAutoConfiguration.class})
//@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ResourceControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc; 
	
	@MockitoBean //instead ofMockBean
	ResourceService resourceService;
	ModelMapper mapper;
	
	@BeforeEach
	public void setup() {
	    this.mapper = new ModelMapper();
	}
	
//	public ResourceControllerWebLayerTest(MockMvc mockMvc, ResourceService resourceService) {
//		this.mockMvc = mockMvc;
//		this.resourceService = resourceService;
//	}


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

		
		//fail("wtf is up");
        String resourceJson = new ObjectMapper().writeValueAsString(testResource);
        fail("wtf is up==================="+resourceJson);
        System.out.println("============================="+resourceJson+"=============================");        
        mockMvc.perform(
                MockMvcRequestBuilders.post("/new-resource")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(resourceJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

	}
}
