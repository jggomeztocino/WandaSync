package wandasync.products.domain.model;

import lombok.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotNull(message = "EAN is required")
    @Digits(integer = 13, fraction = 0, message = "EAN must be a 13-digit number")
    private Long ean;

    @NotBlank(message = "Size cannot be blank")
    private String size;

    @NotBlank(message = "Color cannot be blank")
    private String color;

    @NotNull(message = "Retail price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Retail price must be greater than zero")
    private BigDecimal retailPrice;

    @NotNull(message = "Parent product is required")
    private ParentProduct parentProduct;

    @NotNull(message = "Product status is required")
    private ProductStatus status;

    private Integer stock;
    private BigDecimal dealerPrice;

    public enum ProductStatus {
        AVAILABLE,
        OUT_OF_STOCK,
        DISCONTINUED
    }
}
