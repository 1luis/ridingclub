package de.nordakademie.iaa.RidingClub.service;

/**
 * @author Marc & Luis
 */

//Exception f�r Validierungs-Fehler der Benutzereingaben
public class ValidatorException extends Exception {

    public ValidatorException(String message) {
        super(message);
    }
}
