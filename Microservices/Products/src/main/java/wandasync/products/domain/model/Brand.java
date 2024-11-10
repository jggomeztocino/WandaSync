package wandasync.products.domain.model;

import lombok.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @NotNull(message = "Brand ID is required")
    private Integer brandID;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String contact;

    @NotNull(message = "Brand status is required")
    private BrandStatus status;

    public enum BrandStatus {
        ACTIVE,
        INACTIVE
    }
}
