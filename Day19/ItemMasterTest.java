package day19;

import java.sql.Connection;
import java.util.*;

import day18.JDBCUtility;

public class ItemMasterTest {
public static void main(String[] args) {
	Connection con = JDBCUtility.getConnection();
	
	ItemMasterImpl itemImpl = new ItemMasterImpl(con);
	
	ItemDTO itemDTO = ItemDTO.getItemDTO();
	
	itemDTO.setItem_name("Fresh Watermelon");
	itemDTO.setItemid(5);
	itemDTO.setUnit_price(500);
	itemImpl.insertItem(itemDTO);
	
	itemDTO.setItem_name("Fresh Watermelon");
	itemDTO.setItemid(5);
	itemDTO.setUnit_price(500);
	itemImpl.insertItem(itemDTO);
	
	
	
}
}
