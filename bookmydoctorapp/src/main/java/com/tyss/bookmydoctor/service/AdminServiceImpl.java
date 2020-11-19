package com.tyss.bookmydoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.bookmydoctor.dao.AdminDAO;
import com.tyss.bookmydoctor.entities.Appointment;
import com.tyss.bookmydoctor.entities.Doctor;
import com.tyss.bookmydoctor.entities.Patient;
import com.tyss.bookmydoctor.exception.BookMyDoctorException;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDao;
	
	public Doctor addDoctor(Doctor doctor) {
		
		Doctor addDoctor = adminDao.addDoctor(doctor);
		if(addDoctor!=null) {
			return addDoctor;
		} else {
			throw new BookMyDoctorException("Unable to add doctor");
		} 
	}

	
	public Doctor removeDoctor(int id) {
		Doctor deleteDoctor = adminDao.removeDoctor(id);
		if(deleteDoctor!=null) {
			return deleteDoctor;
		} else {
			throw new BookMyDoctorException("Invalid doctor emailId ");
		} 
	}

	
	public Patient removePatient(int id) {
				Patient deletePatient = adminDao.removePatient(id);
				if(deletePatient!=null) {
					return deletePatient;
				} else {
					throw new BookMyDoctorException("Invalid patient emailId");
				}
	}

	
	public List<Appointment> viewAllAppointments() {
		
		List<Appointment> viewAppointments = adminDao.viewAllAppointments();
		if(viewAppointments!=null) {
			return viewAppointments;
		} else {
			throw new BookMyDoctorException("Unable to fetch all appointments");
		}
	}

	
	public Doctor updateDoctor(Doctor doctor) {
		Doctor updateDoctor = adminDao.updateDoctor(doctor);
		if(updateDoctor!=null) {
			return updateDoctor;
		} else {
			throw new BookMyDoctorException("Unable to update doctor");
		}
	
	}

	
	public Patient updatePatient(Patient patient) {
		Patient updatePatient = adminDao.updatePatient(patient);
		if(updatePatient!=null) {
			return updatePatient;
		} else {
			throw new BookMyDoctorException("Unable to update patient");
		}
		 
	}

	
	public List<Doctor> getAllDoctor() {
		
		List<Doctor> getDoctors = adminDao.getAllDoctor();
		if(getDoctors!=null) {
			return getDoctors;
		} else {
			throw new BookMyDoctorException("Unable to fetch all doctors info");
		}
	}

	
	public List<Patient> getAllPatient() {
		List<Patient> getPatients = adminDao.getAllPatient();
		if(getPatients!=null) {
			return getPatients;
		} else {
			throw new BookMyDoctorException("Unable to fetch all patients info");
		}
	}

	
	public Appointment removeAppointment(int appointmentId) {
		
		Appointment delAppointment = adminDao.removeAppointment(appointmentId);
		if(delAppointment!=null) {
			return delAppointment;
		} else {
			throw new BookMyDoctorException("Invalid appointmentId");
		}
	}

	public List<Appointment> viewAllAppointment(Appointment appointment) {
		List<Appointment> viewAppointments = adminDao.viewAllAppointments();
		if(viewAppointments!=null) {
			return viewAppointments;
		} else {
			throw new BookMyDoctorException("Unable to fetch all appointments");
		}
	}

}
