package com.example.workflow.workmanagementapp.mappers;

import org.springframework.stereotype.Component;

public interface Mapper<A, B> {

	
	
	B mapTo(A a);
	
	A mapFrom(B b);
	
}