# 📦 Ponto Local - backend

## 1) Introduction

The project aims to help local merchants sell their products and services through a comprehensive platform that allows them to log in, register users, edit profiles, create, edit, and delete ads so that nearby consumers can view and purchase safely and quickly.

---

## 2) Technologies and Tools
- Java
- SpringBoot
- Postgres
- Insomnia
- Postman

---

## 3) Instructions to Run the API Locally 
### Prerequisites
Make sure you have the following installed:

- **Java JDK (preferably Java 21):** `java -version`

- **Maven :** `mvn -version`

A Spring Boot project with either pom.xml (Maven).

### Steps to Run the Spring Boot API
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

Tomcat started on port(s): 8080
Now open your browser or a tool like Postman and go to:

http://localhost:8080
You can test any available endpoints, like:

http://localhost:8080/login
(depending on your project structure)

---
## 4) Data base - Tables
### i) Users
This category will handle user registration data, both individuals and legal entities.
Users: General data for platform users. The following will be registered:

| Field                 | Type               | Description                     |
|-----------------------|--------------------|---------------------------------|
| user_id               | serial primary key | Unique user identification      |
| email                 | String             | email register                  |
| user_name             | String             | user/ company name              |
| user_password         | String             | user password (1)               |
| whatsapp              | String             | whatsapp number (2)             |
| person_type           | Boolean            | Identification PF / PJ          |
| user_cpf or user_cnpj | String             | CPF or CNPJ (3)                 |
| address               | String             | Address                         |
| cep                   | String             | CEP                             |
| city                  | String             | City                            |
| state                 | String             | State                           |
| date_creation         | timestamp          | Date of creation of the account |
| date_last_access      | timestamp          | Date of the last day logged     |

### ii) Products

This category will handle the registration data for the products and services to be offered.

CategoryProducts: Data on product categories:

| Field         | Type               | Description                    |
|---------------|--------------------|--------------------------------|
| category_id   | serial primary key | Unique category identification |
| category_name | String             | Name of the category           |

DataProduct: Products informations

| Field        | Type               | Description                      |
|--------------|--------------------|----------------------------------|
| product_id   | serial primary key | Unique product identification    |
| category_id  | serial foreign key | Unique product identification    |
| product_name | String             | Name of the product              |
| product_type | Boolean            | Product type: service or product |

UserProduct: Data on products/services offered by users:

| Field               | Type               | Description                          |
|---------------------|--------------------|--------------------------------------|
| product_detail_id   | serial primary key | Unique product detail identification |
| user_id             | serial foreign key | ID related to users                  |
| product_id          | String             | ID related to products               |
| product_price       | float              | Product price                        |
| product_description | String             | Product description                  |

ImageProduct: Product photos submitted by users:

| Field               | Type              | Description                          |
|---------------------|-------------------|--------------------------------------|
| product_image_id    | serial primary key | Unique product detail identification |
| product_id          | serial foreign key | ID related to products               |
| product_image       | file              | Image of the products                |


InventoryProducts: Data on the customer's inventory, if they are physical products (not services)

| Field            | Type               | Description                     |
|------------------|--------------------|---------------------------------|
| inventory_id     | serial primary key | Unique inventary identification |
| product_quantity | integer            | Quantity of products            |

### iii) Sales
This category will handle the sales data itself.
Sales: Sales data:

| Field         | Type               | Description                   |
|---------------|--------------------|-------------------------------|
| sales_id      | serial primary key | Unique id sale identification |
| seller_id     | serial foreign key | ID related to users           |
| consumer_id   | serial foreign key | ID related to users           |
| date_sale     | timestamp          | Data of sale                  |
| date_delivery | timestamp          | Data of delivery              |
| status        | serial foreign key | Status ID                     |
| total_price   | float              | Total order price             |
| date_delivery | timestamp          | Data of delivery              |

ItemsSales: Data on items sold:

| Field         | Type               | Description                     |
|---------------|--------------------|---------------------------------|
| sales_id      | serial foreign key | id sale related to Sales table  |
| item_id       | serial foreign key | ID related to product_detail_id |
| quantity      | integer            | Quantity of physics products    |
| item_price    | float              | Price of a item sold            |


Status: Sales status information:

| Field         | Type               | Description                                         |
|---------------|--------------------|-----------------------------------------------------|
| status_id     | serial primary key | Unique id status identification                     |
| status        | string             | Sale status: completed, pending, canceled, refunded |

---

## 5) API Endpoints Documentation

This document describes the RESTful API endpoints for a fullstack platform involving users, products, and sales.

---

## Authentication

### POST - `/login` - User login [status code: 200]

**Request example:**

```json
{
  "email": "user@example.com",
  "userPassword": "securePassword123"
}
```

**Response example:**

```json
{
  "token": "jwt_token_example",
  "userId": 1,
  "userName": "John Doe",
  "email": "user@example.com"
}
```

---

## Users

### POST - `/users` - Create a new user 

**Request example:**

```json
{
  "email": "user@example.com",
  "userName": "John Doe",
  "userPassword": "securePassword123",
  "whatsapp": "+5511999999999",
  "isPJ": true,
  "userCpfOrCnpj": "12345678900",
  "address": "123 Main St",
  "cep": "52415421"
}
```

**Response example:** *status code: 201*

```json
{
  "userId": 1,
  "message": "User created successfully"
}
```

### GET - `/users/:userId` - Get user details 

**Response example:** *status code: 200*

```json
{
  "userId": 1,
  "email": "user@example.com",
  "userName": "John Doe",
  "whatsapp": "+5511999999999",
  "isPJ": true,
  "userCpfOrCnpj": "12345678900",
  "address": "123 Main St",
  "cep": "54414142",
  "city": "Salvador",
  "state": "Bahia",
  "dateCreation": "2024-01-01T12:00:00Z",
  "dateLastAccess": "2024-01-05T08:30:00Z"
}
```

### PUT - `/users/:userId` - Update user account 

**Request example:**

```json
{
  "email": "user@example.com",
  "userName": "John Doe",
  "whatsapp": "+5511999999999",
  "isPJ": true,
  "userCpfOrCnpj": "12345678900",
  "address": "123 Main St",
  "cep": "54414142",
  "city": "Rio de Janeiro",
  "state": "Rio de Janeiro",
  "dateCreation": "2024-01-01T12:00:00Z",
  "dateLastAccess": "2024-01-05T08:30:00Z"
}
```

**Response example:** 
*status code: 201*

```json
{
  "userId": 1,
  "email": "user@example.com",
  "userName": "John Doe",
  "whatsapp": "+5511999999999",
  "isPJ": true,
  "userCpfOrCnpj": "12345678900",
  "address": "123 Main St",
  "cep": "54414142",
  "city": "Rio de Janeiro",
  "state": "Rio de Janeiro",
  "dateCreation": "2024-01-01T12:00:00Z",
  "dateLastAccess": "2024-01-05T08:30:00Z"
}
```

### DELETE - `/users/:userId` - Delete user account

**Response example:**
*status code: 204 - No content*

---

## Categories

### GET - `/categories` - List all categories

**Response example:**
*status code: 200*

```json
[
  {
    "categoryId": 1,
    "categoryName": "Electronics"
  },
  {
    "categoryId": 2,
    "categoryName": "Home Appliances"
  }
]
```

---

## Products

### POST - `/products` - Register a new product

**Request example:**

```json
{
  "categoryId": 1,
  "productName": "Smartphone",
  "isProduct": true
}
```

**Response example:**
*status code: 201*

```json
{
  "productId": 1,
  "productName": "Smartphone",
  "isProduct": true
}
```

### GET - `/products/:productId` - Get product details

**Response example:**

```json
{
  "productId": 1,
  "categoryId": 1,
  "productName": "Smartphone",
  "isProduct": true
}
```

### GET - `/products` - Get all products

**Response example:**
*status code 200*

```json
[
  {
    "productId": 1,
    "categoryId": 1,
    "productName": "Smartphone",
    "isProduct": true
  },
  {
    "productId": 2,
    "categoryId": 2,
    "productName": "Mesa",
    "isProduct": true
  }
]
```

### PUT - `/products/:productId` - Update product

**Request example:**

```json
  {
    "categoryId": 1,
    "productName": "TV",
    "isProduct": true
  }
```

**Response example:**
*status code 201*

```json
  {
    "productId": 1,
    "categoryId": 1,
    "productName": "TV",
    "isProduct": true
  }
```

### DELETE - `/products/:productId` - Delete product

**Response example:**
*status code 204 - No content*

---

## User Products

### POST - `/user-products` - User offers a product or service

**Request example:**

```json
{
  "userId": 1,
  "productId": 1,
  "productPrice": 999.99,
  "productDescription": "Brand new smartphone with 128GB storage"
}
```

**Response example:**

```json
{
   "productDetailId": 1, 
   "userId": 1,
   "productId": 1,
   "productPrice": 999.99,
   "productDescription": "Brand new smartphone with 128GB storage"
  
}
```

### GET - `/user-products/:productDetailId` - Get user product info

**Response example:**

```json
{
  "productDetailId": 1,
  "userId": 1,
  "productId": 1,
  "productPrice": 999.99,
  "productDescription": "Brand new smartphone with 128GB storage"
}
```

### PUT - `/user-products/:productDetailId` - Update user product info

**Request example:**

```json
{
  "userId": 1,
  "productId": 1,
  "productPrice": 899.99,
  "productDescription": "Brand new smartphone with 128GB storage, blue color, snapdragon process."
}
```

**Response example:**
*status code 201*

```json
{
  "productDetailId": 1,
   "userId": 1,
   "productId": 1,
   "productPrice": 899.99,
   "productDescription": "Brand new smartphone with 128GB storage, blue color, snapdragon process."
}
```

### DELETE - `/user-products/:productDetailId` - Update user product info

**Response example:**
*status code 204 - No content*

---

## Product Images

### POST - `/product-images` - Upload image for a product

**Request:** `multipart/form-data`

**Form fields:**

* `productId`: 1
* `productImage`: (file)

**Response example:**

```json
{
  "productImageId": 1,
  "message": "Image uploaded successfully"
}
```

### GET - `/product-images/:productId` - Get images for a product

**Response example:**

```json
[
  {
    "productImageId": 1,
    "productId": 1,
    "imageUrl": "https://example.com/images/1.jpg"
  }
]
```

### PUT - `/product-images/:productId` - Update image

**Request example:**

```json
[
  {
    "productImageId": 1,
    "productId": 1,
    "imageUrl": "https://example.com/images/1.jpg"
  }
]
```

**Response example:**
*status code: 201*

```json
[
  {
    "productImageId": 1,
    "productId": 1,
    "imageUrl": "https://example.com/images/1.jpg"
  }
]
```

### DELETE - `/product-images/:productId` - Get image

**Response example:**
*status code 204 - No content*

---

## Inventory

### POST - `/inventory` - Add product to inventory

**Request example:**

```json
{
  "productDetailId": 1,
  "productQuantity": 50
}
```

**Response example:**
*status code 201*

```json
{
  "inventoryId": 1,
  "message": "Inventory updated"
}
```

### GET - `/inventory/:productDetailId` - Get product inventory

**Response example:**
*status code 200*

```json
{
  "inventoryId": 1,
  "productQuantity": 50
}
```

### PUT - `/inventory/:productDetailId` - Update product to inventory

**Request example:**

```json
{
  "productDetailId": 1,
  "productQuantity": 100
}
```

**Response example:**
*status code 201*

```json
{
   "productDetailId": 1,
   "productQuantity": 100
}
```

### DELETE - `/inventory/:productDetailId` - Add product to inventory

**Response example:**
*status code: 204 - No content*

---

## Sales

### POST - `/sales` - Create a new sale

**Request example:**

```json
{
  "sellerId": 1,
  "consumerId": 2,
  "dateSale": "2024-07-20T14:00:00Z",
  "dateDelivery": "2024-07-23T14:00:00Z",
  "statusId": 1,
  "totalPrice": 1999.99
}
```

**Response example:**
*status code 201*

```json
{
  "salesId": 1,
   "sellerId": 1,
   "consumerId": 2,
   "dateSale": "2024-07-20T14:00:00Z",
   "dateDelivery": "2024-07-23T14:00:00Z",
   "statusId": 1,
   "totalPrice": 1999.99
}
```

### GET - `/sales/:salesId` - Get sale details

**Response example:**

```json
{
  "salesId": 1,
  "sellerId": 1,
  "consumerId": 2,
  "dateSale": "2024-07-20T14:00:00Z",
  "dateDelivery": "2024-07-23T14:00:00Z",
  "statusId": 1,
  "totalPrice": 1999.99
}
```
### PUT - `/sales/:salesId` - Update status of the sale

**Request example:**

```json
{
  "sellerId": 1,
  "consumerId": 2,
  "dateSale": "2024-07-20T14:00:00Z",
  "dateDelivery": "2024-07-23T14:00:00Z",
  "statusId": 2,
  "totalPrice": 1999.99
}
```

**Response example:**
*status code 201*

```json
{
  "salesId": 1,
   "sellerId": 1,
   "consumerId": 2,
   "dateSale": "2024-07-20T14:00:00Z",
   "dateDelivery": "2024-07-23T14:00:00Z",
   "statusId": 2,
   "totalPrice": 1999.99
}
```

---

## Sale Items

### POST - `/sale-items` - Add item to a sale

**Request example:**

```json
{
  "salesId": 1,
  "itemId": 1,
  "quantity": 2,
  "itemPrice": 999.99
}
```

**Response example:**

```json
{
  "message": "Item added to sale"
}
```

### GET - `/sale-items/:salesId` - Get items for a sale

**Response example:**

```json
[
  {
    "itemId": 1,
    "quantity": 2,
    "itemPrice": 999.99
  }
]
```

### PUT - `/sale-items/:salesId` - Update item to a sale

**Request example:**

```json
{
  "salesId": 1,
  "itemId": 1,
  "quantity": 4,
  "itemPrice": 1999.99
}
```

**Response example:**

```json
{
   "salesId": 1,
   "itemId": 1,
   "quantity": 4,
   "itemPrice": 1999.99
}
```

---

## Sale Status

### GET - `/statuses` - Get all possible sale statuses

**Response example:**

```json
[
  {
    "statusId": 1,
    "status": "Pending"
  },
  {
    "statusId": 2,
    "status": "Completed"
  },
  {
    "statusId": 3,
    "status": "Canceled"
  }
]
```
---

## 👥 Authors

- Edio Fassbinder Junior
- João Victor Neves Campos de Jesus
- Thiago Rocha Gomes
- Rômulo Sousa Canto
