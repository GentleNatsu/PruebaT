Bienvenido a la Prueba T de Carlos García Cremades
===================================





Para poder arrancar la mejor aplicación del universo, tienes que seguir unos sencillos pasos:

1. Primero necesitamos compilar el programa ejecutando en la carpeta raíz del proyecto:

   ```bash
    mvn clean package
    ```
2. Construimos la imagen de docker:
   ```bash
   docker-compose build
   ```
   La imagen contiene la base de datos y la aplicación. Los datos se precargarán utilizando flyway como control de versiones.


3. Levantamos la imagen del docker:
   ```bash
   docker-compose up
   ```

4. Importamos la colección de peticiones de postman que tenemos en driving/api-rest/postman
   
# Microservicio generado a partir de arquetipo

Toda la documentación relevante al desarrollo de este tipo de proyectos se encuentra en la guía del
desarrollador: [Guía del desarrollador](https://fwk.srv.mercadona.com/framework/spring-boot?pathname=/latest/getting-started/first-api-rest/)

Versión del arquetipo: `5.1.0`
