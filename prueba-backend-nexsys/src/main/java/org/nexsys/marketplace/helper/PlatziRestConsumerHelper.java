package org.nexsys.marketplace.helper;

import org.nexsys.marketplace.dto.ProductoNexsysDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class PlatziRestConsumerHelper {

    RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.escuelajs.co/api/v1/products";

    public List<ProductoNexsysDTO> getProducts() {
        ProductoNexsysDTO[] productsArray = restTemplate.getForObject(API_URL, ProductoNexsysDTO[].class);
        return Arrays.asList(productsArray);
    }

}
