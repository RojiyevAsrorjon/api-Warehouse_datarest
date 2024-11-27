package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.InputProduct;
import uz.demo.app_data_api.projection.CustomInputProduct;

@RepositoryRestResource(path = "inputproduct", excerptProjection = CustomInputProduct.class)
public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {
}
