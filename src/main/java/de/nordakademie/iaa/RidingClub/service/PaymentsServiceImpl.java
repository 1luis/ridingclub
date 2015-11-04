package de.nordakademie.iaa.RidingClub.service;
import de.nordakademie.iaa.RidingClub.model.Member;

import de.nordakademie.iaa.RidingClub.dao.PaymentsDAO;
import de.nordakademie.iaa.RidingClub.model.Payments;
import java.util.List;
import javax.inject.Inject;


public class PaymentsServiceImpl implements PaymentsService {

    @Inject
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
    public List<Payments> listPayments(Long member_id) {

        Member member = memberService.loadMember(member_id);

        if (member == null) {
            //Excetion
        }


        return paymentsDAO.findMember_id(member);
    }

    @Override
    public Payments loadPayments(Long payment_id) {
        return paymentsDAO.load(payment_id);
    }

    @Override
    public void deletePayments(Long payment_id) throws EntityNotFoundException {
        Payments payments = loadPayments(payment_id);
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
