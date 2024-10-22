
package com.bazarAPI.bazar.service;

import com.bazarAPI.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List<Producto> getProductos();
    
    public String saveProducto(Producto pro);
    
    public String deleteProducto(Long id);
    
    public Producto findProducto(Long id); 
    
    public Producto editProducto(Long idOriginal,Long idnueva, Long codigo_producto, String nombre,
                             String marca, Double costo, Double cantidad_disponible);
    
    
    
}
