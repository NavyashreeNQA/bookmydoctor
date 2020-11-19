package com.tyss.bookmydoctor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.tyss.bookmydoctor.entities.Appointment;
import com.tyss.bookmydoctor.entities.Doctor;
import com.tyss.bookmydoctor.entities.Patient;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Transactional
	public Doctor addDoctor(Doctor doctor) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		manager.persist(doctor);
		manager.getTransaction().commit();
		manager.close();
		return doctor;
	}
	
	public Doctor removeDoctor(int id) {
	
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Doctor doctor = manager.find(Doctor.class, id);
		manager.remove(doctor);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return doctor;
	}
	
	public Patient removePatient(int id) {
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Patient deletePatient = manager.find(Patient.class, id);
		manager.remove(deletePatient);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return deletePatient;
		
	}
	
	public List<Appointment> viewAllAppointments(){
		
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Appointment> query = manager.createQuery("FROM Appointment", Appointment.class);
		return query.getResultList();
	}
	
	public Doctor updateDoctor(Doctor doctor) {
	
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Doctor updateDoctor = manager.find(Doctor.class, doctor.getDoctorId());
		BeanUtils.copyProperties(doctor, updateDoctor);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return updateDoctor;
		
	}
	
	
	
	public Patient updatePatient(Patient updatePatient) {
	
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Patient updatedPatient = manager.find(Patient.class, updatePatient.getPatientId());
		BeanUtils.copyProperties(updatePatient, updatePatient);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return updatedPatient;

	}
	

	public List<Doctor> getAllDoctor(){
		
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Doctor> query = manager.createQuery("FROM Doctor", Doctor.class);
		return query.getResultList();
	}
	
	
	public List<Patient> getAllPatient(){
	
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Patient> query = manager.createQuery("FROM Patient", Patient.class);
		return query.getResultList();
	}
	
	
	public Appointment removeAppointment(int appointmentId) {
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Appointment deleteAppointment = manager.find(Appointment.class, appointmentId);
		manager.remove(deleteAppointment);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return deleteAppointment;
	}

	

	


}