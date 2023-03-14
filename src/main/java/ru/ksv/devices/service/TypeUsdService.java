package ru.ksv.devices.service;

import ru.ksv.devices.model.TypeUsd;

import java.util.List;
import java.util.Optional;

public interface TypeUsdService {
    List<TypeUsd> findAll();

    Optional<TypeUsd> findById(Integer id);

    void create(TypeUsd typeUsd);

    boolean update(TypeUsd typeUsd);

    boolean delete(Integer id);
}
