# Guía de Instalación.

## Requisitos

- Java 17 (Requiere declarar variables de entorno)
- Maven 3.8.5 (Requiere declarar variables de entorno)

## Herramienta de Desarrollo Utilizada

- Spring Tool Suite 4

## Herramienta Para Pruebas

- Postman
- Thunderclient

## Pasos para poder arrancar la API

Clonar el Repositorio:
Clona el repositorio del microservicio desde GitHub en tu máquina local.

```sh
git clone https://github.com/edvillarroel1982/bci.git
```

**Configurar la Base de Datos**


La base de datos estaba configurada para correr en memoria, es decir es una H2, caso contrario, asegúrate de tener una instancia de MySQL u otra base de datos compatible en tu sistema. Luego, configura las propiedades de conexión a la base de datos en el archivo application.properties ubicado en src/main/resources.

**Compilar el Proyecto**


Abre una terminal en la raíz del proyecto y ejecuta el siguiente comando para compilar el proyecto:

```sh
mvn clean install
```

**Ejecutar el Servicio**


Una vez compilado con éxito, puedes ejecutar el microservicio utilizando Maven. Ejecuta el siguiente comando:

```sh
mvn spring-boot:run
```

## Verificación de la Documentación de la API:
Después de iniciar el servicio, puedes acceder a la documentación de la API y probar los endpoints utilizando Swagger. Abre un navegador web y visita la siguiente URL:

```sh
http://localhost:8080/swagger-ui/index.html
```

## Pasos para poder consumir la API

- Abrir Postman
- Se debe abrir un nuevo request y seleccionar el verbo POST
- Luego pegar el JSON especificado en el documento en el input

```json
{
"name": "Juan Rodriguez",
"email": "juan@rodriguez.org",
"password": "hunter2",
"phones": [
            {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
            }
          ]
}
```


- Clic en botón SEND

## Verificación de persistencia de Datos

Si se desea verificar los datos guardados del usuario se debe ingresar a la consola h2 del proyecto por medio de la url
http://localhost:8080/h2-console/
Es necesario modificar las credenciales de acuerdo a la especificación en el archivo application.properties del proyecto.
