package wandasync.products.domain.model;

import lombok.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dealer {

    @NotNull(message = "Dealer ID is required")
    private Integer dealerID;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;

    private String contact;

    @NotNull(message = "Dealer status is required")
    private DealerStatus status;

    public enum DealerStatus {
        ACTIVE,
        INACTIVE
    }
}