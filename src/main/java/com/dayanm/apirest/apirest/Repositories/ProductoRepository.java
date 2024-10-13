package com.dayanm.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayanm.apirest.apirest.Entities.Producto;

//A JpaRepository se le tiene que indicar con que entidad(Producto) y tipo de identificador(id) estara trabajando
public interface ProductoRepository  extends JpaRepository<Producto,Long>{

    

}
