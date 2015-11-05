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

    /**
     * Speichert eine neue Zahlung in der Tabelle Payments
     * @param payments
     * @throws EntityAlreadyPresentException
     */
    @Override
    public void savePayment(Payments payments) throws EntityAlreadyPresentException {

        paymentsDAO.save(payments);
    }

    /**
     * Zeigt alle Zahlungen aller Mitglieder und Jahre an (Zahlungsübersicht)
     * @return
     */
    @Override
    public List<Payments> listPayments() {
        return paymentsDAO.findAll();
    }

    /**
     * Zeigt alle Zahlungen eines Mitgliedes an - sonst alle
     * @param member_id
     * @return
     */
    @Override
    public List<Payments> listPayments(Long member_id) {

        Member member = memberService.loadMember(member_id);

        if (member == null) {
            return paymentsDAO.findAll();
            //TODO: Wenn member_id NULL ist, dass lade alle Zahlungen (Marc: macht das Sinn hier?)
        }


        return paymentsDAO.findMember_id(member);
    }

    /**
     * Lädt alle Zahlungen aus der Tabelle Payments
     * @param payment_id
     * @return
     */
    @Override
    public Payments loadPayments(Long payment_id) {
        return paymentsDAO.load(payment_id);
    }

    /**
     * Löscht eine ausgewählte Zalung nach seiner ID
     * @param payment_id
     * @throws EntityNotFoundException
     */
    @Override
    public void deletePayments(Long payment_id) throws EntityNotFoundException {
        Payments payments = loadPayments(payment_id);
        if (payments == null) {
            throw new EntityNotFoundException();
        }
    paymentsDAO.delete(payments);
    }

    /**
     * Ehem. setRoomsDAO
     * @param paymentDAO
     */
    @Inject
    public void setPaymentsDAO(PaymentsDAO paymentDAO) {
        this.paymentsDAO = paymentDAO;
    }
}
