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

    private long id = System.currentTimeMillis();
    private long vehicleId;
    private long userId;
    private double price = 0.0;
    private Type type;
    private Duration duration;
    private Usage usage;

    public Policy(long id, long vehicleId, long userId, double price, Type type, Duration duration, Usage usage) {
        this(vehicleId, userId, price, type, duration, usage);
        this.id = id;

    }

    public Policy(long vehicleId, long userId, double price, Type type, Duration duration, Usage usage) {
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.price = price;
        this.type = type;
        this.duration = duration;
        this.usage = usage;
    }

    public Policy(String s) {
        String[] ss = s.split(Utils.regex);
        id = Long.parseLong(ss[1].substring(1));
        vehicleId = Long.parseLong(ss[2].substring(1));
        userId = Long.parseLong(ss[3].substring(1));
        price = Double.parseDouble(ss[4]);
        type = Type.valueOf(ss[5]);
        duration = Duration.valueOf(ss[6]);
        usage = Usage.valueOf(ss[7]);
    }

    public String toString() {
        String d = Utils.delim;
        return d + "p" + String.valueOf(id) + d + "v" + String.valueOf(vehicleId) + d +
                "u" + String.valueOf(userId) + d + String.valueOf(price) + d +
                type.toString() + d + duration.toString() + d + usage.toString();
    }

    public long getId() {
        return id;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public long getUserId() {
        return userId;
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
