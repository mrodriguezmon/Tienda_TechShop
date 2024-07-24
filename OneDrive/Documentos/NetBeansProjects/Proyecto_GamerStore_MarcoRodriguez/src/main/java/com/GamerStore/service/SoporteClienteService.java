package com.GamerStore.service;

import com.GamerStore.domain.SoporteCliente;
import java.util.List;

public interface SoporteClienteService {
    List<SoporteCliente> getSoportes(boolean activos);

    void save(SoporteCliente soporteCliente);

    void delete(SoporteCliente soporteCliente);

    SoporteCliente getSoporte(SoporteCliente soporteCliente);
}

