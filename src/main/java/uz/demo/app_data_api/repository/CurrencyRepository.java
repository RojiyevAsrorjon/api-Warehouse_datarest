package uz.demo.app_data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.demo.app_data_api.entity.Currency;
import uz.demo.app_data_api.projection.CustomCurrency;

@RepositoryRestResource(path = "currency", excerptProjection = CustomCurrency.class)
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
