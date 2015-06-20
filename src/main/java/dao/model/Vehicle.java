package dao.model;

import utils.Utils;

/**
 * Created by Rico on 6/13/15.
 */
public class Vehicle {
    private long id;
    private long uid;
    private String brand;
    private int year;
    private String model;
    private int miles;
    private double basePrice;

    public Vehicle(long uid, String brand, int year, String model, int miles, double basePrice) {
        id = System.currentTimeMillis();
        this.uid = uid;
        this.brand = brand;
        this.year = year;
        this.model = model;
        this.miles = miles;
        this.basePrice = basePrice;
    }

    public Vehicle(long id, long uid, String brand, int year, String model, int miles, double basePrice) {
        this(uid, brand, year, model, miles, basePrice);
        this.id = id;
    }

    public Vehicle(String s) {
        String[] ss = s.split(Utils.regex);
        id = Long.parseLong(ss[1].substring(1));
        brand = ss[2];
        year = Integer.parseInt(ss[3]);
        model = ss[4];
        miles = Integer.parseInt(ss[5]);
        basePrice = Double.parseDouble(ss[6]);
        uid = Long.parseLong(ss[7].substring(1));
    }

    @Override
    public String toString() {
        String d = Utils.delim;
        return d + "v" + id + d + brand + d +
                year + d + model + d + miles + d + basePrice + d + "u"+uid;
    }


    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
