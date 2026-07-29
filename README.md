# ArquitecturaSoftware-JPA
 
Proyecto académico de Arquitectura de Software que implementa un sistema de **login, registro y verificación de usuarios**, junto con la gestión de un modelo `Competitor`. Las APIs REST se probaron y validaron con **Postman**.
 
## 📋 Descripción
 
Ejercicio práctico enfocado en el uso de **JPA (Java Persistence API)** para la persistencia de datos, siguiendo una arquitectura por capas (modelos, servicios, configuración REST). El proyecto expone endpoints para el registro/autenticación de usuarios y para la gestión de competidores.
 
## 🛠️ Tecnologías utilizadas
 
- **Java** 8.0.2
- **JPA** (Java Persistence API)
- **GlassFish** (servidor de aplicaciones)
- **NetBeans IDE** 8.0.2
- **Base de datos:** JavaDB / Apache Derby (motor embebido de NetBeans)
- **Postman** (pruebas de API)
  
## 📁 Estructura del proyecto
 
```
EjercicioArqSoftware-JPA/
├── nbproject/
│   ├── ant-deploy.xml
│   ├── build-impl.xml
│   ├── genfiles.properties
│   ├── project.properties
│   ├── project.xml
│   └── rest-build.xml
├── setup/
│   └── glassfish-resources.xml
├── src/
│   ├── conf/
│   │   ├── MANIFEST.MF
│   │   └── persistence.xml
│   └── java/com/
│       ├── example/
│       │   ├── models/
│       │   │   └── Competitor.java
│       │   ├── services/
│       │   │   ├── CompetitorService.java
│       │   │   └── LoginService.java
│       │   ├── PersistenceManager.java
│       │   └── RestConfig.java
│       └── mundo/
│           └── Main.java
├── web/
│   └── index.html
├── .gitignore
├── Laboratorio JPA - Rutas.txt
└── build.xml
```
 
## ⚙️ Instalación y ejecución
 
**Requisitos previos:**
- Java JDK 8.0.2
- Servidor GlassFish
- NetBeans IDE 8.0.2 (o compatible)
  
**Pasos:**
1. Clonar el repositorio:
```bash
   git clone https://github.com/juandiegogalindo/ArquitecturaSoftware-JPA.git
```
2. Abrir el proyecto desde NetBeans (`File > Open Project`).
3. Verificar que el servidor GlassFish esté configurado como servidor de aplicaciones del proyecto.
4. Ejecutar el proyecto (`Run`); NetBeans desplegará automáticamente el WAR en GlassFish.
5. La aplicación quedará disponible en `http://localhost:8080/EjercicioArqSoftware-JPA/`
   
## 🔌 Endpoints disponibles
 
### Competitors
 
**Obtener todos los competidores**
```
GET http://localhost:8080/EjercicioArqSoftware-JPA/api/competitors/get
```
 
**Agregar un competidor**
```
POST http://localhost:8080/EjercicioArqSoftware-JPA/api/competitors/add
```
```json
{
  "name": "Laura",
  "surname": "Gomez",
  "age": 20,
  "telephone": "123",
  "cellphone": "300",
  "address": "Calle 1",
  "city": "Bogota",
  "country": "Colombia",
  "winner": false,
  "email": "laura@gmail.com",
  "password": "1234"
}
```
 
### Login
 
**Registrar usuario**
```
POST http://localhost:8080/EjercicioArqSoftware-JPA/api/login/register
```
```json
{
  "username": "admin",
  "password": "1234",
  "role": "ADMIN"
}
```
 
**Autenticar usuario**
```
POST http://localhost:8080/EjercicioArqSoftware-JPA/api/login/auth
```
```json
{
  "email": "laura@gmail.com",
  "password": "1234"
}
```
 
## ✅ Estado del proyecto
 
Completado y funcional. Todas las APIs fueron probadas exitosamente con Postman.
 
## 👤 Autor
 
**Juan Diego Galindo**
Estudiante de Ingeniería de Sistemas - Septimo Semestre
