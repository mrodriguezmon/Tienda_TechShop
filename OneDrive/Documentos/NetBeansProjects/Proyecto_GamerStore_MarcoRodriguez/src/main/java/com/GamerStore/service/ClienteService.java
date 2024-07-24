

package com.GamerStore.service;

import com.GamerStore.domain.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getClientes(boolean activos);

    void save(Cliente cliente);

    void delete(Cliente cliente);

    Cliente getCliente(Cliente cliente);
}

