package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.PaymentsDAO;
import de.nordakademie.iaa.RidingClub.model.Payments;
import java.util.List;
import javax.inject.Inject;


public class PaymentsServiceImpl {

    private PaymentsDAO paymentsDAO;

    @Override
    public void saveRoom(Payments payments) throws EntityAlreadyPresentException {
        paymentsDAO.save(payments);
    }

    @Override
    public List<Payments> listRooms() {
        return paymentsDAO.findAll();
    }

    @Override
    public Payments loadRoom(Long id) {
        return paymentsDAO.load(id);
    }

    @Override
    public void deletePayments(Long id) throws EntityNotFoundException {
        Payments payments = loadPayments(id);
        if (room == null) {
            throw new EntityNotFoundException();
        }
        paymentsDAO.delete(payment);
    }

    @Inject
    public void setRoomDAO(paymentsDAO paymentDAO) {
        this.paymentsDAO = paymentDAO;
    }
}
