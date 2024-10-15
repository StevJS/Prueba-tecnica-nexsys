package org.nexsys.marketplace.mapper;

import org.nexsys.marketplace.dto.CategoriaDTO;
import org.nexsys.marketplace.response.CategoriaPlatziResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoriaPlatziResponseToCategoriaDTO {

    public CategoriaDTO mapToCategoriaDTO(CategoriaPlatziResponse category) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setImage(category.getImage());

        return dto;
    }
}
