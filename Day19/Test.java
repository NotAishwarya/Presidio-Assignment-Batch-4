package day19;

import java.sql.Connection;

import day18.JDBCUtility;

public class Test {
public static void main(String[] args) {
	Connection con = JDBCUtility.getConnection();
	
	ItemDTO itemDTO = ItemDTO.getItemDTO();
	InvoiceMasterDTO invoiceMaster = InvoiceMasterDTO.getInvoiceMasterDTO();
	InvoiceTransDTO invoiceTrans = InvoiceTransDTO.getInvoiceTransDTO();
	CustomerDTO customer = CustomerDTO.getCustomerDTO();
	UserDTO user = UserDTO.getUserDTO();
	
	ItemMasterImpl itemImpl = new ItemMasterImpl(con);
	InvoiceTransImpl invoiceTransImpl = new InvoiceTransImpl(con);
	InvoiceMasterImpl invoiceMasterImpl = new InvoiceMasterImpl(con);
	CustomerImpl customerImpl = new CustomerImpl(con);
	UserImpl userImpl = new UserImpl(con);
	
	
	itemDTO.setItem_name("Fresh Watermelon");
	itemDTO.setItemid(5);
	itemDTO.setUnit_price(500);
	itemImpl.insertItem(itemDTO);
	
	itemDTO.setItem_name("Rohu fish");
	itemDTO.setItemid(5);
	itemDTO.setUnit_price(600);
	itemImpl.insertItem(itemDTO);
	
	itemDTO.setItem_name("Not so  fresh Pomegranate");
	itemDTO.setItemid(6);
	itemDTO.setUnit_price(50);
	itemImpl.insertItem(itemDTO);
	
	System.out.println(itemImpl.findAll());	
	itemImpl.deleteItemByID(1);
	
	itemDTO.setItem_name("Rohu Fish");
	itemDTO.setItemid(5);
	itemDTO.setUnit_price(200);
	itemImpl.updateItem(itemDTO);
	
	//****************************************************************
	invoiceMasterImpl.createInvoiceMasterTable();
	
	invoiceMaster.setCustomerId(23);
	invoiceMaster.setDate("June 9");
	invoiceMaster.setInvoiceId(5);
	invoiceMasterImpl.insertInvoiceMasterItem(invoiceMaster);
	
	invoiceMaster.setCustomerId(54);
	invoiceMaster.setDate("Jan 5");
	invoiceMaster.setInvoiceId(6);
	invoiceMasterImpl.insertInvoiceMasterItem(invoiceMaster);
	
	invoiceMaster.setCustomerId(81);
	invoiceMaster.setDate("April 1");
	invoiceMaster.setInvoiceId(4);
	invoiceMasterImpl.insertInvoiceMasterItem(invoiceMaster);
	
	invoiceMasterImpl.deleteInvoiceMasterItemByID(4);
	
	System.out.println(invoiceMasterImpl.findAll());
	
	//***********************************************************
	invoiceTransImpl.createTableForTrans();
	
	invoiceTrans.setInvoiceId(1);
	invoiceTrans.setItemId(5);
	invoiceTrans.setQty(3);
	invoiceTransImpl.insertTrans(invoiceTrans);
	
	invoiceTrans.setInvoiceId(4);
	invoiceTrans.setItemId(324);
	invoiceTrans.setQty(2);
	invoiceTransImpl.insertTrans(invoiceTrans);
	
	invoiceTrans.setInvoiceId(2);
	invoiceTrans.setItemId(24);
	invoiceTrans.setQty(6);
	invoiceTransImpl.insertTrans(invoiceTrans);
	
	invoiceTrans.setInvoiceId(1);
	invoiceTrans.setItemId(5);
	invoiceTrans.setQty(100);
	invoiceTransImpl.updateTrans(invoiceTrans);
	
	invoiceTrans.setInvoiceId(13290);
	invoiceTrans.setItemId(5);
	invoiceTrans.setQty(100);
	invoiceTransImpl.insertTrans(invoiceTrans);
	
	invoiceTrans.setInvoiceId(13290);
	invoiceTrans.setItemId(5);
	invoiceTrans.setQty(100);
	invoiceTransImpl.deleteTransByDTO(invoiceTrans);
	
	invoiceTrans.setInvoiceId(122);
	invoiceTrans.setItemId(5);
	invoiceTrans.setQty(100);
	invoiceTransImpl.insertTrans(invoiceTrans);
	
	invoiceTransImpl.deleteTransByID(122);
	
	System.out.println(invoiceTransImpl.findAll());
	System.out.println(invoiceTransImpl.findByID(2));
	
	//***********************************************************
	
	userImpl.createUsersTable();
	
	user.setFlag(0);
	user.setPassword("not telling you");
	user.setUsername("Mountain");
	user.setUserid(1);	
	userImpl.insertUser(user);
	
	user.setFlag(0);
	user.setPassword("ilovepandas");
	user.setUsername("Panda Lover");
	user.setUserid(2);	
	userImpl.insertUser(user);
	
	user.setFlag(0);
	user.setPassword("Deepest darkest secret");
	user.setUsername("Sheep");
	user.setUserid(3);	
	userImpl.insertUser(user);
	userImpl.deleteUserByID(3);
	
	user.setFlag(0);
	user.setPassword("Not Deepest darkest secret");
	user.setUsername("Sheep");
	user.setUserid(3);	
	userImpl.insertUser(user);
	userImpl.deleteUserByID(3);
	
	user.setFlag(0);
	user.setPassword("not telling you");
	user.setUsername("Hilly Mountain");
	user.setUserid(1);	
	userImpl.updateUser(user);
	
	System.out.println(userImpl.findAllUsers());
	System.out.println(userImpl.findUserByID(2));
	
	//************************************************************
	
	customerImpl.createCustomerTable();
	
	customer.setCust_name("Sunset");
	customer.setCust_address("Behind the mountains");
	customer.setCust_gstNum(24);
	customer.setCustomerId(1);
	customer.setCust_account_details(343545534);
	customerImpl.insertCustomer(customer);
	
	customer.setCust_name("Dexter");
	customer.setCust_address("In his lab");
	customer.setCust_gstNum(86);
	customer.setCustomerId(2);
	customer.setCust_account_details(9045534);
	customerImpl.insertCustomer(customer);
	
	customer.setCust_name("Corrupted customer");
	customer.setCust_address("is hiding");
	customer.setCust_gstNum(55);
	customer.setCustomerId(3);
	customer.setCust_account_details(2545534);
	customerImpl.insertCustomer(customer);
	customerImpl.deleteCustomerByID(3);
	
	customer.setCust_name("Corrupted customer");
	customer.setCust_address("is not hiding");
	customer.setCust_gstNum(55);
	customer.setCustomerId(3);
	customer.setCust_account_details(2545534);
	customerImpl.insertCustomer(customer);
	customerImpl.deleteCustomerByDTO(customer);
	
	customer.setCust_name("Sun Rise");
	customer.setCust_address("Behind the mountains");
	customer.setCust_gstNum(24);
	customer.setCustomerId(1);
	customer.setCust_account_details(343545534);
	customerImpl.updateCustomer(customer);
	
	System.out.println(customerImpl.findAllCustomer());
	System.out.println(customerImpl.findCustomerByID(2));
	
	JDBCUtility.closeConnection(null, null);
	
}
}
