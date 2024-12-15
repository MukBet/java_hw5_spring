package com.muzika.homeworksb.repository;

import com.muzika.homeworksb.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo save(Todo todo);

    Optional<Todo> findById(Long id);

    List<Todo> findAll();
}
