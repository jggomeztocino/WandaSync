package wandasync.products.domain.model;

import lombok.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParentProduct {

    @NotBlank(message = "Reference cannot be blank")
    private String reference;

    @NotNull(message = "Brand is required")
    private Brand brand;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    private String material;

    private String season;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Department is required")
    private Department department;

    private ProductType productType;

    @NotNull(message = "Parent status is required")
    private ParentStatus parentStatus;

    public enum ParentStatus {
        ACTIVE,
        INACTIVE,
        DISCONTINUED
    }
}
