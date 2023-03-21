package com.ics499.clothingstore.model;

import javax.persistence.Entity;

@Entity
public class Pants extends Product {

	public enum PantsType {
		Jeans, Cargo, Dress, Khaki, Sweat, Pajama
	}

	private PantsType type;
	private boolean pockets;
	private boolean zipper;
	private boolean beltloops;

	public Pants(float price, int stock, String description, String brand, String color, String size, String fit,
			PantsType type, boolean pockets, boolean zipper, boolean beltloops) {
		super(price, stock, description, brand, color, size, fit);
		this.type = type;
		this.pockets = pockets;
		this.zipper = zipper;
		this.beltloops = beltloops;
	}

	public Pants() {  

	}

	public PantsType getType() {
		return type;
	}

	public void setType(PantsType type) {
		this.type = type;
	}

	public boolean isPockets() {
		return pockets;
	}

	public void setPockets(boolean pockets) {
		this.pockets = pockets;
	}

	public boolean isZipper() {
		return zipper;
	}

	public void setZipper(boolean zipper) {
		this.zipper = zipper;
	}

	public boolean isBeltloops() {
		return beltloops;
	}

	public void setBeltloops(boolean beltloops) {
		this.beltloops = beltloops;
	}
}
