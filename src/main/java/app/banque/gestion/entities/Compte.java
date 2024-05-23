package app.banque.gestion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_cpt",discriminatorType =DiscriminatorType.STRING,length =2 )
@AllArgsConstructor

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  codeCompte;
    private Date dateCreation;
    private  double solde;

    @ManyToOne
    @JoinColumn(name="compteclient")
    private Client client;

    @OneToMany
    private List <Operation> operations;

    @ManyToOne
    @JoinColumn(name="code_employee")
    private Employee employee;

}
