package com.example.workflow.workmanagementapp.controllers;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers = ActivitiesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ActivitiesControllerWebLayerTest {

}
