# Supermarket Kata

## Services

com.risto.supermarket.discount[.api] - Discount storage service, used for adding discounts (rw)

com.risto.supermarket.stock[.api] - Stock storage service, used for adding stock items (rw)

com.risto.supermarket.supermarket[.api] - Supermarket and shopping cart service, used for querying stock and discounts (ro)



## REST API draft

### Discounts API

GET /discounts/api/v1/discount/{name}   - Get discount by name
POST /discounts/api/v1/discount/{name}  - Add new discount

GET /discounts/api/v1/discount  		- Get all discounts
DELETE /discounts/api/v1/discount  		- Delete all discounts

POST /discounts/api/v1/discount/calculate  - Calculate savings for items


### Stock API

GET /stock/api/v1/stock/{name}   - Get stocked item by name
POST /stock/api/v1/stock/{name}  - Add new item to stock

GET /stock/api/v1/stock  		 - Get all stocked items
DELETE /stock/api/v1/stock  	 - Delete all stocked items


### Supermarket API

GET /supermarket/api/v1/supermarket              - Get supermarket name, currency, and uuid

GET /supermarket/api/v1/supermarket/stock        - Get stocked items
GET /supermarket/api/v1/supermarket/stock/{name} - Get stocked item by name

GET /supermarket/api/v1/supermarket/discounts        - Get discounts
GET /supermarket/api/v1/supermarket/discounts/{name} - Get discount by name


POST /supermarket/api/v1/supermarket/cart        - Create new shopping cart

GET /supermarket/api/v1/supermarket/cart/{uuid}  - Get shopping cart contents and sub-total, savings, and total to pay info
PUT /supermarket/api/v1/supermarket/cart/{uuid}/item/{name}  - Add item to shopping cart
DELETE /supermarket/api/v1/supermarket/cart/{uuid}/item/{name}  - Remove item from shopping cart


