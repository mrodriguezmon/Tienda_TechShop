package com.GamerStore.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data // Genera getters y setters automáticamente
@Entity // Define que esta clase es una entidad JPA
@Table(name="soporte") // Define la tabla asociada
public class SoporteCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_soporte")
    private Long idSoporte;

    @Column(name="correo_electronico")
    private String correoElectronico;

    @Column(name="tipo_queja")
    private String tipoQueja;

    private String detalle;

    public SoporteCliente() {
        // Constructor por defecto
    }

    public SoporteCliente(String correoElectronico, String tipoQueja, String detalle) {
        this.correoElectronico = correoElectronico;
        this.tipoQueja = tipoQueja;
        this.detalle = detalle;
    }
}
