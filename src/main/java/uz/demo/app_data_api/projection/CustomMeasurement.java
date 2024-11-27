package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Measurement;

@Projection(types = Measurement.class)
public interface CustomMeasurement {

    Integer getId();
    String getName();
    Boolean getActive();
}
