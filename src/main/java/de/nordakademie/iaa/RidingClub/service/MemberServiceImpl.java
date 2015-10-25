package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberDAO;
import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.MemberRequest;

import javax.inject.Inject;
import java.util.List;


public class MemberServiceImpl implements MemberService{

    private MemberDAO memberDAO;

    @Override
    public void saveMember(MemberRequest memberRequest) throws EntityAlreadyPresentException {
        Member newMember = new Member();
        newMember.setName(memberRequest.getName());

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


