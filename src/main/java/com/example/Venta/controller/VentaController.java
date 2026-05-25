package com.example.Venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Venta.model.Venta;
import com.example.Venta.service.VentaService;
@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody Venta venta) {
        try {
            ventaService.registrarVenta(venta);
            return ResponseEntity.ok("Venta registrada y procesada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta: " + e.getMessage());
        }
    }

    
    @GetMapping("/{id}/boleta")
    public ResponseEntity<String> obtenerBoleta(@PathVariable Long id) {
        String boleta = ventaService.generarBoleta(id);
        return ResponseEntity.ok(boleta);
    }

    
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<String> cancelar(@PathVariable Long id) {
        try {
            ventaService.cancelarVenta(id);
            return ResponseEntity.ok("La venta ha sido cancelada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
