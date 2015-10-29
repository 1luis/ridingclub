package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.MemberTypeDAO;
import de.nordakademie.iaa.RidingClub.model.MemberType;

import javax.inject.Inject;

/**
 * Created by 13115 on 28.10.2015.
 */
public class MemberTypeServiceImpl implements  MemberTypeService{

    @Inject
    MemberTypeDAO memberTypeDAO;

    @Override
    public MemberType loadMemberType(String name) {
        return memberTypeDAO.load(name);
    }


}