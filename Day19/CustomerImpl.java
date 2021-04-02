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

	private Connection con;
	private Statement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement insertItemStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement createTable;

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
		int i = 0;

		try {
			findByIDStatement.setInt(1, customerId);
			ResultSet rs = findByIDStatement.executeQuery();

			if (rs.next())
				return 0;
			
			insertItemStatement.setInt(1, customerId);
			insertItemStatement.setString(2, customerDTO.getCust_name());
			insertItemStatement.setString(3, customerDTO.getCust_address());
			insertItemStatement.setInt(4, customerDTO.getCust_account_details());
			insertItemStatement.setInt(5, customerDTO.getCust_gstNum());

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
		int i = 0;

		try {
			updateStatement.setInt(5, customerDTO.getCustomerId());
			updateStatement.setString(1, customerDTO.getCust_name());
			updateStatement.setString(2, customerDTO.getCust_address());
			updateStatement.setInt(4, customerDTO.getCust_gstNum());
			updateStatement.setInt(3, customerDTO.getCust_account_details());

			i = updateStatement.executeUpdate();
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
			System.out.println();
			System.out.println(findAllCustomer());
			System.out.println("\n\nDeleted ........" + i);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteCustomerByDTO(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			deleteStatement.setInt(1, customerDTO.getCustomerId());
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
