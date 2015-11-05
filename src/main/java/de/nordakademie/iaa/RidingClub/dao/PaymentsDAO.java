package de.nordakademie.iaa.RidingClub.dao;

import de.nordakademie.iaa.RidingClub.model.Payments;
import de.nordakademie.iaa.RidingClub.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PaymentsDAO {


        private EntityManager entityManager;

    /**
     * Holt alle vorhandenen Zahlungen aus der Datenbank
     * @return
     */
        @SuppressWarnings("JpaQlInspection")
        public List<Payments> findAll() {
            return entityManager.createQuery("select p from Payments p").getResultList();

        }

    /**
     * Holt alle Zahlungen eines Mitglieds aus der Datenbank
     * @param member
     * @return
     */
        @SuppressWarnings({"JpaQlInspection", "JpaQueryApiInspection"})
        public List findMember_id(Member member) {
        return entityManager.createQuery("select p from Payments p where p.member = :member")
                .setParameter("member", member)
                .getResultList();

        }

    /**
     * Lädt eine Zahlung nach ID
     * @param payment_id
     * @return
     */
        public Payments load(Long payment_id) {
            return entityManager.find(Payments.class, payment_id);
        }

    /**
     * Speichert eine neue Zahlung, falls neu - sonst aktualisiert eine Zahlung
     * @param payments
     */
        public void save(Payments payments) {

            if (payments.getPayment_id() == null) {
                entityManager.persist(payments);
            } else {
                entityManager.merge(payments);
            }
        }

    /**
     * Löschen einer Zahlung
     * @param payments
     */
        public void delete(Payments payments) {
            entityManager.remove(payments);
        }

        @PersistenceContext
        public void setEntityManager(EntityManager entityManager) {
            this.entityManager = entityManager;
        }


}


