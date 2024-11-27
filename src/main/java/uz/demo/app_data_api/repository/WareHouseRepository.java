package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.Warehouse;
import uz.demo.app_data_api.projection.CustomWarehouse;

@RepositoryRestResource(path = "warehouse", excerptProjection = CustomWarehouse.class)
public interface WareHouseRepository extends JpaRepository<Warehouse, Integer> {
}
