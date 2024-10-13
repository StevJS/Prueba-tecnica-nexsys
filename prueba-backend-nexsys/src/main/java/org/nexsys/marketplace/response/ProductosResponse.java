package org.nexsys.marketplace.response;

import lombok.Data;

@Data
public class ProductosResponse {
    private Long id;
    private String name;
    private Long priceFinal;
    private String description;
}
