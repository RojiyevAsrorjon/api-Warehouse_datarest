package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Supplier;

@Projection(types = Supplier.class)
public interface CustomSupplier {

    Integer getId();

    String getName();

    Boolean getActive();

    String getPhoneNumber();
}
