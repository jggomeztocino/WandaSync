package wandasync.products.shared.mapper;

import wandasync.products.domain.model.ParentProduct;
import wandasync.products.application.dto.ParentProductDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {BrandMapper.class, CategoryMapper.class, DepartmentMapper.class})
public interface ParentProductMapper {

    @Mapping(source = "brand.brandID", target = "brandID")
    @Mapping(source = "category.categoryID", target = "categoryID")
    @Mapping(source = "department.departmentID", target = "departmentID")
    @Mapping(source = "parentStatus", target = "parentStatus")
    ParentProductDTO parentProductToParentProductDTO(ParentProduct parentProduct);

    @Mapping(source = "brandID", target = "brand.brandID")
    @Mapping(source = "categoryID", target = "category.categoryID")
    @Mapping(source = "departmentID", target = "department.departmentID")
    @Mapping(source = "parentStatus", target = "parentStatus")
    ParentProduct ParentProductDTOToParentProduct(ParentProductDTO ParentProductDTO);

    default String map(ParentProduct.ParentStatus status) {
        return status != null ? status.name() : null;
    }

    default ParentProduct.ParentStatus map(String status) {
        return status != null ? ParentProduct.ParentStatus.valueOf(status) : null;
    }
}
