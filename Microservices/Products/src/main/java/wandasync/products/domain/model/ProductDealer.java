package wandasync.products.domain.model;

import lombok.*;
import wandasync.products.shared.exception.InvalidProductDealerStateException;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDealer {

    @NotNull(message = "Dealer is required")
    private Dealer dealer;

    @NotNull(message = "Product is required")
    private Product product;

    @NotNull(message = "Unit stock is required")
    @Min(value = 0, message = "Unit stock cannot be negative")
    private Integer unitStock;

    @NotNull(message = "Unit price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Unit price must be greater than zero")
    private BigDecimal unitPrice;

    @NotNull(message = "Status is required")
    private ProductDealerStatus status;

    public enum ProductDealerStatus {
        ACTIVE,
        INACTIVE
    }

    public void setStatus(String status) throws InvalidProductDealerStateException {
        if (status == null) {
            throw new InvalidProductDealerStateException("Status is required");
        }
        if (status.isEmpty()) {
            throw new InvalidProductDealerStateException("Status is required");
        }
        if (status.equals(this.status.name())) {
            return;
        }
        this.status = ProductDealerStatus.valueOf(status.toUpperCase());
    }
}
