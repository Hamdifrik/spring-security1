package app.banque.gestion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_employe")
    private Long codeEmploye;


    @Column(name = "nom_employe")
    private String nomEmploye;

    @OneToMany(mappedBy = "employee")
    private List<Compte> comptes;

    @ManyToMany
    @JoinTable(name="EMP_GPR",
            joinColumns = @JoinColumn(name="CODEEMP"),
            inverseJoinColumns= @JoinColumn(name="CODEGPR"))
    private Collection<Group> groupes;

}
