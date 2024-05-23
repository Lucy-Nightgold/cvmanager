package org.hortense.cvmanager.repositories;

import org.hortense.cvmanager.entities.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Cv, Long> {

    Cv findById(long id);
}
