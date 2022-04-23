package com.nitech.digital.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.nitech.digital.dto.ContactInsertDto;
import com.nitech.digital.service.ContactService;

@ExtendWith(MockitoExtension.class)
public class TestContactController {
	
	@InjectMocks
	ContactController contactController;
	
	@Mock
	ContactService mockedContactService;
	
	//private final Contact contactMock = new Contact();
	private final ContactInsertDto contactInsertDtoMock = new ContactInsertDto();
	
	@BeforeEach
	void init() {
		contactInsertDtoMock.setEmail("email@email.com");
		contactInsertDtoMock.setName("Nome da Silva");
		contactInsertDtoMock.setPhone("558199847856");
		contactInsertDtoMock.setMessage("Message");
	}
	
	@Test
	public void contactRegister() {
		when(mockedContactService.insertContact(contactInsertDtoMock))
		.thenReturn(contactInsertDtoMock);
		
		final ResponseEntity<?> result = contactController.saveContact(contactInsertDtoMock);
		
		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
		Assertions.assertEquals(contactInsertDtoMock, result.getBody());
		
	}

}
