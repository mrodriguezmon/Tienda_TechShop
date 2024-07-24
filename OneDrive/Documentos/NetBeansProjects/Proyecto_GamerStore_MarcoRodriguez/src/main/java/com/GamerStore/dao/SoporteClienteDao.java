
package com.GamerStore.dao;

import com.GamerStore.domain.SoporteCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoporteClienteDao extends JpaRepository<SoporteCliente, Long> {
    
}
