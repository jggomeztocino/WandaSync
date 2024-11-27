package wandasync.products.application.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDealerDTO {

    private Integer dealerID;
    private Long ean;
    private Integer unitStock;
    private BigDecimal unitPrice;
    private String status;

}
