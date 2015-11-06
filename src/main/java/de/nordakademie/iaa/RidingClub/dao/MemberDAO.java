package de.nordakademie.iaa.RidingClub.dao;

import de.nordakademie.iaa.RidingClub.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Marc & Luis
 */

public class MemberDAO {

    private EntityManager entityManager;

    /**
     * Gibt alle vorhandenen Mitglieder zurück
     * @return
     */
    @SuppressWarnings("JpaQlInspection")
    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m").getResultList();

    }

    /**
     * Gibt alle Mitglieder mit entsprechenden Vornamenbestandteilen zurück
     * @param name
     * @return
     */
    @SuppressWarnings("JpaQlInspection")
    public List<Member> findName(String name) {

            return entityManager
                    .createQuery("select m from Member m where m.name like CONCAT('%', :name, '%') ")
                    .setParameter("name", name)
                    .getResultList();

    }

    /**
     * Gibt alle Mitglieder mit entsprechenden Nachnamenbestandteilen zurück
     * @param surname
     * @return
     */
    @SuppressWarnings("JpaQlInspection")
    public List<Member> findSurname(String surname) {

        return entityManager
                .createQuery("select m from Member m where m.surname like CONCAT('%', :surname, '%') ")
                .setParameter("surname", surname)
                .getResultList();

    }

    /**
     * Gibt alle Mitglieder mit entsprechenden Vor- und Nachnamenbestandteilen zurück
     * @param name
     * @param surname
     * @return
     */
    @SuppressWarnings("JpaQlInspection")
    public List<Member> findAll(String name, String surname) {

            return entityManager
                    .createQuery("select m from Member m where m.name like CONCAT('%', :name, '%') and m.surname like CONCAT('%', :surname, '%')")
                    .setParameter("name", name)
                    .setParameter("surname", surname)
                    .getResultList();

    }

    /**
     * Lädt die Mitglieder anhand der member_id
     * @param member_id
     * @return
     */

    public Member load(Long member_id) {
        return entityManager.find(Member.class, member_id);
    }

    /**
     * Speichert ein Mitglied, wenn es neu angelegt wird - sonst aktualisiert es ein Mitglied
     * @param member
     */
    public void save(Member member) {
        if (member.getMember_id() == null) {
            entityManager.persist(member);
        } else {
            entityManager.merge(member);
        }
    }

    /**
     * Löscht ein Mitglied manuell
     * @param member
     */

    public void delete(Member member) {
        entityManager.remove(member);
    }

    /**
     * Entity Manager für Member
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

