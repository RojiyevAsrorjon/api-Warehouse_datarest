package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Warehouse;

@Projection(types = Warehouse.class)
public interface CustomWarehouse {

    Integer getId();
    String getName();
    Boolean getActive();
}
