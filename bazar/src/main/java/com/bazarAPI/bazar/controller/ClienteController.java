
package com.bazarAPI.bazar.controller;

import com.bazarAPI.bazar.model.Cliente;
import com.bazarAPI.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienteServi;
    
    @PostMapping("/cliente/crear")
    public String saveCliente(@RequestBody Cliente cli){
        
        String nota = clienteServi.saveCliente(cli);
        return nota;
    }
    
    @GetMapping("/cliente/traer/{id}")
    public Cliente getCliente(@PathVariable Long id){
        
        Cliente cli = clienteServi.getCliente(id);
        return cli;
    }
    
    @GetMapping("/cliente/traer")
    public List<Cliente> getCliente(){
    
       List<Cliente> listaCli = clienteServi.getCliente();
       return listaCli;
    }
    
    @DeleteMapping("/cliente/borrar/{id}")
    public String deleteCliente(@PathVariable Long id){
    
        String nota = clienteServi.deleteCliente(id);
        return nota;
    }
    
    @PutMapping("cliente/editar/{id}")
    public Cliente editCliente(@PathVariable Long id,
                               @RequestParam(required= false,name= "id_cliente") Long id_cliente,
                               @RequestParam(required= false,name= "nombre") String nombre,
                               @RequestParam(required= false,name= "apellido") String apellido,
                               @RequestParam(required= false,name= "dni") String dni){
        
        Cliente cli = clienteServi.editCliente(id, id_cliente, nombre, apellido, dni);
        return cli;
    } 
    
    @PutMapping("/cliente/editar")
    public Cliente editCliente(@RequestBody Cliente cli){
    
        clienteServi.editCliente(cli);
        Cliente editado = clienteServi.getCliente(cli.getId_cliente());
        return editado;
    }
    
}
