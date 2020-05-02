## The workflow of the Project
#### User Login Module
Use the Respective API's for the Registration and Login



The Product API to add into the system is open and available without any login also

`POST  URL http://localhost:8080/product/add`

`Sample Body `

`{
 	"productName" : "abc",
 	"productDescription" : "Hello ",
 	"productPrice" : "120.5",
 	"available" : "true"
 }`
 
 `Sample Response`
 
 `{
      "id": 1,
      "productName": "abc",
      "productDescription": "Hello ",
      "productPrice": 120.5,
      "available": null,
      "statusInfo": {
          "status": "SUCCESS",
          "messages": null
      }
  }`
  
  Once The logged in user can transact any product
  
  Here's the API to fetch all the products
  
  `GET http://localhost:8080/product/listAll`
  
  `Sample Response {
                       "items": [
                           {
                               "id": 1,
                               "productName": "vvv",
                               "productDescription": "Hello ",
                               "productPrice": 12.5,
                               "available": true
                           },
                           {
                               "id": 2,
                               "productName": "vvv",
                               "productDescription": "Hello ",
                               "productPrice": 12.5,
                               "available": false
                           }
                       ],
                       "statusInfo": {
                           "status": "SUCCESS",
                           "messages": null
                       }
                   }`
                   
   Bases on the available flag a User can add a Product to his transaction
   
   Here's the API to add a transaction for a User 
   
   `POST http://localhost:8080/transaction/add`
   
   `Request Body Sample  {
                         	"userProfile":{
                         		"id" : 30
                         	},
                         	"product" : {
                         		"id" : 1
                         	},
                         	"quantity" : 10
                         }`
                         
   `Response Body  {
                       "id": 1,
                       "userProfile": {
                           "id": 30,
                           "userLogin": null,
                           "firstName": null,
                           "lastName": null,
                           "email": null,
                           "phoneNumber": null,
                           "addressLine1": null,
                           "addressLine2": null,
                           "zipcode": null,
                           "sellerProfile": false,
                           "sellerBusinessName": null,
                           "sellerProfiles": null,
                           "staff": null,
                           "itemInventory": null,
                           "cartItems": null,
                           "ordersMade": null
                       },
                       "product": {
                           "id": 1,
                           "productName": null,
                           "productDescription": null,
                           "productPrice": null,
                           "available": null
                       },
                       "quantity": 10,
                       "statusInfo": {
                           "status": "SUCCESS",
                           "messages": null
                       },
                       "totalPurchase": 0.0
                   }`
                   
   You can List all the transactions made by a User using the API
   
   `GET http://localhost:8080/transaction/listAll/{userId}  sample call http://localhost:8080/transaction/listAll/30`
   
   `Response Body`
   
   `{
        "items": [
            {
                "id": 1,
                "userProfile": {
                    "id": 30,
                    "userLogin": {
                        "id": 30,
                        "username": "staffUser10",
                        "password": "admin"
                    },
                    "firstName": "staffFirstname10",
                    "lastName": "staffLastname",
                    "email": "staffUser10@abc.com",
                    "phoneNumber": "123456789",
                    "addressLine1": "staffUser10add1",
                    "addressLine2": "staffUser10add2",
                    "zipcode": "12345",
                    "sellerProfile": false,
                    "sellerBusinessName": null,
                    "sellerProfiles": [],
                    "staff": [],
                    "itemInventory": [],
                    "cartItems": [],
                    "ordersMade": []
                },
                "product": {
                    "id": 1,
                    "productName": "abc",
                    "productDescription": "Hello ",
                    "productPrice": 120.5,
                    "available": true
                },
                "quantity": 10,
                "statusInfo": null,
                "totalPurchase": 1205.0
            }
        ],
        "statusInfo": {
            "status": "SUCCESS",
            "messages": null
        }
    }`
   
