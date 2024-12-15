package com.muzika.homeworksb.service.impl;

import com.muzika.homeworksb.dto.TodoCreateDto;
import com.muzika.homeworksb.dto.TodoResponseDto;
import com.muzika.homeworksb.exception.EntityNotFoundException;
import com.muzika.homeworksb.mapper.TodoMapper;
import com.muzika.homeworksb.model.Todo;
import com.muzika.homeworksb.repository.TodoRepository;
import com.muzika.homeworksb.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public TodoResponseDto save(TodoCreateDto createDto) {

        Todo todo = todoMapper.toModel(createDto);
        todo.setCreatedDate(LocalDateTime.now());
        // LocalDateTime now = LocalDateTime.now();

        return todoMapper.toDto(
            todoRepository.save(
                todo
            )
        );
    }

    @Override
    public TodoResponseDto findById(Long id) {
        return todoRepository.findById(id)
            .map(todoMapper::toDto)
            .orElseThrow(() -> new EntityNotFoundException("No todo by id: " + id));
    }

    @Override
    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll().stream()
            .map(todoMapper::toDto)
            .toList();
    }
}
