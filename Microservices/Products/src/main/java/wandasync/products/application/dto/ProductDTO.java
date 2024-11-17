package wandasync.products.application.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long ean;
    private String size;
    private String color;
    private BigDecimal retailPrice;
    private String reference;
    private String status;
    private Integer stock;
    private BigDecimal dealerPrice;

}
