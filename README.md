## OPD Token Allocation Engine

### Overview
This project implements a simplified OPD token allocation system using Spring Boot.
It focuses on core backend logic suitable for a backend intern assignment.

### Features Implemented
- Token booking with priority handling
- Slot capacity enforcement
- Emergency and high-priority insertion
- Token cancellation
- Slot status viewing

### Priority Order
1. Emergency
2. Paid
3. Follow-up
4. Online
5. Walk-in

### Simplifications
- In-memory storage is used instead of a database
- One-day OPD simulation
- Fixed slot capacities
- Advanced features like schedulers and distributed queues are explained conceptually

### Edge Cases (Explained)
- No-shows can be handled by cancelling tokens
- Doctor delays can be handled by shifting slot times
- Overflow can be handled by adding buffer capacity

### Tech Stack
- Java 17
- Spring Boot
- Maven
