package com.example.Venta.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venta {
    private Long idVenta;
    private Long usuarioId;
    private Date fechaVenta; 
    private  double total;
    private String metodoPago; 
    private  String estado;
}
