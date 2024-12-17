package com.erasto.collaborator_search.domain.repository;

import com.erasto.collaborator_search.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByCredential(String credential);
}