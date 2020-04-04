package br.com.estado.repository;

import br.com.estado.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
