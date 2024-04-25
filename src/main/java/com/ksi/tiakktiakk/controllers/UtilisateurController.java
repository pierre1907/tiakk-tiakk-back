package com.ksi.tiakktiakk.controllers;

import com.ksi.tiakktiakk.validator.*;
import com.ksi.tiakktiakk.services.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ksi.tiakktiakk.model.Utilisateur;
import com.ksi.tiakktiakk.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurValidator utilisateurValidator;

    // Endpoint pour créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<?> creerUtilisateur(@Valid @RequestBody Utilisateur utilisateur, BindingResult result) {
        utilisateurValidator.validate(utilisateur, result);
        if (result.hasErrors()) {
            return new ResponseEntity<>("Erreur de validation", HttpStatus.BAD_REQUEST);
        }

        Utilisateur nouveauUtilisateur = utilisateurRepository.save(utilisateur);
        return new ResponseEntity<>(nouveauUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getUtilisateurs() {
        return new ResponseEntity<>(utilisateurRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
        boolean updated = utilisateurService.updateUtilisateur(id, utilisateur);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable("id") Long id) {
        boolean deleted = utilisateurService.deleteUtilisateur(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
