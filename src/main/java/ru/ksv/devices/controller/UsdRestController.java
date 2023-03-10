package ru.ksv.devices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ksv.devices.MapperUtil;
import ru.ksv.devices.dto.TypeDto;
import ru.ksv.devices.dto.UsdDto;
import ru.ksv.devices.model.TypeUsd;
import ru.ksv.devices.model.Usd;
import ru.ksv.devices.service.UsdService;

import java.util.List;

@RestController
@RequestMapping("/devices/api/usd/v1")
public class UsdRestController {
    private final UsdService usdService;
    private ModelMapper modelMapper;

    @Autowired
    public UsdRestController(UsdService usdService, ModelMapper modelMapper) {
        this.usdService = usdService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/find_all")
    public List<UsdDto> findAll() {
        List<Usd> usds = usdService.findAll();
        return MapperUtil.convertList(usds, this::convertToUsdDto);
    }

    //выборка записей по части адреса и части заводского номера, формат: /usd_sn_locate?sn='часть номер&locate='часть адреса'
    @RequestMapping(value="/find_by_part", method= RequestMethod.GET)
    public List<UsdDto> findBySnContainingAndLocateContaining(@RequestParam(name = "sn", required = false) String sn, @RequestParam(name = "locate", required = false) String locate) {
        final List<Usd> usds = usdService.findBySnContainingAndLocateContaining(sn, locate);
        return MapperUtil.convertList(usds, this::convertToUsdDto);
    }

    //добавление новой записи
    @PostMapping(value = "/add")
    public ResponseEntity<?> insertUsd(@RequestParam(name = "sn", required = false) String sn, @RequestParam(name = "locate", required = false) String locate,
                                       @RequestParam(name = "type_id", required = false) Integer type_id) {
        usdService.insertUsd(sn, locate, type_id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //добавление новой записи, другой вариант
    @PostMapping(value = "/add2")
    public ResponseEntity<?> insert(@RequestBody Usd usd){
        usdService.create(usd);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private UsdDto convertToUsdDto(Usd usd) {
        UsdDto usdDto = modelMapper.map(usd, UsdDto.class);
        usdDto.setTypeDto(convertToTypeDto(usd.getTypeUsd()));
        return usdDto;
    }

    private TypeDto convertToTypeDto(TypeUsd typeUsd) {
        return modelMapper.map(typeUsd, TypeDto.class);
    }
}
