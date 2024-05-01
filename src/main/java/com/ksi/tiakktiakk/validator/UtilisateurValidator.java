package com.ksi.tiakktiakk.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ksi.tiakktiakk.model.Utilisateur;

@Component
public class UtilisateurValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Utilisateur.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Utilisateur utilisateur = (Utilisateur) target;

        // Vérification si le nom est vide
        if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()) {
            errors.rejectValue("nom", "NotEmpty", "Le nom ne peut pas être vide");
        }

        // Vérification si le prénom est vide
        if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
            errors.rejectValue("prenom", "NotEmpty", "Le prénom ne peut pas être vide");
        }

        //verification du numéro de téléphone
        if ((utilisateur.getAdresse().getTelephone1() == null || utilisateur.getAdresse().getTelephone1().isEmpty())) {
            errors.rejectValue("adresse.telephone1", "NotEmpty",
                    "Veuillez fourni un numéro de téléphone valide");
        }

        //verification de l'email
        if ((utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty())) {
            errors.rejectValue("email", "NotEmpty",
                    "Veuillez fournir un email valide");
        }

        //verification de la photo
        if ((utilisateur.getPhoto() ==null || utilisateur.getPhoto().isEmpty())) {
            errors.rejectValue("photo", "NotEmpty",
                    "Veuillez fournir une photo");
        }

    }
}
