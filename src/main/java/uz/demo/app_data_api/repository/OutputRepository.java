package uz.demo.app_data_api.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.demo.app_data_api.projection.CustomOutput;

@RepositoryRestResource(path = "output", excerptProjection = CustomOutput.class)
public interface OutputRepository {
}
