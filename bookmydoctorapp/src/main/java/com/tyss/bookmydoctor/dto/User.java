package com.tyss.bookmydoctor.dto;
import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class User implements Serializable {
	
	private String role;
	private  String email;
	private String password;
	private int phone;
}