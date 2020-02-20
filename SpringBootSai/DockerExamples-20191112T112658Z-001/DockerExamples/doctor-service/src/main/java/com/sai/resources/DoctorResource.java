package com.sai.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.entities.Doctor;
import com.sai.services.DoctorService;

@RestController
public class DoctorResource {

	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/doctor")
	public Doctor getDoctorByName(@RequestParam("name") String name) {
		return doctorService.fetchDoctorByName(name);
	}
	
	@GetMapping("/all")
	public List<String> getDoctors(){
		List<Doctor> doctorList = doctorService.fetchDoctors();
		List<String> doctorDetails = new ArrayList<>();
		for(Doctor doctor: doctorList) {
			doctorDetails.add(doctor.getName()+", "+doctor.getSpecialization());
		}
		return doctorDetails;
	}
	
}
