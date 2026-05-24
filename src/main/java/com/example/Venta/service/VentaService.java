package com.example.Venta.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Venta.model.Venta;
import com.example.Venta.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired VentaRepository ventaRepository;

public void registrarVenta(Venta venta) {
        venta.setFechaVenta((java.sql.Date) new Date());
        venta.setEstado("PENDIENTE");  
        
        
        double totalCalculado = calcularTotal(venta.getTotal(), 0.19, 0.0); 
        venta.setTotal(totalCalculado);
        
        ventaRepository.save(venta);
    }


    public double calcularTotal(double subtotal, double impuestoPorcentaje, double descuento) {
        double impuestos = subtotal * impuestoPorcentaje;
        double total = (subtotal + impuestos) - descuento;
        return Math.max(total, 0.0); // Previene que el total sea negativo
    }

    public String generarBoleta(Long idVenta) {
        Optional<Venta> ventaOpt = ventaRepository.findById(idVenta);
        
        if (ventaOpt.isPresent()) {
            Venta v = ventaOpt.get();
            return String.format(
                "==================================\n" +
                "         BOLETA ELECTRONICA       \n" +
                "==================================\n" +
                "ID Venta    : %d\n" +
                "ID Usuario  : %d\n" +
                "Fecha       : %s\n" +
                "Método Pago : %s\n" +
                "Estado      : %s\n" +
                "----------------------------------\n" +
                "TOTAL       : $%.2f\n" +
                "==================================",
                v.getIdVenta(), v.getUsuarioId(), v.getFechaVenta().toString(), 
                v.getMetodoPago(), v.getEstado(), v.getTotal()
            );
        }
        return "Error: No se pudo generar la boleta. Venta no encontrada.";
    }

    
    public void cancelarVenta(Long idVenta) {
        Optional<Venta> ventaOpt = ventaRepository.findById(idVenta);
        
        if (ventaOpt.isPresent()) {
            Venta venta = ventaOpt.get();
            venta.setEstado("CANCELADA");
            ventaRepository.save(venta); // Actualiza el estado en la BD
        } else {
            throw new RuntimeException("La venta con ID " + idVenta + " no existe.");
        }
    }
}
