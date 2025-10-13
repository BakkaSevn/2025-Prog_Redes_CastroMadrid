
# 👨‍💻 Programación Sobre Redes - 2025 👨‍💻

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#%E2%80%8D-programaci%C3%B3n-sobre-redes---2025-%E2%80%8D)

#### Benjamín Nehemías Castro Madrid 6to 1ra Computación

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#benjam%C3%ADn-nehem%C3%ADas-castro-madrid-6to-1ra-computaci%C3%B3n)

#### Correo:  [benjamin.castromadrid28et32@gmail.com](mailto:benjamin.castromadrid28et32@gmail.com)

[](https://github.com/BakkaSevn/2025-Prog_Redes_CastroMadrid/tree/TP4_Socket_Mini_Chat#correo-benjamincastromadrid28et32gmailcom)

Este repositorio está dedicado a la materia  **Programación sobre Redes**, dictada por el profesor  **Gonzalo Nicolás Consorti**  en la  **Escuela General José de San Martín ET32**, ubicada en el Distrito Escolar 14. La materia se imparte durante el año  **2025**  y está enfocada en proporcionar una comprensión profunda de los conceptos fundamentales de las redes y la programación orientada a ellas.

## Consigna del Trabajo Práctico
### # TP 3 - Socket transmisión Archivos

Implementar un sistema de transmisión de archivos entre un cliente y un servidor utilizando sockets en Java, con comunicación punto a punto. El cliente enviará un archivo al servidor y el servidor lo recibirá y guardará en el sistema local. Además, el cliente debe permitir la selección dinámica de los archivos a enviar y mostrar mensajes de estado de la conexión y de la transmisión utilizando colores en la consola.  
  
  
**Servidor:**  

-   El servidor debe escuchar en un puerto específico (por ejemplo, 5000).
-   Aceptar la conexión de un cliente.
-   Recibir el archivo enviado por el cliente.
-   Guardar el archivo recibido en el sistema de archivos local.
-   Mostrar mensajes de estado, indicando la recepción del archivo.

  
  
  
**Cliente:**  

-   El cliente debe conectarse al servidor a través de un socket.
-   Permitir al usuario elegir el archivo que desea enviar mediante un JOptionPane para mostrar una ventana de selección de archivos.
-   Mostrar mensajes de estado usando colores para indicar:Conexión exitosa al servidor.
-   Envío exitoso de archivo.
-   Error en la transmisión o conexión.
-   El cliente debe poder enviar múltiples archivos de forma secuencial (uno a uno), y después de cada envío, dar al usuario la opción de enviar otro archivo o finalizar la transmisión.

**Colores en la Consola:** Utilizar códigos ANSI para mostrar mensajes en diferentes colores en la consola:  

-   para indicar éxito (por ejemplo, conexión establecida o archivo enviado correctamente).
-   para indicar errores (por ejemplo, problemas de conexión o transmisión fallida).
-   para mensajes informativos (por ejemplo, inicio de conexión o espera de acción del usuario).

  
**Elección de archivos (Cliente):**  
  
  

-   El cliente debe permitir la selección de archivos mediante una ventana de selección (usando JOptionChoiser).
-   El cliente debe preguntar al usuario si desea enviar otro archivo después de cada transferencia exitosa.

**Condiciones adicionales:**  
  
  
  

-   Utilizar sockets TCP (clase Socket y ServerSocket).
-   El archivo debe ser transmitido en bloques de datos (por ejemplo, utilizando un buffer de 4 KB).
-   Los flujos de entrada y salida deben manejarse correctamente.
-   El cliente y el servidor deben manejar adecuadamente las excepciones (errores de conexión, lectura/escritura de archivos, etc.).

  
  
  
  
Este es el detalle de los nuevos requisitos:

-   Selección dinámica de archivos: El cliente puede elegir cualquier archivo de su sistema para enviarlo al servidor mediante un cuadro de diálogo de selección de archivos (  
      
    JOptionChoiser ).
-   Colores en consola: Usar códigos ANSI para que el texto de la consola se muestre en diferentes colores (verde para éxito, rojo para error, azul para mensajes informativos).
-   Enviar múltiples archivos: El cliente puede enviar varios archivos de manera secuencial.

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
