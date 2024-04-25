package com.ksi.tiakktiakk.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.ksi.tiakktiakk.repository.UtilisateurRepository;
import java.util.*;
import com.ksi.tiakktiakk.model.Utilisateur;

public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Autowired
    public List<Utilisateur> getAllUtilisateurs() {;
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        Optional
        <Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        return optionalUtilisateur.orElse(null);
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public boolean updateUtilisateur(Long id, Utilisateur utilisateur) {
        if (utilisateurRepository.existsById(id)) {
            utilisateur.setId(id); // Assurez-vous que l'ID de l'utilisateur correspond à l'ID fourni
            utilisateurRepository.save(utilisateur);
            return true;
        }
        return false;
    }

    public boolean deleteUtilisateur(Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

