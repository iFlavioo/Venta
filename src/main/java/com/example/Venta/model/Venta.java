package com.example.Venta.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "venta")

public class Venta {
    @Id
    private Long idVenta;
    private Long usuarioId;
    private Date fechaVenta; 
    private  double total;
    private String metodoPago; 
    private  String estado;
}
