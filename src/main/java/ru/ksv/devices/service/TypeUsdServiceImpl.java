package ru.ksv.devices.service;

import org.springframework.stereotype.Service;
import ru.ksv.devices.model.TypeUsd;
import ru.ksv.devices.repository.TypeUsdRepo;

@Service
public class TypeUsdServiceImpl implements TypeUsdService {
    private final TypeUsdRepo typeUsdRepo;

    public TypeUsdServiceImpl(TypeUsdRepo typeUsdRepo) {
        this.typeUsdRepo = typeUsdRepo;
    }

    @Override
    public void create(TypeUsd typeUsd) {
        typeUsdRepo.save(typeUsd);
    }
}
