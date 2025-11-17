
# 👨‍💻 Programación Sobre Redes - 2025 👨‍💻

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/GuiaEjercicios-1_2025#-programaci%C3%B3n-sobre-redes---2025-)

#### Benjamín Nehemías Castro Madrid 6to 1ra Computación

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/GuiaEjercicios-1_2025#benjam%C3%ADn-nehem%C3%ADas-castro-madrid-6to-1ra-computaci%C3%B3n)

#### Correo:  [benjamin.castromadrid28et32@gmail.com](mailto:benjamin.castromadrid28et32@gmail.com)

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/GuiaEjercicios-1_2025#correo-benjamincastromadrid28et32gmailcom)

Este repositorio está dedicado a la materia  **Programación sobre Redes**, dictada por el profesor  **Gonzalo Nicolás Consorti**  en la  **Escuela General José de San Martín ET32**, ubicada en el Distrito Escolar 14. La materia se imparte durante el año  **2025**  y está enfocada en proporcionar una comprensión profunda de los conceptos fundamentales de las redes y la programación orientada a ellas.

## Consigna TP Final (De a 1)



**Juego elegido:**

Desarrollar un juego para dos jugadores utilizando programación en red mediante sockets, gestión de hilos y manejo de flujos de datos en Java.

### **Requisitos Funcionales**

El juego debe estar basado en un tablero de 3x3 casillas.  
Los jugadores deben elegir entre dos símbolos: X y O.  
El jugador 1 es X y el jugador 2 es O.  
El objetivo del juego es conseguir alinear tres de tus símbolos de manera horizontal, vertical o diagonal antes que el oponente.

**Servidor:** El servidor debe aceptar conexiones de dos clientes (que juegan entre sí), gestionar el estado del juego (tablero) para ambos jugadores, coordinar los turnos alternados, validar los movimientos de cada jugador (verificar que la casilla esté vacía antes de realizar un movimiento), notificar el resultado de cada jugada (quién ganó, si es un empate) y determinar y notificar al ganador cuando alguien gane o si es un empate.

**Cliente:** El cliente se conecta al servidor proporcionando la IP y el puerto, permite al jugador hacer un movimiento (poner su X u O en una celda), recibe y muestra el estado actualizado del tablero, muestra un mensaje indicando el resultado de cada jugada (X gana, O gana, empate) y, al finalizar, muestra el resultado del juego.

Se utilizarán **TCP/IP** para la comunicación cliente-servidor.  
El protocolo de comunicación debe ser claro y sencillo:

1.  El cliente se conecta al servidor y se autentica.
    
2.  El servidor gestiona los turnos de los jugadores y los notifica.
    
3.  El cliente envía la coordenada de la celda en la que desea colocar su símbolo.
    
4.  El servidor responde con el estado actualizado del tablero y si hubo un ganador o empate.
    
5.  El servidor notifica a los jugadores si la partida ha terminado.
    

El servidor debe manejar múltiples clientes utilizando **hilos (Thread)** para gestionar cada conexión de forma concurrente. Cada conexión debe ser atendida en un hilo separado para que el servidor pueda manejar varios juegos simultáneamente.  
Se debe implementar **sincronización adecuada** para garantizar que el estado del juego no se vea afectado por cambios concurrentes entre hilos.

Se utilizarán las clases de Java:  
**InputStream, OutputStream, ObjectInputStream, ObjectOutputStream**, **BufferedReader**, **PrintWriter**.

Implementar manejo robusto de excepciones de **IO**.  
Asegurar que todos los recursos sean cerrados después de finalizar la conexión.

----------

## **Requisitos Técnicos Obligatorios**

-   Implementación correcta de **ServerSocket** y **Socket**.
    
-   Uso de **Thread** para concurrencia.
    
-   Captura y gestión de excepciones como **IOException**, **SocketException**, etc.
    
-   Código organizado en clases con propósitos claros.
    
-   El juego debe ser por consola (sin interfaz gráfica).
    

----------

## **Estructura de Código**

### **Clase Celda:**

Representa una casilla del tablero. Puede estar vacía o contener una 'X' o 'O'.

**Atributos:**

-   String estado – Puede ser "VACIA", "X" o "O".
    

**Métodos:**

-   vaciar(): Vacía la celda.
    
-   marcar(String simbolo): Marca la celda con 'X' o 'O'.
    
-   esVacia(): Retorna true si la celda está vacía.
    

----------

### **Clase Tablero:**

Representa el tablero de 3x3 del juego.

**Atributos:**

-   Celda[][] tablero – El tablero de juego.
    

**Métodos:**

-   mostrarTablero(): Muestra el tablero por consola.
    
-   colocarSimbolo(int fila, int col, String simbolo): Coloca el símbolo del jugador en la casilla correspondiente.
    
-   esGanador(): Retorna true si hay un ganador.
    
-   esEmpate(): Retorna true si el juego ha terminado en empate.
    
-   esTableroCompleto(): Retorna true si el tablero está lleno.
    

----------

### **Clase Jugador:**

Representa a un jugador (Jugador 1 o Jugador 2).

**Atributos:**

-   String nombre – Nombre del jugador.
    
-   String simbolo – Símbolo del jugador ('X' o 'O').
    

**Métodos:**

-   realizarMovimiento(int fila, int col): Realiza un movimiento colocando su símbolo en la casilla correspondiente.
    

----------

### **Clase Servidor:**

Gestiona las conexiones con los clientes y el flujo de la partida.

**Métodos:**

-   iniciarServidor(): Inicia el servidor y espera conexiones.
    
-   gestionarPartida(): Coordina el flujo del juego entre los dos jugadores.
    
-   validarMovimiento(): Verifica que la jugada sea válida.
    
-   notificarEstadoJuego(): Informa a los jugadores sobre el estado de la partida (si hay ganador, empate, etc.).
    

----------

### **Clase Cliente:**

Conecta al jugador al servidor y gestiona su participación en el juego.

**Métodos:**

-   conectarConServidor(): Establece la conexión con el servidor.
    
-   realizarMovimiento(): Permite al jugador realizar un movimiento.
    
-   recibirEstadoJuego(): Recibe y muestra el estado del juego después de cada jugada.

## **Condiciones de Victoria/Derrota**

**Victoria:** Un jugador gana si logra alinear tres de sus símbolos en una fila, columna o diagonal.  
**Derrota:** Si el otro jugador logra alinear tres de sus símbolos antes.  
**Empate:** Si todas las casillas están ocupadas y no hay ganador.

## Objetivo del repositorio

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/GuiaEjercicios-1_2025#objetivo-del-repositorio)

El objetivo principal de este repositorio es ofrecer un espacio centralizado donde podrás encontrar todo el material confeccionado durante el curso, incluyendo:

-   **Ejercicios prácticos**: Una serie de ejercicios y actividades que ayudarán a afianzar los conocimientos adquiridos, con soluciones detalladas para que puedas aprender de manera efectiva.
    
-   **Proyectos y entregas**: Los proyectos y entregas que forman parte de la evaluación del curso. Cada proyecto estará acompañado de documentación que explica los objetivos, el código, y los resultados esperados.
    
-   **Recursos adicionales**: Material extra que el profesor Gonzalo Nicolás Consorti ha proporcionado para complementar la enseñanza. Esto incluye artículos, tutoriales, y enlaces a recursos externos relacionados con la programación en redes.
    

## Estructura

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/GuiaEjercicios-1_2025#estructura)

Este repositorio se ira actualizando a medida que las clases con el profesor se vayan dictando durante el año presente. Actualmente la estructura es la siguiente

 -   **main**
 -   **GuiaEjercicios-1_2025**  -- Aquí podrás encontrar los ejercicios de la primer guía.
	    -   guia_Ejercicios_1
 -   **GuiaEjercicios-2_2025**  -- Aquí podrás encontrar los ejercicios de la segunda guía.
	    -   guia_Ejercicios_2
 - **TPFinal_2025** -- Aquí podras encontrar el trabajo práctico final de la matería.
	- tictactoe-sockets

## Conclusión

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/GuiaEjercicios-1_2025#conclusi%C3%B3n)

Este repositorio recompila todo tipo de información adquirida durante mi instancia en la materia y en la escuela. En especial, el lenguaje de programación JAVA.  [![(https://static.wixstatic.com/media/ff9d7d_6c4add613f9142998981fa424cf843b8mv2.png/v1/fill/w_1046,h_654,al_c,q_90,usm_0.66_1.00_0.01,enc_avif,quality_auto/ff9d7d_6c4add613f9142998981fa424cf843b8mv2.png)](https://camo.githubusercontent.com/15c86d0f843cf000b1b4153d295761bc2363258a668e21cbb1fb72fce9232bfb/68747470733a2f2f7374617469632e7769787374617469632e636f6d2f6d656469612f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e672f76312f66696c6c2f775f313034362c685f3635342c616c5f632c715f39302c75736d5f302e36365f312e30305f302e30312c656e635f617669662c7175616c6974795f6175746f2f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e67)](https://camo.githubusercontent.com/15c86d0f843cf000b1b4153d295761bc2363258a668e21cbb1fb72fce9232bfb/68747470733a2f2f7374617469632e7769787374617469632e636f6d2f6d656469612f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e672f76312f66696c6c2f775f313034362c685f3635342c616c5f632c715f39302c75736d5f302e36365f312e30305f302e30312c656e635f617669662c7175616c6974795f6175746f2f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e67)
