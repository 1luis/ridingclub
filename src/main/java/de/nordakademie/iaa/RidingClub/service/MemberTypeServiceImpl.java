package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberTypeDAO;
import de.nordakademie.iaa.RidingClub.model.MemberType;

import javax.inject.Inject;

/**
 * @author Marc & Luis
 */

public class MemberTypeServiceImpl implements  MemberTypeService{

    @Inject
    MemberTypeDAO memberTypeDAO;

    @Override
    public MemberType loadMemberType(String name) {
        return memberTypeDAO.load(name);
    }


}