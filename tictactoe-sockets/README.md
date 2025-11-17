# TicTacToe Sockets (Console) - Proyecto Maven

Proyecto Java para jugar TicTacToe (3x3) entre dos jugadores mediante sockets TCP.
Diseñado para abrirse/importarse en Spring Tools Suite (STS) o Eclipse como proyecto Maven.

## ¿Qué incluye?
- Servidor que acepta conexiones y coordina partidas entre pares de clientes.
- Cliente de consola que se conecta al servidor, envía movimientos y muestra el tablero.
- Código escrito con `Socket`, `ServerSocket`, `Thread`, `BufferedReader`, `PrintWriter`.
- Manejo básico de concurrencia y cierre de recursos.

## Cómo ejecutar
1. Importar en STS/Eclipse: *File > Import > Existing Maven Projects* y seleccionar la carpeta del proyecto.
2. Ejecutar la clase `com.example.tictactoe.server.Servidor` como aplicación Java.
3. Ejecutar dos instancias del cliente `com.example.tictactoe.client.Cliente` (desde STS o desde línea de comandos) y conectarlas a la IP y puerto mostrados (por defecto `localhost:5000`).

También puedes ejecutar por terminal (desde la raíz del proyecto):
- Compilar: `mvn package`
- Ejecutar servidor: `java -cp target/tictactoe-sockets-1.0-SNAPSHOT.jar com.example.tictactoe.server.Servidor`
- Ejecutar cliente: `java -cp target/tictactoe-sockets-1.0-SNAPSHOT.jar com.example.tictactoe.client.Cliente`

## Protocolo de texto (simple)
- Cliente conecta y envía `AUTH:<nombre>` para identificarse.
- Servidor responde `WAIT` hasta emparejar a otro jugador.
- Cuando empieza la partida, servidor envía `START:<tuSimbolo>:<turno>` donde `tuSimbolo` es X u O y `turno` es `true` si inicia.
- Cliente envía `MOVE:<fila>,<col>` (filas y columnas 0..2) en su turno.
- Servidor responde `UPDATE:<tablero>` con tablero en una línea separado por `;` y luego `RESULT:<estado>` con `IN_PROGRESS`, `X_WINS`, `O_WINS`, `DRAW`.
- Servidor envía `END:<mensaje>` cuando termina la partida.

## Notas
- Juego por consola, sin GUI.
- Código y comentarios en español.
