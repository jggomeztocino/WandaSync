package wandasync.products.domain.model;

import lombok.*;
import wandasync.products.shared.exception.InvalidParentProductStateException;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParentProduct {

    @NotBlank(message = "Reference cannot be blank")
    private String reference;

    @Setter
    @NotNull(message = "Brand is required")
    private Brand brand;

    @Setter
    @NotBlank(message = "Model cannot be blank")
    private String model;

    @Setter
    private String material;

    @Setter
    private String season;

    @Setter
    @NotNull(message = "Category is required")
    private Category category;

    @Setter
    @NotNull(message = "Department is required")
    private Department department;

    @Setter
    private ProductType productType;

    @NotNull(message = "Parent status is required")
    private ParentStatus parentStatus;

    public enum ParentStatus {
        ACTIVE,
        INACTIVE,
        DISCONTINUED
    }

    public void setParentStatus(String parentStatus) throws InvalidParentProductStateException {
        if (parentStatus == null) {
            throw new InvalidParentProductStateException("Parent status is required");
        }
        if (parentStatus.isEmpty()) {
            throw new InvalidParentProductStateException("Parent status is required");
        }
        if (parentStatus.equals(this.parentStatus.name())) {
            return;
        }
        this.parentStatus = ParentStatus.valueOf(parentStatus.toUpperCase());
    }
}
