package ru.ksv.devices.service;

import ru.ksv.devices.model.Counter;
import java.util.List;

public interface CounterService {
    List<Counter> findAll();
}
