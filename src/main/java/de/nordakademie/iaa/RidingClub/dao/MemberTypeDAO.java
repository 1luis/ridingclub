package de.nordakademie.iaa.RidingClub.dao;

import de.nordakademie.iaa.RidingClub.model.MemberType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by 13115 on 28.10.2015.
 */
public class MemberTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //MemberType enthält Mitgliedsart und Beitrag als Stammdaten
    public MemberType load(String name) {

        return entityManager.find(MemberType.class, name);
    }

}