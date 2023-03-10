package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ksv.devices.model.Usd;

import java.util.List;

public interface UsdRepo extends JpaRepository<Usd, Integer> {
    @EntityGraph(attributePaths = {"typeUsd"})
    @Query(value = "SELECT u FROM Usd u")
    List<Usd> findAll();

    @EntityGraph(attributePaths = {"typeUsd"})
    @Query(value = "SELECT u FROM Usd u LEFT OUTER JOIN u.typeUsd t WHERE u.locate LIKE CONCAT('%',:locate,'%') AND CONCAT(u.sn, '::text') LIKE CONCAT('%',:sn,'%') ORDER BY u.locate")
    List<Usd> findBySnContainingAndLocateContaining(String sn, String locate);

    @Modifying
    @Transactional
    @Query(value = "CALL insert_usd(:sn, :locate, :type_id);", nativeQuery = true)
    void insertUsd(@Param("sn") String sn, @Param("locate") String locate, @Param("type_id") Integer type_id);

    @Modifying
    @Transactional
    Usd save(Usd usd);
}
