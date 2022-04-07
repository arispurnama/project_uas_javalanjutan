package com.neo.sihotel.controller;

import com.neo.sihotel.model.Room;
import com.neo.sihotel.model.TypeRoom;
import com.neo.sihotel.repository.TypeRoomRepository;
import com.neo.sihotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    TypeRoomRepository typeRoomRepository;

    @GetMapping("/dashboard")
    public String dashboard(){

        return "home";
    }

}
