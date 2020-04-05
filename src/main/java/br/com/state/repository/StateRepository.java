package br.com.state.repository;

import br.com.state.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface StateRepository extends JpaRepository<State, Long> {

  Boolean existsByName(String name);

}
