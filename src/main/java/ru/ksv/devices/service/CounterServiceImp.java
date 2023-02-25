package ru.ksv.devices.service;

import org.springframework.stereotype.Service;
import ru.ksv.devices.model.Counter;
import ru.ksv.devices.repository.CounterRepo;

import java.util.List;

@Service
public class CounterServiceImp implements CounterService {
    private final CounterRepo counterRepo;

    public CounterServiceImp(CounterRepo counterRepo) {
        this.counterRepo = counterRepo;
    }

    @Override
    public List<Counter> findAll() {
        return (List<Counter>) counterRepo.findAll();
    }
}
