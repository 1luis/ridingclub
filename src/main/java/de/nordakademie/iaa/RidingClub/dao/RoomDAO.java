package de.nordakademie.iaa.RidingClub.dao;

import de.nordakademie.iaa.RidingClub.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDAO {

    private EntityManager entityManager;


    @SuppressWarnings("unchecked")
    public List<Room> findAll() {

        return entityManager.createQuery("select room from Room room").getResultList();
    }


    public Room load(Long id) {
        return entityManager.find(Room.class, id);
    }


    public void save(Room room) {
        if (room.getId() == null) {
            entityManager.persist(room);
        } else {
            entityManager.merge(room);
        }
    }


    public void delete(Room room) {
        entityManager.remove(room);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
