package wandasync.products.shared.mapper;

import wandasync.products.domain.model.Department;
import wandasync.products.application.dto.DepartmentDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(source = "status", target = "status")
    DepartmentDTO departmentToDepartmentDTO(Department department);

    @Mapping(source = "status", target = "status")
    Department DepartmentDTOToDepartment(DepartmentDTO DepartmentDTO);

    default String map(Department.DepartmentStatus status) {
        return status != null ? status.name() : null;
    }

    default Department.DepartmentStatus map(String status) {
        return status != null ? Department.DepartmentStatus.valueOf(status) : null;
    }
}
