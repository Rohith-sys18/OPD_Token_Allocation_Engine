package com.example.medico_backend_intern_task.entity;

public enum Priority {
    EMERGENCY(1),
    PAID(2),
    FOLLOW_UP(3),
    ONLINE(4),
    WALK_IN(5);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
