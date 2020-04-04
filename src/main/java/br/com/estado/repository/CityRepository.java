package br.com.estado.repository;

import br.com.estado.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
