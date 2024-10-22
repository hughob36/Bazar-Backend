
package com.bazarAPI.bazar.repository;

import com.bazarAPI.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductoRepository extends JpaRepository <Producto,Long>{
    
}
