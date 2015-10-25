package de.nordakademie.iaa.RidingClub.controller;

import de.nordakademie.iaa.RidingClub.model.Room;
import de.nordakademie.iaa.RidingClub.service.RoomService;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.util.List;


@RestController
public class RoomController {


    private RoomService roomService;


    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> listRooms() {
        return roomService.listRooms();
    }


    @RequestMapping(value = "/rooms", method = RequestMethod.PUT)
    public void saveRoom(@RequestBody Room room) throws Exception {
        roomService.saveRoom(room);
    }


    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable Long id) throws Exception {
        roomService.deleteRoom(id);
    }

    @Inject
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
}
