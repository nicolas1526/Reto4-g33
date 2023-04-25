package com.grupoG33.reto3.controller;

import com.grupoG33.reto3.dbo.GamaDbo;
import com.grupoG33.reto3.dbo.MessageDbo;
import com.grupoG33.reto3.model.ClientModel;
import com.grupoG33.reto3.model.GamaModel;
import com.grupoG33.reto3.model.MessageModel;
import com.grupoG33.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> obtener(){
        return messageService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<MessageModel> obtenerPorId(@PathVariable int id){
        return messageService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody MessageModel message){
        messageService.crear(message);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        messageService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody MessageDbo messageInput){
        messageService.actualizar(messageInput);
    }
}
