package com.nitech.digital.service;

import com.nitech.digital.domain.Contact;
import com.nitech.digital.dto.ContactInsertDto;
import com.nitech.digital.email.EmailValidation;
import com.nitech.digital.exception.EmailNotValidException;
import com.nitech.digital.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import org.modelmapper.ModelMapper;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public ContactInsertDto insertContact(ContactInsertDto contactInsertDto){
    	EmailValidation emailValidation = new EmailValidation();
    	
    	if(emailValidation.validEmail(contactInsertDto.getEmail())) {
    		Contact contact = new ModelMapper().map(contactInsertDto, Contact.class);
            contact.setDateContact(new Date());            
            contactRepository.save(contact);
            return new ModelMapper().map(contact, ContactInsertDto.class);    		   		
    	}else{
    		throw new EmailNotValidException("Email: "+contactInsertDto.getEmail()+" not valid");
    	}   
    	 
    }
}
