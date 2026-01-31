# OPD Token Allocation Engine

## Overview
The OPD Token Allocation Engine is a Spring Boot–based backend service that simulates token generation and allocation for a hospital OPD workflow.

This project focuses on **core backend logic**, prioritization rules, and handling real-world OPD scenarios such as slot capacity limits, emergency insertions, and cancellations. It is intentionally designed as a simplified system suitable for a backend intern assignment.

---

## Problem Context
Doctors operate in fixed OPD time slots (for example, 9–10 AM, 10–11 AM), where each slot has a limited capacity. Tokens can be generated from multiple sources such as online bookings, walk-ins, paid priority patients, follow-up visits, and emergencies.

The system must allocate tokens fairly while enforcing slot limits and prioritizing critical cases.

---

## Core Features
- Token booking for OPD slots
- Priority-based token allocation
- Per-slot hard capacity enforcement
- Emergency and high-priority token insertion
- Token cancellation handling
- Slot-wise token status viewing via APIs

---

## Token Priority Order
Tokens are allocated based on the following priority (highest to lowest):

1. Emergency  
2. Paid  
3. Follow-up  
4. Online  
5. Walk-in  

Higher-priority tokens are always considered before lower-priority ones, while ensuring that slot capacity constraints are respected.

---

## Allocation Logic (High-Level)
- Each doctor has predefined OPD slots with a maximum token capacity.
- Incoming token requests are evaluated based on priority and slot availability.
- Emergency tokens can be dynamically inserted ahead of lower-priority tokens.
- If a slot reaches its capacity, lower-priority tokens may be deferred or rejected.
- Token cancellations immediately free up capacity for reallocation.

The allocation logic is implemented in the service layer to keep controllers lightweight and maintain clear separation of concerns.

---

## Edge Cases Considered
- **Cancellations / No-Shows**  
  Cancelled tokens free slot capacity and allow new allocations.

- **Emergency Insertions**  
  Emergency tokens are prioritized and inserted even when slots are near capacity.

- **Doctor Delays**  
  Slot timing shifts are explained conceptually and can be handled by adjusting slot boundaries.

- **Overflow Scenarios**  
  Overflow can be handled through buffer capacity or deferring lower-priority tokens (explained conceptually).

---

## Simplifications & Assumptions
To keep the project focused on backend logic and clarity:

- In-memory data structures are used instead of a database
- Simulation is limited to a single OPD day
- Slot capacities are fixed
- Advanced features such as schedulers, distributed queues, and persistence are explained conceptually rather than implemented

These simplifications were made intentionally to prioritize **logic clarity over infrastructure complexity**.

---

## Project Structure
opd-token-engine
├── src/main/java/com/example/opd
│ ├── OpdApplication.java
│ ├── controller
│ │ └── TokenController.java
│ ├── service
│ │ └── TokenService.java
│ ├── model
│ │ ├── Doctor.java
│ │ ├── Slot.java
│ │ ├── Token.java
│ │ ├── Priority.java
│ │ └── TokenStatus.java
│ └── dto
│ └── TokenRequest.java
└── README.md
