package wandasync.products.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wandasync.products.shared.exception.InvalidProductTypeStateException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {

    @NotNull(message = "ProductType ID is required")
    private Integer productTypeID;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "ProductType status is required")
    private ProductTypeStatus status;

    public enum ProductTypeStatus {
        ACTIVE,
        INACTIVE
    }

    public void setStatus(String status) throws InvalidProductTypeStateException {
        if (status == null) {
            throw new InvalidProductTypeStateException("ProductType status is required");
        }
        if (status.isEmpty()) {
            throw new InvalidProductTypeStateException("ProductType status is required");
        }
        if (status.equals(this.status.name())) {
            return;
        }
        this.status = ProductTypeStatus.valueOf(status.toUpperCase());
    }
}

