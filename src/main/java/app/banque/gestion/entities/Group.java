package app.banque.gestion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numGroupe;
    private String nomGroupe;
    @ManyToMany(mappedBy = "groupes")
    private Collection<Employee> employes;
}