package com.nitech.digital.controller;


import com.nitech.digital.dto.ContactInsertDto;
import com.nitech.digital.service.ContactService;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/api/contact")
    public ResponseEntity<?> saveContact(@RequestBody ContactInsertDto contactInsertDto){
    	return ResponseEntity.status(HttpStatus.CREATED).body(this.contactService.insertContact(contactInsertDto));
    }

    
    @GetMapping("")
    public ResponseEntity<?> getContact(){
        return ResponseEntity.ok("O teste foi concluido com exito!");
    }
}





















