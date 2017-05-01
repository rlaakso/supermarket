# Supermarket Kata

## Design assumptions

The supermarket is divided into three different services, stock and discount services for read-write access for stocked items database and discount database. Supermarket/shopping cart service provides read-only access to stocked items and discounts, and capability to create and use shopping carts. 


Items, Money, and Discounts are value objects used to model the stock and discounts.

ShoppingCart is an entity object which models shopping cart in a supermarket.

Supermarket is an aggregate object which models stock and discounts.

Domain events are not modelled.

ShoppingCart could be modified to use event sourcing, but at the moment it's just a snapshot of the cart contents.

StockRepository and DiscountRepository are repositories for storing stocked items and discounts.

DiscountCalculatorService is a service to calculate which discounts apply to a shopping cart. 

The design follows CQRS, where Supermarket is a query interface to stocked items and discounts, and StockRepository and DiscountRepository provide commands to alter stocked items and active discounts. 



### Compromises

- Items in shopping cart don't have local id's.

- Domain events are not modelled.

- Shopping cart could use event sourcing.


## Services

com.risto.supermarket.discount[.api] - Discount repository service, used for adding discounts (rw).

com.risto.supermarket.stock[.api] - Stock repository service, used for adding stock items (rw).

com.risto.supermarket.supermarket[.api] - Supermarket service, used for querying stock and discounts (ro).

com.risto.supermarket.shoppingcart[.api] - Shopping cart service, used to access shopping carts.


## REST API draft

### Discounts API

GET /discounts/api/v1/discount/{name}   - Get discount by name.

POST /discounts/api/v1/discount/{name}  - Add a new discount.


GET /discounts/api/v1/discount  		- Get all discounts.

DELETE /discounts/api/v1/discount  		- Delete all discounts.


POST /discounts/api/v1/discount/calculate  - Calculate savings for shopping cart items.


### Stock API

GET /stock/api/v1/stock/{name}   - Get stocked item by name.

POST /stock/api/v1/stock/{name}  - Add a new item to stock.


GET /stock/api/v1/stock  		 - Get all stocked items.

DELETE /stock/api/v1/stock  	 - Delete all stocked items.


### Supermarket API

GET /supermarket/api/v1/supermarket              - Get supermarket name, currency, and uuid.


GET /supermarket/api/v1/supermarket/stock        - Get all stocked items.

GET /supermarket/api/v1/supermarket/stock/{name} - Get stocked item by name.


GET /supermarket/api/v1/supermarket/discounts        - Get all discounts.

GET /supermarket/api/v1/supermarket/discounts/{name} - Get discount by name.


### Shopping Cart API

POST /shoppingcart/api/v1/cart        - Create a new shopping cart.

GET /shoppingcart/api/v1/cart/{uuid}  - Get shopping cart contents, sub-total, savings, and total to pay.

PUT /shoppingcart/api/v1/cart/{uuid}/item/{name}  - Add item to a shopping cart.

DELETE /shoppingcart/api/v1/cart/{uuid}/item/{name}  - Remove item from a shopping cart.


