package com.example.Venta.model;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private boolean activo; // CRITICAL: Para verificar si el usuario puede comprar

    // Constructores
    public UsuarioDTO() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}