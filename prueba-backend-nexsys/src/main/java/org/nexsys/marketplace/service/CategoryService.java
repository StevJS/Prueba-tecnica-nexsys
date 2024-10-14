package org.nexsys.marketplace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nexsys.marketplace.converter.CategoriaPlatziResponseToCategoriaDTO;
import org.nexsys.marketplace.dto.CategoriaDTO;
import org.nexsys.marketplace.helper.PlatziRestConsumerHelper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final PlatziRestConsumerHelper helper;
    private final CategoriaPlatziResponseToCategoriaDTO categoriaConverter;

    public List<CategoriaDTO> getAllCategories() {
        try {
            return helper.getCategoriasFromPlatzi().stream()
                    .map(this.categoriaConverter::mapToCategoriaDTO)
                    .toList();
        } catch (Exception e) {
            log.error("Error al obtener las categorias del API", e);
            return Collections.emptyList();
        }
    }
}