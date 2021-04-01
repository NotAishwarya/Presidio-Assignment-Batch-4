package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.JDBCUtility;

public class InvoiceTransImpl implements InvoiceTransDAO {

	Connection con;
	Statement findAllStatement;
	PreparedStatement findByIDStatement;
	PreparedStatement insertItemStatement;
	PreparedStatement deleteStatement;
	PreparedStatement updateStatement;
	PreparedStatement createTable;

	public InvoiceTransImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		try {
			createTable = con.prepareStatement("create table invoice_trans(invoice_id INTEGER, item_id INTEGER, gty INTEGER)");
			findAllStatement = con.createStatement();
			findByIDStatement = con.prepareStatement("select * from invoice_trans where invoice_id = ?");
			insertItemStatement = con.prepareStatement("insert into invoice_trans values(?, ?, ?)");
			deleteStatement = con.prepareStatement("delete from invoice_trans where invoice_id = ?");
			updateStatement = con
					.prepareStatement("update invoice_trans set item_id = ?, qty = ? where invoice_id = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public InvoiceTransDTO findByID(Integer invoiceId) {
		// TODO Auto-generated method stub
		try {
			findByIDStatement.setInt(1, invoiceId);
			ResultSet rs = findByIDStatement.executeQuery();

			InvoiceTransDTO invoiceTransItem = InvoiceTransDTO.getInvoiceTransDTO();

			while (rs.next()) {
				invoiceTransItem.setInvoiceId(rs.getInt(1));
				invoiceTransItem.setQty(rs.getInt(3));
				invoiceTransItem.setItemId(rs.getInt(2));
				;
			}

			return invoiceTransItem;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InvoiceTransDTO> findAll() {
		// TODO Auto-generated method stub
		List<InvoiceTransDTO> invoiceTransItems = new ArrayList<InvoiceTransDTO>();

		try {
			ResultSet rs = findAllStatement.executeQuery("select * from invoice_trans");
			while (rs.next()) {
				InvoiceTransDTO invoiceTransItem = InvoiceTransDTO.getInvoiceTransDTO();
				invoiceTransItem.setInvoiceId(rs.getInt(1));
				invoiceTransItem.setQty(rs.getInt(3));
				invoiceTransItem.setItemId(rs.getInt(2));
				;

				invoiceTransItems.add(invoiceTransItem);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return invoiceTransItems;
	}

	@Override
	public int insertTrans(InvoiceTransDTO invoiceTransDTO) {
		// TODO Auto-generated method stub
		int invoiceId = invoiceTransDTO.getInvoiceId();
		int itemId = invoiceTransDTO.getItemId();
		int qty = invoiceTransDTO.getQty();

		int i = 0;

		try {
			insertItemStatement.setInt(1, invoiceId);
			insertItemStatement.setInt(2, itemId);
			insertItemStatement.setInt(3, qty);

			i = insertItemStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		return i;
	}

	@Override
	public int updateTrans(InvoiceTransDTO invoiceTransDTO) {
		// TODO Auto-generated method stub
		int invoiceId = invoiceTransDTO.getInvoiceId();
		int itemId = invoiceTransDTO.getItemId();
		int qty = invoiceTransDTO.getQty();
		int i = 0;

		try {
			updateStatement.setInt(3, invoiceId);
			updateStatement.setInt(1, itemId);
			updateStatement.setInt(2, qty);

			i = insertItemStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		return i;
	}

	@Override
	public int deleteTransByID(Integer invoiceId) {
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
	public int deleteTransByDTO(InvoiceTransDTO invoiceTransDTO) {
		// TODO Auto-generated method stub
		int invoiceId = invoiceTransDTO.getInvoiceId();

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
	public int createTableForTrans() {
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
