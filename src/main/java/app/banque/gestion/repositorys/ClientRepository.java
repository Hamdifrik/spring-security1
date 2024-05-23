package app.banque.gestion.repositorys;

import app.banque.gestion.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
