package org.clinical.patientcrud.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Participant {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PatientID;
	private String nom;
	private String prenom;
	private String sexe;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date dateNaissance;
	private int age;
	private String adresse;
	private Boolean malade;
	@OneToMany(mappedBy="participant")
	private Collection<RendezVous> rendezVous;

}
