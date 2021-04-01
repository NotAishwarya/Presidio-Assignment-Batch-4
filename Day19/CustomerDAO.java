package day19;

import java.util.List;

public interface CustomerDAO {
	
	public int createCustomerTable();
	
	public CustomerDTO findCustomerByID(Integer customerId);

	public List<CustomerDTO> findAllCustomer();

	public int insertCustomer(CustomerDTO customerDTO);

	public int updateCustomer(CustomerDTO customerDTO);

	public int deleteCustomerByID(Integer customerId);

	public int deleteCustomerByDTO(CustomerDTO customerDTO);
}
 