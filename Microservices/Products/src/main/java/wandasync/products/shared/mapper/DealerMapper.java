package wandasync.products.shared.mapper;

import wandasync.products.domain.model.Dealer;
import wandasync.products.application.dto.DealerDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DealerMapper {

    @Mapping(source = "status", target = "status")
    DealerDTO dealerToDealerDTO(Dealer dealer);

    @Mapping(source = "status", target = "status")
    Dealer DealerDTOToDealer(DealerDTO DealerDTO);

    default String map(Dealer.DealerStatus status) {
        return status != null ? status.name() : null;
    }

    default Dealer.DealerStatus map(String status) {
        return status != null ? Dealer.DealerStatus.valueOf(status) : null;
    }
}