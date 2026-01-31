package com.example.medico_backend_intern_task.service;

import com.example.medico_backend_intern_task.entity.Priority;
import com.example.medico_backend_intern_task.entity.Slot;
import com.example.medico_backend_intern_task.entity.Token;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    private final Map<String, Slot> slotStore = new HashMap<>();

    public TokenService() {
        // Sample slots
        slotStore.put("DOC1-9AM", new Slot("DOC1-9AM", 5));
        slotStore.put("DOC2-9AM", new Slot("DOC2-9AM", 5));
        slotStore.put("DOC3-9AM", new Slot("DOC3-9AM", 5));
    }

    public synchronized String bookToken(String slotId, String patientName, Priority priority) {
        Slot slot = slotStore.get(slotId);
        if (slot == null) return "Invalid slot";

        Token newToken = new Token(patientName, priority);

        if (!slot.isFull()) {
            slot.addToken(newToken);
            return "Token booked successfully";
        }

        // Slot full → check priority
        Token lowest = slot.getTokens().get(slot.getTokens().size() - 1);
        if (priority.getValue() < lowest.getPriority().getValue()) {
            slot.removeLowestPriorityToken();
            slot.addToken(newToken);
            return "High priority token inserted, lower priority token removed";
        }

        return "Slot full. Token rejected";
    }

    public synchronized String cancelToken(String slotId, String tokenId) {
        Slot slot = slotStore.get(slotId);
        if (slot == null) return "Invalid slot";

        slot.getTokens().removeIf(t -> t.getId().equals(tokenId));
        return "Token cancelled";
    }

    public Slot getSlot(String slotId) {
        return slotStore.get(slotId);
    }
}
