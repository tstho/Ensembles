package ensembles.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Package")
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
