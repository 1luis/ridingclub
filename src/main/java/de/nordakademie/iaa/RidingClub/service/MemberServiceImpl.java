package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberDAO;
import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.MemberRequest;
import de.nordakademie.iaa.RidingClub.model.MemberType;
import de.nordakademie.iaa.RidingClub.model.Payments;
import javafx.animation.PauseTransitionBuilder;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MemberServiceImpl implements MemberService{

    private MemberDAO memberDAO;

    @Override
    public void saveMember(MemberRequest memberRequest) throws EntityAlreadyPresentException {
        Member newMember = new Member();
        newMember.setName(memberRequest.getName());
        Payments newPayments = new Payments();

        Set<Payments> setOfPayments = new HashSet<>();
        setOfPayments.add(newPayments);
//switcht über die Mitgliederart
        switch (memberRequest.getMemberType()){
            case Vollmitlied:
                newPayments.setMemberType(MemberType.Vollmitlied);
                newPayments.setAmount(25);
            case Jugendmitglied:
                newPayments.setMemberType(MemberType.Jugendmitglied);
                newPayments.setAmount(15);
            case Ermaessigt:
                newPayments.setMemberType(MemberType.Ermaessigt);
                newPayments.setAmount(23);
            case Foerdermitglied:
                newPayments.setMemberType(MemberType.Foerdermitglied);
                newPayments.setAmount(10);
            case Familienmitglied:
                newPayments.setMemberType(MemberType.Familienmitglied);
                newPayments.setAmount(-3);
                //TODO: Familienmitglied bedeutet eigentlich 3€ Rabatt auf die jeweilige Mitgliedsart
            default:
                break;
        }

        newMember.setPayments(setOfPayments);

        memberDAO.save(newMember);
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


