package day19;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import day18.JDBCUtility;

public class ItemMasterImpl implements ItemMasterDAO {

	private Connection con;
	private Statement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement insertItemStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement createTable;

	public ItemMasterImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		try {
			createTable = con.prepareStatement(" create table items(id INTEGER, name varchar(30), price FLOAT)");
			findAllStatement = con.createStatement();
			findByIDStatement = con.prepareStatement("select * from items where id = ?");
			insertItemStatement = con.prepareStatement("insert into items values(?, ?, ?)");
			deleteStatement = con.prepareStatement("delete from items where id = ?");
			updateStatement = con.prepareStatement("update items set name = ?, price = ? where id = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ItemDTO findByID(Integer itemid) {
		// TODO Auto-generated method stub
		try {
			findByIDStatement.setInt(1, itemid);
			ResultSet rs = findByIDStatement.executeQuery();

			ItemDTO item = ItemDTO.getItemDTO();

			while (rs.next()) {
				item.setItem_name(rs.getString(2));
				item.setItemid(rs.getInt(1));
				item.setUnit_price(rs.getFloat(3));
			}

			return item;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ItemDTO> findAll() {
		// TODO Auto-generated method stub

		List<ItemDTO> items = new ArrayList<ItemDTO>();

		try {
			ResultSet rs = findAllStatement.executeQuery("select * from items");
			while (rs.next()) {
				ItemDTO item = ItemDTO.getItemDTO();
				item.setItem_name(rs.getString(2));
				item.setItemid(rs.getInt(1));
				item.setUnit_price(rs.getFloat(3));

				items.add(item);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return items;
	}

	@Override
	public int insertItem(ItemDTO itemDTO) {
		int itemid = itemDTO.getItemid();
		int i = 0;

		try {
			findByIDStatement.setInt(1, itemid);
			ResultSet rs = findByIDStatement.executeQuery();

			if (rs.next())
				return 0;

			System.out.println("Executed Update");
			insertItemStatement.setInt(1, itemid);
			insertItemStatement.setString(2, itemDTO.getItem_name());
			insertItemStatement.setFloat(3, itemDTO.getUnit_price());

			return i = insertItemStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int updateItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			updateStatement.setString(1, itemDTO.getItem_name());
			updateStatement.setFloat(2, itemDTO.getUnit_price());
			updateStatement.setInt(3, itemDTO.getItemid());

			i = updateStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteItemByID(Integer itemid) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			deleteStatement.setInt(1, itemid);
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteItemByDTO(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			deleteStatement.setInt(1, itemDTO.getItemid());
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

}
