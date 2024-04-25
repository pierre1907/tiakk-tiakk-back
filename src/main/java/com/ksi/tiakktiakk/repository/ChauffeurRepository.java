package com.ksi.tiakktiakk.repository;

import com.ksi.tiakktiakk.model.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
}
