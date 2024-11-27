package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Output;
import uz.demo.app_data_api.entity.OutputProduct;
import uz.demo.app_data_api.entity.Product;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {

    Integer getId();

    Product getProduct();

    Double getPrice();

    Double getAmount();

    Output getOutput();

}
