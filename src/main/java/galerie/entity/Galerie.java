package galerie.entity;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    // TODO : Mettre en oeuvre la relation oneToMany vers Exposition
    @OneToMany(mappedBy = "organisateur")
    List<Exposition> evenements = new LinkedList<>();
    
    public int CAnuel(int annee) {
    	float res = 0;
		
		for (Exposition exposition : evenements) {
			float toAdd = exposition.getAnnee() == annee ? exposition.ChiffreAffaire() : 0;
			res += toAdd;
		}	
	    	return (int) res;
    }
}
