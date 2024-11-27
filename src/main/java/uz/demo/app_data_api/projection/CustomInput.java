package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Currency;
import uz.demo.app_data_api.entity.Input;
import uz.demo.app_data_api.entity.Supplier;
import uz.demo.app_data_api.entity.Warehouse;

import java.util.Date;

@Projection(types = Input.class)
public interface CustomInput {

    Integer getId();

    Date getDate();

    Warehouse getWarehouse();

    Supplier getSupplier();

    Currency getCurrency();

    String getFactoryName();

    String getCode();
}
