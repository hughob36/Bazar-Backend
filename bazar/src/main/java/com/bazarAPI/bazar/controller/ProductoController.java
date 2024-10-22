
package com.bazarAPI.bazar.controller;

import com.bazarAPI.bazar.model.Producto;
import com.bazarAPI.bazar.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    private IProductoService productoServi;
    
    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        
        String nota = productoServi.saveProducto(producto);
        return nota;
    }
    
    @GetMapping("/productos/traer")
    public List<Producto> traerProducto(){
        
        List<Producto> pro = productoServi.getProductos();        
       return pro;    
    }
    
    @GetMapping("/productos/Id/{id}")
    public Producto unProducto(@PathVariable Long id){
    
        Producto pro = productoServi.findProducto(id);
        return pro;
    }
    
    @DeleteMapping("productos/borrar/{id}")
    public String borrarProducto(@PathVariable Long id){
    
        String nota = productoServi.deleteProducto(id);
        return nota;
    }
    
    @PutMapping("/productos/editar/{idOriginal}")
    public Producto editarProducto(@PathVariable Long idOriginal,
                                   @RequestParam(required = false, name = "idnueva") Long idNueva, 
                                   @RequestParam(required = false, name = "codigo_producto") Long codigo_productoNueva,
                                   @RequestParam(required = false, name = "nombre") String nombreNuevo,
                                   @RequestParam(required = false, name = "marca") String marcaNuevo, 
                                   @RequestParam(required = false, name = "costo") Double costoNuevo,
                                   @RequestParam(required = false, name = "cantidad_disponible") Double cantidad_disponibleNuevo){
    
        
        productoServi.editProducto(idOriginal, idNueva, codigo_productoNueva, nombreNuevo, marcaNuevo, costoNuevo, cantidad_disponibleNuevo);
        
        Producto pro = productoServi.findProducto(idNueva);
        return pro;
    }
}
