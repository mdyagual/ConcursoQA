# ConcursoQA
Challenge por parte de Softka U para ingreso: Concurso de preguntas y respuestas
- El reto consiste en realizar un programa que simule un concurso de preguntas y respuestas con 5 rondas. Por cada una se debe elegir una pregunta pertenenciente a una categoría. A medida que el jugador avance en la partida, las preguntas suben de categoría, aumentando la dificultad.
- Previamente, se debe configurar el juego, generando 25 preguntas con su respectiva categoria. Por defecto, existirán 5 categorías, cada una con un grupo de 5 preguntas. Luego, se procede a seleccionar las 5 preguntas que serán parte de la partida. Estas preguntas deben ser de categorías diferentes.
- Al iniciar el juego, se le pedirá al jugador que ingrese un nickname para ser identificado dentro del historial del juego.
- Durante la partida, el jugador debe contestar correctamente para pasar a la siguiente ronda. Además tiene la opción de abandonar la partida en cualquiera de las rondas, llevándose lo acumulado.
- El jugador gana la partida de pasar por las 5 rondas, llevándose un premio acumulado. Si su respuesta llega a ser incorrecta en cualquier ronda, pierde la partida y el dinero acumulado.
- Toda partida finalizada es almacenada en un archivo de texto (.txt) con fecha y hora de inicio de la partida, el nickname, el resultado de la partida y el premio adquirido.


- [Diagrama UML del reto](https://www.dropbox.com/s/v4ws1yipw6k8ks9/ConcursoQA1.png?dl=0)


# Tecnologías usadas

- Java 1.8
- IDE: Netbeans IDE 8.2
 
 #Inicio del programa
 
- Para iniciar el programa se debe dar click derecho en la carpeta del proyecto -> Run


# Salidas del programa

## Validaciones

Validaciones de evitar el ingreso de datos erróneos.

![ingresar datos correctos](https://www.dropbox.com/s/g2ofwwomwkydo07/Validaciones.JPG?dl=0)

Ingreso de las opciones disponibles: No permite iniciar el juego si no se configura previamente

![ingresar opcion valida](https://www.dropbox.com/s/k14i29mjd2r1b6l/Configuracion.JPG?dl=0)


## Flujo del juego
Por defecto la opción 5 será para abandono de la partida. La respuesta correcta es la que se lee como True y cambia de lugar en cada ronda. El premio aumenta $1000 por cada ronda que pasa.

Escenario 1: El jugador gana la partida

![gana1](https://www.dropbox.com/s/n2vvw75skzgdwbp/Acumulado1.JPG?dl=0)
![gana2](https://www.dropbox.com/s/mjqi4eng6zks3ex/Acumulado2.JPG?dl=0))
![gana3](https://www.dropbox.com/s/bdg2qvlyfxlk667/Fin%20partida.JPG?dl=0)

Escenario 2: El jugador abandona la partida: Elige la opción 5. Puede hacerlo en cualquier ronda.
![abandona](https://www.dropbox.com/s/nkkgcqrno3t94z4/Abandono.JPG?dl=0)

Escenario 3: El jugador pierde la partida: El jugador selecciona una respuesta incorrecta.
![pierde](https://www.dropbox.com/s/153w5ewce5wzg8l/Perdio.JPG?dl=0)



# Persistencia de datos 📘
- Los datos de cada partida se guardan en historialPartidas.txt con el siguiente formato: fechaYHora,nickname,premio,estadoPartida
- Fecha y hora con formato AAAA-MM-DD HH:mm:ss 
- Nickname del jugador
- Premio en $
- Estado en que terminó la partida el jugador
![historial](https://www.dropbox.com/s/wmpjzdt8ednfgda/Historial.JPG?dl=0)


	![persistencia de datos](https://i.ibb.co/X4F4ZNW/12.png)
