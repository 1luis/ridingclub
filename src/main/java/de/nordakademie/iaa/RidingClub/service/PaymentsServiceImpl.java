package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.PaymentsDAO;
import de.nordakademie.iaa.RidingClub.model.Payments;
import java.util.List;
import javax.inject.Inject;


public class PaymentsServiceImpl implements PaymentsService {

    private PaymentsDAO paymentsDAO;
    @Inject
    private MemberService memberService;

    @Override
    public void savePayment(Payments payments) throws EntityAlreadyPresentException {



        paymentsDAO.save(payments);
    }

    @Override
    public List<Payments> listPayments() {
        return paymentsDAO.findAll();
    }

    @Override
    public Payments loadPayments(Long id) {
        return paymentsDAO.load(id);
    }

    @Override
    public void deletePayments(Long id) throws EntityNotFoundException {
        Payments payments = loadPayments(id);
        if (payments == null) {
            throw new EntityNotFoundException();
        }
        paymentsDAO.delete(payments);
    }

    @Inject
    public void setRoomDAO(PaymentsDAO paymentDAO) {
        this.paymentsDAO = paymentDAO;
    }
}
