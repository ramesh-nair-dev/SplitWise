
---

# 💸 SplitWise Clone – Expense Sharing Backend

A backend system that models the **core principles of expense sharing** as seen in SplitWise.
This project was built with **enterprise engineering discipline**: layered architecture, domain-driven design, and extensibility in mind.

---

## 🚀 Why This Project Stands Out

This isn’t just “expense CRUD.” It demonstrates **system-level thinking**:

* **Domain-Driven Entities**
  `User`, `Expense`, `Group`, `Transaction`, `Balance` — mapped to reflect real-world relationships.

* **Expense Splitting Strategies**

  * Equal split
  * Percentage split
  * Exact amount split
    Encapsulated via **Strategy Pattern**, making the system extensible for future splitting rules.

* **Layered Architecture**
  Controllers → Services → Repositories → DTOs → Entities.
  Ensures separation of concerns and maintainability.

* **Settlement Engine**
  Tracks outstanding balances and optimizes settlement among users — moving the system closer to real production behavior.

* **State Modeling**
  Enums for expense types and payment statuses guarantee correctness at compile-time.

This system captures **the essence of SplitWise**, but designed as a **clean, extensible backend**.

---

## 📂 Project Structure

```
src/main/java/splitwise
├── controller        # REST entry points (Expense, User, Group)
├── service           # Business logic (ExpenseService, BalanceService)
├── repository        # JPA Repositories for persistence
├── dtos              # Request & Response contracts
├── models            # Entities (User, Expense, Group, Balance, Transaction)
└── enums             # Strongly typed states (ExpenseType, PaymentStatus)
```

---

## ⚙️ Core Features

* **User Management** → Create and manage users
* **Expense Creation** → Add expenses with different split strategies
* **Balance Tracking** → Who owes whom and how much
* **Settlement** → Optimized settlement logic to minimize transactions
* **Group Expenses** → Track shared costs within groups
* **Clean API Contracts** → DTO-based requests and responses

---

## 🧠 Engineering Insights Reflected Here

* **Strategy Pattern** → Used for flexible expense-splitting rules.
* **Decoupling for evolution** → Expense calculation, settlement, and persistence are modular.
* **Error resilience** → Strongly typed enums prevent invalid states.
* **Extensibility** → New split strategies or payment flows can be added without breaking existing code.
* **Real-world abstraction** → System mirrors how real expense apps like SplitWise handle balances.

---

## ⚡ Quick Start

```bash
# Clone repo
git clone https://github.com/your-username/SplitWise.git
cd SplitWise

# Build & run
mvn spring-boot:run
```

App starts at: [http://localhost:8080](http://localhost:8080)

---

## 🏆 Takeaway

This project goes beyond CRUD.
It demonstrates:

* **System design maturity**
* **Knowledge of design patterns**
* **Ability to translate real-world problems into clean backend solutions**

The implementation is closer to how **product companies architect real systems** — layered, extensible, and production-oriented.

---

## 👤 Author

**Ramesh Nair**

* Backend Engineer | Java | Spring Boot | System Design Enthusiast
* Focused on building **scalable, maintainable, real-world systems**.
* Passionate about **clean architecture, design patterns, and domain modeling**.

📫 Reach me at: \[[your-email@example.com](mailto:your-email@example.com)]
🌐 GitHub: [github.com/your-username](https://github.com/your-username)

---

⚡ This README positions your SplitWise project as an **elite-level engineering artifact**, not a student exercise.

---

👉 Do you want me to also add a **Mermaid system diagram** (like expense flow → splitting → balance → settlement) so that recruiters see a **visual architecture** right in your README? That would silently scream *“this guy thinks like a system designer.”*
