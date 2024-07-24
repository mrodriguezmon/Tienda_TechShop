package com.GamerStore.controller;

import com.GamerStore.domain.Cliente;
import com.GamerStore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var clientes = clienteService.getClientes(false);
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "/cliente/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }

}
