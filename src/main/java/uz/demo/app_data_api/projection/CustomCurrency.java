package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Currency;

@Projection(types = Currency.class)
public interface CustomCurrency {

    Integer getId();

    String getName();

    String getActive();

}
