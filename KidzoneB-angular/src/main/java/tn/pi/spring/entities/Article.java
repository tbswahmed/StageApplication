package tn.pi.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public class Article  implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		long idArt;

		String ArtDescription;
		float prix;
		float qteStock;
		
		@Lob
		@Column(columnDefinition = "MEDUIMBLOB")
		String articleImg;
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		String artReference ;
		
		@JsonIgnore
		@ManyToOne
		Categorie categorie;
		
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy="artciles")
		private Set<Devis> devis;

		
		

}
