package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.Supplier;
import uz.demo.app_data_api.projection.CustomSupplier;

@RepositoryRestResource(path = "supplier", excerptProjection = CustomSupplier.class)
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
