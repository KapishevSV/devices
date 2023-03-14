package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksv.devices.model.TypeUsd;

import java.util.List;
import java.util.Optional;

public interface TypeUsdRepo extends JpaRepository<TypeUsd, Integer> {
    List<TypeUsd> findAll();

    Optional<TypeUsd> findById(Integer id);

    TypeUsd save(TypeUsd typeUsd);
}
