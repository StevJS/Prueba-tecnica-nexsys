package org.nexsys.marketplace.response;

import lombok.Data;
import lombok.ToString;
import org.nexsys.marketplace.dto.CategoriaDTO;

@Data
@ToString
public class ProductoPlatziResponse {
    private Long id;
    private String title;
    private Long price;
    private String description;
    private String[] images;
    private CategoriaDTO category;
}
