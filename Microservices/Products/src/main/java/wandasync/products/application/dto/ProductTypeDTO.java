package wandasync.products.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeDTO {

    private Integer productTypeID;
    private String name;
    private String status;

}
