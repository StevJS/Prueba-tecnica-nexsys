package org.nexsys.marketplace.service;

import org.nexsys.marketplace.request.ProductoNexsysRequest;
import org.nexsys.marketplace.response.ProductosResponse;

import java.util.List;

public interface IProductoNexsysService {
    List<ProductosResponse> getAllProductoNexsys();

    ProductoNexsysRequest createProductoNexsys(ProductoNexsysRequest request);
}
