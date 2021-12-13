package org.clinical.patientcrud.dao;

import org.clinical.patientcrud.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
