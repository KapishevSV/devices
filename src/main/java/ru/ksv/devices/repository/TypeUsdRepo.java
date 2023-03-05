package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksv.devices.model.TypeUsd;

public interface TypeUsdRepo extends JpaRepository<TypeUsd, Integer> {
    TypeUsd save(TypeUsd typeUsd);
}
