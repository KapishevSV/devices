package ru.ksv.devices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public List<UsdDto> findAll() {
        List<Usd> usds = usdService.findAll();
        return MapperUtil.convertList(usds, this::convertToUsdDto);
    }

    //выборка записей по части адреса, формат: /usd_locate/locate?'часть адреса'
    @RequestMapping(value="usd_locate", method= RequestMethod.GET)
    public List<UsdDto> findByLocateContaining(@RequestParam(name = "locate", required = false) String locate) {
        final List<Usd> usds = usdService.findByLocateContaining(locate);
        return MapperUtil.convertList(usds, this::convertToUsdDto);
    }

    //выборка записей по части адреса и части заводского номера, формат: /usd_sn_locate?sn='часть номер&locate='часть адреса'
    @RequestMapping(value="usd_sn_locate", method= RequestMethod.GET)
    public List<UsdDto> findBySnContainingAndLocateContaining(@RequestParam(name = "sn", required = false) String sn, @RequestParam(name = "locate", required = false) String locate) {
        final List<Usd> usds = usdService.findBySnContainingAndLocateContaining(sn, locate);
        return MapperUtil.convertList(usds, this::convertToUsdDto);
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
