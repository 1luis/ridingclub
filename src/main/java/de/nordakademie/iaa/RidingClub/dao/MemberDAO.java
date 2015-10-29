package de.nordakademie.iaa.RidingClub.dao;

import de.nordakademie.iaa.RidingClub.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MemberDAO {

    private EntityManager entityManager;


    @SuppressWarnings("JpaQlInspection")
    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m").getResultList();

    }


    public Member load(Long id) {
        return entityManager.find(Member.class, id);
    }

//TODO: Brauchen wir diese Methode wirklich? (Pascal)
    public void save(Member member) {
        if (member.getId() == null) {
            entityManager.persist(member);
        } else {
            entityManager.merge(member);
        }
    }


    public void delete(Member member) {
        entityManager.remove(member);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

