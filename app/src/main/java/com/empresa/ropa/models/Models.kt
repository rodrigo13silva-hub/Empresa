package com.empresa.ropa.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    val nombre: String,
    val contraseña: String, // Hash con BCrypt
    val rol: String, // ADMIN, VENDEDOR, CLIENTE
    val razonSocial: String? = null, // Para clientes corporativos
    val rut: String? = null,
    val telefono: String? = null,
    val direccion: String? = null,
    val ciudad: String? = null,
    val estado: String = "activo", // activo, inactivo
    val fechaRegistro: Long = System.currentTimeMillis()
)

@Entity(tableName = "productos")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val descripcion: String,
    val categoria: String, // Camiseta, Pantalón, Chaqueta, etc.
    val precio: Double,
    val cantidad: Int,
    val tallas: String, // JSON: ["XS", "S", "M", "L", "XL", "XXL"]
    val colores: String, // JSON: ["Negro", "Blanco", "Azul"]
    val imagen: String? = null, // URL o path
    val codigoProducto: String,
    val estado: String = "activo"
)

@Entity(tableName = "cotizaciones")
data class Cotizacion(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val numero: String, // COT-001, COT-002
    val clienteId: Int,
    val vendedorId: Int,
    val fechaCreacion: Long = System.currentTimeMillis(),
    val fechaVencimiento: Long = 0,
    val subtotal: Double = 0.0,
    val descuento: Double = 0.0,
    val impuesto: Double = 0.0,
    val total: Double = 0.0,
    val estado: String = "borrador", // borrador, enviada, aceptada, rechazada, facturada
    val notas: String? = null
)

@Entity(tableName = "cotizacion_detalles")
data class CotizacionDetalle(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cotizacionId: Int,
    val productoId: Int,
    val cantidad: Int,
    val talla: String,
    val color: String,
    val precioUnitario: Double,
    val subtotal: Double
)

@Entity(tableName = "facturas")
data class Factura(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val numero: String, // FAC-001, FAC-002
    val cotizacionId: Int,
    val clienteId: Int,
    val fechaEmision: Long = System.currentTimeMillis(),
    val fechaPago: Long? = null,
    val subtotal: Double = 0.0,
    val descuento: Double = 0.0,
    val impuesto: Double = 0.0,
    val total: Double = 0.0,
    val estado: String = "pendiente", // pendiente, pagada, anulada
    val metodoPago: String? = null, // Efectivo, Transferencia, Tarjeta
    val referenciaPago: String? = null
)

@Entity(tableName = "clientes")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val usuarioId: Int,
    val razonSocial: String,
    val rut: String,
    val giro: String,
    val telefono: String,
    val email: String,
    val direccion: String,
    val ciudad: String,
    val contactoPrincipal: String,
    val estado: String = "activo",
    val creditoDisponible: Double = 0.0,
    val fechaRegistro: Long = System.currentTimeMillis()
)
