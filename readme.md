# Microservices Product App

TODO description


# Endpoints

List of all the endpoints, ordered by microservice

## product-service endpoints
- GET - /api/product
-- List of all existing products
- GET - /api/product/id
-- Get product info by id
- POST - /api/product
-- Create a new product
- PUT - /api/product/{id}
-- Update an existing product
- DELETE - /api/product/{id}
-- Delete an existing product

## order-service endpoints
- GET - /api/order
-- List of all existing orders
- GET - /api/order/id
-- Get order info by id
- POST - /api/order
-- Create a new order
- PUT - /api/order/{id}
-- Update an existing order
- DELETE - /api/order/{id}
-- Delete an existing order

## inventory-service endpoints
- GET - /api/inventory (RequestBody skuCode, quantity)
-- Check if an item is in stock
- GET - /api/inventory/{skuCode}
-- Return the stock of the specified item
- POST - /api/inventory/ (RequestBody skuCode, quantity)
-- Create a new item with the specified quantity.
- TODO: PUT (aupdate), PATCH add, PATCH remove, DELETE, GET (all). Not necessary for this microservices example.