package wandasync.products.shared.mapper;

import wandasync.products.domain.model.Product;
import wandasync.products.application.dto.ProductDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ParentProductMapper.class})
public interface ProductMapper {

    @Mapping(source = "parentProduct.reference", target = "reference")
    @Mapping(source = "status", target = "status")
    ProductDTO productToProductDTO(Product product);

    @Mapping(source = "reference", target = "parentProduct.reference")
    @Mapping(source = "status", target = "status")
    Product ProductDTOToProduct(ProductDTO ProductDTO);

    default String map(Product.ProductStatus status) {
        return status != null ? status.name() : null;
    }

    default Product.ProductStatus map(String status) {
        return status != null ? Product.ProductStatus.valueOf(status) : null;
    }
}
