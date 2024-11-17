# Domains

## What is a Domain?

In hexagonal architecture, a **domain** is an area of knowledge or responsibility that is encapsulated within a microservice. Each domain is independent and communicates with other domains through events and ports, following the principle of separation of concerns. Domains are the foundation of hexagonal architecture, allowing the system to be modular, scalable, and highly flexible.

## Domains of WandaSync

WandaSync is composed of several domains, each managing a specific aspect of the system. Below are the main domains of WandaSync:

### 1. Products 🛍️

#### Responsibilities

- **Product Management**: Handle product information, including names, descriptions, pricing, images, brand, and attributes.
- **Inventory Management**: Track product availability and manage stock levels across different dealers.

#### Entities

- **ParentProduct**: Represents the general information of a product without specific variations such as size or color. This includes attributes like brand, model, material, and category.
- **Product**: Represents an item available for purchase, including specific variations like size and color, as well as retail price, stock, and dealer price.
- **Brand**: Represents the brand associated with a product, including contact information.
- **Category**: Categorizes products into groups and may have a parent category for hierarchical structuring.
- **Department**: Represents different departments for products (e.g., Men's, Women's).
- **Dealer**: Represents the supplier or vendor of a product.
- **ProductDealer**: Manages the association between a product and its dealer, keeping track of stock and pricing.

### 2. Users 👥

#### Responsibilities

- **User Information Management**: Store and manage user profiles, including personal information, contact details, and group memberships.
- **Authentication and Authorization**: Handle user credentials and group-based permissions.
- **Address Management**: Store and manage multiple addresses for billing and shipping purposes.

#### Entities

- **User**: Represents a customer with personal information, credentials, billing and shipping addresses, and group association.
- **Credentials**: Manages user credentials securely, including password information.
- **Address**: Represents addresses for billing and shipping purposes.
- **Group**: Defines user groups to manage permissions and group-specific functionalities.

### 3. Orders 🛒

#### Responsibilities

- **Order Processing**: Create and manage orders placed by users.
- **Order Line Items**: Manage individual products within an order, including their quantities and prices.
- **Order Summary and Validation**: Calculate total order amounts and ensure that orders meet all criteria before processing.

#### Entities

- **Order**: Represents a purchase transaction, including the user who placed it, the order date, and its status.
- **OrderLine**: Represents an item within an order, including the product, quantity, and price. The total price is derived based on the unit price and quantity.

### 4. Notifications 🔔

#### Responsibilities

- **Event-Based Notifications**: Send alerts to users based on system events, such as order status updates.
- **Message Management**: Manage the content of notifications and ensure they reach the correct user.

#### Entities

- **Notification**: Represents a message intended for a user, including details like creation date, content, and user association.

## General Domain Class Diagram

The following diagram illustrates the relationships and structure of the different domains within WandaSync. Each domain encapsulates entities with specific responsibilities, which communicate across boundaries via defined relationships.

![General Domain Class Diagram](./Diagrams/General%20Domain%20Class%20Diagram.png)

## Conclusion

By focusing on these key domains—**Products** 🛍️, **Users** 👥, **Orders** 🛒, and **Notifications** 🔔—WandaSync ensures that each core functionality is encapsulated within its own microservice. This alignment with hexagonal architecture principles enhances modularity and scalability, allowing the system to efficiently handle essential e-commerce operations while remaining flexible to adapt to future requirements.