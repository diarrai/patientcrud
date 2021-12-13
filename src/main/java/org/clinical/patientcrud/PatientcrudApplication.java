package org.clinical.patientcrud;

import java.util.Date;

import org.clinical.patientcrud.dao.MedecinRepository;
import org.clinical.patientcrud.dao.ParticipantRepository;
import org.clinical.patientcrud.entities.Medecin;
import org.clinical.patientcrud.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientcrudApplication implements CommandLineRunner {
	@Autowired
	ParticipantRepository participantRepository;
	@Autowired
	MedecinRepository medecinRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientcrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		participantRepository.save(new Participant(null,"Diarra", "Ibrahim","M",new Date(), 35,"Tentout",false, null));
		participantRepository.save(new Participant(null,"Tangara","Aminata","F",new Date(), 25,"Ouodjoumabougou",false, null));
		participantRepository.save(new Participant(null,"Coulibaly","Adam","",new Date(), 15,"Korembougou",true, null));
		participantRepository.save(new Participant(null,"Coulibaly","Fatoumata","",new Date(), 20,"Bamako",true, null));
		medecinRepository.save(new Medecin(null,"Dr Ibrahim Soumbounou","Medecin generaliste","amir@icermali.org", null));
		medecinRepository.save(new Medecin(null,"Dr Gaoussou Santara","Pediatre","gsantara@icermali.org", null));
		medecinRepository.save(new Medecin(null,"Dr Moussa Traore","Medecin generaliste","moussa.t@icermali.org", null));
		//Ce code ci-dessous permet d'afficher la liste des participants
		participantRepository.findAll().forEach(p->{
			System.out.println(p.getNom());
			System.out.println(p.getPrenom());
		});
		
		
	}

}
