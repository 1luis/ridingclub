package de.nordakademie.iaa.RidingClub.service;



public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;


    public EntityNotFoundException() {
        super();
    }


    public EntityNotFoundException(String message) {
        super(message);
    }
}
