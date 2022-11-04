<h1>Sample Customer API</h1>

This application provides a RESTful API for storing customer data.

The API is implemented in Spring Boot and written in Java 11. It currently stores all data in memory, so data will be lost when execution is stopped. However, sample data is seeded. Note that scope has also been included to easily transition to an external database in the future (see below). The API includes all standard CRUD operations as well as the ability to retrieve a list of customers by surname.

<h2>Operation</h2>

To use the API:
- Clone this repository with the command: git clone https://github.com/andrew-mahoney-mswdev/SpringBootAPI.git
- Execute the main method in /src/main/java/com/counties/customers/CustomersApplication.java
- The API is now available on http://localhost:8080/api/v1/customer
- HTTP requests can be sent to the API using your preferred method. The API was tested with Postman.

To get all customers:
- Send a GET request to localhost:8080/api/v1/customer
- 8 sample customers with random UUIDs should be returned

To get one customer:
- Copy the UUID of the customer you wish to get
- Send a GET request to localhost:8080/api/v1/customer/{id}
- The customer with the provided UUID should be returned

To create a customer:
- Send a POST request to localhost:8080/api/v1/customer with a JSON object in the following structure:<br>
    {<br>
        "name": "Andrew",<br>
        "surname": "Mahoney",<br>
        "email": "andrew.mahoney.mswdev@gmail.com"<br>
    }<br>
- If successful, the API should return a success value of 1
- You can get all customers to check that the new customer has been added
- Note that the "name" and "surname" values are required. The POST request will return a 400 status if either of these values are not provided. Email is not required as a customer may not have an email address.

To delete a customer:
- Copy the UUID of the customer you wish to delete
- Send a DELETE request to localhost:8080/api/v1/customer/{id}
- If successful, the API should return a success value of 1
- You can confirm the deletion by checking that no customer is returned when you pass a GET request to localhost:8080/api/v1/customer/{id}

To update a customer:
- Copy the UUID of the customer you wish to update
- Send a PUT request to localhost:8080/api/v1/customer/{id} with a JSON object in the following structure:<br>
    {<br>
        "name": "Ashton",<br>
        "surname": "Bingham",<br>
        "email": "ashton.bingham@gmail.com"<br>
    }<br>
- If successful, the API should return a success value of 1
- You can confirm the update by passing a GET request to localhost:8080/api/v1/customer/{id}
- Note that the "name" and "surname" values are required. The PUT request will return a 400 status if either of these values are not provided.

To retrieve all customers with a given surname:
- Send a PUT request to localhost:8080/api/v1/customer with a JSON object in the following structure:<br>
    {<br>
        "surname": "Bingham"<br>
    }<br>
- The API will return every customer with the specified surname

The application includes one JUnit test to verify customer retrieval by surname. This test is available in \src\test\java\com\counties\customers\CustomersApplicationTests.java. It can be run using the JUnit test execution feature of your IDE.

<h2>Further development</h2>

Scope has been included to easily transition to an external database. To do so, one could create a new DAO class that extends CustomerDAO. This class would need to access the external DB. The repository name of this class can then be autowired into the CustomerService class as a dependency injection.
