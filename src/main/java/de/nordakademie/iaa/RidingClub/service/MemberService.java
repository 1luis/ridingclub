package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.model.Member;
import java.util.List;



public interface MemberService {

    void saveMember(Member member) throws EntityAlreadyPresentException, ValidatorException;

    List<Member> listMembers();


    Member loadMember(Long id);


    void deleteMember(Long id) throws EntityNotFoundException;

}

