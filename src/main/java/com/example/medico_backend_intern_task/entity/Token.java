package com.example.medico_backend_intern_task.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

public class Token {
        private String id;
        private String patientName;
        private Priority priority;
        private TokenStatus status;
        private LocalDateTime createdAt;

        public Token(String patientName, Priority priority) {
            this.id = UUID.randomUUID().toString();
            this.patientName = patientName;
            this.priority = priority;
            this.status = TokenStatus.ACTIVE;
            this.createdAt = LocalDateTime.now();
        }

        public String getId() {
            return id;
        }

        public Priority getPriority() {
            return priority;
        }

        public TokenStatus getStatus() {
            return status;
        }

        public void cancel() {
            this.status = TokenStatus.CANCELLED;
        }

        public String getPatientName() {
            return patientName;
        }

}
