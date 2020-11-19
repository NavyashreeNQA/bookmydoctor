package com.tyss.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.bookmydoctor.dto.ResponseDTO;
import com.tyss.bookmydoctor.entities.Appointment;
import com.tyss.bookmydoctor.entities.Doctor;
import com.tyss.bookmydoctor.service.DoctorService;

@RestController
@RequestMapping("/doctor-profile")
public class DoctorController {
	@Autowired
	private DoctorService docService;
	
	@PostMapping("/doctor")
	public ResponseDTO getDoctor(@RequestBody Doctor doctor) {
		ResponseDTO response=new ResponseDTO();
		response.setData(docService.addDoctor(doctor));
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseDTO updateDoctor(@RequestBody Doctor doctor) {
		ResponseDTO response=new ResponseDTO();
		response.setData(docService.updateDoctor(doctor));
		return response;
	}
	
	@DeleteMapping("/doctor/{doctorId}")
	public ResponseDTO removeDoctor(@PathVariable int doctorId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(docService.removeDoctor(doctorId));
		return response;
	}
	
	@GetMapping("/ratings")
	public ResponseDTO getAllRatings() {
		ResponseDTO response=new ResponseDTO();
		response.setData(docService.getAllRatings());
		return response; 
		 
	}
	
	@GetMapping("/appointments")
	public ResponseDTO getAllScheduledAppointment(){
		 ResponseDTO response=new ResponseDTO();
		 response.setData(docService.getAllScheduledAppointment());
		 return response;
		 
	}
	
	@PutMapping("/availability/{id}")
	 public ResponseDTO updateAvailability(Appointment availability) {
		ResponseDTO response=new ResponseDTO();
		response.setData(docService.updateAvailability(availability));
		return response;
		 
	 }
}
