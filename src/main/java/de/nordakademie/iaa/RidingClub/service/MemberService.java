package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.model.MemberRequest;

import java.util.List;

public interface MemberService {

    void saveMember(MemberRequest member) throws EntityAlreadyPresentException;

    List<Member> listMembers();


    Member loadMember(Long id);


    void deleteMember(Long id) throws EntityNotFoundException;

}

