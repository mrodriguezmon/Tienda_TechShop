package com.GamerStore.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data // Genera getters y setters automáticamente
@Entity // Define que esta clase es una entidad JPA
@Table(name="cliente") // Define la tabla asociada
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente;

    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String provincia;
    private String codigoPostal;
    private String contraseña;

    @Transient
    private String confirmarContraseña;

    public Cliente() {
        // Constructor por defecto
    }

    public Cliente(String nombre, String apellidos, String correoElectronico, String provincia, String codigoPostal, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.contraseña = contraseña;
    }
}


