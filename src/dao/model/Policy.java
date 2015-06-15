package dao.model;

import utils.Utils;

/**
 * Created by Rico on 6/13/15.
 */
public class Policy {

    public enum Type {
        CI, //Comprehensive insurance
        TPO,    //Third-party only
        TPFT,   //Third-party fire and theft
    }

    public enum Duration {HALF, ONE}

    public enum Usage {LOW, MID, HEAVY}

    private int id;
    private int vehicleId;
    private int userId;
    private double price;
    private Type type;
    private Duration duration;
    private Usage usage;

    public String toString() {
        String d = Utils.delim;
        return String.valueOf(id) + d + String.valueOf(vehicleId) + d +
                String.valueOf(userId) + d + String.valueOf(price) + d +
                type.toString() + d + duration.toString() + d +
                usage.toString() + d + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
