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

	private Connection con;
	private Statement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement insertItemStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement createTableStatement;
	
	public InvoiceMasterImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		try {
			createTableStatement = con.prepareStatement("create table invoice_master(invoice_id INTEGER, date varchar(30), customer_id INTEGER)");
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
	public int insertInvoiceMasterItem(InvoiceMasterDTO invoiceMasterDTO) {
		// TODO Auto-generated method stub
		int invoiceId = invoiceMasterDTO.getInvoiceId();
		int i = 0;

		try {
			findByIDStatement.setInt(1, invoiceId);
			ResultSet rs = findByIDStatement.executeQuery();
			
			if (rs.next())
				return 0;
			
			insertItemStatement.setInt(1, invoiceId);
			insertItemStatement.setString(2, invoiceMasterDTO.getDate());
			insertItemStatement.setInt(3, invoiceMasterDTO.getCustomerId());

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
	public int updateInvoiceMasterItem(InvoiceMasterDTO invoiceMasterDTO) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			updateStatement.setInt(3, invoiceMasterDTO.getInvoiceId());
			updateStatement.setString(1, invoiceMasterDTO.getDate());
			updateStatement.setInt(2, invoiceMasterDTO.getCustomerId());

			i = updateStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
 
		return i;
	}

	@Override
	public int deleteInvoiceMasterItemByID(Integer invoiceId) {
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
	public int deleteInvoiceMasterItemByDTO(InvoiceMasterDTO invoiceMasterDTO) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			deleteStatement.setInt(1, invoiceMasterDTO.getInvoiceId());
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
