package br.com.state.repository;

import br.com.state.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

  Optional<City> findByName(final String name);

  Boolean existsByStateId(final Long stateId);

  List<City> findAllByStateId(final Long stateId);

  Boolean existsByName(final String name);

}
