package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.CondidatRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondidatService {

    private final CondidatRepo condidatRepo;

    @Autowired
    public CondidatService(CondidatRepo condidatRepo) {
        this.condidatRepo = condidatRepo;
    }

    public Condidat getCondidatById(Long id) {
        return condidatRepo.findById(id).orElseThrow(() -> new IllegalStateException("Condidat with id " + id + " does not exist"));
    }

    public void validateCondidat(Long id) {
        Condidat condidat = condidatRepo.findById(id).orElseThrow(() -> new IllegalStateException("Condidat with id " + id + " does not exist"));
        condidat.setValidated(true);
        condidatRepo.save(condidat);
    }

    public void unvalidateCondidat(Long id) {
        Condidat condidat = condidatRepo.findById(id).orElseThrow(() -> new IllegalStateException("Condidat with id " + id + " does not exist"));
        condidat.setValidated(false);
        condidatRepo.save(condidat);
    }

    public Condidat registerCondidat(Condidat condidat) {
        return condidatRepo.save(condidat);
    }
}
