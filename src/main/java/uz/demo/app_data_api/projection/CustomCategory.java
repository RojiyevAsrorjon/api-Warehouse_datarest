package uz.demo.app_data_api.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.demo.app_data_api.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();
    String getName();
    Category getCategory();
    Boolean getActive();
}
