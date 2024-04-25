package com.ksi.tiakktiakk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksi.tiakktiakk.model.*;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long>{
    
}
