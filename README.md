**Tips creación de proyecto Maven Clean Architecture**  ![Clean Architecture](https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg)
  
**Proyecto Raiz**

 - Crear un Proyecto Maven en blanco, sin arquetipo.
 - Nombrarlo de acuerdo al objetivo general del sistema. Por ejemplo: *Vuelos*  
 - [Opcional] Eliminar la carpeta "src" de este proyecto.

  
**Proyecto Core**  
 - Crear un Modulo Maven en blanco, sin arquetipo. El asistente precargará el group-id y demás, del proyecto Raiz
 - Nombrarlo de acuerdo a la capa del proyecto. Por ejemplo: *Vuelos-Core*
 - Agregar las dependencias de Junit y Mockito ***[Nota: Agregar la carpeta con la clase MockitoExtension en src/test, para poder usar Mockito con Junit5]***

  
**Proyecto Boundaries**  
 - Crear un Modulo Maven en blanco, sin arquetipo. El asistente precargará el group-id y demás, del proyecto Raiz
 - Nombrarlo de acuerdo a la capa del proyecto. Por ejemplo: *Vuelos-Boundaries* 
 - Agregar las dependencias de spring boot, spring data y spring web, y las que se necesiten.
 - Agregarle al pom.xml, junto a artifactID, la etiqueta `<packaging>war</packaging>`
