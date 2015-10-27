package de.nordakademie.iaa.RidingClub.dao;

import de.nordakademie.iaa.RidingClub.model.MemberType;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class MemberTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public MemberType load(String name) {
        return entityManager.find(MemberType.class, name);
    }

}
