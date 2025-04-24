package co.edu.poli.examen2.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.examen2.model.Producto;
import co.edu.poli.examen2.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Producto producto) {
        Producto existingProducto = productoRepository.findById(producto.getId()).orElse(null);

        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setPrecio(producto.getPrecio());
            return productoRepository.save(existingProducto);
        }
        return null;
    }

    public Producto deleteProducto(String id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        
        if (producto != null) {
            productoRepository.delete(producto);
            return producto;
    }
    return null;
}

}
