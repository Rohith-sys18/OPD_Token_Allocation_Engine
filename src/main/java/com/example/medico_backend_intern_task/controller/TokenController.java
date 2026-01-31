package com.example.medico_backend_intern_task.controller;

import com.example.medico_backend_intern_task.dto.TokenRequest;
import com.example.medico_backend_intern_task.entity.Slot;
import com.example.medico_backend_intern_task.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/book")
    public String bookToken(@RequestBody TokenRequest request) {
        return tokenService.bookToken(
                request.slotId,
                request.patientName,
                request.priority
        );
    }

    @DeleteMapping("/cancel/{slotId}/{tokenId}")
    public String cancelToken(@PathVariable String slotId,
                              @PathVariable String tokenId) {
        return tokenService.cancelToken(slotId, tokenId);
    }

    @GetMapping("/slot/{slotId}")
    public Slot getSlotStatus(@PathVariable String slotId) {
        return tokenService.getSlot(slotId);
    }
}