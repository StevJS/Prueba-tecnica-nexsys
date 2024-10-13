package org.nexsys.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "producto_nexsys")
@Data
public class ProductoNexsys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "El precio de compra es obligatorio")
    @Min(value = 0, message = "El precio de compra no puede ser negativo")
    @Column(name = "buy_price", nullable = false)
    private Long buyPrice;

    @NotNull(message = "La categoria no puede ser null")
    @Min(value = 0, message = "El precio de compra no puede ser negativo")
    @Column(name = "category_platzi", nullable = false)
    private Long categoryPlatzi;

    @Size(max = 255, message = "La URL de la imagen no puede tener más de 255 caracteres")
    @Column(name = "image")
    private String imageUrl;
}