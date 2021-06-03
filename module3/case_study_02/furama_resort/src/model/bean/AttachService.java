package model.bean;

public class AttachService {
    private int idAttach;
    private String nameAttach;
    private double costAttach;
    private int unitAttach;

    public AttachService(int idAttach, String nameAttach, double costAttach, int unitAttach) {
        this.idAttach = idAttach;
        this.nameAttach = nameAttach;
        this.costAttach = costAttach;
        this.unitAttach = unitAttach;
    }

    public int getIdAttach() {
        return idAttach;
    }

    public void setIdAttach(int idAttach) {
        this.idAttach = idAttach;
    }

    public String getNameAttach() {
        return nameAttach;
    }

    public void setNameAttach(String nameAttach) {
        this.nameAttach = nameAttach;
    }

    public double getCostAttach() {
        return costAttach;
    }

    public void setCostAttach(double costAttach) {
        this.costAttach = costAttach;
    }

    public int getUnitAttach() {
        return unitAttach;
    }

    public void setUnitAttach(int unitAttach) {
        this.unitAttach = unitAttach;
    }
}
