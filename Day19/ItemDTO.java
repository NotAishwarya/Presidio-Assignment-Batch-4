package day19;

import java.io.Serializable;

public class ItemDTO implements Serializable, Cloneable {
	private int itemid;
	private String item_name;
	private float unit_price;

	private static ItemDTO itemDTO;

	synchronized public static ItemDTO getItemDTO() {
		if (itemDTO == null) {
			itemDTO = new ItemDTO();
		}
		itemDTO.clear();
		return itemDTO.getCloneItemDTO();
	}

	private ItemDTO getCloneItemDTO() {
		try {
			return (ItemDTO) super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public void clear() {
		item_name = null;
		itemid = 0;
		unit_price = 0;
	}
	
	private ItemDTO() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ItemDTO [itemid=" + itemid + ", item_name=" + item_name + ", price=" + unit_price + "]";
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + itemid;
		result = prime * result + Float.floatToIntBits(unit_price);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) 
			return true;
		
		if(obj == null)
			return false;
		
		if(getClass() != obj.getClass())
			return false;
		
		ItemDTO other = (ItemDTO) obj;
		
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		
		if (itemid != other.itemid)
			return false;
		
		if (Float.floatToIntBits(unit_price) != Float.floatToIntBits(other.unit_price))
			return false;
		
		return true;
		
	}

}
