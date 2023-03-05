package ru.ksv.devices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksv.devices.model.TypeUsd;
import ru.ksv.devices.service.TypeUsdService;

@RestController
@RequestMapping("/devices/api/type_usd/v1")
public class TypeUsdRestController {
    private final TypeUsdService typeUsdService;
    private ModelMapper modelMapper;

    @Autowired
    public TypeUsdRestController(TypeUsdService typeUsdService, ModelMapper modelMapper) {
        this.typeUsdService = typeUsdService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> insertType(@RequestBody TypeUsd typeUsd){
        typeUsdService.create(typeUsd);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

