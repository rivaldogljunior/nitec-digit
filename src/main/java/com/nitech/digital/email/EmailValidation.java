package com.nitech.digital.email;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class EmailValidation {
	
	public boolean validEmail(String email) {
		boolean valid = true;
		try {
			InternetAddress emailAddress = new InternetAddress(email);
			emailAddress.validate();
		}catch(AddressException e) {
			return false;
		}
		return valid;
	}

}
