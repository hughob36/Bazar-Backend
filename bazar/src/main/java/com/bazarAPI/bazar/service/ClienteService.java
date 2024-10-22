
package com.bazarAPI.bazar.service;

import com.bazarAPI.bazar.model.Cliente;
import com.bazarAPI.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public String crearCliente(Cliente cli) {
        clienteRepo.save(cli);        
       return "Guardaste un cliente";       
    } 

    @Override
    public Cliente traerCliente(Long id_cliente) {
        
        Cliente cli = clienteRepo.findById(id_cliente).orElse(null);
        return cli;
    }

    @Override
    public List<Cliente> traerCliente() {
      
        List<Cliente> listCliente = clienteRepo.findAll();
        return listCliente;
    }
    
    
    /*Long id_cliente, String nombre, String apellido, String dni*/
    
}
