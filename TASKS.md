# Booking System Backend - Task Tracker

> **Status Legend:** `[ ]` Not Started | `[~]` In Progress | `[x]` Completed

---

## Phase 1: Foundation (Week 1-2)

### Project Setup
- [ ] Initialize Spring Boot 3.x project with Maven
- [ ] Configure Java 17+ and project dependencies in `pom.xml` 
- [ ] Set up `application.yml` with dev/prod profiles
- [ ] Configure PostgreSQL database connection
- [ ] Set up Spring Data JPA and Hibernate
- [ ] Configure SpringDoc OpenAPI (Swagger) for API docs
- [ ] Set up project package structure (`api/`, `service/`, `repository/`, `model/`, `dto/`, `mapper/`, `exception/`, `config/`, `util/`)

### Database Schema & Migrations
- [ ] Create `User` entity (id, email, password_hash, first_name, last_name, phone, role, timestamps)
- [ ] Create `Hotel` entity (id, name, description, address, city, country, star_rating, amenities, images, timestamps)
- [ ] Create `Room` entity (id, hotel_id FK, room_type, capacity, price_per_night, available, amenities, timestamps)
- [ ] Create `Booking` entity (id, user_id FK, room_id FK, hotel_id FK, check_in_date, check_out_date, guests_count, total_price, status, timestamps)
- [ ] Create `Payment` entity (id, booking_id FK, amount, currency, payment_method, payment_status, transaction_id, timestamps)
- [ ] Set up database indexes for performance (email, city, dates, status)
- [ ] Create seed data script for development/testing

### Global Configuration
- [ ] Create `GlobalExceptionHandler.java` with `@ControllerAdvice` 
- [ ] Define standard `ApiResponse<T>` wrapper (success, data, error, meta/pagination)
- [ ] Define custom exceptions (`ResourceNotFoundException`, `BookingException`, `PaymentException`)
- [ ] Configure CORS settings for frontend origin
- [ ] Set up logging configuration

### Repository Layer
- [ ] Create `UserRepository.java` with custom query methods
- [ ] Create `HotelRepository.java` with search/filter query methods
- [ ] Create `RoomRepository.java` with availability query methods
- [ ] Create `BookingRepository.java` with user booking query methods

---

## Phase 2: Authentication & Security (Week 2-3)

### Security Configuration
- [ ] Configure `SecurityConfig.java` - Spring Security filter chain
- [ ] Set up password encoding (BCrypt)
- [ ] Configure CSRF protection
- [ ] Set up rate limiting for auth endpoints
- [ ] Configure HTTPS settings

### JWT Implementation
- [ ] Create `JwtConfig.java` - JWT secret, expiration settings
- [ ] Create `JwtUtil.java` - token generation, validation, parsing
- [ ] Implement JWT authentication filter
- [ ] Implement token refresh mechanism
- [ ] Set up httpOnly cookie handling for tokens

### Auth DTOs
- [ ] Create `LoginRequest.java` (email, password)
- [ ] Create `RegisterRequest.java` (email, password, firstName, lastName, phone)
- [ ] Create `AuthResponse.java` (user info, token expiration)

### Auth Service & Controller
- [ ] Create `AuthService.java` interface
- [ ] Implement `AuthServiceImpl.java` - register, login, logout, refresh, getCurrentUser
- [ ] Implement email uniqueness validation
- [ ] Implement password strength validation
- [ ] Create `AuthController.java` with all auth endpoints:
  - [ ] `POST /api/auth/register` 
  - [ ] `POST /api/auth/login` 
  - [ ] `POST /api/auth/logout` 
  - [ ] `POST /api/auth/refresh` 
  - [ ] `GET /api/auth/me` 

### User Management
- [ ] Create `UserMapper.java` - entity to DTO mapping
- [ ] Implement user profile update service
- [ ] Implement role-based access control (USER, ADMIN roles)

---

## Phase 3: Hotel Management (Week 3-4)

### Hotel DTOs
- [ ] Create `HotelResponse.java` (full hotel details)
- [ ] Create `HotelSummaryResponse.java` (for search results list)
- [ ] Create `RoomResponse.java` (room details with pricing)
- [ ] Create `SearchRequest.java` (location, dates, guests, filters)
- [ ] Create `ReviewResponse.java` (review details)

### Hotel Mapper
- [ ] Create `HotelMapper.java` - entity to response DTO mapping
- [ ] Map amenities JSON to structured objects
- [ ] Map images JSON to URL list

### Hotel Service
- [ ] Create `HotelService.java` interface
- [ ] Implement `HotelServiceImpl.java`:
  - [ ] Search hotels by location, dates, guests with filtering
  - [ ] Get hotel by ID with full details
  - [ ] Get rooms for a hotel
  - [ ] Get reviews for a hotel
  - [ ] Check availability for date range
- [ ] Implement search result pagination and sorting
- [ ] Implement filter logic (price range, star rating, amenities)

### Hotel Controller
- [ ] Create `HotelController.java` with endpoints:
  - [ ] `GET /api/hotels/search` - search with query params
  - [ ] `GET /api/hotels/{id}` - hotel details
  - [ ] `GET /api/hotels/{id}/rooms` - hotel rooms
  - [ ] `GET /api/hotels/{id}/reviews` - hotel reviews
  - [ ] `GET /api/hotels/{id}/availability` - availability check

### Hotel Admin (CRUD)
- [ ] Implement hotel creation (admin only)
- [ ] Implement hotel update (admin only)
- [ ] Implement hotel deletion/deactivation (admin only)
- [ ] Implement room management (add/update/remove rooms)
- [ ] Implement image upload endpoint

---

## Phase 4: Booking System (Week 4-5)

### Booking DTOs
- [ ] Create `BookingRequest.java` (roomId, hotelId, checkIn, checkOut, guestsCount)
- [ ] Create `BookingResponse.java` (full booking details with hotel/room info)

### Booking Mapper
- [ ] Create `BookingMapper.java` - entity to response DTO mapping

### Booking Service
- [ ] Create `BookingService.java` interface
- [ ] Implement `BookingServiceImpl.java`:
  - [ ] Create booking with availability validation
  - [ ] Get booking by ID
  - [ ] Get all bookings for a user
  - [ ] Cancel booking with refund policy logic
- [ ] Implement room availability checking (no double bookings)
- [ ] Implement date range validation (check-in before check-out, no past dates)
- [ ] Implement pricing calculation (price_per_night x nights + taxes)
- [ ] Implement booking status transitions (PENDING -> CONFIRMED -> CANCELLED)
- [ ] Add concurrent booking conflict resolution

### Booking Controller
- [ ] Create `BookingController.java` with endpoints:
  - [ ] `POST /api/bookings` - create booking
  - [ ] `GET /api/bookings/{id}` - get booking
  - [ ] `GET /api/users/{userId}/bookings` - get user bookings
  - [ ] `PUT /api/bookings/{id}/cancel` - cancel booking

---

## Phase 5: Payment Integration (Week 5-6)

### Payment DTOs
- [ ] Create `PaymentIntentRequest.java` (bookingId, paymentMethod)
- [ ] Create `PaymentConfirmRequest.java` (paymentIntentId, paymentMethodId)
- [ ] Create `PaymentResponse.java` (status, amount, transactionId)

### Payment Service
- [ ] Create `PaymentService.java` interface
- [ ] Implement `PaymentServiceImpl.java`:
  - [ ] Create payment intent (Stripe integration)
  - [ ] Confirm payment
  - [ ] Get payment status
  - [ ] Handle payment webhooks
- [ ] Implement Strategy pattern for multiple payment methods
- [ ] Implement payment-booking status synchronization
- [ ] Handle payment failure and retry logic
- [ ] Implement refund processing for cancellations

### Payment Controller
- [ ] Create `PaymentController.java` with endpoints:
  - [ ] `POST /api/payments/create-intent` 
  - [ ] `POST /api/payments/confirm` 
  - [ ] `GET /api/payments/{id}/status` 
- [ ] Create webhook endpoint for Stripe callbacks

### Transaction Management
- [ ] Implement transactional booking + payment flow
- [ ] Add idempotency keys for payment operations
- [ ] Create payment audit logging

---

## Phase 6: Polish & Testing (Week 6-7)

### Unit Tests
- [ ] Write tests for `AuthService` (register, login, token handling)
- [ ] Write tests for `HotelService` (search, filter, availability)
- [ ] Write tests for `BookingService` (create, cancel, validation)
- [ ] Write tests for `PaymentService` (intent, confirm, status)
- [ ] Write tests for mappers
- [ ] Write tests for utility classes

### Integration Tests
- [ ] Write controller integration tests for auth endpoints
- [ ] Write controller integration tests for hotel endpoints
- [ ] Write controller integration tests for booking endpoints
- [ ] Write controller integration tests for payment endpoints
- [ ] Write repository integration tests with test database

### API Documentation
- [ ] Ensure all endpoints have OpenAPI annotations
- [ ] Add request/response examples in Swagger docs
- [ ] Document error codes and responses
- [ ] Add API versioning documentation

### Performance & Security
- [ ] Implement database query optimization (N+1 prevention, pagination)
- [ ] Add caching with Redis for hotel search results
- [ ] Implement connection pooling (HikariCP configuration)
- [ ] Add input validation and sanitization on all endpoints
- [ ] Implement SQL injection prevention verification
- [ ] Add rate limiting on sensitive endpoints
- [ ] Security audit - verify XSS, CSRF, and injection protections

### Deployment Preparation
- [ ] Create Dockerfile for containerization
- [ ] Set up `application-prod.yml` with production configs
- [ ] Configure health check endpoint (`/actuator/health`)
- [ ] Set up database migration tool (Flyway or Liquibase)
- [ ] Create CI/CD pipeline configuration
- [ ] Document deployment process

---

## Summary

| Phase | Tasks | Completed |
|-------|-------|-----------|
| Phase 1: Foundation | 22 | 0 |
| Phase 2: Authentication & Security | 22 | 0 |
| Phase 3: Hotel Management | 22 | 0 |
| Phase 4: Booking System | 16 | 0 |
| Phase 5: Payment Integration | 16 | 0 |
| Phase 6: Polish & Testing | 20 | 0 |
| **Total** | **118** | **0** |
