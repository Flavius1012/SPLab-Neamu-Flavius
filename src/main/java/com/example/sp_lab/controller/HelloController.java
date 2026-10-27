package com.example.sp_lab.controller;

import com.example.sp_lab.component.ClientComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record HelloController(ClientComponent clientComponent1, ClientComponent clientComponent2) {

    @GetMapping("/")
    public String printMessage(){
        return "client1 = " + clientComponent1 + "    client2 = " + clientComponent2;
    }



}
