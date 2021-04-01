package day19;

import java.io.Serializable;

public class InvoiceMasterDTO implements Cloneable, Serializable{

	private int invoiceId;
	private String date;
	private int customerId;
	
	private static InvoiceMasterDTO invoiceMasterDTO;
	
	private InvoiceMasterDTO() {
		
	}
	
	synchronized public static InvoiceMasterDTO getInvoiceMasterDTO() {
		if(invoiceMasterDTO == null)
			return invoiceMasterDTO = new InvoiceMasterDTO();
		else 
			invoiceMasterDTO.clear();
			return invoiceMasterDTO.getClone();
	}
	
	public void clear() {
		invoiceId = 0;
		date = null;
		customerId = 0;
	}
	
	private InvoiceMasterDTO getClone() {
		try {
			return (InvoiceMasterDTO) super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "InvoiceMasterDTO [invoice id =" + invoiceId + ", date =" + date + ", customer id =" + customerId + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + invoiceId;
		result = prime * result + customerId;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) 
			return true;
		
		if(obj == null)
			return false;
		
		if(getClass() != obj.getClass())
			return false;
		
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		
		if (invoiceId != other.invoiceId)
			return false;
		
		if (customerId != other.customerId)
			return false;
		
		return true;
		
	}
	
}
