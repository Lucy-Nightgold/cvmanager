package org.hortense.cvmanager.repositories;

import org.hortense.cvmanager.entities.Cv24Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cv24TypeRepository extends CrudRepository<Cv24Type, Long> {
}
