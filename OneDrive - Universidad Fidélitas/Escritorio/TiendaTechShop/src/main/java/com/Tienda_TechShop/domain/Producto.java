package com.Tienda_TechShop.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data//GET Y SET AUTOS
@Entity//VA TENER UN MAPEO CON UNA TABLA
@Table(name="producto")//DEFINE LA TABLA ASOCIADA

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    //ESTO SE TIENE QUE ELIMINAR!! **PENDIENTE**
    //private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

   @ManyToOne //Efectivamente la asosiación de muchos a uno
   @JoinColumn(name = "id_categoria") //Indicar el atributo en este caso de la tabla, id_categoria en minuscula xq asi sale en la tabla
   private Categoria categoria;
}
