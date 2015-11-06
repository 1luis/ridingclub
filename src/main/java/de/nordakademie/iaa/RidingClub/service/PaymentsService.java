package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.model.Payments;
import java.util.List;

/**
 * @author Marc & Luis
 */

public interface PaymentsService{


    void savePayment(Payments payments) throws EntityAlreadyPresentException;


    List<Payments> listPayments();

    List<Payments> listPayments(Long member_id);


    Payments loadPayments(Long member_id);


    void deletePayments(Long member_id) throws EntityNotFoundException;

    void changeStatusPayments(Long member_id) throws EntityNotFoundException;

}