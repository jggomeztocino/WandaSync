package wandasync.products.domain.model;

import lombok.*;
import wandasync.products.shared.exception.InvalidDealerStateException;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dealer {

    @NotNull(message = "Dealer ID is required")
    private Integer dealerID;

    @Setter
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Setter
    private String description;

    @Setter
    private String contact;

    @NotNull(message = "Dealer status is required")
    private DealerStatus status;

    public enum DealerStatus {
        ACTIVE,
        INACTIVE
    }

    public void setStatus(String status) throws InvalidDealerStateException {
        if (status == null) {
            throw new InvalidDealerStateException("Dealer status is required");
        }
        if (status.isEmpty()) {
            throw new InvalidDealerStateException("Dealer status is required");
        }
        if (status.equals(this.status.name())) {
            return;
        }
        this.status = DealerStatus.valueOf(status.toUpperCase());
    }
}