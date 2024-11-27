package wandasync.products.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Integer departmentID;
    private String name;
    private String description;
    private String status;

}
