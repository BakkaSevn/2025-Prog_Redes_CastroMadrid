
# 👨‍💻 Programación Sobre Redes - 2025 👨‍💻

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#%E2%80%8D-programaci%C3%B3n-sobre-redes---2025-%E2%80%8D)

#### Benjamín Nehemías Castro Madrid 6to 1ra Computación

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#benjam%C3%ADn-nehem%C3%ADas-castro-madrid-6to-1ra-computaci%C3%B3n)

#### Correo:  [benjamin.castromadrid28et32@gmail.com](mailto:benjamin.castromadrid28et32@gmail.com)

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#correo-benjamincastromadrid28et32gmailcom)

Este repositorio está dedicado a la materia  **Programación sobre Redes**, dictada por el profesor  **Gonzalo Nicolás Consorti**  en la  **Escuela General José de San Martín ET32**, ubicada en el Distrito Escolar 14. La materia se imparte durante el año  **2025**  y está enfocada en proporcionar una comprensión profunda de los conceptos fundamentales de las redes y la programación orientada a ellas.

## Consigna del Trabajo Práctico
### # TP 4 - Socket Mini-chat SEGURO
Desarrollar un sistema de chat donde los clientes puedan intercambiar mensajes de texto y archivos, mientras que el servidor redirige los mensajes a todos los clientes conectados, además de permitir la mensajería privada. Todos los mensajes deben ser encriptados para asegurar la privacidad, y los comandos específicos deben estar disponibles para los usuarios.  
  
  
  
**Funcionalidad básica de chat:**  
  

-   Los clientes pueden enviar mensajes de texto a todos los usuarios conectados.
-   Los mensajes privados pueden ser enviados a un cliente específico mediante el comando /msg [usuario] [mensaje].
-   Los mensajes deben ser encriptados antes de ser enviados al servidor, asegurando que el servidor no pueda leer el contenido del mensaje.

  
  
**Comandos disponibles:**  
Los clientes deben poder usar los siguientes comandos desde la consola:  

-   /salir: Cierra la sesión del cliente y desconecta al usuario.
-   /listar: Muestra una lista de todos los usuarios conectados al chat.
-   /verComandos: Muestra una lista de todos los comandos disponibles.
-   /msg [usuario] [mensaje]: Envía un mensaje privado a un cliente específico.
-   /enviarArchivo [usuario] [archivo]: Envía un archivo a un cliente específico.
-   /ayuda: Muestra información de ayuda sobre cómo utilizar el chat y los comandos disponibles.

  
  
**Redirección de mensajes:**  

-   Los mensajes enviados por los clientes deben ser recibidos por todos los demás clientes conectados al chat, salvo que se trate de un mensaje privado, en cuyo caso solo el destinatario recibirá el mensaje.
-   Los mensajes deben ser enviados por el servidor de manera que todos los clientes los reciban (utilizando hilos y sockets).

  
  
**Encriptación de mensajes:**

-   Todos los mensajes deben ser encriptados antes de ser enviados y desencriptados al ser recibidos. El servidor no podrá ver ni modificar los contenidos de los mensajes. Se puede utilizar alguna de las siguientes librerías para la encriptación:
-   AES (Advanced Encryption Standard)
-   RSA (Rivest-Shamir-Adleman)
-   La encriptación debe ser transparente para el usuario; es decir, los usuarios no deben notar ningún cambio en la interacción, pero los mensajes estarán protegidos

  
  
**Interfaz y consola con colores:**

-   Diferenciar entre los mensajes enviados por el cliente y los mensajes enviados por el servidor en la consola utilizando códigos ANSI:
-   para los mensajes del servidor o mensajes de éxito.
-   para los mensajes del cliente.
-   para mensajes de error.
-   para mensajes informativos de sistema (como comandos).

  
  
**Envío de archivos:**  

-   Los clientes deben poder enviar archivos a otros usuarios mediante el comando /enviarArchivo [usuario] [archivo].
-   El servidor debe recibir el archivo y redirigirlo al cliente destinatario, asegurando la correcta recepción y almacenamiento.

**Manejo de conexiones:**  
  

-   El servidor debe manejar múltiples clientes simultáneamente utilizando hilos (Thread).
-   El servidor debe desconectar al cliente correctamente cuando este envíe el comando /salir o cierre la conexión.

**Interfaz de Usuario (CLI):**  

-   Los clientes deben tener una interfaz de línea de comandos (CLI) donde pueden ver los mensajes del servidor y de otros clientes, escribir sus propios mensajes, y ejecutar comandos como los mencionados anteriormente.
-   El cliente debe mostrar mensajes como:
-   "Conexión exitosa al servidor."
-   "Comando no válido, intente /verComandos."
-   "Archivo enviado correctamente."
-   "Usuario no encontrado para el mensaje privado."

## Objetivo del repositorio

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#objetivo-del-repositorio)

El objetivo principal de este repositorio es ofrecer un espacio centralizado donde podrás encontrar todo el material confeccionado durante el curso, incluyendo:

-   **Ejercicios prácticos**: Una serie de ejercicios y actividades que ayudarán a afianzar los conocimientos adquiridos, con soluciones detalladas para que puedas aprender de manera efectiva.
    
-   **Proyectos y entregas**: Los proyectos y entregas que forman parte de la evaluación del curso. Cada proyecto estará acompañado de documentación que explica los objetivos, el código, y los resultados esperados.
    
-   **Recursos adicionales**: Material extra que el profesor Gonzalo Nicolás Consorti ha proporcionado para complementar la enseñanza. Esto incluye artículos, tutoriales, y enlaces a recursos externos relacionados con la programación en redes.
    

## Estructura

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#estructura)

Este repositorio se ira actualizando a medida que las clases con el profesor se vayan dictando durante el año presente. Actualmente la estructura es la siguiente

-   **main**
-   **tp4Socket_Mini-chat**  -- Aquí podrás encontrar los ejercicios del cuarto trabajo práctico.

## Conclusión

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#conclusi%C3%B3n)

Este repositorio recompila todo tipo de información adquirida durante mi instancia en la materia y en la escuela. En especial, el lenguaje de programación JAVA.  [![(https://static.wixstatic.com/media/ff9d7d_6c4add613f9142998981fa424cf843b8mv2.png/v1/fill/w_1046,h_654,al_c,q_90,usm_0.66_1.00_0.01,enc_avif,quality_auto/ff9d7d_6c4add613f9142998981fa424cf843b8mv2.png)](https://camo.githubusercontent.com/15c86d0f843cf000b1b4153d295761bc2363258a668e21cbb1fb72fce9232bfb/68747470733a2f2f7374617469632e7769787374617469632e636f6d2f6d656469612f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e672f76312f66696c6c2f775f313034362c685f3635342c616c5f632c715f39302c75736d5f302e36365f312e30305f302e30312c656e635f617669662c7175616c6974795f6175746f2f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e67)](https://camo.githubusercontent.com/15c86d0f843cf000b1b4153d295761bc2363258a668e21cbb1fb72fce9232bfb/68747470733a2f2f7374617469632e7769787374617469632e636f6d2f6d656469612f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e672f76312f66696c6c2f775f313034362c685f3635342c616c5f632c715f39302c75736d5f302e36365f312e30305f302e30312c656e635f617669662c7175616c6974795f6175746f2f6666396437645f36633461646436313366393134323939383938316661343234636638343362387e6d76322e706e67)
