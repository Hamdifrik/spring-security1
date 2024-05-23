package app.banque.gestion.entities;


        import jakarta.persistence.DiscriminatorValue;
        import jakarta.persistence.Entity;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteEparne extends  Compte{

    private double taux;




}
