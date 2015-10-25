package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.dao.RoomDAO;
import de.nordakademie.iaa.RidingClub.model.Room;

import javax.inject.Inject;
import java.util.List;


public class RoomServiceImpl implements RoomService {


    private RoomDAO roomDAO;

    @Override
    public void saveRoom(Room room) throws EntityAlreadyPresentException {
        roomDAO.save(room);
    }

    @Override
    public List<Room> listRooms() {
        return roomDAO.findAll();
    }

    @Override
    public Room loadRoom(Long id) {
        return roomDAO.load(id);
    }

    @Override
    public void deleteRoom(Long id) throws EntityNotFoundException {
        Room room = loadRoom(id);
        if (room == null) {
            throw new EntityNotFoundException();
        }
        roomDAO.delete(room);
    }

    @Inject
    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }
}
