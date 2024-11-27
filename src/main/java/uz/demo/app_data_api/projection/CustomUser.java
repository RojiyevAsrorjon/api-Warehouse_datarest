package uz.demo.app_data_api.projection;


import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Warehouse;

import java.util.Set;

@Projection(types = CustomUser.class)
public interface CustomUser {
    Integer getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    String getCode();

    String getPassword();

    Boolean getActive();

    Set<Warehouse> getWarehouses();
}
