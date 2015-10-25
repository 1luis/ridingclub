package de.nordakademie.iaa.RidingClub.service;

import de.nordakademie.iaa.RidingClub.model.Room;

import java.util.List;

public interface RoomService {


    void saveRoom(Room room) throws EntityAlreadyPresentException;


    List<Room> listRooms();


    Room loadRoom(Long id);


    void deleteRoom(Long id) throws EntityNotFoundException;

}
