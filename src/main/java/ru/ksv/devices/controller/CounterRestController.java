package ru.ksv.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksv.devices.model.Counter;
import ru.ksv.devices.service.CounterService;

import java.util.List;

@RestController
public class CounterRestController {
    private final CounterService counterService;

    @Autowired
    public CounterRestController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping(value = "counter")
    public ResponseEntity<List<Counter>> findAll(){
        final List<Counter> counter = counterService.findAll();

        return counter != null && !counter.isEmpty()
                ? new ResponseEntity<>(counter, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
