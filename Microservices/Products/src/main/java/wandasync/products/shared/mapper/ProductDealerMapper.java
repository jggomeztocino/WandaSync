package wandasync.products.shared.mapper;

import wandasync.products.domain.model.ProductDealer;
import wandasync.products.application.dto.ProductDealerDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {DealerMapper.class, ProductMapper.class})
public interface ProductDealerMapper {

    @Mapping(source = "dealer.dealerID", target = "dealerID")
    @Mapping(source = "product.ean", target = "ean")
    @Mapping(source = "status", target = "status")
    ProductDealerDTO productDealerToProductDealerDTO(ProductDealer productDealer);

    @Mapping(source = "dealerID", target = "dealer.dealerID")
    @Mapping(source = "ean", target = "product.ean")
    @Mapping(source = "status", target = "status")
    ProductDealer ProductDealerDTOToProductDealer(ProductDealerDTO ProductDealerDTO);

    default String map(ProductDealer.ProductDealerStatus status) {
        return status != null ? status.name() : null;
    }

    default ProductDealer.ProductDealerStatus map(String status) {
        return status != null ? ProductDealer.ProductDealerStatus.valueOf(status) : null;
    }
}
