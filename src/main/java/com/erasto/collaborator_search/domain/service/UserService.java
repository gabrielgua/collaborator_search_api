package com.erasto.collaborator_search.domain.service;

import com.erasto.collaborator_search.domain.model.User;
import com.erasto.collaborator_search.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional(readOnly = true)
    public Optional<User> findByCredential(String credential) {
        return repository.findByCredential(credential);
    }

}