package wandasync.products.domain.model;

import lombok.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @NotNull(message = "Category ID is required")
    private Integer categoryID;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;

    private Category parentCategory;

    @NotNull(message = "Category status is required")
    private CategoryStatus status;

    public enum CategoryStatus {
        ACTIVE,
        INACTIVE
    }
}
