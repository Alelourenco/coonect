package com.hub.integrator.marketplace.coonect.repository;

import com.hub.integrator.marketplace.coonect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
