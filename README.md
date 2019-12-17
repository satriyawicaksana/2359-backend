# 2359-backend
Backend test for 2359
Backend Application Raw can be found at dir `App`

## List of end point

| No. | Description                           | Method | Endpoint                                       | Params         | Body                                 | Output           |
|-----|---------------------------------------|--------|------------------------------------------------|----------------|--------------------------------------|------------------|
| 1.  | Get All Available Shape               | GET    | `http://localhost:8080/shapes`                 | `null`         | `null`                               | List<Shape>      |
| 2.  | Get Detail of selected Shape          | GET    | `http://localhost:8080/shapes/{id}`            | String id      | `null`                               | Optional<Shape>  |
| 3.  | Calculate Area of Shape               | GET    | `http://localhost:8080/shapes/calculate`       | `null`         | * Object with shapeId, and Requirement | String           |
| 4.  | Save Calculate result                 | POST   | `http://localhost:8080/shapes/calculate`       | `null`         | SavedShape                           | `null`           |
| 5.  | Get All Saved Shape                   | GET    | `http://localhost:8080/shapes/saved`           | `null`         | `null`                               | List<SavedShape> |
| 6.  | Get All Saved Shape for each user     | GET    | `http://localhost:8080/shapes/saved/{userid}`  | String userid  | `null`                               | List<SavedShape> |
| 7.  | Admin Add new Shape for each user     | POST   | `http://localhost:8080/shapes/saved`           | `null`         | SavedShape                           | `null`           |
| 8.  | Admin Edit Shape for each user        | PUT    | `http://localhost:8080/shapes/saved/{shapeId}` | String shapeId | SavedShape                           | `null`           |
| 9.  | Admin Delete Shape for each user      | DELETE | `http://localhost:8080/shapes/saved/{shapeId}` | String shapeId | `null`                               | `null`           |
| 10. | User Sign Up                          | POST   | `http://localhost:8080/signup`                 | `null`         | User                                 | `null`           |
| 11. | Admin Sign Up                         | POST   | `http://localhost:8080/admin/signup`           | `null`         | User                                 | `null`           |
| 12. | Admin Delete User                     | DELETE | `http://localhost:8080/admin/delete/{userId}`  | String userId  | `null`                               | `null`           |
| 13. | User Sign In                          | POST   | `http://localhost:8080/signin`                 | `null`         | User                                 | boolean          |
| 14. | (Addition) User check unique username | POST   | `http://localhost:8080/checkUser`              | `null`         | String username                      | boolean          |
| 15. | Admin Edit Categories, Requirement, Area Formula, and Name | PUT   | `http://localhost:8080/shapes{shapeId}`              | String shapeId         | Shape                      | boolean          |

## Data Structure
1. Shape  
  `private String _id;`  
  `private String name;`  
  `private int shapeid;`  
  `private Map<String, Double>[] requirement;`  
  `private int[] categories;`  
  `private String[] area;`  
2. SavedShape  
  `String _id;`  
  `String userid;`  
  `String name;`  
  `int shapeid;`  
  `Map<String, Double> requirement;`  
  `double area;`  
  `int[] categories;`  
  `String[] categoriesString;`  
3. User  
  `String _id;`  
  `String username;`  
  `String password;`  
  `String fullname;`  
  `String role;`  
4. * Object with shapeId, and Requirement  
  `int shapeid `  
  `Map<String, Double> requirement `  
  
## how to import data
In order to work with the list of Shape. we need to import our initial table of `shape`, and `superuser`.  
Those file can be found in root directory of this project called `initialshape.json` and `superuser.json`  
### Collection Structure
![Collection MongoDB Structure ](https://raw.githubusercontent.com/satriyawicaksana/2359-backend/master/CollectionStructure.PNG)
### Document Structure
#### Shape
![Document Structure for Shape](https://raw.githubusercontent.com/satriyawicaksana/2359-backend/master/Document%20for%20Shape.PNG)
#### Saved Shape
![Document Structure for Saved Shape](https://raw.githubusercontent.com/satriyawicaksana/2359-backend/master/Document%20for%20Saved%20Shape.PNG)
#### User
![Document Structure for Shape](https://raw.githubusercontent.com/satriyawicaksana/2359-backend/master/Document%20for%20User.PNG)
