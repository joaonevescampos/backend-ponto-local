# 📦 Ponto Local - backend

## 1) Introduction - Rômulo

---

## 2) Technologies - Thiago

---

## 3) Instructions to Run the API Locally  - João
### Prerequisites
Make sure you have the following installed:

- **Java JDK (preferably Java 21):** `java -version`

- **Maven :** `mvn -version`

A Spring Boot project with either pom.xml (Maven).

🚀 **Steps to Run the Spring Boot API**
1. Navigate to your project folder:
   `cd path/to/your/project`
2. Build the project and download dependencies `./mvnw clean install`.
   If the command above fails, try: `mvn clean install`

3. Run the Spring Boot application
   If you're using IntelliJ:
   Open the class annotated with @SpringBootApplication and click the green ▶ play button next to the main method.

Run via terminal (using Maven Wrapper):

`./mvnw spring-boot:run`

Or, if you have Maven installed globally:

`mvn spring-boot:run`

4. Verify if the API is running
   If everything works correctly, you'll see a message like:

scss
Copiar
Editar
Tomcat started on port(s): 8080
Now open your browser or a tool like Postman and go to:

arduino
Copiar
Editar
http://localhost:8080
You can test any available endpoints, like:

bash
Copiar
Editar
http://localhost:8080/api/users
(depending on your project structure)


---

## 4) Project Endpoints

### ✅ Sprint 1 — Registration, Authentication, Products and Address

#### 🧑‍💼 Users and Authentication - João

**POST   /auth/register**
- Register a user (merchant or customer)
  **POST   /auth/login**
- Login using email and password
  **GET    /users/me**
- Get authenticated user profile
  **PUT    /users/me**
- Update user profile
  **DELETE /users/me**
- Delete user account


#### 🧾 Merchants - Rômulo

**PUT    /sellers/verify**
- Register/update CNPJ/CPF and business info
  **GET    /sellers/:id**
- View a merchant's public profile


#### 📦 Products - Thiago

**POST   /products**
- Create a new product
  **GET    /products**
    - List products with filters (search, city, etc.)
      **GET    /products/:id**
- View product details
  **PUT    /products/:id**
    - Edit product (only owner)
      **DELETE /products/:id**
- Delete product

---

### 🏠 Address / Validation - Rômulo

**POST   /addresses/validate**
- Validate ZIP code and geolocation
  **PUT    /addresses**
- Update merchant address

---

### 🌍 Sprint 2 — Geolocation, Cart, Orders, Payments

#### 📍 Geolocation and Filters - João

**GET    /products/nearby**
- List products by radius (e.g., 30km) or neighborhood
  **GET    /locations**
    - List available states/cities/neighborhoods

#### 🛒 Cart - Thiago

**GET    /cart**
- View user's cart
  **POST   /cart**
    - Add product to cart
      **DELETE /cart/:productId**
- Remove product from cart


#### 📦 Orders - Rômulo

**POST   /orders**
- Complete an order
  **GET    /orders**
    - List user orders (customer)
      **GET    /orders/seller**
- List received orders (merchant)
  **GET    /orders/:id**
    - View order details

#### 💳 Payments - João

**POST   /payments/checkout**
- Create payment via Pix, credit card, etc.
  **POST   /payments/webhook**
    - Webhook for gateway notifications

---

### 💼 Sprint 3 — Commissions, Advertising, Subscriptions

#### 💰 Commissions and Monthly Subscription - Thiago

**GET    /payments/commissions**
- Commission report
  **POST   /subscriptions**
    - Pay subscription to keep store active
      **GET    /subscriptions/status**
- Check subscription status

#### 📢 Advertising - João

**POST   /ads/promote/:productId**
- Promote product with payment
  **GET    /ads**
    - List promoted ads


#### 📦 Product Basket Subscriptions - Rômulo

**POST   /plans/subscribe**
- Subscribe to product basket
  **GET    /plans**
- List subscription plans
  **GET    /plans/me**
- View active subscription
  **DELETE /plans/cancel**
- Cancel subscription

---

### 🎉 Sprint 4 — Events, Loyalty Program, Dashboard

#### 🎪 Virtual Events - João

**POST   /events**
- Create an event (market, promotion, etc.)
  **GET    /events**
- List events
  **GET    /events/:id**
- View event details

#### 🏅 Loyalty Program - Rômulo

**GET    /rewards**
- View user's points balance
  **POST   /rewards/redeem**
    - Redeem points for discounts

#### 📊 Reports and Dashboard - Thiago

**GET    /dashboard/sales**
- Sales report
  **GET    /dashboard/top-products**
    - Top-selling products
      **GET    /dashboard/overview**
- General store overview

---

## 👥 Authors

- João Victor Neves Campos de Jesus
- Thiago
- Rômulo
