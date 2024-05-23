package org.hortense.cvmanager.repositories;
import org.hortense.cvmanager.entities.GenreType;
import org.hortense.cvmanager.entities.IdentiteType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdentityRepository extends CrudRepository<IdentiteType, Long> {

    Optional<IdentiteType> findByNomAndPrenomAndTelAndGenre(
            String nom, String prenom, String tel, GenreType genre
    );
}
