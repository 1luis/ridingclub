package de.nordakademie.iaa.RidingClub.dao;

import de.nordakademie.iaa.RidingClub.model.Payments;
import de.nordakademie.iaa.RidingClub.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by luisiglesias on 23/10/15.
 */
public class PaymentsDAO {


        private EntityManager entityManager;


        @SuppressWarnings("JpaQlInspection")
        public List<Payments> findAll() {
            return entityManager.createQuery("select p from Payments p").getResultList();

        }

        @SuppressWarnings("JpaQlInspection")
        public List<Payments> findAll(Member id) {
        return entityManager.createQuery("select p from Payments p where p.member = :id")
                .setParameter("id", id)
                .getResultList();

        }


        public Payments load(Long id) {
            return entityManager.find(Payments.class, id);
        }


        public void save(Payments payments) {

            //Wenn neu-> gespeichert sonst aktualisiert
            if (payments.getId_payment() == null) {
                entityManager.persist(payments);
            } else {
                entityManager.merge(payments);
            }
        }


        public void delete(Payments payments) {
            entityManager.remove(payments);
        }

        @PersistenceContext
        public void setEntityManager(EntityManager entityManager) {
            this.entityManager = entityManager;
        }
    }


