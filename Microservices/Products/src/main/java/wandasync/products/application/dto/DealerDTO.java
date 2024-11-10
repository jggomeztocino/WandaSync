package wandasync.products.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealerDTO {

    private Integer dealerID;
    private String name;
    private String description;
    private String contact;
    private String status;

}
