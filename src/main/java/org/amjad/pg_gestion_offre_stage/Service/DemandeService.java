package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.DemandeRepository;
import org.amjad.pg_gestion_offre_stage.Entity.Demande;
import org.amjad.pg_gestion_offre_stage.Enum.Duree;
import org.amjad.pg_gestion_offre_stage.Enum.Etat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    public void createDemande(Demande demande){
        demandeRepository.save(demande);
    }

    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    public void createDemande(String nom, String prenom, String email, String cin, MultipartFile cv, String description, String duree,String etat) throws Exception {
        Demande demande = new Demande();
        demande.setNom(nom);
        demande.setPrenom(prenom);
        demande.setEmail(email);
        demande.setCIN(cin);
        demande.setCv(new String(cv.getBytes()));
        demande.setDescription(description);
        demande.setEtat(Etat.valueOf(etat));
        demande.setDuree(Duree.fromValue(duree));

        demandeRepository.save(demande);
    }

    public void validerDemande(Long id) {
        Demande demande = demandeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Demande with id " + id + " does not exist"));
        demande.setEtat(Etat.valider);
        demandeRepository.save(demande);
    }

    public void nonValiderDemande(Long id) {
        Demande demande = demandeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Demande with id " + id + " does not exist"));
        demande.setEtat(Etat.nonValider);
        demandeRepository.save(demande);
    }

    public List<Demande> getNonValideDemandes() {
        return demandeRepository.findByEtat(Etat.nonValider);
    }

    public List<Demande> getValideDemandes() {
        return demandeRepository.findByEtat(Etat.valider);
    }

    public List<Demande> getEnAttentDemandes() {
        return demandeRepository.findByEtat(Etat.enAttente);
    }
}
