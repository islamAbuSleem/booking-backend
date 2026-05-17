# Booking System - Backend

A robust hotel booking system backend built with Spring Boot, following SOLID principles and Clean Code practices.

## Tech Stack

- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Build Tool**: Maven
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA + Hibernate
- **Security**: Spring Security + JWT
- **API Documentation**: SpringDoc OpenAPI (Swagger)
- **Testing**: JUnit 5 + Mockito
- **Payment Gateway**: Stripe SDK

## Project Structure

```
src/main/java/com/booking/
├── api/                    # REST Controllers
├── service/                # Business Logic Layer
├── repository/             # Data Access Layer
├── model/                  # Domain Models (JPA Entities)
├── dto/                    # Data Transfer Objects
│   ├── request/            # Request DTOs
│   └── response/           # Response DTOs
├── mapper/                 # Object Mapping
├── exception/              # Custom Exceptions & Global Handler
├── config/                 # Configuration (Security, JWT, DB)
├── util/                   # Utilities
└── BookingApplication.java
```

## Architecture Principles

- **SRP**: Each class has a single responsibility
- **OCP**: Extensible via interfaces and patterns (Strategy, Factory)
- **LSP**: Proper inheritance hierarchies
- **ISP**: Specific interfaces for different concerns
- **DIP**: Constructor injection, depend on abstractions

## API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout
- `POST /api/auth/refresh` - Refresh token
- `GET /api/auth/me` - Get current user

### Hotels
- `GET /api/hotels/search` - Search hotels
- `GET /api/hotels/{id}` - Get hotel details
- `GET /api/hotels/{id}/rooms` - Get hotel rooms
- `GET /api/hotels/{id}/reviews` - Get hotel reviews
- `GET /api/hotels/{id}/availability` - Check availability

### Bookings
- `POST /api/bookings` - Create booking
- `GET /api/bookings/{id}` - Get booking details
- `GET /api/users/{userId}/bookings` - Get user bookings
- `PUT /api/bookings/{id}/cancel` - Cancel booking

### Payments
- `POST /api/payments/create-intent` - Create payment intent
- `POST /api/payments/confirm` - Confirm payment
- `GET /api/payments/{id}/status` - Get payment status

## Getting Started

```bash
mvn clean install
mvn spring-boot:run
```

## Frontend

This backend serves the [booking-frontend](https://github.com/islamAbuSleem/booking-frontend). See `TASKS.md` for the full implementation plan and progress tracking.

## License

MIT
