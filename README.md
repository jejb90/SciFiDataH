# SciFiDataH

# Documentación de API con Swagger y Base de Datos H2

En este proyecto de Spring Boot, hemos utilizado Swagger para documentar los endpoints de nuestra API, lo que facilita su exploración y comprensión.

## Documentación de Endpoints con Swagger

La documentación de los endpoints de la API se encuentra disponible a través de Swagger. Puedes acceder a la interfaz Swagger UI en la siguiente URL:

[Swagger UI](http://localhost:8080/swagger-ui/index.html#)

La interfaz Swagger UI proporciona una forma fácil de explorar y probar los diferentes endpoints de la API. Puedes ver los detalles de cada endpoint, sus parámetros, solicitudes y respuestas.

## Base de Datos H2 para Pruebas

Para facilitar las pruebas y el desarrollo, hemos configurado una base de datos H2. Esta base de datos en memoria es una excelente opción para realizar pruebas sin afectar una base de datos en producción.

## Acceso a la Consola de H2

Si deseas explorar la base de datos H2, puedes acceder a su consola a través de la siguiente URL:

[Consola de H2](http://localhost:8080/h2-console)

Para acceder, utiliza los siguientes detalles:

- **Driver Class**: org.h2.Driver
- **JDBC URL**: jdbc:h2:mem:testdb
- **Usuario**: sa
- **Contraseña**: (deja este campo en blanco)

Asegúrate de que estás en un entorno de desarrollo y que la base de datos H2 está configurada para pruebas y desarrollo.

## Captura de Pantalla de la Consola de H2

![Captura de Pantalla de la Consola de H2](src/main/resources/static/img/Console%20H2.png)

Recuerda que la configuración puede variar según tus necesidades y el entorno en el que estás trabajando. ¡Diviértete explorando la documentación de Swagger y probando tus endpoints!


## Diagrama ER de la BD

![Captura de Pantalla de ER](src/main/resources/static/img/Diagrama%20ER.png)
