package wandasync.products.shared.mapper;

import wandasync.products.domain.model.Category;
import wandasync.products.application.dto.CategoryDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "parentCategory.categoryID", target = "parentCategoryID")
    @Mapping(source = "status", target = "status")
    CategoryDTO categoryToCategoryDTO(Category category);

    @Mapping(source = "parentCategoryID", target = "parentCategory.categoryID")
    @Mapping(source = "status", target = "status")
    Category CategoryDTOToCategory(CategoryDTO CategoryDTO);

    default String map(Category.CategoryStatus status) {
        return status != null ? status.name() : null;
    }

    default Category.CategoryStatus map(String status) {
        return status != null ? Category.CategoryStatus.valueOf(status) : null;
    }
}
