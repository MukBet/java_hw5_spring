package com.muzika.homeworksb.service;

import com.muzika.homeworksb.dto.TodoCreateDto;
import com.muzika.homeworksb.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {
    TodoResponseDto save(TodoCreateDto createDto);

    TodoResponseDto findById(Long Id);

    List<TodoResponseDto> findAll();
}
