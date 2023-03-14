package ru.ksv.devices.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ksv.devices.model.TypeUsd;
import ru.ksv.devices.repository.TypeUsdRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TypeUsdServiceImpl implements TypeUsdService {
    private final TypeUsdRepo typeUsdRepo;

    public TypeUsdServiceImpl(TypeUsdRepo typeUsdRepo) {
        this.typeUsdRepo = typeUsdRepo;
    }

    @Override
    public List<TypeUsd> findAll() {
        return typeUsdRepo.findAll();
    }

    @Override
    public Optional<TypeUsd> findById(Integer id) {
        return typeUsdRepo.findById(id);
    }

    @Override
    public void create(TypeUsd typeUsd) {
        typeUsdRepo.save(typeUsd);
    }

    @Override
    public boolean update(TypeUsd typeUsd) {
        if(typeUsdRepo.existsById(typeUsd.getId())){
            typeUsd.setId(typeUsd.getId());
            typeUsdRepo.save(typeUsd);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if(typeUsdRepo.existsById(id)){
            typeUsdRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
