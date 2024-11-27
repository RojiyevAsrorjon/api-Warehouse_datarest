package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Client;
import uz.demo.app_data_api.entity.Currency;
import uz.demo.app_data_api.entity.Output;
import uz.demo.app_data_api.entity.Warehouse;

import java.util.Date;

@Projection(types = Output.class)
public interface CustomOutput {

    Integer getId();

    Date getDate();

    Warehouse getWareHouse();

    Currency getCurrency();

    String getFactoryNumber();

    String getCode();

    Client getClient();
}
