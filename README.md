# Burger Order

## Overview
Burger Order is a web application that allows users to create custom burgers by selecting various ingredients and placing orders. The application consists of a frontend built with Vue.js and a backend powered by Spring Boot.

## Features
- Create custom burgers with a variety of ingredients.
- View and manage your burger orders.
- Responsive design for optimal viewing on different devices.

## Architecture
The project is divided into two main parts:
1. **Client**: The frontend application built with Vue.js.
2. **Server**: The backend application built with Spring Boot.

### Client
- **Framework**: Vue.js
- **State Management**: Pinia
- **Routing**: Vue Router
- **Styling**: SCSS

### Server
- **Framework**: Spring Boot
- **Dependencies**: Lombok, Logstash, Spring Web, Spring Test
- **Database**: In-memory storage using a HashMap


## Project Setup

### Client
1. Navigate to the `client` directory.
2. Install dependencies:
    ```sh
    npm install
    ```
3. Run the development server:
    ```sh
    npm run serve
    ```

## API Endpoints
### OrderController
- `POST /order`: Add a new order.
- `GET /order/ingrediens`: Get available ingredients.
