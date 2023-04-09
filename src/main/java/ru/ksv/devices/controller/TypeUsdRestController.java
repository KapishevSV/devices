package ru.ksv.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ksv.devices.model.TypeUsd;
import ru.ksv.devices.service.TypeUsdService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devices/api/v1/type_usd")
public class TypeUsdRestController {
    private final TypeUsdService typeUsdService;

    @Autowired
    public TypeUsdRestController(TypeUsdService typeUsdService) {
        this.typeUsdService = typeUsdService;
    }

    //поиск всех typeUsd
    @GetMapping(value = "/find_all")
    public ResponseEntity<List<TypeUsd>> findAll(){
        final List<TypeUsd> types = typeUsdService.findAll();

        return types != null && !types.isEmpty()
                ? new ResponseEntity<>(types, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //поиск typeUsd по id
    @GetMapping(value = "/find_id")
    public ResponseEntity<Optional<TypeUsd>> findId(@RequestParam(name = "id", required = false) Integer id){
        final Optional<TypeUsd> types = typeUsdService.findById(id);

        return types != null && !types.isEmpty()
                ? new ResponseEntity<>(types, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //создание нового typeUsd
    @PostMapping(value = "/add")
    public ResponseEntity<?> insertType(@RequestBody TypeUsd typeUsd){
        typeUsdService.create(typeUsd);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //обновление typeUsd
    @PutMapping(value = "/update")
    public ResponseEntity<?> updateType(@RequestBody TypeUsd typeUsd){
        typeUsdService.update(typeUsd);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //удаление typeUsd
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteType(@RequestParam(name = "id", required = true) Integer id){
        if(typeUsdService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

