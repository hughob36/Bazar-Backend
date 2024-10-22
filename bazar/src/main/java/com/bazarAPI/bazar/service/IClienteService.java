
package com.bazarAPI.bazar.service;

import com.bazarAPI.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public String crearCliente(Cliente cli);
    
    public Cliente traerCliente(Long id_cliente);
    
    public List<Cliente> traerCliente();
    
}
