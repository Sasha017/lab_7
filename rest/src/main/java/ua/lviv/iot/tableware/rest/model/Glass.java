package ua.lviv.iot.tableware.rest.model;

import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;
import ua.lviv.iot.tableware.rest.model.Glass;
import ua.lviv.iot.tableware.rest.model.MatherialType;

public class Glass extends DisponsableTableWare {
    private int temperatureResistance;
    private int waterCapacityGal;
  
    public Glass(String manufacturer, int price, int fireResistance, int dateOfManufacture, MatherialType matherial,
            int temperatureResistance, int waterCapacityGal) {
        super(manufacturer, price, fireResistance, dateOfManufacture, matherial);
        this.temperatureResistance = temperatureResistance;
        this.waterCapacityGal = waterCapacityGal;
    }
    public int getTemperatureResistance() {
        return temperatureResistance;
    }
    public void setTemperatureResistance(int temperatureResistance) {
        this.temperatureResistance = temperatureResistance;
    }
    public int getWaterCapacityGal() {
        return waterCapacityGal;
    }
    public void setWaterCapacityGal(int waterCapacityGal) {
        this.waterCapacityGal = waterCapacityGal;
    }
    public Glass() {
        
    }
	public String getHeaders() {
		return super.getHeaders()+",temperatureResistance "+",waterCapacityGal";
	}
	public String toCSV() {
		return super.toCSV()+","+"temperatureResistance= "+getTemperatureResistance()+","+"waterCapacityGal="+getWaterCapacityGal();
	}


	public Glass put(Integer id, Glass glass) {
		return null;
	}

	}
		
	
