package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.demo.app_data_api.entity.Input;
import uz.demo.app_data_api.projection.CustomInput;

@RepositoryRestResource(path = "input", excerptProjection = CustomInput.class)
public interface InputRepository extends JpaRepository<Input, Integer> {
}
