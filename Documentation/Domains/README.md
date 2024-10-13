# Domains

## What is a Domain?

In hexagonal architecture, a **domain** is an area of knowledge or responsibility that is encapsulated within a microservice. Each domain is independent and communicates with other domains through events and ports, following the principle of separation of concerns. Domains are the foundation of hexagonal architecture, allowing the system to be modular, scalable, and highly flexible.

## Domains of WandaSync

WandaSync is composed of several domains, each managing a specific aspect of the system. Below are the main domains of WandaSync:

### 1. Products 🛍️

#### Responsibilities

- **Product Management**: Handle product information, including names, descriptions, pricing, and images.
- **Inventory Management**: Track product availability and stock levels.

#### Entities

- **Product**: Represents an item available for purchase, containing details like name, description, price, and images.

### 2. Users 👥

#### Responsibilities

- **User Information Management**: Store and manage user profiles, including personal information and preferences.
- **Authentication and Authorization**: Handle user login, registration, and access control.
- **Order History**: Maintain a record of past orders for each user.

#### Entities

- **User**: Represents a customer with personal information, credentials, and preferences.

### 3. Orders 🛒

#### Responsibilities

- **Order Processing**: Create and manage orders placed by users.
- **Status Tracking**: Monitor the order status from initiation to fulfillment.
- **Order Validation**: Ensure that orders meet all criteria before processing (e.g., product availability).

#### Entities

- **Order**: Represents a purchase transaction, including user information, items ordered, total cost, and status.
- **OrderItem**: An individual product within an order, including quantity and price. This entity is part of the order aggregate and will reference a product entity.

### 4. Notifications 🔔

#### Responsibilities

- **Event-Based Notifications**: Send alerts to users based on events like order status updates.

#### Entities

- **Notification**: A message intended for the user, including content, type, and delivery channel.

## Conclusion

By focusing on these key domains—**Products** 🛍️, **Users** 👥, **Orders** 🛒, and **Notifications** 🔔—WandaSync ensures that each core functionality is encapsulated within its own microservice. This alignment with hexagonal architecture principles enhances modularity and scalability, allowing the system to efficiently handle essential e-commerce operations while remaining flexible to adapt to future requirements.