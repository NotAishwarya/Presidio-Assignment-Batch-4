package day19;

import java.sql.Connection;

import day18.JDBCUtility;

public class InvoiceTransTest {
public static void main(String[] args) {
	Connection con = JDBCUtility.getConnection();
	
	InvoiceTransImpl invoiceTransImpl = new InvoiceTransImpl(con);
	InvoiceTransDTO invoiceTrans = InvoiceTransDTO.getInvoiceTransDTO();
	
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
	invoiceTransImpl.updateTrans(invoiceTrans);
	
	invoiceTrans.setInvoiceId(13290);
	invoiceTrans.setItemId(5);
	invoiceTrans.setQty(100);
	invoiceTransImpl.deleteTransByDTO(invoiceTrans);
	
	invoiceTrans.setInvoiceId(122);
	invoiceTrans.setItemId(5);
	invoiceTrans.setQty(100);
	invoiceTransImpl.updateTrans(invoiceTrans);
	
	invoiceTransImpl.deleteTransByID(122);
	
	System.out.println(invoiceTransImpl.findAll());
	System.out.println(invoiceTransImpl.findByID(4));
}
}
