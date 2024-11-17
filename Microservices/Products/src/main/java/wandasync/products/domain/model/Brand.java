package wandasync.products.domain.model;

import lombok.*;
import wandasync.products.shared.exception.InvalidBrandStateException;

import javax.validation.constraints.*;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @NotNull(message = "Brand ID is required")
    private Integer brandID;

    @NotBlank(message = "Name cannot be blank")
    @Setter
    private String name;

    @Setter
    private String contact;

    @NotNull(message = "Brand status is required")
    private BrandStatus status;

    public enum BrandStatus {
        ACTIVE,
        INACTIVE
    }

    public void setStatus(String status) throws InvalidBrandStateException {
        try{
            this.status = BrandStatus.valueOf(status.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            zthrow new InvalidBrandStateException("Invalid brand status: " + status);
        }
    }
}
