package com.example.Venta.model;

import lombok.Data;

@Data
public class UsuarioDTO {
private int  id;
private String nombre;
private String  apellido;
private String  correo; 
private String contreseña; 
private String telefono;
private String rol;
private boolean activo; 
}
