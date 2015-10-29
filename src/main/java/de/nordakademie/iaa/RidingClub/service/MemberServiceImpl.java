package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberDAO;
import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.Payments;

import javax.inject.Inject;
import java.util.List;


public class MemberServiceImpl implements MemberService {

    @Inject
    private MemberDAO memberDAO;
    @Inject
    private PaymentsService paymentsService;

    @Override
    public void saveMember(Member member) throws EntityAlreadyPresentException, ValidatorException {

        Payments payments = new Payments();

      /*  //TODO: Validierungen der Inputs
        if (member.getName1() == null
                || member.getName1().isEmpty()) {
            throw new ValidatorException("Der Vorname ist ungültig.");
        }
*/
        // Wenn ein neuer Member angelegt wird
        if (member.getId() == null) {
            memberDAO.save(member);

        }

        payments.setMemberType(member.getMemberType());

        switch (member.getMemberType()) {

            case "Vollmitglied":
                payments.setAmount(25);
                break;

            case "Ermaessigt":
                payments.setAmount(23);
                break;

            case "Jugendmitglied":
                payments.setAmount(15);
                break;
            case "Foerdermitglied":
                payments.setAmount(10);
                break;
        }

        payments.setMember(member);
        paymentsService.savePayment(payments);

    }

    @Override
    public List<Member> listMembers() {
        return memberDAO.findAll();
    }

    @Override
    public List<Member> listMembers(String name, String surname) {
        return memberDAO.findAll(name, surname);
    }

    @Override
    public Member loadMember(Long id) {
        return memberDAO.load(id);
    }

    @Override
    public void deleteMember(Long id) throws EntityNotFoundException {
        Member member = loadMember(id);
        if (member == null) {
            throw new EntityNotFoundException();
        }
        memberDAO.delete(member);
    }

}


