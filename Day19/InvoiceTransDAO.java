package day19;

import java.util.List;

public interface InvoiceTransDAO {
	public int createTableForTrans();
	
	public InvoiceTransDTO findByID(Integer invoiceId);

	public List<InvoiceTransDTO> findAll();

	public int insertTrans(InvoiceTransDTO invoiceTransDTO);

	public int updateTrans(InvoiceTransDTO invoiceTransDTO);

	public int deleteTransByID(Integer invoiceId);

	public int deleteTransByDTO(InvoiceTransDTO invoiceTransDTO);
}
