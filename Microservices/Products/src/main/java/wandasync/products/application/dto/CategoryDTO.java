package wandasync.products.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Integer categoryID;
    private String name;
    private String description;
    private Integer parentCategoryID;
    private String status;

}
