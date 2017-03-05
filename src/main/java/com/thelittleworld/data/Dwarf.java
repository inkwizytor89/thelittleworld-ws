package com.thelittleworld.data;

public class Dwarf {

	private String name;
	private final CompanyOld companyOld;

	private Nature nature;

	public Dwarf(String name, CompanyOld companyOld) {
		this.name = name;
		this.companyOld = companyOld;
		nature = new Nature();
	}

	public void thinkMoreLike(final Nature otherNature) {
		nature.moveThinkingTo(otherNature);
	}

	public double getMorale() {
		return companyOld.getMorales() / companyOld.getDwarfs().size();
	}

	@Override
	public String toString() {
		String card = name + " [Morale:" + getMorale() + ", " + nature.toString() + "]";
		return card;
	}
}
