# Mowers Project
## _Code Challenge_

Mower Project es una code challenge para el control de un mower en las distintas
plateaus de un complejo industrial.


## Caracteristicas

- REST API para una facil entrada de datos e integración con otros sistemas
- Movimiento de diferentes Mower en un misma plateau

En este momento tengo que comentar por que he decidido por crear una REST API
para este proyecto.
Creo que como metodo de entrada de información y integración con otros sistemas externos
el protocolo REST facilita mucho el trabajo.

## Tecnologias

Este proyecto ha usado las siguiente tecnologias:

- [Java 17] 
- [Maven] Para la gestion de librerias.
- [Spring Boot] - Framework para Java.
- [JUnit5] - Libreria para facilitar el desarrollo de test.
- [Lombok] - Libreria para facilitar el desaarrollo de la aplicacion.


## Instalaciones necesarias

Mowers Project requiere tener instalado el equipo:
- [Java 17]
- [Maven]
 
Tras la instalación de ambos se requiere ir a la carpeta donde se encuentra el proyecto
y ejecutar el siguiente comando.
```sh
mvn clean install
```

## Arranque del servidor

Para poder arrancar el servidor, una vez realizadas las instalaciones necesarias y la compilación, has de dirigir a la carpeta y ejecutar el siguiente comando:
```sh
mvn spring-boot:run
```

El servidor por defecto arranca en el puerto 8080.

## Prueba del endpoint

Ahora mismo la aplicación de Mowers tiene los siguiente endpoint:

- /instructions
```sh
POST
{
	  "maximumX": 5,

    "maximumY": 5,

    "instructions" :[
			{
				"initialX": 1,
				"initialY": 2,
				"initialFacing" : "N",
				"instructions": "LMLMLMLMM"
			},
			{
				"initialX": 3,
				"initialY": 3,
				"initialFacing" : "E",
				"instructions": "MMRMMRMRRM"
			}
		]
}
```
Respuesta
```sh
{
	"finalPositions": [
		"1 3 N",
		"5 1 E"
	]
}
```







