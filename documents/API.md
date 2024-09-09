## HATEOAS - Hypermedia API

#### Web URLs

|Web URL                           | HTTP Action | Operation                | 
|----------------------------------|-------------|--------------------------|
|`http://localhost:8080/index.html`| GET         | Returns `index.html` page|

#### Explore Rest APIs

Naviagte to the root URL : [http://localhost:8080/](http://localhost:8080/)

<img src="images\url-root.PNG"/>

- **Filtering:** 
to narrow down the query results by specific parameters, eg. id, or email
```
GET /api/persons?email=example1@domain.com
GET /api/cars?id=3
```

- **Sorting:** 
basically allows sorting the results ascending or descending by a chosen parameter or parameters, eg. by name
```
GET /api/cars?sort=name,asc
GET /api/cars?sort=name,desc
```

##### Person APIs

| RESTful URL                      | HTTP Action | Noun  |Business Operation |Remarks                    | 
|----------------------------------|-------------|-------|-------------------|---------------------------|
|`/api/persons`                    |GET          |persons|get all persons    |                           |  
|`/api/persons`                    |POST         |persons|create person      |[Sample JSON Body](#person)|  
|`/api/persons/{id}`               |PUT          |persons|update person      |[Sample JSON Body](#person)|  
|`/api/persons/{id}`               |GET          |persons|get person by id   |                           |  
|`/api/persons/{id}`               |DELETE       |persons|delete person by id|                           | 

##### Person APIs others

| RESTful URL                      | HTTP Action | Noun  |Business Operation         |Remarks                    | 
|----------------------------------|-------------|-------|---------------------------|---------------------------|
|`/api/persons/{id}/books`         |GET          |books  |get all books of person    |                           |  
|`/api/persons/{id}/movies`        |GET          |movies |get all movies of person   |                           |  
|`/api/persons/{id}/address`       |GET          |address|get address of person      |                           |  

##### Address APIs

| RESTful URL                      | HTTP Action | Noun  |Business Operation         |Remarks                    | 
|----------------------------------|-------------|-------|---------------------------|---------------------------|
|`/api/addresses`                  |GET          |address|get all addresses          |                           | 
|`/api/addresses/{id}`             |GET          |address|get address by address id  |                           | 
|`/api/addresses/{id}/person`      |GET          |address|get person by address id   |                           | 

##### Books APIs

| RESTful URL                      | HTTP Action | Noun  |Business Operation         |Remarks                    | 
|----------------------------------|-------------|-------|---------------------------|---------------------------|
|`/api/bookses`                    |GET          |bookses|get all books              |                           | 
|`/api/bookses/{id}`               |GET          |bookses|get a book by id           |                           | 

##### Movies APIs

| RESTful URL                      | HTTP Action | Noun  |Business Operation         |Remarks                    | 
|----------------------------------|-------------|-------|---------------------------|---------------------------|
|`/api/movies`                     |GET          |movies |get all movies             |                           | 
|`/api/movies/{id}`                |GET          |movies |get a movie by id          |                           | 
|`/api/movies/{id}/persons`        |GET          |movies |get a movie by id          | Test Pending              | 

##### Sample Valid JSON Request Body

###### <a id="person">Person -> /api/person</a>

```json
{
  "name": "aws3",
  "email": "examplt3@domain.com",
  "mobileNumber": "1234771",
  "address": {
    "city": "Wisopburgh-aws",
    "zipcode": "9077-777"
  },
  "books": [
    {
      "title": "book33"
    },
    {
      "title": "book34"
    }
  ]
}
```
