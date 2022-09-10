package tn.pi.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Facture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idFact;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long numFact;
	@Temporal(TemporalType.DATE)
	Date dateFact = new Date(System.currentTimeMillis());
	long Quantité;
	float tva;
	float totalHT;
	float totalTTC;
	@JsonIgnore
	@OneToOne
	private Devis devis;
	
}