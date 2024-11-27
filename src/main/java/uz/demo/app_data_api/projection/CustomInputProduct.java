package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Input;
import uz.demo.app_data_api.entity.InputProduct;
import uz.demo.app_data_api.entity.Product;

import java.util.Date;

@Projection(types = InputProduct.class)
public interface CustomInputProduct {

    Integer getId();

    Product getProduct();

    Double getAmount();

    Double getPrice();

    Date getExpiryDate();

    Input getInput();
}
