package org.nexsys.marketplace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nexsys.marketplace.converter.CategoriaPlatziResponseToCategoriaDTO;
import org.nexsys.marketplace.dto.CategoriaDTO;
import org.nexsys.marketplace.response.CategoriaPlatziResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final RestTemplate restTemplate;
    private final CategoriaPlatziResponseToCategoriaDTO categoriaConverter;

    @Value("${api.categoria.url}")
    private String apiUrl;

    public List<CategoriaDTO> getAllCategories() {
        try {
            CategoriaPlatziResponse[] categoryArray = restTemplate.getForObject(apiUrl, CategoriaPlatziResponse[].class);
            return Optional.ofNullable(categoryArray)
                    .map(List::of)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(this.categoriaConverter::mapToCategoriaDTO)
                    .toList();
        } catch (Exception e) {
            log.error("Error al obtener las categorias del API", e);
            return Collections.emptyList();
        }

    }

}
