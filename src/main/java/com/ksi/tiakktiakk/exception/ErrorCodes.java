package com.ksi.tiakktiakk.exception;

public enum ErrorCodes {
    ADRESSE_NOT_FOUND(1000),
    CHAUFFEUR_NOT_FOUND(2000),
    CLIENT_NOT_FOUND(3000),
    COMMANDE_NOT_FOUND(4000),
    COURSE_NOT_FOUND(5000),
    FACTURE_NOT_FOUND(6000),
    PAIEMENT_NOT_FOUND(7000),
    ROLE_NOT_FOUND(8000),
    TRAJET_NOT_FOUND(9000),
    UTILISATEUR_NOT_FOUND(10000),
    VEHICULE_NOT_FOUND(11000),

    ;

    private final int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
