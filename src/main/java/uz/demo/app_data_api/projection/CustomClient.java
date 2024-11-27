package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Client;

@Projection(types = Client.class)
public interface CustomClient {

    Integer getId();

    String getName();

    String getPhoneNumber();
}
