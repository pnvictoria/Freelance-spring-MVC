package ua.edu.sumdu.ponomarenko.models;

public class Skills {
    //skills_id
    private int skillsId;
    //skills_title
    private String skillsTitle;
    //specialization_fk
    private Specialization specialization;

    public Skills() {
    }

    public Skills(int skillsId, String skillsTitle, Specialization specialization) {
        this.skillsId = skillsId;
        this.skillsTitle = skillsTitle;
        this.specialization = specialization;
    }

    public int getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(int skillsId) {
        this.skillsId = skillsId;
    }

    public String getSkillsTitle() {
        return skillsTitle;
    }

    public void setSkillsTitle(String skillsTitle) {
        this.skillsTitle = skillsTitle;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
