package org.geofence.springplayground.repositories;

import org.geofence.springplayground.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

