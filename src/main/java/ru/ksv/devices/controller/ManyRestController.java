package ru.ksv.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksv.devices.model.Many;
import ru.ksv.devices.service.ManyService;

import java.util.List;

@RestController
public class ManyRestController {
    private final ManyService manyService;

    @Autowired
    public ManyRestController(ManyService manyService) {
        this.manyService = manyService;
    }

    @GetMapping(value = "many")
    public ResponseEntity<List<Many>> findAll(){
        final List<Many> manys = manyService.findAll();

        return manys != null && !manys.isEmpty()
                ? new ResponseEntity<>(manys, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

