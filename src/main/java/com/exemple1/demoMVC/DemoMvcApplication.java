package com.exemple1.demoMVC;

import com.exemple1.demoMVC.entities.Patient;
import com.exemple1.demoMVC.services.PatientServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMvcApplication.class, args);
	}



	CommandLineRunner commandLineRunner(PatientServicesImp patientServices){
		return args -> {
			patientServices.save(new Patient(null,"AHMAD",200,new Date(),true));
			patientServices.save(new Patient(null,"KARIM",100,new Date(),false));
		    patientServices.save(new Patient(null,"IMANE",130,new Date(),true));
			patientServices.save(new Patient(null,"LAILA",130,new Date(),true));

		};
	}

}
