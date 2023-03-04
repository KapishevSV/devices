package ru.ksv.devices.service;

import org.springframework.stereotype.Service;
import ru.ksv.devices.model.Usd;
import ru.ksv.devices.repository.UsdRepo;

import java.util.List;

@Service
public class UsdServiceImp implements UsdService {
    private final UsdRepo usdRepo;

    public UsdServiceImp(UsdRepo usdRepo) {
        this.usdRepo = usdRepo;
    }

    @Override
    public List<Usd> findAll() {
        return usdRepo.findAll();
    }

    @Override
    public List<Usd> findByLocateContaining(String locate) {
        return usdRepo.findByLocateContaining(locate);
    }

    @Override
    public List<Usd> findBySnContainingAndLocateContaining(String sn, String locate) {
        return usdRepo.findBySnContainingAndLocateContaining(sn, locate);
    }
}
