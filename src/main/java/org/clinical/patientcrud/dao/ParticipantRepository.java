package org.clinical.patientcrud.dao;

import org.clinical.patientcrud.entities.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	public Page<Participant> findByNomContains(String mc, Pageable pageable);

}
