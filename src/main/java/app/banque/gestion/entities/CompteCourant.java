package app.banque.gestion.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity

@DiscriminatorValue("CC")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class CompteCourant extends  Compte{
    private double decouvert;
}
