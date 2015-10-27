package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberTypeDAO;
import de.nordakademie.iaa.RidingClub.model.MemberType;

import javax.inject.Inject;



public class MemberTypeServiceImpl implements  MemberTypeService{

    @Inject
    MemberTypeDAO memberTypeDAO;

    @Override
    public MemberType loadMemberType(String name) {
        return memberTypeDAO.load(name);
    }


}






