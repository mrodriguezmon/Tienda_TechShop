package com.GamerStore.service.impl;

import com.GamerStore.dao.SoporteClienteDao;
import com.GamerStore.domain.SoporteCliente;
import com.GamerStore.service.SoporteClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoporteClienteServiceImpl implements SoporteClienteService {

    @Autowired
    private SoporteClienteDao soporteClienteDao;

    @Override
    public List<SoporteCliente> getSoportes(boolean activos) {
        return (List<SoporteCliente>) soporteClienteDao.findAll();
    }

    @Override
    public void save(SoporteCliente soporteCliente) {
        soporteClienteDao.save(soporteCliente);
    }

    @Override
    public void delete(SoporteCliente soporteCliente) {
        soporteClienteDao.delete(soporteCliente);
    }

    @Override
    public SoporteCliente getSoporte(SoporteCliente soporteCliente) {
        return soporteClienteDao.findById(soporteCliente.getIdSoporte()).orElse(null);
    }
}

