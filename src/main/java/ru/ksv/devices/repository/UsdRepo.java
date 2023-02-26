package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ksv.devices.model.Usd;

import java.util.List;

public interface UsdRepo extends JpaRepository<Usd, Integer> {
    @EntityGraph(attributePaths = {"type"})
    @Query(value = "SELECT u FROM Usd u")
    List<Usd> findAll();
}
