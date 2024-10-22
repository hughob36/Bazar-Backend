
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
    public String saveCliente(Cliente cli) {
        clienteRepo.save(cli);        
       return "Guardaste un cliente";       
    } 

    @Override
    public Cliente getCliente(Long id_cliente) {
        
        Cliente cli = clienteRepo.findById(id_cliente).orElse(null);
        return cli;
    }

    @Override
    public List<Cliente> getCliente() {
      
        List<Cliente> listCliente = clienteRepo.findAll();
        return listCliente;
    }
       
    @Override
    public String deleteCliente(Long id) {
        
        clienteRepo.deleteById(id);
        return "Borraste un cliente";
    }

    @Override
    public Cliente editCliente(Long id_original,
                               Long id_cliente,
                               String nombre,
                               String apellido,
                               String dni) {
        
        
        Cliente cli = clienteRepo.findById(id_original).orElse(null);
        
        cli.setId_cliente(id_cliente);
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setDni(dni);
        
        clienteRepo.save(cli);
        
        return cli;
        
    }

    @Override
    public Cliente editCliente(Cliente cli) {
        
        Cliente nuevoCli = clienteRepo.findById(cli.getId_cliente()).orElse(null);
        nuevoCli.setNombre(cli.getNombre());
        nuevoCli.setApellido(cli.getApellido());
        nuevoCli.setDni(cli.getDni());        
        
        clienteRepo.save(nuevoCli);
        
        return nuevoCli;
    }
    
}
