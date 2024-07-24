package com.GamerStore.service;

import com.GamerStore.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activos);
    
    //se obteiene un producto a partir del id de un producto

    public Producto getProducto(Producto producto);

    //se inse
    public void save(Producto producto);

    //se elimina el producto que tiene el id pasado por el paramento
    public void delete(Producto producto);
}
