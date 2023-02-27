package ru.ksv.devices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksv.devices.MapperUtil;
import ru.ksv.devices.dto.TypeDto;
import ru.ksv.devices.dto.UsdDto;
import ru.ksv.devices.model.Type;
import ru.ksv.devices.model.Usd;
import ru.ksv.devices.service.UsdService;

import java.util.List;

@RestController
public class UsdRestController {
    private final UsdService usdService;
    private ModelMapper modelMapper;

    @Autowired
    public UsdRestController(UsdService usdService, ModelMapper modelMapper) {
        this.usdService = usdService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/usd")
    public List<UsdDto> findAllUsd() {
        List<Usd> posts = usdService.findAll();
        return MapperUtil.convertList(posts, this::convertToUsdDto);
    }

    @GetMapping(value = "counter")
    public ResponseEntity<List<Usd>> findAll(){
        final List<Usd> usds = usdService.findAll();

        return usds != null && !usds.isEmpty()
                ? new ResponseEntity<>(usds, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private UsdDto convertToUsdDto(Usd usd) {
        UsdDto usdDto = modelMapper.map(usd, UsdDto.class);
        usdDto.setTypeDto(convertToTypeDto(usd.getType()));
        return usdDto;
    }

    private TypeDto convertToTypeDto(Type type) {
        return modelMapper.map(type, TypeDto.class);
    }
}
