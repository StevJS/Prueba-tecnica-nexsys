package org.nexsys.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoNexsysDTO {
    private Long id;
    private String name;
    private Long buyPrice;
    private CategoriaDTO categoryPlatzi;
    private String[] imageUrl;
}
