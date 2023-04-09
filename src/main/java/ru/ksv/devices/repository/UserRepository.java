package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksv.devices.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
