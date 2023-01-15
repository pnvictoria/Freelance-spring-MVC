package ua.edu.sumdu.ponomarenko.models;

public class Specialization {

    private int specializationId;
    private String specializationTitle;

    public Specialization() {
    }

    public Specialization(int specializationId, String specializationTitle) {
        this.specializationId = specializationId;
        this.specializationTitle = specializationTitle;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationTitle() {
        return specializationTitle;
    }

    public void setSpecializationTitle(String specializationTitle) {
        this.specializationTitle = specializationTitle;
    }
}
