# Java Portfolio 🚀

Bienvenido a mi colección de proyectos en Java. Este repositorio muestra mi capacidad para desarrollar aplicaciones de escritorio enfocándome en la lógica funcional y la seguridad de los datos.

---

## 🔐 1. Buscador de Personas (Basedatos.java)
Este es un motor de búsqueda conectado a una base de datos **MySQL** mediante la librería **JDBC**.

### Notas clave de Seguridad (Ciberseguridad):
* **Prevención de SQL Injection:** El proyecto implementa `PreparedStatement` en lugar de consultas estáticas. Esto asegura que cualquier entrada maliciosa del usuario sea tratada estrictamente como texto y no como código ejecutable, protegiendo la integridad de la base de datos.
* **Manejo de Excepciones:** Uso de bloques `try-catch` para gestionar errores de conexión de forma segura sin exponer detalles del sistema.

```java
// Ejemplo de implementación de seguridad:
String sql = "SELECT * FROM Personas WHERE nombre LIKE ?";
PreparedStatement st = conexion.prepareStatement(sql);
st.setString(1, "%" + nombreABuscar + "%");
