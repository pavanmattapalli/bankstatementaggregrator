# Bank Statement Aggregator

## Overview  
The **Bank Statement Aggregator** is an API-driven solution that processes and aggregates transaction statements for companies operating across multiple locations. The project uses **AWS S3, MySQL, and REST APIs** to store, parse, and retrieve transaction data.  

## API Endpoints  

### UserController  
#### 1. Register User  
**Endpoint:** `POST /users/register`  
**Request Body:**  
```json
{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "password123",
  "company": {
    "companyId": 1
  }
}
```
**Response:**  
- ✅ Success: *User registered successfully!*  
- ❌ Failure: *Company information is required, company does not exist, or username already exists.*  

#### 2. Login User  
**Endpoint:** `POST /users/login`  
**Request Example:**  
```
http://localhost:8080/users/login?username=john_doe&password=password123
```
**Response:**  
- ✅ Success: *Login successful!*  
- ❌ Failure: *Invalid username or password.*  

#### 3. Get User by ID  
**Endpoint:** `GET /users/{id}`  
**Example:**  
```
http://localhost:8080/users/1
```
**Response:**  
```json
{
  "userId": 1,
  "username": "john_doe",
  "email": "john@example.com",
  "company": {
    "companyId": 1,
    "companyName": "Example Company"
  }
}
```

#### 4. Get All Users  
**Endpoint:** `GET /users/all`  
**Example:**  
```
http://localhost:8080/users/all
```
**Response:**  
```json
[
  {
    "userId": 1,
    "username": "john_doe",
    "email": "john@example.com",
    "company": {
      "companyId": 1,
      "companyName": "Example Company"
    }
  },
  {
    "userId": 2,
    "username": "jane_doe",
    "email": "jane@example.com",
    "company": {
      "companyId": 1,
      "companyName": "Example Company"
    }
  }
]
```

---

### CompanyController  
#### 5. Create Company  
**Endpoint:** `POST /companies/create`  
**Request Body:**  
```json
{
  "companyName": "New Company"
}
```
**Response:**  
- ✅ Success: *Company created successfully!*  
- ❌ Failure: *Company already exists.*  

#### 6. Get Company by ID  
**Endpoint:** `GET /companies/{id}`  
**Example:**  
```
http://localhost:8080/companies/1
```
**Response:**  
```json
{
  "companyId": 1,
  "companyName": "Example Company"
}
```

#### 7. Get All Companies  
**Endpoint:** `GET /companies/all`  
**Example:**  
```
http://localhost:8080/companies/all
```
**Response:**  
```json
[
  {
    "companyId": 1,
    "companyName": "Example Company"
  },
  {
    "companyId": 2,
    "companyName": "Another Company"
  }
]
```

---

### StatementController  
#### 8. Generate Bank Statement  
**Endpoint:** `POST /statements/generate`  
**Request Example:**  
```
http://localhost:8080/statements/generate?userId=1&companyId=1&branchId=1&transactionCount=10&deleteAfterUpload=true
```
**Response:**  
- ✅ Success: *URL of the uploaded file*  
- ❌ Failure: *Error message*  

#### 9. Download Bank Statement  
**Endpoint:** `GET /statements/download`  
**Request Example:**  
```
http://localhost:8080/statements/download?key=company_1_user_1_1234567890.csv
```
**Response:**  
- ✅ Success: *File downloaded to user's downloads folder*  
- ❌ Failure: *Error message*  

#### 10. Parse Bank Statement  
**Endpoint:** `POST /statements/parse`  
**Request Example:**  
```
http://localhost:8080/statements/parse?filePath=/path/to/file.csv
```
**Response:**  
- ✅ Success: *Transactions parsed and saved successfully!*  
- ❌ Failure: *Error message*  

---

## Tech Stack Used
- **Backend:** Java/Spring Boot  
- **Database:** MySQL  
- **Cloud Services:** AWS S3, AWS IAM  
- **Testing:** Postman API  
- **Version Control:** Git & GitHub  

## How to Run the Project
1. Clone the repository:  
   ```bash
   git clone https://github.com/your-username/bankstatementaggregrator.git
   ```
2. Install dependencies (`Maven` for Java).  
3. Configure AWS credentials and database connection.  
4. Start the backend server:  
   ```bash
   mvn spring-boot:run
   ```
5. Test API endpoints using Postman.  

---

