package de.nordakademie.iaa.RidingClub.service;


public class EntityAlreadyPresentException extends Exception {

    private static final long serialVersionUID = 1L;


    public EntityAlreadyPresentException() {
        super();
    }


    public EntityAlreadyPresentException(String message) {
        super(message);
    }
}
