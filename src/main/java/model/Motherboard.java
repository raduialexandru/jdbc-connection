package model;

public class Motherboard {
    private String type;
    private String model;
    private int id;

    public Motherboard(String type, String model){
        this.type = type;
        this.model = model;
    }

    public int getId() {
        return id;
    }
}
