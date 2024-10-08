# Projeto Spring Security com JWT

Este é um projeto de API RESTful desenvolvido com Spring Boot, que implementa autenticação e autorização utilizando JWT (JSON Web Token) e possui integração com um banco de dados MySQL executado em um contêiner Docker.

## Funcionalidades

O projeto possui dois principais endpoints:

1. **POST /login**  
   Este endpoint permite que um usuário faça login. O usuário deve enviar um `LoginRequest` contendo o nome de usuário e a senha. Em caso de sucesso, um JWT será retornado, que pode ser usado para autenticação em outros endpoints.

   **Request Body**:
   ```json
   {
       "username": "seu_usuario",
       "password": "sua_senha"
   }
   ```

   **Response**:
   ```json
   {
       "token": "jwt_token_aqui",
       "expiresIn": 300
   }
   ```

2. **GET /users**  
   Este endpoint retorna uma lista de usuários. O acesso a este endpoint requer autenticação através de um token JWT, que deve ser incluído no cabeçalho da requisição.

   **Headers**:
   ```
   Authorization: Bearer jwt_token_aqui
   ```

## Configuração do Banco de Dados

O projeto utiliza um banco de dados MySQL que é iniciado através de um contêiner Docker. A configuração do Docker Compose está incluída para facilitar a execução do banco de dados.

### Docker Compose

Para iniciar o banco de dados MySQL, utilize o seguinte arquivo `docker-compose.yml`:

```yaml
version: '3.8'
services:
  mysql:
    image: mysql:latest
    container_name: mysql_container
    environment:
      MYSQL_ROOT_PASSWORD: sua_senha_root
      MYSQL_DATABASE: nome_do_banco
      MYSQL_USER: usuario
      MYSQL_PASSWORD: sua_senha
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

### Executando o Projeto

1. Clone o repositório do projeto:
   ```bash
   git clone https://github.com/juniorapeles/spring-sercurity.git
   cd seu-projeto
   ```

2. Inicie o contêiner Docker com o MySQL:
   ```bash
   docker-compose up -d
   ```

3. Execute a aplicação Spring Boot:
   ```bash
   ./mvnw spring-boot:run
   ```

Agora, você pode testar os endpoints utilizando ferramentas como Postman ou Curl.

## Dependências

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Docker

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou correções. Para isso, você pode abrir uma nova issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
