package wandasync.products.domain.model;

import lombok.*;
import wandasync.products.shared.exception.InvalidDepartmentStateException;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @NotNull(message = "Department ID is required")
    private Integer departmentID;

    @Setter
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Setter
    private String description;

    @NotNull(message = "Department status is required")
    private DepartmentStatus status;

    public enum DepartmentStatus {
        ACTIVE,
        INACTIVE
    }

    public void setStatus(String status) throws InvalidDepartmentStateException {
        if (status == null) {
            throw new InvalidDepartmentStateException("Department status is required");
        }
        if (status.isEmpty()) {
            throw new InvalidDepartmentStateException("Department status is required");
        }
        if (status.equals(this.status.name())) {
            return;
        }
        this.status = DepartmentStatus.valueOf(status.toUpperCase());
    }
}