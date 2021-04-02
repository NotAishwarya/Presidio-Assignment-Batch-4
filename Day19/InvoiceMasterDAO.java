package day19;

import java.util.List;

public interface InvoiceMasterDAO {
	public int createInvoiceMasterTable();

	public InvoiceMasterDTO findByID(Integer invoiceId);

	public List<InvoiceMasterDTO> findAll();

	public int insertInvoiceMasterItem(InvoiceMasterDTO invoiceMasterDTO);

	public int updateInvoiceMasterItem(InvoiceMasterDTO invoiceMasterDTO);

	public int deleteInvoiceMasterItemByID(Integer invoiceId);

	public int deleteInvoiceMasterItemByDTO(InvoiceMasterDTO invoiceMasterDTO);
}
