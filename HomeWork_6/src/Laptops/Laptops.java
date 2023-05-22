package Laptops;


import java.time.LocalDate;

public class Laptops {
//    поля
    private String model; //модель
    private Integer guarantee; //гарантия
    private String OS;
    private String color;
    private Double diagonal;
    private String screenResolution; // разрешение экрана
    private String CPU; // процессор
    private String amountOfRAM; // объем оперативной памяти
    private String hardDiskCapacity; // объем жесткого диска


    public Laptops(String model, Integer guarantee, String OS, String color, Double diagonal, String screenResolution, String CPU, String amountOfRAM, String hardDiskCapacity) {
        this.model = model;
        this.guarantee = guarantee;
        this.OS = OS;
        this.color = color;
        this.diagonal = diagonal;
        this.screenResolution = screenResolution;
        this.CPU = CPU;
        this.amountOfRAM = amountOfRAM;
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getAmountOfRAM() {
        return amountOfRAM;
    }

    public void setAmountOfRAM(String amountOfRAM) {
        this.amountOfRAM = amountOfRAM;
    }

    public String getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public void setHardDiskCapacity(String hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                "модель: '" + model + '\'' +
                ", гарантия: " + guarantee +
                ", операционная система: '" + OS + '\'' +
                ", цвет: '" + color + '\'' +
                ", диагональ (дюймы): " + diagonal + "\'\'" +
                ", разрешение экрана: '" + screenResolution + '\'' +
                ", процессор: '" + CPU + '\'' +
                ", объем оперативной памяти: '" + amountOfRAM + '\'' +
                ", объем жесткого диска: '" + hardDiskCapacity + '\'' +
                '}';
    }
}
