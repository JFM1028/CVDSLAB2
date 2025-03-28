# LAB2 - PATTERNS

#### TALLER 2
##### PATTERNS - FACTORY

## OBJETIVOS
1. Entender ¿qué es Maven?
2. Usar comandos de generación de arquetipos, compilación y ejecución de un proyecto usando Maven
3. Obtener puntos adicionales por PR qué corrijan o mejoren los laboratorios

## LA HERRAMIENTA MAVEN
La herramienta [Apache Maven](https://maven.apache.org/what-is-maven.html) se usa para gestionar y manejar proyectos de software. La base de maven para un proyecto es el concepto de un modelo de objeto de proyecto (POM), Maven puede gestionar la compilación, los informes y la documentación de un proyecto a partir de este modelo, que se concreta en el archivo `pom.xml`.

Ingresar a la página de la herramienta y entender:
- Cuál es su mayor utilidad
- Fases de maven
- Ciclo de vida de la construcción
- Para qué sirven los plugins
- Qué es y para qué sirve el repositorio central de maven

SOLUTION
### 1. **¿Cuál es la mayor utilidad de Apache Maven?**

Apache Maven es una herramienta de automatización y gestión de proyectos en Java que facilita la construcción, el reporte y la documentación de proyectos. Su mayor utilidad radica en:

- **Gestión de dependencias:** Automatiza la descarga y resolución de las bibliotecas y plugins necesarios para el proyecto desde repositorios remotos.
- **Consistencia en la construcción:** Proporciona un ciclo de vida estándar para compilar, probar, empaquetar e implementar aplicaciones, asegurando que los proyectos se construyan de manera consistente.
- **Modularidad y reutilización:** Permite la creación de proyectos modulares, donde diferentes módulos pueden compartir configuraciones y dependencias.
- **Facilidad de configuración:** Utiliza un archivo de configuración (`pom.xml`) para definir dependencias, plugins, perfiles, y más.

### 2. **Fases de Maven**

Maven define un conjunto de fases que representan diferentes etapas del ciclo de vida de construcción de un proyecto. Las fases más comunes son:

- **validate:** Verifica que el proyecto está correcto y toda la información necesaria está disponible.
- **compile:** Compila el código fuente del proyecto.
- **test:** Ejecuta las pruebas unitarias utilizando un marco de pruebas adecuado como JUnit.
- **package:** Empaqueta el código compilado en un formato distribuible, como un JAR o WAR.
- **verify:** Ejecuta cualquier verificación necesaria sobre el resultado de las pruebas antes de continuar.
- **install:** Instala el paquete en el repositorio local, lo que lo hace disponible como una dependencia para otros proyectos en la máquina local.
- **deploy:** Copia el paquete final al repositorio remoto para compartirlo con otros desarrolladores y proyectos.

### 3. **Ciclo de vida de la construcción**

El ciclo de vida de construcción en Maven es un conjunto de fases que se ejecutan en un orden específico. Maven tiene tres ciclos de vida principales:

- **default:** Maneja la construcción de proyectos, e incluye todas las fases descritas anteriormente.
- **clean:** Maneja la limpieza del proyecto, eliminando archivos generados por una construcción anterior. Las fases son:
  - `pre-clean`
  - `clean`
  - `post-clean`
- **site:** Maneja la creación del sitio web del proyecto, que incluye la documentación. Las fases son:
  - `pre-site`
  - `site`
  - `post-site`
  - `site-deploy`

### 4. **¿Para qué sirven los plugins en Maven?**

Los plugins en Maven son componentes que proporcionan tareas adicionales para el ciclo de vida de la construcción. Sirven para extender la funcionalidad de Maven, permitiendo realizar tareas específicas como:

- **Compilar código fuente** (`maven-compiler-plugin`).
- **Ejecutar pruebas unitarias** (`maven-surefire-plugin`).
- **Generar documentación del proyecto** (`maven-site-plugin`).
- **Empaquetar el proyecto en un JAR, WAR, etc.** (`maven-jar-plugin`, `maven-war-plugin`).
  
Cada fase del ciclo de vida de Maven puede estar asociada con uno o más plugins, lo que permite personalizar la construcción del proyecto.

### 5. **¿Qué es y para qué sirve el repositorio central de Maven?**

El **repositorio central de Maven** es un gran almacén en línea que contiene una vasta colección de librerías y componentes que son utilizados por proyectos Maven. Su propósito es:

- **Almacenar y distribuir librerías:** Proporciona un lugar centralizado desde donde Maven puede descargar automáticamente las dependencias de un proyecto.
- **Facilitar la resolución de dependencias:** Cuando un proyecto declara una dependencia en su `pom.xml`, Maven verifica si está disponible en el repositorio local; si no, la descarga desde el repositorio central.
- **Estandarizar la distribución de componentes:** Permite que los desarrolladores distribuyan sus librerías y herramientas a una audiencia más amplia.

El repositorio central de Maven se encuentra en https://repo.maven.apache.org/maven2/ y se configura de manera predeterminada en cualquier instalación de Maven.


## EJERCICIO DE LAS FIGURAS
### CREAR UN PROYECTO CON MAVEN
Buscar cómo se crea un proyecto maven con ayuda de los arquetipos (archetypes).
  mvn archetype:generate -DgroupId=edu.eci.cvds -DartifactId=Patterns -Dpackage=edu.eci.cvds.patterns.archetype -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false

Busque cómo ejecutar desde línea de comandos el objetivo "generate" del plugin "archetype", con los siguientes parámetros:
```yml
ProjectId: org.apache.maven.archetypes:maven-archetype-quickstart:1.0
Id del Grupo: edu.eci.cvds
Id del Artefacto: Patterns
Paquete: edu.eci.cvds.patterns.archetype
```

Se debió haber creado en el directorio, un nuevo proyecto `Patterns` a partir de un modelo o arquetipo, que crea un conjunto de directorios con un conjunto de archivos básicos.

Cambie al directorio `Patterns`:
```sh
$ cd Patterns
```

Para ver el conjunto de archivos y directorios creados por el comando `mvn` ejecute el comando `tree`.
```sh
$ tree
```
En caso de que no funcione en git bash, otra herramienta que se puede usar es PowerShell ya que ésta maneja el comando "tree".

En algunos sistemas operativos, este comando no funciona correctamente o puede requerir un parámetro (por ejemplo: `tree /f`). En caso que funcione, la
salida muestra la estructura del proyecto, similar a como se muestra a continuación:
```sh
.
│ pom.xml
└───src
├───main
│ └───java
│ └───edu
│ └───eci
│ └───cvds
│ └───patterns
  └───archetype
│ App.java
│
└───test
└───java
└───edu
└───eci
└───cvds
└───patterns
└───archetype
AppTest.java
```

## AJUSTAR ALGUNAS CONFIGURACIONES EN EL PROYECTO
Edite el archivo `pom.xml` y realize la siguiente actualización:

Hay que cambiar la version del compilador de Java a la versión 8, para ello, agregue la sección `properties` antes de la sección de
dependencias:
```xml
<properties>
  <maven.compiler.target>1.8</maven.compiler.target>
  <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

## COMPILAR Y EJECUTAR
Para compilar ejecute el comando:
```sh
$ mvn package
```

Si maven no actualiza las dependencias utilice la opción `-U` así:
```sh
$ mvn -U package
```

Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando `mvn`.

Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase `App.java` como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html

Realice el cambio en la clase `App.java` para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. 

Utilizar la primera posición del parámetro que llega al método "main" para realizar elsaludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente:

Buscar cómo enviar parámetros al plugin "exec".

Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!

Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!

Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?

Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido.

Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!

## HACER EL ESQUELETO DE LA APLICACIÓN
Cree el paquete `edu.eci.cvds.patterns.shapes` y el paquete `edu.eci.cvds.patterns.shapes.concrete`.

Cree una interfaz llamada `Shape.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` de la siguiente manera:
```java
package edu.eci.cvds.patterns.shapes;

public interface Shape {
    public int getNumberOfEdges();
}
```

Cree una enumeración llamada `RegularShapeType.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` así:

```java
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {
    Triangle, Quadrilateral, Pentagon, Hexagon
}
```

En el directorio `src/main/java/edu/eci/cvds/patterns/shapes/concrete` cree las diferentes clases (Triangle, Quadrilateral, Pentagon, Hexagon), que implementen la interfaz creada y retornen el número correspondiente de vértices que tiene la figura. 

Siguiendo el ejemplo del triángulo:
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {
    public int getNumberOfEdges() {
        return 3;
    }
}
```

Cree el archivo `ShapeMain.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` con el metodo main:
```java
package edu.eci.cvds.patterns.shapes;

public class ShapeMain {

  public static void main(String[] args) {
    if (args == null || args.length != 1) {
      System.err.println("Parameter of type RegularShapeType is required.");
      return;
    }
    try {
      RegularShapeType type = RegularShapeType.valueOf(args[0]);
      Shape shape = ShapeFactory.create(type);
      System.out.println(
        String.format(
          "Successfully created a %s with %s sides.",
          type,
          shape.getNumberOfEdges()
        )
      );
    } catch (IllegalArgumentException ex) {
      System.err.println(
        "Parameter '" + args[0] + "' is not a valid RegularShapeType"
      );
      return;
    }
  }
}
```

Analice y asegúrese de entender cada una de las instrucciones que se encuentran en todas las clases que se crearon anteriormente. Cree el archivo `ShapeFactory.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` implementando el patrón fábrica (Hint: https://refactoring.guru/design-patterns/catalog), haciendo uso de la instrucción switch-case de Java y usando las enumeraciones.

¿Cuál fábrica hiciste? y ¿Cuál es mejor?
- Simple Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/0788a0b7-a071-4b90-ac3f-5982289ff3b3)

- Factory Method:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/cd82548d-347b-4a10-88bd-2d203dac12bd)
- Abstract Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/1c79a12b-21d4-46be-8f19-40f3b62b6af7)

Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:
- Sin parámetros
- Parámetro: qwerty
- Parámetro: pentagon
- Parámetro: Hexagon

¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?

## ENTREGAR
- Se espera al menos que durante la sesión de laboratorio, se termine el ejercicio del saludo y haya un avance significativo del ejercicio de las figuras.
Dentro del directorio del proyecto, cree un archivo de texto integrantes.txt con el nombre de los dos integrantes del taller.
- Crear un repositorio para este proyecto y agregar la url del mismo, como entrega del laboratorio.
- La entrega final se realizará en Moodle.
- NOTA: Investigue para qué sirve "gitignore" y cómo se usa. Para futuras entregas, debe estar configurado.

<!-- https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax -->

mvn archetype:generate -DgroupId=edu.eci.cvds -DartifactId=Patterns -Dpackage=edu.eci.cvds.patterns.archetype -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false


Enunciado
La factorización de números enteros es un problema complejo para el cual no se conocen algoritmos clásicos eficientes. La criptografía clásica está soportada en la dificultad para encontrar los factores primos de números grandes.

Diseñe, construya y despliegue un aplicación web para investigar los factores de números enteros y los números primos. El programa debe estar desplegado en tres máquinas virtuales de EC2 de AWS como se describe abajo. Las tecnologías usadas en la solución deben ser maven, git, github, Spring, html5, y js. No use liberías adicionales.

No copie código existente ni suyo ni de otras fuentes. todo el entregable debe ser original creado en la clase por usted.

 Solo use la documentación autorizada por el profesor.

Documentación autorizada:
https://docs.oracle.com/javase/8/docs/api/
https://spring.io/guides/gs/rest-service
https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/amazon-linux-install.html
AWS Academy
AWS

Problema:
Diseñe un prototipo de sistema de microservicios que tenga un servicio (En la figura se representa con el nombre Math Services) para computar las funciones numéricas.  El servicio de las funciones numéricas debe estar desplegado en al menos dos instancias virtuales de EC2. Adicionalmente, debe implementar un service proxy que reciba las solicitudes de llamado desde los clientes  y se las delega a las dos instancias del servicio numérico usando un algoritmo de round-robin. El proxy deberá estar desplegado en otra máquina EC2. Asegúrese que se pueden configurar las direcciones y puertos de las instancias del servicio en el proxy usando variables de entorno del sistema operativo.  Finalmente, construya un cliente Web mínimo con un formulario que reciba el valor y de manera asíncrona invoke el servicio en el PROXY. Puede hacer un formulario para cada una de las funciones. El cliente debe ser escrito en HTML y JS.
﻿
Sobre las funciones numéricas:
Sus servicios matemáticos deben incluir dos funciones. 
Una para calcular los factores de un número: factors(n) retorna un json con una lista de números enteros positivos. (Recibe solo enteros positivos)
Una para calcular los números primos hasta un número dado: primes(n), retorna en un json los números primos menores o iguales a n.
PARA AMBAS IMPLEMENTACIONES USE UN ALGORITMO  DE FUERZA BRUTA, ES DECIR EXPLORE CADA UNO DE LOS VALORES. Usted debe implemntar las dos funciones, no debe usar funciones de una librería o del API (si ya existen).

Por ejemplo, para un  número dado n los factores se pueden calcular así:
1 es un factor de todos los números
de ahí en adelante simplemente mirando el módulo puede verificar si es o no factor.
Puede mirar todos los numeros hasta n/2
n pertenece también a los factores.
Para los primos, puede usar su función de factores así:

1 es un número primo
de ahí en adelante recuerde que un número es primo si solo es divisible por 1 y por si mismo.
Es decir un número es primo si el tamaño del conjunto de factores es 2.
Asegúrese que sus funciones sirven cuando el parámetro es 1.

Detalles adicionales de la arquitectura y del API
Implemente los servicios para responder al método de solicitud HTTP GET. Deben usar el nombre de la función especificado y el parámetro debe ser pasado en la variable de query con nombre "value".

El proxy debe delegar el llamado a los servicios de backend. El proxy y los servicios se deben implementar en Java usando Spring.

Ejemplo 1 de un llamado:

EC2
https://amazonxxx.x.xxx.x.xxx:{port}/factors?value=13

Salida. El formato de la salida y la respuesta debe ser un JSON con el siguiente formato

{
 "operation": "factors",
 "input":  15,
 "output":  "1,3,5,15"
}

Ejemplo 2 de un llamado:

EC2
https://amazonxxx.x.xxx.x.xxx:{port}/factors?value=112

Salida. El formato de la salida y la respuesta debe ser un JSON con el siguiente formato

{
 "operation": "factors",
 "input":  112,
 "output":  "1, 2, 4, 7, 8, 14, 16, 28, 56, 112"
}

Ejemplo 3 de un llamado:

EC2
https://amazonxxx.x.xxx.x.xxx:{port}/primes?value=100

Salida. El formato de la salida y la respuesta debe ser un JSON con el siguiente formato

{
 "operation": "primes",
 "input":  100,
 "output":  "2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,97"
}

Entregable:

1. Proyecto actualizado en github (un solo repositorio)

2. Descripción del proyecto enel README con pantallazos que muestren el funcionamiento.

3. Descripción de como correrlo en EC2.

4. Video de menos de un minuto del funcionamiento (lo puede tomar con el celular una vez funcione)

En el campo de texto escriba la direción de su repositorio GITHUB.


Ayuda

Para invocar un servicios get desde java puede hacerlo de manera fácil con:
     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";

    public static void main(String[] args) throws IOException {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
    }

} 
     
    
Para invocar servicios rest de forma asíncrona desde un cliente JS
     

<!DOCTYPE html>
<html>
    <head>
        <title>Form Example</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Form with GET</h1>
        <form action="/hello">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" value="John"><br><br>
            <input type="button" value="Submit" onclick="loadGetMsg()">
        </form> 
        <div id="getrespmsg"></div>

        <script>
            function loadGetMsg() {
                let nameVar = document.getElementById("name").value;
                const xhttp = new XMLHttpRequest();
                xhttp.onload = function() {
                    document.getElementById("getrespmsg").innerHTML =
                    this.responseText;
                }
                xhttp.open("GET", "/hello?name="+nameVar);
                xhttp.send();
            }
        </script>

        <h1>Form with POST</h1>
        <form action="/hellopost">
            <label for="postname">Name:</label><br>
            <input type="text" id="postname" name="name" value="John"><br><br>
            <input type="button" value="Submit" onclick="loadPostMsg(postname)">
        </form>
        
        <div id="postrespmsg"></div>
        
        <script>
            function loadPostMsg(name){
                let url = "/hellopost?name=" + name.value;

                fetch (url, {method: 'POST'})
                    .then(x => x.text())
                    .then(y => document.getElementById("postrespmsg").innerHTML = y);
            }
        </script>
    </body>
</html>

3. Aplicación Spring mínima

-------
package co.edu.eci.lambda.springrest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
-------
package co.edu.eci.lambda.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
---------
package co.edu.eci.lambda.springrest;


public record Greeting(long id, String content) { }

    4. Ejemplo pom.xml de Spring con plugins

    
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.0</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>rest-service-complete</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>rest-service-complete</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
