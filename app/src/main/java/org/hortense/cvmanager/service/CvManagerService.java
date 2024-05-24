package org.hortense.cvmanager.service;

import org.hortense.cvmanager.entities.Cv24Type;
import org.hortense.cvmanager.entities.IdentiteType;
import org.hortense.cvmanager.repositories.Cv24TypeRepository;
import org.hortense.cvmanager.repositories.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CvManagerService {

    @Autowired
    private Cv24TypeRepository cv24TypeRepository;

    @Autowired
    private IdentityRepository identityRepository;



    public String retrieveResumes() {
        Iterable<Cv24Type> cvs = cv24TypeRepository.findAll();
        return "test";
    }

    public Cv24Type addCV(Cv24Type cv) {
        return cv24TypeRepository.save(cv);
    }

    public boolean cvAlreadyExists(Cv24Type cv) {
        Optional<IdentiteType> identity = identityRepository.findByNomAndPrenomAndTelAndGenre(
                cv.getIdentite().getNom(),
                cv.getIdentite().getPrenom(),
                cv.getIdentite().getTel(),
                cv.getIdentite().getGenre()
        );
        return identity.isPresent();
    }

    public Optional<Cv24Type> findCvById(Long id) {
        return cv24TypeRepository.findById(id);
    }

    public void deleteCv(Cv24Type cv) {
        cv24TypeRepository.delete(cv);
    }
}
