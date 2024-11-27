package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.Client;
import uz.demo.app_data_api.projection.CustomClient;

@RepositoryRestResource(path = "client", excerptProjection = CustomClient.class)
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
