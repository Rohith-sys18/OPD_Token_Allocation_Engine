package com.example.medico_backend_intern_task.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Slot {

    private String slotId;
    private int capacity;
    private List<Token> tokens = new ArrayList<>();

    public Slot(String slotId, int capacity) {
        this.slotId = slotId;
        this.capacity = capacity;
    }

    public synchronized void addToken(Token token) {
        tokens.add(token);
        tokens.sort(Comparator.comparingInt(t -> t.getPriority().getValue()));
    }

    public synchronized boolean isFull() {
        return tokens.size() >= capacity;
    }

    public synchronized Token removeLowestPriorityToken() {
        return tokens.remove(tokens.size() - 1);
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
