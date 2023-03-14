package ru.ksv.devices.service;

import org.springframework.stereotype.Service;
import ru.ksv.devices.model.Usd;
import ru.ksv.devices.repository.UsdRepo;

import java.util.List;

@Service
public class UsdServiceImpl implements UsdService {
    private final UsdRepo usdRepo;

    public UsdServiceImpl(UsdRepo usdRepo) {
        this.usdRepo = usdRepo;
    }

    @Override
    public List<Usd> findAll() {
        return usdRepo.findAll();
    }

    @Override
    public List<Usd> findBySnContainingAndLocateContaining(String sn, String locate) {
        return usdRepo.findBySnContainingAndLocateContaining(sn, locate);
    }

    @Override
    public void insertUsd(String sn, String locate, Integer type_id) {
        usdRepo.insertUsd(sn, locate, type_id);
    }

    @Override
    public void create(Usd usd) {
        usdRepo.save(usd);
    }

    @Override
    public boolean update(Usd usd) {
        if(usdRepo.existsById(usd.getId())){
            usd.setId(usd.getId());
            usdRepo.save(usd);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if(usdRepo.existsById(id)){
            usdRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
