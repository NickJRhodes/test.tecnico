# Aclaraciones

  - Proyecto maven
  - Se utiliza Spring Boot 2.3.3
  - No se utiliza una capa Servicio
  - No se utiliza una capa DTO
  - Se utiliza una base de datos en memoria
  - Se generaron test unitarios con JUnit 5 y Spring Boot Test
  - Existe sólo un test de integración, para probar el contexto de la aplicación
  - La cobertura de los test es del 100%
  - Cualquier excepción que ocurra cuando se llama a la api provocará una respuesta de estado 500 y el mensaje "Error inesperado."
  - Se generan logs de todas las excepciones
  - El objeto Persona es una mezcla entre entidad pura y modelo de negocio, cumpliendo con las reglas del requerimiento del proyecto
  - La aplicación levanta en el puerto 8080 con Tomcat embebido
  
# Endpoints

  - GET: http://localhost:8080/personas
  - POST: http://localhost:8080/personas Ejemplo cuerpo de la solicitud: {"nombre": "Fernanda", "apellido": "Lopez", "edad": 20, "sexo": "F"}
  - PUT: http://localhost:8080/personas/${id} Ejemplo cuerpo de la solicitud: {"id": 12, "nombre": "Fernanda", "apellido": "Lopez", "edad": 20, "sexo": "F"}
  - DELETE: http://localhost:8080/personas/${id}
  
  
 ## Nicolás Rodriguez
