package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ksv.devices.model.Many;

import java.util.List;

public interface ManyRepo extends JpaRepository<Many, Integer>{
    @EntityGraph(attributePaths = {"one"})
    @Query(value = "SELECT m FROM Many m")
    List<Many> findAll();
}
