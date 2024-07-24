
package com.GamerStore.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data//GET Y SET AUTOS
@Entity//VA TENER UN MAPEO CON UNA TABLA
@Table(name="categoria")//DEFINE LA TABLA ASOCIADA

public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    //@OneToMany //Es una asociación para una relación de uno a muchos entre tablas
    //@Column (name="id_categoria") //es la columna con la que se realiza la asociación en minuscula porque asi viene en la tabla
    //private List<Producto> productos;
    
    public Categoria(){
        
    }
    
    public Categoria(String categoria, boolean activo){
        this.descripcion = categoria;
        this.activo = activo;
    }
}
