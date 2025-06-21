# 👨‍💻 Programación Sobre Redes - 2025 👨‍💻
#### Benjamín Nehemías Castro Madrid 6to 1ra Computación
#### Correo: benjamin.castromadrid28et32@gmail.com

Este repositorio está dedicado a la materia **Programación sobre Redes**, dictada por el profesor **Gonzalo Nicolás Consorti** en la **Escuela General José de San Martín ET32**, ubicada en el Distrito Escolar 14. La materia se imparte durante el año **2025** y está enfocada en proporcionar una comprensión profunda de los conceptos fundamentales de las redes y la programación orientada a ellas.

## Consigna Trabajo Práctico N°1 - Files/Archivos 

1) Ingresar datos numéricos (por diferentes orígenes, sin usar la clase Scanner para leer o
escribir e ingresando, por lo menos, 2 veces el numero ‘0’ por cada uno de los orígenes de
datos entrantes e enviarlos a un algoritmo que los almacene en 2 sectores de memoria
distintos:
- volátil (en memoria) – “vectores”, para guardar la información en tiempo real (ingresar
por lo menos 5 valores). Vector de 5 espacios.
- no-volátil (disco) – “archivos de texto”, para guardar y leer los datos del proceso (guardar
por lo menos 5 valores). Uno por cada renglón. //no crear el archivo de texto a mano.

2) Leer los datos numéricos del vector cargado en el punto 1 y generar 2 archivos de salida:
-Por un lado, los resultados de dividir entre cada dato leído y el número que quede de la
siguiente operación (siguiente número del vector - 3) en un archivo “resultados.txt”. Con el
formato en un renglón por cuenta: numero1 / numero2 = resultado
-Y por el otro lado, cada vez que la división tire un error matemático o de falta de algún
número de entrada, guardar el error correspondiente en un archivo “error.txt” ubicado en
la carpeta del proyecto. ”. Con el formato en un renglón por cuenta: numero1 / numero2 =
error

(Punto 3 para después de ver lectura de archivos)
3) Leer los datos numéricos de los 2 orígenes guardados en el punto 1 y generar 2 archivos
de salida:
-Por un lado, los resultados de la división entre cada dato leído y el numero 3 en un archivo
“resultados.txt”. Con el formato en un renglón por cuenta: numero1 / numero2 = resultado

-Y por el otro lado, cada vez que la división tire un error matemático o de falta de algún
número de entrada, guardar el error correspondiente en un archivo “error.txt” ubicado en
la carpeta del proyecto.

La divicion por el numero 0 o por un valor vacio sabemos que no es posible (ya que da infinito, osea error), asi que sabiendo que esto puede pasar (que lo sabemos) y el tipo de excepcion que nos va a devolver (ArithmeticException -> en caso de dividir por '0' y NullPointerException -> en caso de faltarle alguno de los 2 numero a dividir) podemos atrapar el error para que el programa siga funcionando hasta terminar su rutina y cada vez que suceda, dar un error de aviso.

## Objetivo del repositorio

El objetivo principal de este repositorio es ofrecer un espacio centralizado donde podrás encontrar todo el material confeccionado durante el curso, incluyendo:
    
-   **Ejercicios prácticos**: Una serie de ejercicios y actividades que ayudarán a afianzar los conocimientos adquiridos, con soluciones detalladas para que puedas aprender de manera efectiva.
    
-   **Proyectos y entregas**: Los proyectos y entregas que forman parte de la evaluación del curso. Cada proyecto estará acompañado de documentación que explica los objetivos, el código, y los resultados esperados.
    
-   **Recursos adicionales**: Material extra que el profesor Gonzalo Nicolás Consorti ha proporcionado para complementar la enseñanza. Esto incluye artículos, tutoriales, y enlaces a recursos externos relacionados con la programación en redes.

## Estructura
Este repositorio se ira actualizando a medida que las clases con el profesor se vayan dictando durante el año presente. Actualmente la estructura es la siguiente
 - **main**
 - **GuiaEjercicios-1_2025** --> Aquí podrás encontrar los ejercicios de la primer guía.
	 - guia_Ejercicios_1  --> Carpeta del proyecto en Maven.
 - **trabajoPracticoArchivosIO** --> Aquí encontrarás los ejercicios del TP N°1 - Files.
	 - trabajoPracticoArchivosIO --> Carpeta del proyecto en Maven.

## Conclusión
Este repositorio recompila todo tipo de información adquirida durante mi instancia en la materia y en la escuela.
En especial, el lenguaje de programación JAVA.
![(https://static.wixstatic.com/media/ff9d7d_6c4add613f9142998981fa424cf843b8~mv2.png/v1/fill/w_1046,h_654,al_c,q_90,usm_0.66_1.00_0.01,enc_avif,quality_auto/ff9d7d_6c4add613f9142998981fa424cf843b8~mv2.png)](https://static.wixstatic.com/media/ff9d7d_6c4add613f9142998981fa424cf843b8~mv2.png/v1/fill/w_1046,h_654,al_c,q_90,usm_0.66_1.00_0.01,enc_avif,quality_auto/ff9d7d_6c4add613f9142998981fa424cf843b8~mv2.png)

