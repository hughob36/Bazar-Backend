
package com.bazarAPI.bazar.service;

import com.bazarAPI.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public String saveCliente(Cliente cli);
    
    public Cliente getCliente(Long id_cliente);
    
    public List<Cliente> getCliente();
    
    public String deleteCliente(Long id);
    
    public Cliente editCliente(Long id_original,Long id_cliente, String nombre, String apellido, String dni);
    
    public Cliente editCliente(Cliente cli);
}
