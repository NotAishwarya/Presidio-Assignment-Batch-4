package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import day18.JDBCUtility;

public class CustomerImpl implements CustomerDAO {

	Connection con;
	Statement findAllStatement;
	PreparedStatement findByIDStatement;
	PreparedStatement insertItemStatement;
	PreparedStatement deleteStatement;
	PreparedStatement updateStatement;
	PreparedStatement createTable;

	public CustomerImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		
		try {
			createTable = con.prepareStatement("create table customer(customer_id INTEGER, customer_name varchar(30), customer_address varchar(30), customer_account_details INTEGER, customer_gst_number INTEGER)");
			findAllStatement = con.createStatement();
			findByIDStatement = con.prepareStatement("select * from customer where customer_id = ?");
			insertItemStatement = con.prepareStatement("insert into customer values(?, ?, ?, ?, ?)");
			deleteStatement = con.prepareStatement("delete from customer where customer_id = ?");
			updateStatement = con.prepareStatement("update customer set customer_name = ?, customer_address = ?, customer_account_details = ?, customer_gst_number = ? where customer_id = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CustomerDTO findCustomerByID(Integer customerId) {
		// TODO Auto-generated method stub
		try {
			findByIDStatement.setInt(1, customerId);
			ResultSet rs = findByIDStatement.executeQuery();

			CustomerDTO customer = CustomerDTO.getCustomerDTO();

			while (rs.next()) {
				customer.setCustomerId(rs.getInt(1));
				customer.setCust_name(rs.getString(2));
				customer.setCust_address(rs.getString(3));
				customer.setCust_account_details(rs.getInt(4));
				customer.setCust_gstNum(rs.getInt(5));
			}

			return customer;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDTO> findAllCustomer() {
		// TODO Auto-generated method stub
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();

		try {
			ResultSet rs = findAllStatement.executeQuery("select * from customer");
			while (rs.next()) {
				CustomerDTO customer = CustomerDTO.getCustomerDTO();
				customer.setCustomerId(rs.getInt(1));
				customer.setCust_name(rs.getString(2));
				customer.setCust_address(rs.getString(3));
				customer.setCust_account_details(rs.getInt(4));
				customer.setCust_gstNum(rs.getInt(5));

				customers.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customers;
	}

	@Override
	public int insertCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		int customerId = customerDTO.getCustomerId();
		String customerName = customerDTO.getCust_name();
		String customerAddress = customerDTO.getCust_address();
		int customerAccountDetails = customerDTO.getCust_account_details();
		int customerGSTNumber = customerDTO.getCust_gstNum();

		int i = 0;

		try {
			insertItemStatement.setInt(1, customerId);
			insertItemStatement.setString(2, customerName);
			insertItemStatement.setString(3, customerAddress);
			insertItemStatement.setInt(4, customerAccountDetails);
			insertItemStatement.setInt(5, customerGSTNumber);

			i = insertItemStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		return i;
	}

	@Override
	public int updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		int customerId = customerDTO.getCustomerId();
		String customerName = customerDTO.getCust_name();
		String customerAddress = customerDTO.getCust_address();
		int customerAccountDetails = customerDTO.getCust_account_details();
		int customerGSTNumber = customerDTO.getCust_gstNum();

		int i = 0;

		try {
			updateStatement.setInt(5, customerId);
			updateStatement.setString(1, customerName);
			updateStatement.setString(2, customerAddress);
			updateStatement.setInt(4, customerGSTNumber);
			updateStatement.setInt(3, customerAccountDetails);

			i = insertItemStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		return i;
	}

	@Override
	public int deleteCustomerByID(Integer customerId) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			deleteStatement.setInt(1, customerId);
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteCustomerByDTO(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		int customerId = customerDTO.getCustomerId();
		int i = 0;

		try {
			deleteStatement.setInt(1, customerId);
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int createCustomerTable() {
		// TODO Auto-generated method stub
		try {
			int i = createTable.executeUpdate();
			return i;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

}
