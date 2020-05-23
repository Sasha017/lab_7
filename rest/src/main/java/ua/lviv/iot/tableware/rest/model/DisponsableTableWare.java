package ua.lviv.iot.tableware.rest.model;
import static java.lang.Integer.compare;

import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;
import ua.lviv.iot.tableware.rest.model.MatherialType;

public abstract class DisponsableTableWare {
    private String manufacturer;
    private int price;
    private int fireResistance;
    private int dateOfManufacture;
    private MatherialType matherial;
    private int id;
   

   public final int getId() {
       return id;
   }

   public final void setId(int id) {
       this.id = id;
   }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFireResistance() {
        return fireResistance;
    }

    public void setFireResistance(int fireResistance) {
        this.fireResistance = fireResistance;
    }

    public int getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(int dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public MatherialType getMatherial() {
        return matherial;
    }

    public void setMatherial(MatherialType matherial) {
        this.matherial = matherial;
    }

    
    public DisponsableTableWare(String manufacturer, int price, int fireResistance, int dateOfManufacture,
                                MatherialType matherial) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.fireResistance = fireResistance;
        this.dateOfManufacture = dateOfManufacture;
        this.matherial = matherial;
    }

    public DisponsableTableWare() {

    }

    public int compareTo(DisponsableTableWare anotherTableWare) {
        return compare(this.getDateOfManufacture(), anotherTableWare.getDateOfManufacture());
    }
    public String toCSV() {
		return "price = " + getPrice() + " manufacturer = " + getManufacturer() + 
				" fireResistance = "	+ getFireResistance() + " dateOfManufacture = " + getDateOfManufacture() + " matherial = "  + getMatherial();
	}

	public String getHeaders() {

		return "manufacturer,  price ,  fireResistance, dateOfManufacture,  matherial";
	}
}