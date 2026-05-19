# 🧪 Activity: API Request Processing Pipeline (Decorator Pattern)

## 🎯 Objective

Design a backend API processing system using the **Decorator Pattern** to dynamically add features such as logging, authentication, caching, and rate limiting without modifying the core request handler.

---

## 📌 Scenario

You are building a backend API system that processes client requests.

The system already contains a clean core request handler responsible for processing requests.

However, new backend requirements appear:

* 📝 Request Logging
* 🔐 Authentication Checks
* ⚡ Response Caching
* 🚦 Rate Limiting

The challenge:

> these features should be added dynamically without modifying the original request service.

---

## ⚠️ Problem Context

Without a proper design:

* The main request handler becomes overloaded with responsibilities
* Logging, authentication, and caching logic become mixed together
* Service classes grow excessively large
* Code becomes tightly coupled
* Adding or removing features becomes difficult
* Maintenance becomes harder over time

Example bad design:

```java id="k29xsa"
processRequest() {
    authenticate();
    checkRateLimit();
    validateRequest();
    logRequest();
    checkCache();
    handleBusinessLogic();
}
```

This leads to:

* low flexibility
* difficult testing
* poor scalability
* duplicated cross-cutting logic

---

## 🧠 Your Task

Design an **API Request Processing Pipeline** using the **Decorator Pattern**.

You must:

* keep the core request handler unchanged
* add optional behaviors dynamically
* support multiple layered decorators
* allow combining decorators in different runtime orders
* keep each feature isolated in its own class

---

## 📏 Requirements

---

### 🔵 Component Interface

Create a standard interface:

* `RequestService`
* contains method: `handleRequest(String request)`

This represents the common contract used by all services and decorators.

---

### 🟢 Concrete Component

Create the original core service:

#### ⚙️ BasicRequestService

Responsibilities:

* process the API request
* contain only core business logic
* remain clean and minimal

Important:

> this class should NOT contain logging, caching, or authentication logic.

---

### 🟣 Base Decorator

Create an abstract decorator class:

#### 🧩 RequestServiceDecorator

The decorator must:

* implement `RequestService`
* store a wrapped `RequestService` object
* delegate execution internally

This class acts as the foundation for all decorators.

---

### 🟡 Concrete Decorators

Create separate decorators for additional features.

---

#### 📝 LoggingDecorator

Responsibilities:

* log request start
* log request completion

---

#### 🔐 AuthenticationDecorator

Responsibilities:

* verify user authentication
* allow request execution only if authenticated

---

#### ⚡ CachingDecorator

Responsibilities:

* simulate checking cached responses
* return cached data if available
* otherwise delegate request processing

---

#### 🚦 RateLimitingDecorator

Responsibilities:

* simulate request limit checks
* block excessive requests

---

## 🧩 Design Expectations

Your solution must:

* use object wrapping through composition
* keep core business logic isolated
* allow decorators to be combined dynamically
* follow Open/Closed Principle
* avoid modifying existing services
* separate each responsibility into its own decorator

---

## 🔌 Key Design Mapping

| Component                    | Role                |
| ---------------------------- | ------------------- |
| RequestService               | Component Interface |
| BasicRequestService          | Concrete Component  |
| RequestServiceDecorator      | Base Decorator      |
| Logging/Auth/Cache/RateLimit | Concrete Decorators |
| Main Class                   | Client              |

---

## ✅ Expected Outcome

A working system where:

* the core request service remains unchanged
* decorators add functionality externally
* features can be combined dynamically
* request flow passes through multiple layers
* responsibilities remain clean and isolated

---

## 🚀 Example Use Case (Conceptual Flow)

1. Create core request service
2. Wrap service with logging
3. Wrap logging with authentication
4. Wrap authentication with rate limiting
5. Execute final decorated object

Example conceptual flow:

```text id="s72kqp"
RateLimitingDecorator
    → AuthenticationDecorator
        → LoggingDecorator
            → BasicRequestService
```

---

## 🔁 Challenge Extension (Optional)

### 🔄 1. Add Compression Decorator

Create:

* `CompressionDecorator`

Responsibilities:

* simulate compressing API responses
* wrap existing request pipeline dynamically

---

### 📊 2. Add Monitoring Decorator

Track:

* execution time
* request metrics
* performance statistics

Without modifying existing decorators.

---

### 🧠 3. Dynamic Runtime Configuration

Allow the system to dynamically select decorators based on:

* configuration file
* environment settings
* request type
* API endpoint

---

## 📌 Key Insight

This activity demonstrates the core purpose of the **Decorator Pattern**:

> It allows behavior to be added dynamically without modifying existing code.

Most importantly:

* the core service remains stable
* features remain reusable
* responsibilities stay separated
* middleware pipelines become flexible and scalable
