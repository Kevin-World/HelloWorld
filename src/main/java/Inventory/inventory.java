package Inventory;

import java.sql.Date;

public class inventory {
	private String inventoryItemCode;
	private String organizationCode;
	private String subinventoryCode;
	private String inventoryLocation;
	private int quantity;
	private int recQuantity;
	private Date rDate;

	public String getInventoryCode() {
		return inventoryItemCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryItemCode = inventoryCode;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getSubinventoryCode() {
		return subinventoryCode;
	}

	public void setSubinventoryCode(String subinventoryCode) {
		this.subinventoryCode = subinventoryCode;
	}

	public String getInventoryLocation() {
		return inventoryLocation;
	}

	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRecQuantity() {
		return recQuantity;
	}

	public void setRecQuantity(int recQuantity) {
		this.recQuantity = recQuantity;
	}

	public Date getRDate() {
		return rDate;
	}

	public void setRDate(Date rDate) {
		this.rDate = rDate;
	}

	public inventory(String inventoryItemCode, String organizationCode, String subinventoryCode, String inventoryLocation,
			int quantity, int recQuantity, Date rDate) {
		super();
		this.inventoryItemCode = inventoryItemCode;
		this.organizationCode = organizationCode;
		this.subinventoryCode = subinventoryCode;
		this.inventoryLocation = inventoryLocation;
		this.quantity = quantity;
		this.recQuantity = recQuantity;
		this.rDate = rDate;
	}
	
	public inventory() {
		super();
	}
}
