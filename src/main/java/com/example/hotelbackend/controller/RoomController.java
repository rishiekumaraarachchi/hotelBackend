package com.example.hotelbackend.controller;

import com.example.hotelbackend.model.Room;
import com.example.hotelbackend.response.RoomResponse;
import com.example.hotelbackend.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(@RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
            Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
            RoomResponse roomResponse = new RoomResponse(savedRoom.getId(),
                    savedRoom.getRoomType(),
                    savedRoom.getRoomPrice());
            return ResponseEntity.ok(roomResponse);

    }
}
