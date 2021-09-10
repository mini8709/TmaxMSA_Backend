package com.msa.server.application.dto;

import com.msa.server.adapter.persistence.Example;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExampleResponseDto {
    private Long id;
    private Integer value;

    public static ExampleResponseDto from(Example example){

        return new ExampleResponseDto(
                example.getId(),
                example.getValue()
        );
    }
    private ExampleResponseDto(Long id, Integer value){
        this.value = value;
        this.id = id;
    }
}
