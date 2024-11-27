package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.OutputProduct;
import uz.demo.app_data_api.projection.CustomOutputProduct;

@RepositoryRestResource(path = "outputproduct", excerptProjection = CustomOutputProduct.class)
public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {
}
