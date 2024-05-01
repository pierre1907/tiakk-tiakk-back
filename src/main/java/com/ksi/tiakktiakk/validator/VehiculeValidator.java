package com.ksi.tiakktiakk.validator;

import com.ksi.tiakktiakk.model.Vehicule;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

@Component
public class VehiculeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Vehicule.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Vehicule vehicule = (Vehicule) target;

        if(vehicule.getMarque() == null || vehicule.getMarque().isEmpty()) {
            errors.rejectValue("marque", "NotEmpty", "La marque ne peut pas être vide");
        }

        if(vehicule.getModele() == null || vehicule.getModele().isEmpty()) {
            errors.rejectValue("modele", "NotEmpty", "Le modèle ne peut pas être vide");
        }

        if(vehicule.getMatricule() == null || vehicule.getMatricule().isEmpty()) {
            errors.rejectValue("immatriculation", "NotEmpty", "L'immatriculation ne peut pas être vide");
        }

        if(vehicule.getCouleur() == null || vehicule.getCouleur().isEmpty()) {
            errors.rejectValue("couleur", "NotEmpty", "La couleur ne peut pas être vide");
        }
    }
}
