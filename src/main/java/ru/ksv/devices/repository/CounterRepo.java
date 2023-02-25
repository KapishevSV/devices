package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksv.devices.model.Counter;

public interface CounterRepo extends JpaRepository<Counter, Integer> {
}
