package org.nexsys.marketplace.request;

import lombok.Data;

@Data
public class ProductoNexsysRequest {
    private Long id;
    private String name;
    private String description;
    private Long priceFinal;
    private Long categoryId;
    private String imageUrl;
}
