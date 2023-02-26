package ru.ksv.devices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ksv.devices.model.Many;
import ru.ksv.devices.repository.ManyRepo;

import java.util.List;

@Service
public class ManyServiceImp implements ManyService {
    private ManyRepo manyRepo;

    @Autowired
    public ManyServiceImp(ManyRepo manyRepo) {
        this.manyRepo = manyRepo;
    }

    @Override
    public List<Many> findAll() {
        return (List<Many>)manyRepo.findAll();
    }
}
