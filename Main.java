# Fashion Peak - Módulo CRUD con JDBC
## GA7-220501096-AA2-EV01

**Autor:** Laura Valentina Torres Chaparro  
**Ficha:** 2977463 - Análisis y Desarrollo de Software  
**Instructor:** Elizabeth Gelves Gelves  
**SENA Colombia - 2026**

---

## 📁 Estructura del Proyecto

```
TorresChaparro_AA2_EV01/
├── src/
│   └── com/fashionpeak/
│       ├── Main.java                    ← Punto de entrada
│       ├── conexion/
│       │   └── Conexion.java            ← Conexión JDBC MySQL
│       ├── modelo/
│       │   └── Producto.java            ← Clase modelo (POO)
│       ├── dao/
│       │   ├── IProductoDAO.java        ← Interface CRUD
│       │   └── ProductoDAO.java         ← Implementación CRUD
│       └── vista/
│           └── MenuPrincipal.java       ← Menú de consola
├── fashionpeak_db.sql                   ← Script base de datos
├── REPOSITORIO.txt                      ← Enlace del repositorio
└── README.md                            ← Este archivo
```

---

## 🛠️ Requisitos

- Java JDK 17 o superior
- MySQL Server 8.0+
- MySQL Connector/J (JDBC Driver)
- IDE: IntelliJ IDEA / Eclipse / NetBeans

---

## ⚙️ Configuración

### 1. Crear la base de datos
Ejecutar el script `fashionpeak_db.sql` en MySQL Workbench:
```sql
SOURCE fashionpeak_db.sql;
```

### 2. Configurar la conexión
Editar el archivo `Conexion.java` con tus datos:
```java
private static final String URL      = "jdbc:mysql://localhost:3306/fashionpeak";
private static final String USUARIO  = "root";
private static final String PASSWORD = "tu_contraseña";
```

### 3. Agregar el driver JDBC
Descargar `mysql-connector-j-8.x.x.jar` desde:  
https://dev.mysql.com/downloads/connector/j/

Agregar al classpath del proyecto en tu IDE.

---

## ▶️ Ejecución

Compilar y ejecutar la clase `Main.java`. El programa mostrará:

```
╔══════════════════════════════════════╗
║   FASHION PEAK - Módulo de Productos ║
║   Codificación JDBC con MySQL        ║
╚══════════════════════════════════════╝

╔══════════════════════════════════════╗
║       FASHION PEAK - CRUD            ║
╠══════════════════════════════════════╣
║  1. Insertar producto                ║
║  2. Consultar todos                  ║
║  3. Consultar por ID                 ║
║  4. Consultar por categoría          ║
║  5. Actualizar producto              ║
║  6. Eliminar producto                ║
║  0. Salir                            ║
╚══════════════════════════════════════╝
```

---

## 📦 Paquetes y Clases

| Paquete | Clase | Descripción |
|---------|-------|-------------|
| `com.fashionpeak` | `Main` | Punto de entrada |
| `com.fashionpeak.conexion` | `Conexion` | Gestión JDBC (Singleton) |
| `com.fashionpeak.modelo` | `Producto` | Modelo de datos (POO) |
| `com.fashionpeak.dao` | `IProductoDAO` | Interface CRUD |
| `com.fashionpeak.dao` | `ProductoDAO` | Implementación CRUD |
| `com.fashionpeak.vista` | `MenuPrincipal` | Interfaz de consola |
