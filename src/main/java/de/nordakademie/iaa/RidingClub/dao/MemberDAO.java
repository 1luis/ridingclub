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

    @SuppressWarnings("JpaQlInspection")
    public List<Member> findName(String name) {

            return entityManager
                    .createQuery("select m from Member m where m.name like CONCAT('%', :name, '%') ")
                    .setParameter("name", name)
                    .getResultList();

    }

    @SuppressWarnings("JpaQlInspection")
    public List<Member> findSurname(String surname) {

        return entityManager
                .createQuery("select m from Member m where m.surname like CONCAT('%', :surname, '%') ")
                .setParameter("surname", surname)
                .getResultList();

    }


    @SuppressWarnings("JpaQlInspection")
    public List<Member> findAll(String name, String surname) {

            return entityManager
                    .createQuery("select m from Member m where m.name like CONCAT('%', :name, '%') and m.surname like CONCAT('%', :surname, '%')")
                    .setParameter("name", name)
                    .setParameter("surname", surname)
                    .getResultList();

    }

    public Member load(Long member_id) {
        return entityManager.find(Member.class, member_id);
    }

    public void save(Member member) {
        if (member.getMember_id() == null) {
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

