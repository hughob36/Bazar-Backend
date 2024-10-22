
package com.bazarAPI.bazar.controller;

import com.bazarAPI.bazar.model.Cliente;
import com.bazarAPI.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienteServi;
    
    @PostMapping("/cliente/crear")
    public String crearCliente(@RequestBody Cliente cli){
        
        String nota = clienteServi.crearCliente(cli);
        return nota;
    }
    
}
