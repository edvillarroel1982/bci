# Guía de Instalación.

## Requisitos

- JDK 18 (Requiere declarar variables de entorno)
- Maven 3.8.5 (Requiere declarar variables de entorno)

## Herramienta de Desarrollo Utilizada

- Spring Tool Suite 4

## Herramienta Para Pruebas

- Postman v9.15.2

## Pasos para poder arrancar la API

Los pasos que voy a describir a continuación corresponden a la configuración con el IDE de desarrollo Spring Tool Suite 4 (Eclipse).

- Descargar el proyecto y descomprimir su contenido
- Abrir el IDE de desarrollo (en mi caso Spring Tool Suite 4)
- Ir a File->Import->Seleccionar “Existing Maven Projects”.
- Clic en “Browse…” y seleccionar el proyecto.
- Configurar Java y Maven desde las preferencias en el menú “Windows”
- Ejecutar desde la consola posicionado en la ruta del proyecto.
```sh
mvn clean package 
``` 
- Clic derecho en el proyecto “Run As→Spring boot app”

## Pasos para poder consumir la API

- Abrir Postman
- Se debe abrir un nuevo request de tipo POST
- Seleccionar opción body→raw→cambiar la opción text a JSON
- Clic derecho en el proyecto “Run As→Spring boot app”
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

