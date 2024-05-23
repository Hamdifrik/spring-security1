package app.banque.gestion.repositorys;


import app.banque.gestion.entities.Compte;
import app.banque.gestion.entities.CompteCourant;
import app.banque.gestion.entities.CompteEparne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
    @Query("SELECT cc FROM CompteCourant cc")
    List<CompteCourant> findAllCompteCourant();

    @Query("SELECT ce FROM CompteEparne ce")
    List<CompteEparne> findAllCompteEpargne();
}
