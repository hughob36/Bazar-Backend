
package com.bazarAPI.bazar.service;

import com.bazarAPI.bazar.model.Producto;
import com.bazarAPI.bazar.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepo;    
    
    @Override
    public List<Producto> getProductos() {
        
        List<Producto> productos = productoRepo.findAll();        
        return productos;
    }

    @Override
    public String saveProducto(Producto pro) {
        
        productoRepo.save(pro);
        return "Guardaste un producto";        
    }

    @Override
    public String deleteProducto(Long id) {
        
        productoRepo.deleteById(id);
        return "Borraste un producto";
    }

    @Override
    public Producto findProducto(Long id) {
                
        Producto pro = productoRepo.findById(id).orElse(null);
        return pro;
    }

    @Override
    public Producto editProducto(Long idOriginal, Long idnueva,
                            Long codigo_producto, 
                            String nombre,
                            String marca, 
                            Double costo, 
                            Double cantidad_disponible) {
                
        Producto pro = productoRepo.findById(idOriginal).orElse(null);
        
        pro.setId(idnueva);
        pro.setCodigo_producto(codigo_producto);
        pro.setNombre(nombre);
        pro.setMarca(marca);
        pro.setCosto(costo);
        pro.setCantidad_disponible(cantidad_disponible);
        
        productoRepo.save(pro);
        
        return pro;        
    }    
    
}
