package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.JDBCUtility;

public class InvoiceMasterImpl implements InvoiceMasterDAO{

	Connection con;
	Statement findAllStatement;
	PreparedStatement findByIDStatement;
	PreparedStatement insertItemStatement;
	PreparedStatement deleteStatement;
	PreparedStatement updateStatement;
	PreparedStatement createTableStatement;
	
	public InvoiceMasterImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		try {
			createTableStatement = con.prepareStatement("create table from invoice_master(invoice_id INTEGER, date varchar(30), customer_id INTEGER)");
			findAllStatement = con.createStatement();
			findByIDStatement = con.prepareStatement("select * from invoice_master where invoice_id = ?");
			insertItemStatement = con.prepareStatement("insert into invoice_master values(?, ?, ?)");
			deleteStatement = con.prepareStatement("delete from invoice_master where invoice_id = ?");
			updateStatement = con.prepareStatement("update invoice_master set date = ?, customer_id = ? where invoice_id = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public InvoiceMasterDTO findByID(Integer invoiceId) {
		// TODO Auto-generated method stub
		try {
			findByIDStatement.setInt(1, invoiceId);
			ResultSet rs = findByIDStatement.executeQuery();

			InvoiceMasterDTO invoiceItem = InvoiceMasterDTO.getInvoiceMasterDTO();

			while (rs.next()) {
				invoiceItem.setInvoiceId(rs.getInt(1));
				invoiceItem.setDate(rs.getString(2));
				invoiceItem.setCustomerId(rs.getInt(3));
			}

			return invoiceItem;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InvoiceMasterDTO> findAll() {
		// TODO Auto-generated method stub

		List<InvoiceMasterDTO> invoiceItems = new ArrayList<InvoiceMasterDTO>();

		try {
			ResultSet rs = findAllStatement.executeQuery("select * from invoice_master");
			while (rs.next()) {
				InvoiceMasterDTO invoiceItem = InvoiceMasterDTO.getInvoiceMasterDTO();
				invoiceItem.setInvoiceId(rs.getInt(1));
				invoiceItem.setDate(rs.getString(2));
				invoiceItem.setCustomerId(rs.getInt(3));
				
				invoiceItems.add(invoiceItem);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return invoiceItems;
	}

	@Override
	public int insertItem(InvoiceMasterDTO invoiceMasterDTO) {
		// TODO Auto-generated method stub
		String date = invoiceMasterDTO.getDate();
		int invoiceId = invoiceMasterDTO.getInvoiceId();
		int customerId = invoiceMasterDTO.getCustomerId();

		int i = 0;

		try {
			insertItemStatement.setInt(1, invoiceId);
			insertItemStatement.setString(2, date);
			insertItemStatement.setInt(3, customerId);

			i = insertItemStatement.executeUpdate();
			;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		return i;
	}

	@Override
	public int updateItem(InvoiceMasterDTO invoiceMasterDTO) {
		// TODO Auto-generated method stub
		String date = invoiceMasterDTO.getDate();
		int invoiceId = invoiceMasterDTO.getInvoiceId();
		int customerId = invoiceMasterDTO.getCustomerId();

		int i = 0;

		try {
			updateStatement.setInt(3, invoiceId);
			updateStatement.setString(1, date);
			updateStatement.setInt(2, customerId);

			i = insertItemStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
 
		return i;
	}

	@Override
	public int deleteItemByID(Integer invoiceId) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			deleteStatement.setInt(1, invoiceId);
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteItemByDTO(InvoiceMasterDTO invoiceMasterDTO) {
		// TODO Auto-generated method stub
		int invoiceId = invoiceMasterDTO.getInvoiceId();
		int i = 0;

		try {
			deleteStatement.setInt(1, invoiceId);
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int createInvoiceMasterTable() {
		// TODO Auto-generated method stub
		try {
			int i = createTableStatement.executeUpdate();
			return i;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

}
