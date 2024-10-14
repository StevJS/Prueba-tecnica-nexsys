package org.nexsys.marketplace.helper;

import org.nexsys.marketplace.response.ProductoPlatziResponse;
import org.nexsys.marketplace.response.CategoriaPlatziResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class PlatziRestConsumerHelper {

    private final RestTemplate restTemplate;
    private final String productosApiUrl;
    private final String categoriasApiUrl;

    public PlatziRestConsumerHelper(
            RestTemplate restTemplate,
            @Value("${api.productos.url}") String productosApiUrl,
            @Value("${api.categoria.url}") String categoriasApiUrl) {
        this.restTemplate = restTemplate;
        this.productosApiUrl = productosApiUrl;
        this.categoriasApiUrl = categoriasApiUrl;
    }

    public List<ProductoPlatziResponse> getProductosFromPlatzi() {
        ProductoPlatziResponse[] productsArray = restTemplate.getForObject(productosApiUrl, ProductoPlatziResponse[].class);
        return Arrays.asList(productsArray);
    }

    public List<CategoriaPlatziResponse> getCategoriasFromPlatzi() {
        CategoriaPlatziResponse[] categoryArray = restTemplate.getForObject(categoriasApiUrl, CategoriaPlatziResponse[].class);
        return Optional.ofNullable(categoryArray)
                .map(Arrays::asList)
                .orElse(List.of());
    }
}