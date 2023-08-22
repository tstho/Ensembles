package ensembles.app.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subcription")
public class Subscription {
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		
		
		private LocalDate startDate;
		
		private LocalDate endDate;
		
		private double price;
		
		
		public Subscription() {
			super();
		}


		public Subscription(Long id, LocalDate startDate,LocalDate endDate, double price) {
				
			super();
			this.id = id;
			this.startDate = startDate;
			this.endDate = endDate;
			this.price = price;
			
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public double getprice() {
			return price;
		}

		public void setprice(double price) {
			this.price = price;
		}

		
		public String toString() {
			return "Subcription [id=" + id + ", startDate=" + startDate+ ", endDate=" + endDate + ", price=" + price + "]";
		}
		
		
}