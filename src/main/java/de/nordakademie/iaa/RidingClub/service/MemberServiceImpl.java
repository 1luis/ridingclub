package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberDAO;
import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.MemberType;
import de.nordakademie.iaa.RidingClub.model.Payments;

import javax.inject.Inject;
import javax.persistence.Column;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MemberServiceImpl implements MemberService{

    private MemberDAO memberDAO;
    private PaymentsService paymentsService;

    @Override
    public void saveMember(Member member) throws EntityAlreadyPresentException {

        Payments payments = new Payments ();


        // Wenn ein neuer Member angelegt wird
       if (member.getId() == null){
           payments = new Payments();
           payments.setMember(member);
           payments.setStatus(false);
           //payments.setYear(member.getEntryDate().getYear());
           payments.setYear(2015);
       }

        memberDAO.save(member);
        paymentsService.savePayment(payments);
    }

    @Override
    public List<Member> listMembers() {
        return memberDAO.findAll();
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

    @Inject
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }


}


