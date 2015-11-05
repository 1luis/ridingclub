package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberDAO;
import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.Payments;

import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;


public class MemberServiceImpl implements MemberService {

    @Inject
    private MemberDAO memberDAO;
    @Inject
    private PaymentsService paymentsService;

    @Override
    public void saveMember(Member member) throws EntityAlreadyPresentException, ValidatorException {

        Payments payments = new Payments();

      //TODO: Prüfung der Eingaben, ob leer
        if (member.getName() == null
                || member.getName().isEmpty()
                || member.getSurname().isEmpty()
                || member.getAddress().isEmpty()
                || member.getBirthday().isEmpty()
                || member.getEntryDate().isEmpty())

        {
            throw new ValidatorException("Der Vorname ist ungueltig.");
        }


        // Wenn neues Mitglied, dann
        if (member.getMember_id() == null) {

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
            payments.setStatus("offen");


            payments.setMember(member);

            paymentsService.savePayment(payments);

            memberDAO.save(member);






        }
        //TODO: Wenn kein neues Mitglied, dann Aktualisierung der Mitgliedsdaten
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
    public Member loadMember(Long member_id) {
        return memberDAO.load(member_id);
    }

    @Override
    public void deleteMember(Long member_id) throws EntityNotFoundException {
        Member member = loadMember(member_id);
        if (member == null) {
            throw new EntityNotFoundException();
        }
        memberDAO.delete(member);
    }

}


