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
   Las he probado y me han funcionado todas, pero pido perdón y que se valore el código si alguna no funciona :) 

   Hay pruebas para todos los endpoints solicitados.

5. Se ha configurado envers para las tiendas, en la capa de driven para que historifique los cambios que se hacen en la
   store en la tabla store_h

6. Se adjunta un contrato open-api en api-rest/contracts.

7. Para probar la internacionalización de los errores, habría que llamar al get por id con una tienda no válidaç

8. Se ha utilizado flyway para inicializar la bbdd e insertar registros.
   
# Microservicio generado a partir de arquetipo

Toda la documentación relevante al desarrollo de este tipo de proyectos se encuentra en la guía del
desarrollador: [Guía del desarrollador](https://fwk.srv.mercadona.com/framework/spring-boot?pathname=/latest/getting-started/first-api-rest/)

Versión del arquetipo: `5.1.0`
