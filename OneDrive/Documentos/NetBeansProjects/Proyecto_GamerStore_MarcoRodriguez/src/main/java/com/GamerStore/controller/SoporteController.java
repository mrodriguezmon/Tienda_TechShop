
package com.GamerStore.controller;

import com.GamerStore.domain.SoporteCliente;
import com.GamerStore.service.SoporteClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//public class SoporteController {
  //  @GetMapping("/SoporteTecnico")
    //public String soporteTecnico() {
      //  return "SoporteTecnico";
    //}
@Controller
@RequestMapping("/soporte")
public class SoporteController {

    @Autowired
    private SoporteClienteService soporteClienteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var soportes = soporteClienteService.getSoportes(false);
        model.addAttribute("soportes", soportes);
        model.addAttribute("totalSoportes", soportes.size());
        return "/soporte/listado";
    }

    @GetMapping("/nuevo")
    public String soporteNuevo(SoporteCliente soporteCliente) {
        return "/soporte/modifica";
    }

    @PostMapping("/guardar")
    public String soporteGuardar(SoporteCliente soporteCliente) {
        soporteClienteService.save(soporteCliente);
        return "redirect:/soporte/listado";
    }

    @GetMapping("/eliminar/{idSoporte}")
    public String soporteEliminar(SoporteCliente soporteCliente) {
        soporteClienteService.delete(soporteCliente);
        return "redirect:/soporte/listado";
    }

    @GetMapping("/modificar/{idSoporte}")
    public String soporteModificar(SoporteCliente soporteCliente, Model model) {
        soporteCliente = soporteClienteService.getSoporte(soporteCliente);
        model.addAttribute("soporteCliente", soporteCliente);
        return "/soporte/modifica";
    }
}

