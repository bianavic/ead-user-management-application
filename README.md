# ead-user-management-application

Projeto backend baseado em Rest API utilizando o framework Spring para o gerenciamento de usuários de um sistema

--- 
#### Checklist

- [x] Utilização de um editor de código sugerido neste documento;
- [x] Instalação do Postman e do Git (opcional);
- [x] Criação do projeto base;
- [x] Adição das dependências e implementação das properties.
- [x] Implementação das classes: User, UserResource e UserService.
- [x] Implementação da interface UserRepository.
- [x] Implementação das classes e mecanismo de exceção.
- [x] Configuração da aplicação para testes.
- [x] Teste da aplicação com a ferramenta postman.

---

### instalação
1. Clone o repositorio
```bash
git clone git@github.com:bianavic/ead-user-management-application.git
```

2. Navegue para o diretório do projeto
```bash
cd ead-user-management-application
```

## API


| API ROUTE		          | DESCRIPTION          | STATUS |
|:---------------------|:--------------------------|:-------|
| [GET] /users	        | Retrieve all the users    | 200    |
| [GET] /users/{id}    | Retrieve a user by its ID | 200    |
| [POST] /users        | Add a new user            | 201    |
| [PUT] /users/{id}    | Update user by its ID     | 200    |
| [DELETE] /users/{id} | Remove a user by its ID   | 204    |

### initial set of data

| id | name        | email           | cpf       | password   |
| :--- |:----------|:----------------|:----------|:-----------|
| 1 | Maria Brown | maria@gmail.com | 988888888 | 123456     |
| 2 | Alex Green  | alex@gmail.com  | 977777777 | 123456     |

---

#### get all users
```bash
curl --location 'http://localhost:8081/users'
```
###### 200 OK
``` json
[
    {
        "id": 1,
        "name": "Test 1",
        "email": "test1@email.com",
        "cpf": "123",
        "password": "123"
    },
    {
        "id": 2,
        "name": "Test 2",
        "email": "test2@email.com",
        "cpf": "321",
        "password": "321"
    }
]
```


#### get user by its ID
```bash
curl --location 'http://localhost:8081/users/1'
```
###### 200 OK
``` json
{
    "id": 1,
    "name": "Test 1",
    "email": "test1@email.com",
    "cpf": "123",
    "password": "123"
}
```

###### 404 NOT FOUND
```bash
{
    "timestamp": "2024-02-23T21:31:57.592737272",
    "status": 404,
    "error": "Resource not found",
    "message": "User id not found: 1",
    "path": "/users/9"
}
```

#### add a new user
```bash
curl --location 'http://localhost:8081/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Test 1",
    "email": "test1@email.com",
    "cpf": "123",
    "password": "123"
}'
```
###### 201 CREATED
``` json
{
    "id": 1,
    "name": "Test 1",
    "email": "test1@email.com",
    "cpf": "123",
    "password": "123"
}
```

#### update user by its ID
```bash
curl --location --request PUT 'http://localhost:8081/users/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Updated User",
    "email": "updated@email.com",
    "cpf": "222",
    "password": "222"
}'
```
###### 200 OK
``` json
{
    "id": 2,
    "name": "Updated User",
    "email": "updated@email.com",
    "cpf": "222",
    "password": "222"
}
```

###### 404 NOT FOUND
```bash
{
    "timestamp": "2024-02-23T21:33:59.466526638",
    "status": 404,
    "error": "Resource not found",
    "message": "Error updating user: 10",
    "path": "/users/10"
}
```

#### delete user by its ID
```bash
curl --location --request DELETE 'http://localhost:8081/users/1'
```
###### 204 NO CONTENT
``` json

```

###### 404 NOT FOUND
```bash
{
    "timestamp": "2024-02-23T21:35:17.24026122",
    "status": 404,
    "error": "Resource not found",
    "message": "Error deleting user: 5",
    "path": "/users/5"
}
```