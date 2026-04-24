package com.empresa.ropa.repository

import com.empresa.ropa.database.FacturaDao
import com.empresa.ropa.models.Factura
import com.empresa.ropa.utils.FormatUtils
import kotlinx.coroutines.flow.Flow

class FacturaRepository(private val facturaDao: FacturaDao) {

    suspend fun crearFactura(factura: Factura): Long {
        // Generar número de factura
        val ultimaFactura = facturaDao.obtenerUltima()
        val numero = if (ultimaFactura != null) {
            val secuencial = ultimaFactura.numero.split("-").last().toInt() + 1
            FormatUtils.generarNumero("FAC", secuencial)
        } else {
            FormatUtils.generarNumero("FAC", 1)
        }

        val facturaConNumero = factura.copy(numero = numero)
        return facturaDao.insertar(facturaConNumero)
    }

    suspend fun actualizarFactura(factura: Factura) {
        facturaDao.actualizar(factura)
    }

    suspend fun eliminarFactura(factura: Factura) {
        facturaDao.eliminar(factura)
    }

    suspend fun obtenerFacturaPorId(id: Int): Factura? {
        return facturaDao.obtenerPorId(id)
    }

    suspend fun obtenerFacturaPorCotizacion(cotizacionId: Int): Factura? {
        return facturaDao.obtenerPorCotizacion(cotizacionId)
    }

    fun obtenerFacturasPorCliente(usuarioId: Int): Flow<List<Factura>> {
        return facturaDao.obtenerPorCliente(usuarioId)
    }

    fun obtenerFacturasPorEstado(estado: String): Flow<List<Factura>> {
        return facturaDao.obtenerPorEstado(estado)
    }

    suspend fun marcarComoPagada(facturaId: Int) {
        val factura = facturaDao.obtenerPorId(facturaId)
        if (factura != null) {
            facturaDao.actualizar(
                factura.copy(
                    estado = "pagada",
                    fechaPago = System.currentTimeMillis()
                )
            )
        }
    }

    suspend fun anularFactura(facturaId: Int) {
        val factura = facturaDao.obtenerPorId(facturaId)
        if (factura != null) {
            facturaDao.actualizar(factura.copy(estado = "anulada"))
        }
    }

    suspend fun obtenerIngresosTotales(desde: Long, hasta: Long): Double {
        return facturaDao.obtenerIngresosTotales(desde, hasta) ?: 0.0
    }
}
