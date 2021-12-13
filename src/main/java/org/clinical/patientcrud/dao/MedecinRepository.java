package org.clinical.patientcrud.dao;

import org.clinical.patientcrud.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
