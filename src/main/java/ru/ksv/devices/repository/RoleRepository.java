package ru.ksv.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksv.devices.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
