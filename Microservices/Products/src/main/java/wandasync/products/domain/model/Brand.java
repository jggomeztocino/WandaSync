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
            if (status == null) {
                throw new InvalidBrandStateException("Brand status is required");
            }
            if (status.isEmpty()) {
                throw new InvalidBrandStateException("Brand status is required");
            }
            if (status.equals(this.status.name())) {
                return;
            }
            this.status = BrandStatus.valueOf(status.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            throw new InvalidBrandStateException("Invalid brand status: " + status);
        }
    }
}
