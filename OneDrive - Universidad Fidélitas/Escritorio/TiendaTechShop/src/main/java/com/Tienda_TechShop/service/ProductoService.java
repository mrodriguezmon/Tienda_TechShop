package com.Tienda_TechShop.service;

import com.Tienda_TechShop.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activos);
    
    //se obteiene un producto a partir del id de un producto

    public Producto getProducto(Producto producto);

    //se inse
    public void save(Producto producto);

    //se elimina el producto que tiene el id pasado por el paramento
    public void delete(Producto producto);
    
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    public List<Producto> metodoSQL(double precioInf, double precioSup);
    
    
}
