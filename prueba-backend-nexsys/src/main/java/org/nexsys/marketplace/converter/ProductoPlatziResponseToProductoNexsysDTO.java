package org.nexsys.marketplace.converter;

import org.nexsys.marketplace.entity.ProductoNexsys;
import org.nexsys.marketplace.response.ProductoPlatziResponse;
import org.nexsys.marketplace.response.ProductosResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductoPlatziResponseToProductoNexsysDTO {

    public ProductosResponse convertToProductosResponse(ProductoNexsys producto) {
        ProductosResponse response = new ProductosResponse();
        response.setId(producto.getId());
        response.setName(producto.getName());
        response.setPriceFinal(producto.getBuyPrice());
        response.setDescription(producto.getDescription());
        return response;
    }

    public ProductoNexsys convertToProductoNexsys(ProductoPlatziResponse response) {
        ProductoNexsys producto = new ProductoNexsys();
        producto.setId(response.getId());
        producto.setName(response.getTitle());
        producto.setDescription(response.getDescription());
        producto.setBuyPrice(response.getPrice());
        producto.setCategoryPlatzi(response.getCategory().getId());
        producto.setImageUrl(response.getCategory().getImage());

        return producto;
    }
}
