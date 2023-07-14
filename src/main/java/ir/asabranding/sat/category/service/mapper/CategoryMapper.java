package ir.asabranding.sat.category.service.mapper;

import ir.asabranding.sat.category.domain.Category;
import ir.asabranding.sat.category.service.dto.CategoryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
    @Mapping(target = "parrent", source = "parrent", qualifiedByName = "categoryId")
    CategoryDTO toDto(Category s);

    @Named("categoryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CategoryDTO toDtoCategoryId(Category category);
}
