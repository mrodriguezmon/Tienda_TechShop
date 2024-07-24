package com.GamerStore.service;

import com.GamerStore.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);
    
    //se obteiene un categoria a partir del id de un categoria

    public Categoria getCategoria(Categoria categoria);

    //se inse
    public void save(Categoria categoria);

    //se elimina el categoria que tiene el id pasado por el paramento
    public void delete(Categoria categoria);
}
