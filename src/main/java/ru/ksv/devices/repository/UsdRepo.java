package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ksv.devices.model.Usd;

import java.util.List;

public interface UsdRepo extends JpaRepository<Usd, Integer> {
    //@EntityGraph(attributePaths = {"type"})
    //@Query(value = "SELECT u FROM Usd u")
    List<Usd> findAll();

//    @EntityGraph(attributePaths = {"type"})
//    @Query(value = "SELECT u FROM Usd u WHERE u.locate LIKE CONCAT('%',:locate,'%')")
//    List<Usd> findByLocateContaining(String locate);

//    @Query(value = "SELECT u FROM Usd u LEFT OUTER JOIN u.type t WHERE u.locate LIKE CONCAT('%',:locate,'%')")
//    @Query(value = "SELECT u FROM Usd u LEFT OUTER JOIN u.type t WHERE u.locate LIKE CONCAT('%',:locate,'%') AND CONCAT(u.sn, '::text') LIKE CONCAT('%',:sn,'%')")
    List<Usd> findByLocateContaining(String locate);

    List<Usd> findBySnContainingAndLocateContaining(String sn, String locate);
}
