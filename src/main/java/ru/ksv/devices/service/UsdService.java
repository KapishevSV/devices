package ru.ksv.devices.service;

import ru.ksv.devices.model.Usd;
import java.util.List;

public interface UsdService {
    List<Usd> findAll();

    List<Usd> findBySnContainingAndLocateContaining(String sn, String locate);

    void insertUsd(String sn, String locate, Integer type_id);
}
