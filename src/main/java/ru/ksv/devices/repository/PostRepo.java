package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ksv.devices.model.Post;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    @EntityGraph(attributePaths = {"user"})
    @Query(value = "SELECT u FROM Post u")
    List<Post> findAll();
}
