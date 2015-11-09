package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberDAO;
import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.Payments;

import java.util.*;
import javax.inject.Inject;
import java.util.regex.Pattern;

/**
 * @author Marc & Luis
 */

public class MemberServiceImpl implements MemberService {

    @Inject
    private MemberDAO memberDAO;
    @Inject
    private PaymentsService paymentsService;

    //Neues oder Aktualisierung eines Members
    @Override
    public void saveMember(Member member) throws EntityAlreadyPresentException, ValidatorException {

        Payments payments = new Payments();
        int year = Calendar.getInstance().get(Calendar.YEAR);

      //Prüfung der Eingaben, ob leer
        if (member.getName() == null
                || member.getMemberType().isEmpty()
                || member.getName().isEmpty()
                || member.getSurname().isEmpty()
                || member.getAddress().isEmpty()
                || member.getCity().isEmpty()
                || member.getZipcode().isEmpty()
                || member.getBirthday().equals(null)
                || member.getEntryDate().equals(null)
                || member.getIban().equals(null))

        {
            throw new ValidatorException("Bitte alle Felder ausfüllen!");
        }

        // Wenn neues Mitglied, dann
        if (member.getMember_id() == null) {

            payments.setMemberType(member.getMemberType());

            //Set price
            payments.setAmount(familyMember(member.getFamilyMember(), member.getMemberType()));

            //set year, status und member in Payment:
            payments.setYear(year);
            payments.setStatus("offen");
            payments.setMember(member);

            //Speichern beides:
            paymentsService.savePayment(payments);
            memberDAO.save(member);

        }
        //Wenn kein neues Mitglied, dann Aktualisierung der Mitgliedsdaten
        else{

            //Member die in DB ist zum vergleichen:
            Member member2 = loadMember(member.getMember_id());
            payments =  paymentsService.loadPayments(member.getMember_id());

            //änderung price falls FamilyMember geändert ist
            if (member2.getFamilyMember() != member.getFamilyMember()){
                payments.setAmount(familyMember(member.getFamilyMember(), member.getMemberType()));
            }

            //notice datum gegeben: logik mit die noticedatum:
            if ( member2.getNoticeDate() == member.getNoticeDate() ) {

            }else{
                //Set The exit Date:

                //31.12.XXXX
                Calendar endYear = Calendar.getInstance();

                endYear.set(year, 12, 31 );
                Calendar noticeDate = Calendar.getInstance();
                noticeDate.setTime(member.getNoticeDate());
                noticeDate.add(Calendar.MONTH, 3);

                //ist der noticeDate + 3 Monate kleiner als 31.12.aktuelleJahr
                if(noticeDate.before(endYear)){

                    //set in ExitDate die NoticeDate + dieses 3 Monate
                    member.setExitDate(noticeDate.getTime());

                }else{

                    //sonst: Ende nächstes Jahr
                    noticeDate.set(year, 12, 31);
                    member.setExitDate(noticeDate.getTime());
                }
            }

            //Speichern alle änderungen in Member bzw Payments die gegebene Member
            paymentsService.savePayment(payments);
            memberDAO.save(member);
        }

    }

    @Override
    public List<Member> listMembers() {
        return memberDAO.findAll();
    }

    //Für die Suche wenn nur ein Name gegeben ist:
    @Override
    public List<Member> listMembersName(String name){
        return memberDAO.findName(name);
    }

    //ür die Suche, wenn nur ein nachname gegeben ist
    @Override
    public List<Member> listMembersSurname(String surname){
        return memberDAO.findSurname(surname);
    }

    //Fur die Suche, wenn ein Name und ein Nachname gegebne ist:
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

    //Methode: gibt ein price zuruck abhängig von der MemberType und der FamilyMember
    public int familyMember (boolean familyMember, String memberType){

        int price = 0;

        //Unterschiedliche Typen von Mitglieder und prices:
        switch (memberType) {
            case "Vollmitglied":
                price = 25;
                break;

            case "Ermaessigt":
                price = 23;
                break;

            case "Jugendmitglied":
                price = 15;
                break;

            case "Foerdermitglied":
                price = 10;
                break;
        }

        //Wenn ein Familienmitglieder ist, dann - Euro weniger price:
        if (familyMember == true){
            price = price - 3;
        }
        return price;

    }

}


