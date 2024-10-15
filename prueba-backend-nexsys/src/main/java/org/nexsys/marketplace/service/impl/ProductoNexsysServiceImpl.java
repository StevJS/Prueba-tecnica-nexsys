package org.nexsys.marketplace.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nexsys.marketplace.mapper.ProductoNexsysMapper;
import org.nexsys.marketplace.mapper.ProductoPlatziResponseToProductoNexsysDTO;
import org.nexsys.marketplace.entity.ProductoNexsys;
import org.nexsys.marketplace.exception.ProductoCreationException;
import org.nexsys.marketplace.helper.PlatziRestConsumerHelper;
import org.nexsys.marketplace.request.ProductoNexsysRequest;
import org.nexsys.marketplace.response.ProductoPlatziResponse;
import org.nexsys.marketplace.repository.IProductoRepository;
import org.nexsys.marketplace.response.ProductosResponse;
import org.nexsys.marketplace.service.IProductoNexsysService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductoNexsysServiceImpl implements IProductoNexsysService {

    private final IProductoRepository productoRepository;
    private final RestTemplate restTemplate;
    private final ProductoPlatziResponseToProductoNexsysDTO productoConverter;
    private final ProductoNexsysMapper productoNexsysMapper;
    private final PlatziRestConsumerHelper helper;

    @Override
    @Transactional
    public List<ProductosResponse> getAllProductoNexsys() {
        try {
            List<ProductoPlatziResponse> products = helper.getProductosFromPlatzi();
            saveDataPlatziResponse(products.toArray(new ProductoPlatziResponse[0]));

            return productoRepository.findAll().stream()
                    .map(productoConverter::convertToProductosResponse)
                    .toList();
        } catch (Exception e) {
            log.error("Error al obtener productos de la base de datos", e);
            return Collections.emptyList();
        }
    }

    @Transactional
    void saveDataPlatziResponse(ProductoPlatziResponse[] productsArray) {
        if (productsArray != null && productsArray.length > 0) {
            for (ProductoPlatziResponse platziProduct : productsArray) {
                Optional<ProductoNexsys> existingProduct = productoRepository.findById(platziProduct.getId());

                if (existingProduct.isEmpty()) {
                    ProductoNexsys producto = productoConverter.convertToProductoNexsys(platziProduct);
                    productoRepository.save(producto);
                } else {
                    log.info("El producto con ID {} ya existe y no será duplicado", platziProduct.getId());
                }
            }
        }
    }


    @Override
    @Transactional
    public ProductoNexsysRequest createProductoNexsys(ProductoNexsysRequest request) {
        try {
            log.info("Iniciando creación de producto: {}", request);
            ProductoNexsys producto = productoNexsysMapper.requestToEntity(request);
            ProductoNexsys savedProducto = productoRepository.save(producto);
            log.info("Producto creado exitosamente con ID: {}", savedProducto.getId());
            return productoNexsysMapper.entityToRequest(savedProducto);
        } catch (Exception e) {
            log.error("Error al crear producto", e);
            throw new ProductoCreationException("No se pudo crear el producto", e);
        }
    }
}