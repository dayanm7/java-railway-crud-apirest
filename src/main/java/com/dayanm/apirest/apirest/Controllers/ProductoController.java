package com.dayanm.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayanm.apirest.apirest.Entities.Producto;
import com.dayanm.apirest.apirest.Repositories.ProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 


//Aqui se crean las direcciones y urls para el consumo de peticiones de el cliente

@RestController
@RequestMapping("/productos")
public class ProductoController {

    //Crea una injeccion de una instacion del repositorio mencionado(ProductoRepository)
    @Autowired
    //esta sera la conexion con la bd
    private ProductoRepository productoRepository;

    //GetALL muestra todos los datos
    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    //get individual
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el id indicado: "+id));
    }

    //Post
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        //aqui se ocupara el mismo formato de atributos creados en la clase producto a exepcion de id que es creciente automaticamente
        return productoRepository.save(producto);
    }

    //Put
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto){
         Producto productoPut =  productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " +id));

        productoPut.setNombre(producto.getNombre());
        productoPut.setPrecio(producto.getPrecio());
        return productoRepository.save(productoPut);
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        Producto productoPut =  productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " +id));

        productoRepository.delete(productoPut);
        return "El producto con el ID: " +id + " fue elimilnado con exito";
    }
}
