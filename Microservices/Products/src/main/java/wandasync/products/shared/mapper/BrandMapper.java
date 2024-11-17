package wandasync.products.shared.mapper;

import wandasync.products.domain.model.Brand;
import wandasync.products.application.dto.BrandDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    @Mapping(source = "status", target = "status")
    BrandDTO brandToBrandDto(Brand brand);

    @Mapping(source = "status", target = "status")
    Brand brandDtoToBrand(BrandDTO brandDto);

    default String map(Brand.BrandStatus status) {
        return status != null ? status.name() : null;
    }

    default Brand.BrandStatus map(String status) {
        return status != null ? Brand.BrandStatus.valueOf(status) : null;
    }
}
