# 🎬 SeatFix System

**SeatFix System** is a full-fledged backend system for booking movies and events, inspired by the BookMyShow use case. Designed and implemented from scratch, this project demonstrates strong understanding and application of Low-Level Design (LLD), Object-Oriented Principles, Design Patterns, and scalable system development using modern Java and Spring Boot technologies.

---

## 📌 Project Overview

This backend application enables users to:

- Book tickets seamlessly
- Handle concurrent booking scenarios
- Ensure secure authentication and user management

The system was designed with a focus on:

- ⚙️ **Scalability**
- 🧱 **Maintainability**
- 🔁 **Extensibility**
- ✅ **Security**

---

## 🧠 Key Highlights

### ✅ **Low-Level Design (LLD)**

- Created detailed **Class Diagrams**, **Entity-Relationship Diagrams**, and **Schema Design**
- Followed solid **Object-Oriented Programming (OOP)** principles
- Designed for real-world use cases with scalability in mind

### 💡 **Design Principles Used**

- **Single Responsibility Principle**
- **Open/Closed Principle**
- **Liskov Substitution Principle**
- **Interface Segregation Principle**
- **Dependency Inversion Principle**

### 🧰 **Design Patterns Applied**

- **Singleton Pattern**: Used for concurrency control during ticket booking (ensuring thread-safety and consistency)
---

## 🛠️ Tech Stack

| Layer              | Technology / Tool              |
|--------------------|--------------------------------|
| Language           | Java                           |
| Framework          | Spring Boot                    |
| ORM                | Hibernate + JPA                |
| Security           | Spring Security                |
| Database           | MySQL (via MySQL Workbench)    |
| Architecture       | MVC (Model-View-Controller)    |
| Password Handling  | BCrypt (for hashing passwords) |
| Exception Handling | Custom Exceptions              |
| Build Tool         | Maven / Gradle                 |

---

## 🔐 Security Features

- Integrated **Spring Security** for authentication and authorization
- Used **BCrypt Algorithm** for secure password encryption
- Followed best practices for data validation and secure API development

---

## 💬 Features

- User Registration & Login
- View Movies and Event Listings
- Book Tickets (Handles concurrent requests safely)
- Seat Selection and Availability Checking

---

## 📊 Database Design

- **Entities**: User, Movie, Event, Theater, Screen, Seat, Show, Booking, Payment
- Relationships:
  - One-to-Many: Theater → Screens
  - One-to-Many: Screen → Shows
  - Many-to-Many: Users ↔ Bookings (via Tickets)
  - Show ↔ Seat Mapping for availability

---

## 📈 Scalability & Extensibility

- Designed keeping **future scale** in mind: microservices ready structure
- Follows **Separation of Concerns** for easy feature addition and maintenance
- **Reusable services** and layered architecture (Controller, Service, Repository)

---

## 🧪 Testing & Validation

- Unit tested core services and repository layers
- Exception handling implemented across layers
- Input validations using annotations and custom validators

---

## 🧑‍💻 Author

> **Shivam Kanaujiya**  
> Backend Developer | LLD Enthusiast | Java & Spring Expert  
> [GitHub Profile](https://github.com/Sk2k19)  
> [LinkedIn](https://www.linkedin.com/in/shivam-kanaujiya-b53070213/) *(if applicable)*

---

## 🚀 Future Improvements

- Integrate payment gateway (Razorpay / Stripe)
- Implement caching with Redis for show availability
- Add real-time seat locking with WebSockets
- Build frontend using React or Angular
- Convert to microservices architecture

---

## 📁 How to Run

1. Clone the repository  
   `git clone https://github.com/Sk2k19/Seatifix-System.git`

2. Navigate to the project folder  
   `cd seatfix-system`

3. Configure `application.properties` with your DB credentials

4. Run the application  
   `./mvnw spring-boot:run`

5. Access the app via Postman or Swagger UI (if enabled)

---

## 🙌 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---


