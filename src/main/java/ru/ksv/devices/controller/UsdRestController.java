package ru.ksv.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksv.devices.model.Usd;
import ru.ksv.devices.service.UsdService;

import java.util.List;

@RestController
public class UsdRestController {
    private final UsdService usdService;

    @Autowired
    public UsdRestController(UsdService usdService) {
        this.usdService = usdService;
    }

    @GetMapping(value = "counter")
    public ResponseEntity<List<Usd>> findAll(){
        final List<Usd> usds = usdService.findAll();

        return usds != null && !usds.isEmpty()
                ? new ResponseEntity<>(usds, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
