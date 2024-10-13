package org.nexsys.marketplace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nexsys.marketplace.dto.CategoriaDTO;
import org.nexsys.marketplace.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("nexsys/v1/category")
@RequiredArgsConstructor
@Validated
public class CategoriaController {

    private final CategoryService categoriaService;

    @GetMapping("/")
    public ResponseEntity<List<CategoriaDTO>> getCategory() {
        log.info("Solicitando la categoria");
        List<CategoriaDTO> categoria = categoriaService.getAllCategories();
        return categoria.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categoria);
    }
}
