
package com.GamerStore.dao;

import com.GamerStore.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository <Categoria,Long>{
    
}
