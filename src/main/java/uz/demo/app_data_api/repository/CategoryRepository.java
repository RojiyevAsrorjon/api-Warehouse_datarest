package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.Category;
import uz.demo.app_data_api.projection.CustomCategory;

@RepositoryRestResource(path = "category", excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
