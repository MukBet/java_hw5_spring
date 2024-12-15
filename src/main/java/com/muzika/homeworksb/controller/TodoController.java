package com.muzika.homeworksb.controller;

import com.muzika.homeworksb.dto.TodoCreateDto;
import com.muzika.homeworksb.dto.TodoResponseDto;
import com.muzika.homeworksb.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public TodoResponseDto create(@RequestBody @Valid TodoCreateDto createDto) {
        System.out.println("!!!!!!!!!!!!");
        return service.save(createDto);
    }

    @GetMapping
    public String getTodos(HttpServletRequest request) {
        System.out.println("Request received from: " + request.getRemoteAddr());
        return "List of Todos";
    }
}
