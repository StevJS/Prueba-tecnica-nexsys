package org.nexsys.marketplace.mapper;

import org.nexsys.marketplace.entity.ProductoNexsys;
import org.nexsys.marketplace.request.ProductoNexsysRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductoNexsysMapper {

    public ProductoNexsys requestToEntity(ProductoNexsysRequest request) {
        if (request == null) {
            return null;
        }

        ProductoNexsys entity = new ProductoNexsys();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setBuyPrice(request.getPriceFinal());
        entity.setCategoryPlatzi(request.getCategoryId());
        entity.setImageUrl(request.getImageUrl());

        return entity;
    }

    public ProductoNexsysRequest entityToRequest(ProductoNexsys entity) {
        if (entity == null) {
            return null;
        }

        ProductoNexsysRequest request = new ProductoNexsysRequest();
        request.setId(entity.getId());
        request.setName(entity.getName());
        request.setDescription(entity.getDescription());
        request.setPriceFinal(entity.getBuyPrice());
        request.setCategoryId(entity.getCategoryPlatzi());
        request.setImageUrl(entity.getImageUrl());

        return request;
    }
}