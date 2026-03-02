
# ADT7_Practica1 - Spring Boot Deployment en Azure

Este proyecto corresponde a la **Práctica 2 de Acceso a Datos UD07**, donde se despliega una aplicación Spring Boot con MySQL en un servidor **Ubuntu** en **Microsoft Azure** usando **Tomcat 10**.

---

## 📦 Estructura del proyecto

adt7_practica1/
├── src/
├── pom.xml
├── README.md
├── application-example.properties
└── .gitignore


> Nota: `application.properties` real no se sube a GitHub por seguridad (contiene contraseñas de la base de datos).

---

## ⚙ Configuración de base de datos

- **Base de datos:** MySQL
- **Nombre:** `adt7_practica1`
- **Usuario:** definido por variable de entorno `DB_USER`
- **Contraseña:** definida por variable de entorno `DB_PASS`

### Variables de entorno en Ubuntu:

```bash
export DB_USER=camu
export DB_PASS=adt7_practica2
```

```springboot
spring.datasource.url=jdbc:mysql://localhost:3306/adt7_practica1?useSSL=false&serverTimezone=UTC
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
server.servlet.context-path=/adt7_practica1
```
```bash
sudo apt update && sudo apt install -y mysql-server tomcat10 ufw openjdk-17-jdk
```
```bash
sudo ufw allow 8080/tcp
sudo ufw enable
sudo ufw status
```
```sql
CREATE DATABASE adt7_practica1;
CREATE USER 'camu'@'localhost' IDENTIFIED BY 'adt7_practica2';
GRANT ALL PRIVILEGES ON adt7_practica1.* TO 'camu'@'localhost';
FLUSH PRIVILEGES;
```
```bash
sudo cp target/adt7_practica1.war /var/lib/tomcat10/webapps/
sudo systemctl restart tomcat10
```
🌐 Acceso a Swagger UI
http://4.233.137.68:8080/adt7_practica1/swagger-ui/index.html
