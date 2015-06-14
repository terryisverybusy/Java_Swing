package dao.model;

/**
 * Created by Rico on 6/13/15.
 */
public class Vehicle {
    private int id;
    private String brand;
    private int year;
    private String model;
    private int estimateValue;
    private int miles;

    @Override
    public String toString() {
        return String.valueOf(id) + "||" + brand + "||" +
                String.valueOf(year) + "||" + model + "||" +
                String.valueOf(estimateValue) + "||" + String.valueOf(miles) + "||";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getEstimateValue() {
        return estimateValue;
    }

    public void setEstimateValue(int estimateValue) {
        this.estimateValue = estimateValue;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }
}
