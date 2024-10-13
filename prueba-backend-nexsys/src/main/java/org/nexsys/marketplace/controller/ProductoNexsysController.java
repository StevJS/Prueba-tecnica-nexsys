package org.nexsys.marketplace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nexsys.marketplace.request.ProductoNexsysRequest;
import org.nexsys.marketplace.response.ProductosResponse;
import org.nexsys.marketplace.service.IProductoNexsysService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/nexsys/v1")
@RequiredArgsConstructor
@Validated
public class ProductoNexsysController {

    private final IProductoNexsysService productoNexsysService;

    @GetMapping("/products/")
    public ResponseEntity<List<ProductosResponse>> getAllProducts() {
        log.info("Solicitando todos los productos");
        List<ProductosResponse> productos = productoNexsysService.getAllProductoNexsys();
        return productos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(productos);
    }

    @PostMapping("/product/")
    public ResponseEntity<Map<String, Long>> createProductNexsys(@RequestBody ProductoNexsysRequest request) {
        log.info("Creando nuevo producto");
        try {
            ProductoNexsysRequest producto = productoNexsysService.createProductoNexsys(request);

            if (producto != null && producto.getId() != null) {
                Map<String, Long> response = new HashMap<>();
                response.put("pid", producto.getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } catch (Exception e) {
            log.error("Error al crear producto", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}