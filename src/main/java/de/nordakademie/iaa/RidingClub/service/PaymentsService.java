package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.model.Payments;
import java.util.List;


public interface PaymentsService{


    void savePayment(Payments payments) throws EntityAlreadyPresentException;


    List<Payments> listPayments();


    Payments loadPayments(Long id);


    void deletePayments(Long id) throws EntityNotFoundException;

}