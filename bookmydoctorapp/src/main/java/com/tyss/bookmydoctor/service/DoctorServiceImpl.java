package com.tyss.bookmydoctor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.bookmydoctor.dao.DoctorDAO;
import com.tyss.bookmydoctor.entities.*;
import com.tyss.bookmydoctor.exception.BookMyDoctorException;
@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorDAO doctorDao;
	
	public Doctor addDoctor(Doctor doctor) {
		Doctor addDoctor = doctorDao.addDoctor(doctor);
		if(addDoctor!=null) {
			return addDoctor;
		} else {
			throw new BookMyDoctorException("Unable to add doctor");
		}
			
	}

	
	public Doctor updateDoctor(Doctor doctor) {
		
		Doctor updateDoctor = doctorDao.updateDoctor(doctor);
		if(updateDoctor!=null) {
			return updateDoctor;
		} else {
			throw new BookMyDoctorException("Unable to update doctor");
		}
	}

	
	public Doctor removeDoctor(int doctorId) {
	Doctor delDoctor = doctorDao.removeDoctor(doctorId);
		if(delDoctor!=null) {
			return delDoctor;
		} else {
			throw new BookMyDoctorException("Invalid doctorId");
		}
		
	}

	
	public List<RatingDetails> getAllRatings() {
		
		List<RatingDetails> ratingDetails = doctorDao.getAllRating();
		if(ratingDetails!=null) {
			return ratingDetails;
		} else {
			throw new BookMyDoctorException("Ratings is not available");
		}
	}

	
	public List<Appointment> getAllScheduledAppointment() {
		
		 List<Appointment> scheduledAppointments = doctorDao.getAllScheduledAppointment();
		if(scheduledAppointments!=null) {
			return scheduledAppointments;
		} else {
			throw new BookMyDoctorException("There is no appointment scheduled");
		}
	}

	
	public Appointment updateAvailability(Appointment availability) {
		
		Appointment updateavailability = doctorDao.updateAppointment(availability);
		if(updateavailability!=null) {
			return updateavailability;
		} else {
			throw new BookMyDoctorException("Unable to update doctor's availability");
		}
	}

	
	public List<DueDays> updateTimeslot(Date timeslotFrom, Date timeslotTo) {
		
		List<DueDays> updateTimeslot = doctorDao.updateTimeslot(timeslotFrom, timeslotTo);
		if(updateTimeslot!=null) {
			return updateTimeslot;
		} else {
			throw new BookMyDoctorException("Unable to update timeslot");
		}
	}


	
}
