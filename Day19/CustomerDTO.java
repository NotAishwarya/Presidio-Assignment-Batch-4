package day19;

import java.io.Serializable;

public class CustomerDTO implements Cloneable, Serializable {
	private int customerId;
	private String cust_name;
	private String cust_address;
	private int cust_account_details;
	private int cust_gstNum;
	
	private static CustomerDTO customerDTO;
	
	private CustomerDTO() {

	}
	
	synchronized public static CustomerDTO getCustomerDTO() {
		if(customerDTO == null)
			return customerDTO = new CustomerDTO();
		else
			customerDTO.clear();
			return customerDTO.getClone();
	}
	
	private CustomerDTO getClone() {
		try {
			return (CustomerDTO) super.clone();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int cust_id) {
		this.customerId = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_add) {
		this.cust_address = cust_add;
	}

	public int getCust_account_details() {
		return cust_account_details;
	}

	public void setCust_account_details(int cust_account_details) {
		this.cust_account_details = cust_account_details;
	}

	public int getCust_gstNum() {
		return cust_gstNum;
	}

	public void setCust_gstNum(int cust_gstNum) {
		this.cust_gstNum = cust_gstNum;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [customer id=" + customerId + ", cust_name=" + cust_name + ", cust_add=" + cust_address
				+ ", cust_account_details=" + cust_account_details + ", cust_gstNum=" + cust_gstNum + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + (( cust_name == null) ? 0 : cust_name.hashCode());
		result = prime * result + (( cust_address == null) ? 0 : cust_address.hashCode());
		result = prime * result + cust_gstNum;
		result = prime * result + cust_account_details;
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
		
		CustomerDTO other = (CustomerDTO) obj;
		
		if (cust_name == null) {
			if (other.cust_name != null)
				return false;
		} else if (!cust_name.equals(other.cust_name))
			return false;
		
		if (cust_address == null) {
			if (other.cust_address != null)
				return false;
		} else if (!cust_address.equals(other.cust_address))
			return false;
		
		
		if (cust_gstNum != other.cust_gstNum)
			return false;
		
		if (customerId != other.customerId)
			return false;
		
		if (cust_account_details != other.cust_account_details)
			return false;
		
		return true;
		
	}
	
	public void clear() {
		cust_account_details = 0;
		cust_name = null;
		cust_address = null;
		cust_gstNum = 0;
		customerId = 0;
	}
}
