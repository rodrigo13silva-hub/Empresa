# Gestión de Empresa - Ropa Corporativa

App Android para gestionar catálogo de productos, cotizaciones y facturación para empresa de ropa corporativa.

## Características

- 🔐 **Autenticación segura** con roles (Admin, Vendedor, Cliente)
- 📦 **Catálogo de productos** con fotos y características
- 📋 **Generación de cotizaciones** personalizadas
- 💳 **Sistema de facturación** automático
- 👥 **Gestión de clientes** y usuarios
- 📊 **Reportes y estadísticas**

## Estructura del Proyecto

```
/app
  /src
    /main
      /java/com/empresa
        /ui
          - LoginActivity
          - MenuPrincipalActivity
          - CatalogoActivity
          - CotizacionActivity
          - FacturaActivity
        /models
          - Usuario
          - Producto
          - Cotizacion
          - Factura
          - Cliente
        /adapters
          - ProductoAdapter
          - CotizacionAdapter
        /database
          - AppDatabase
          - DAO interfaces
        /services
          - AuthService
          - ProductoService
          - CotizacionService
      /res
        /layout
        /drawable
        /values
      AndroidManifest.xml
  build.gradle
```

## Tecnología

- **Lenguaje:** Kotlin/Java
- **Base de datos:** Room (SQLite local) + Firebase (opcional)
- **UI:** Material Design
- **Autenticación:** JWT o Firebase Auth

## Instalación

1. Clonar el repositorio
2. Abrir en Android Studio
3. Descargar dependencias: `./gradlew build`
4. Ejecutar en emulador o dispositivo físico

## Próximos pasos

- [ ] Crear estructura de proyecto base
- [ ] Implementar autenticación
- [ ] Crear catálogo de productos
- [ ] Sistema de cotizaciones
- [ ] Sistema de facturación
- [ ] Base de datos
