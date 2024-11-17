package wandasync.products.shared.mapper;

import wandasync.products.domain.model.ProductType;
import wandasync.products.application.dto.ProductTypeDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {

    ProductTypeMapper INSTANCE = Mappers.getMapper(ProductTypeMapper.class);

    ProductTypeDTO productTypeToProductTypeDTO(ProductType productType);

    ProductType ProductTypeDTOToProductType(ProductTypeDTO ProductTypeDTO);

    default String map(ProductType.ProductTypeStatus status) {
        return status != null ? status.name() : null;
    }

    default ProductType.ProductTypeStatus map(String status) {
        return status != null ? ProductType.ProductTypeStatus.valueOf(status) : null;
    }
}
