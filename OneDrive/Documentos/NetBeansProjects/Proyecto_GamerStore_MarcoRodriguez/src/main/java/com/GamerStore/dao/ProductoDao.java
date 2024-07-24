
package com.GamerStore.dao;

import com.GamerStore.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository <Producto,Long>{
    
}
