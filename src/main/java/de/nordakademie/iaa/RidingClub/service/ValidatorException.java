package de.nordakademie.iaa.RidingClub.service;

/**
 * Created by 13115 on 28.10.2015.
 */

//Exception f�r Validierungs-Fehler der Benutzereingaben
public class ValidatorException extends Exception {

    public ValidatorException(String message) {
        super(message);
    }
}
