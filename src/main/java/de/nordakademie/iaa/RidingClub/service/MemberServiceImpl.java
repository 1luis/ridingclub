package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberDAO;
import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.Payments;

import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;


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
            throw new ValidatorException("Der Vorname ist ung�ltig.");
        }
*/
        // Neu
        if (member.getId() == null) {

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
            int year = Calendar.getInstance().get(Calendar.YEAR);
            payments.setYear(year);
            payments.setStatus("aktiv");
            payments.setMember(member);


            paymentsService.savePayment(payments);

            memberDAO.save(member);


            // Profesor profesor=new Profesor(7, "Sara", "Barrrera", "Salas");

        /*    Set<Payments> payments=new HashSet<>();

            Payments payment1 = new Payments();
            Payments payment2 = new Payments();


            payment1.setYear(2015);
            payment1.setAmount(20);
            payment1.setId_payment((long) 1);
            payment1.setStatus("aktiv");
            payment1.setMemberType("tuputamadre");
            payment1.setMember(member);

            payment2.setYear(2016);
            payment2.setId_payment((long) 2);
            payment2.setAmount(21);
            payment2.setStatus("aktivo");
            payment2.setMemberType("tuputamadre2");
            payment2.setMember(member);

            payments.add(payment1);
            payments.add(payment2);

            member.setPayments(payments);

            member.setId((long) 1);

            memberDAO.save(member);*/

        }
        //Aktualisierung
        else{

        }


    }

    @Override
    public List<Member> listMembers() {
        return memberDAO.findAll();
    }

    @Override
    public List<Member> listMembersName(String name){
        return memberDAO.findName(name);
    }

    @Override
    public List<Member> listMembersSurname(String surname){
        return memberDAO.findSurname(surname);
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


