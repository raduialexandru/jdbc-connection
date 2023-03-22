package model;


public class Laptop {
    private int id;
    private String model;
    private Processor processor;
    private Motherboard motherboard;
    private int memoryRAMinGb;
    private int hardDiskMemoryInGb;
    private int displaySize;
    private boolean webCamera;


    public Laptop(int id,String model, Processor processor, Motherboard motherboard, int memoryRAMinGb, int hardDiskMemoryInGb, int displaySize, boolean webCamera) {
        this.id = id;
        this.model = model;
        this.processor = processor;
        this.motherboard = motherboard;
        this.memoryRAMinGb = memoryRAMinGb;
        this.hardDiskMemoryInGb = hardDiskMemoryInGb;
        this.displaySize = displaySize;
        this.webCamera = webCamera;

    }
}
