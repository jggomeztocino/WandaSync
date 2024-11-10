package wandasync.products.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParentProductDTO {

    private String reference;
    private Integer brandID;
    private String model;
    private String material;
    private String season;
    private Integer categoryID;
    private Integer departmentID;
    private String productType;
    private String parentStatus;

}
