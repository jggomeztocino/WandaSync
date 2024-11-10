package wandasync.products.domain.model;

import lombok.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @NotNull(message = "Department ID is required")
    private Integer departmentID;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;

    @NotNull(message = "Department status is required")
    private DepartmentStatus status;

    public enum DepartmentStatus {
        ACTIVE,
        INACTIVE
    }
}