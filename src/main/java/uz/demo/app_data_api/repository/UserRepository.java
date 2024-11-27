package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.User;
import uz.demo.app_data_api.projection.CustomUser;

@RepositoryRestResource(path = "user", excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<User, Integer> {
}
