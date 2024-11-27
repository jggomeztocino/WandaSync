package wandasync.products.domain.model;

import lombok.*;
import wandasync.products.shared.exception.InvalidCategoryStateException;

import javax.validation.constraints.*;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @NotNull(message = "Category ID is required")
    private Integer categoryID;

    @NotBlank(message = "Name cannot be blank")
    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Category parentCategory;

    @NotNull(message = "Category status is required")
    private CategoryStatus status;

    public enum CategoryStatus {
        ACTIVE,
        INACTIVE
    }

    public void setStatus(String status) throws InvalidCategoryStateException {
        if (status == null) {
            throw new InvalidCategoryStateException("Category status is required");
        }
        if (status.isEmpty()) {
            throw new InvalidCategoryStateException("Category status is required");
        }
        if (status.equals(this.status.name())) {
            return;
        }
        this.status = CategoryStatus.valueOf(status.toUpperCase());
    }
}
