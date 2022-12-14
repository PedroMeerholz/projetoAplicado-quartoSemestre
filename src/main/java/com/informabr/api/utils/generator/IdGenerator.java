package com.informabr.api.utils.generator;

import com.informabr.api.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
    private Long id;
    private UserRepository repository;

    public IdGenerator(UserRepository repository) {
        this.repository = repository;
    }

    private void getLastDatabaseId() {
        if(repository.getLastId().isPresent()) {
            this.id = repository.getLastId().get();
        } else {
            this.id = new Long(1);
        }
    }

    private void increaseId() {
        getLastDatabaseId();
        this.id = this.id += 1;
    }

    public Long getNewId() {
        increaseId();
        return this.id;
    }
}
