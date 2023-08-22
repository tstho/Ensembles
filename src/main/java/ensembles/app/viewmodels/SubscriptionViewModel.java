package ensembles.app.viewmodels;

import java.util.Date;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class SubscriptionViewModel {
	
	private Date startDate;
	
	private Date endDate;
	
	private double price;
	
	





	public Date getStartDate() {
		return startDate;
	}








	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}





	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}




	public double getprice() {
		return price;
	}





	public void setprice(double price) {
		this.price = price;
	}


	

		@Override
		public String toString() {
			return "SubscriptionViewModel  startDate=" + startDate+ ", endDate=" + endDate + ", price=" + price +  "]";
		}
		
		
	}


