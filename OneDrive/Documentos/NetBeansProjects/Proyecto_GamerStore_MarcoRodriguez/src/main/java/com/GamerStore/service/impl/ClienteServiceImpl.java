
package com.GamerStore.service.impl;


import com.GamerStore.dao.ClienteDao;
import com.GamerStore.domain.Cliente;
import com.GamerStore.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> getClientes(boolean activos) {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
}

