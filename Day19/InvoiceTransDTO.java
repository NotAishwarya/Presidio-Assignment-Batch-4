package day19;

import java.io.Serializable;

public class InvoiceTransDTO implements Cloneable, Serializable {
	private int invoiceId;
	private int itemId;
	private int qty;
	private static InvoiceTransDTO invoiceTransDTO;

	private InvoiceTransDTO() {

	}

	synchronized public static InvoiceTransDTO getInvoiceTransDTO() {
		if (invoiceTransDTO == null)
			return invoiceTransDTO = new InvoiceTransDTO();
		else
			invoiceTransDTO.clear();
			return invoiceTransDTO.getClone();
	}

	private InvoiceTransDTO getClone() {
		try {
			return (InvoiceTransDTO) super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public void clear() {
		invoiceId = 0;
		itemId = 0;
		qty = 0;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "InvoiceMasterDTO [invoice id =" + invoiceId + ", item ID =" + itemId + ", Quantity =" + qty + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + invoiceId;
		result = prime * result + qty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		InvoiceTransDTO other = (InvoiceTransDTO) obj;

		if (itemId != other.itemId)
			return false;

		if (invoiceId != other.invoiceId)
			return false;

		if (qty != other.qty)
			return false;

		return true;

	}

}
