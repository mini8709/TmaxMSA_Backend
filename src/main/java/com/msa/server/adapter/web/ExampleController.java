package com.msa.server.adapter.web;

import com.msa.server.application.ExampleService;
import com.msa.server.application.dto.ExampleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService){
        this.exampleService = exampleService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ExampleResponseDto findById(@PathVariable Long id){
        return this.exampleService.findById(id);
    }
}
