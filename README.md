# Desafío Evaluado día 18

## Tabla de contenidos
1.[Requerimientos](#requerimientos)
1.[Funcionamiento](#funcionamiento)
1.[Notas de la versión (v2)](#Notasdelaversión(v2))

## Requerimientos
En el siguiente desafío debes crear un archivo y un fichero. Se necesita escribir y leer desde
el archivo creado por el usuario. Para ello, se deberá validar la información de entrada.
El archivo tendrá múltiples líneas y en cada línea un texto aleatorio.
Cada elemento debe corresponder a un texto precargado dentro de ArrayList que se entregará
en el requerimiento, esto debe implementarse para llenar el archivo.
En el ejemplo anterior, el fichero está llenado con información extraída desde un ArrayList.

## Funcionamiento

Programa que permite agregar datos un Arraylist para luego insertarlos en un archivo de texto (txt). 
Cuenta con un método llamado Crear Archivo. El cual crea una carpeta y un archivo de texto en su interior.
Además inserta en el interior del archivo los datos del Arraylist.
Contiene un método denominado bucarTexto el cual busca dentro del archivo txt y cuenta la cantidad de veces
que ese elemento se repite.

## Notas de la versión (v2)

En esta versión se cuenta con un archivo txt ubicado en "src/desafioEvaluadoDia18V2/" que permite ingresar 
datos de entrada al programa. Estos datos luego pueden ser consultados mediante la consola, para saber la
cantidad de veces que esta palabra se repite. 

En el método de búsqueda se ha actualizado la forma de filtrar esta información mediante el uso de secuencia
de datos utilizando la herramienta Stream. Además, el contador ha sido actualizado utilizando el .size() de 
la lista e igualando este al retorno de este método.
