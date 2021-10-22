package com.finance.adapter.web;

import com.finance.application.SlipService;
import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipCreateResponseDto;
import com.finance.application.dto.SlipSingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class SlipController {

    private final SlipService slipService;

    @PostMapping("/api/v0/slips")
    public SlipCreateResponseDto create(@RequestBody SlipCreateRequestDto slipCreateRequestDto){
        return slipService.create(slipCreateRequestDto);
    }

    @GetMapping("/api/v0/slip/{id}")
    public SlipSingleResponseDto findSlipById(@PathVariable String id) {
        return slipService.findSlipById(id);
    }


    @GetMapping("/api/v0/slips/{id}")
    public List<SlipSingleResponseDto> findSlipByTxId(@PathVariable String id) {
        return slipService.findSlipByTxId(id);
    }
}
