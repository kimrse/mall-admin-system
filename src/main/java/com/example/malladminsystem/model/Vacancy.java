package com.example.malladminsystem.model;

public class Vacancy {

    private Long idVacancy;
    private Long idStore;
    private String vacancyTitle;
    private String vacancyDescription;
    private Double salary;
    private boolean isActive;
    public Long getIdVacancy() {
        return idVacancy;
    }
    public Long getIdStore() {
        return idStore;
    }
    public void setIdStore(Long idStore) {
        this.idStore = idStore;
    }
    public String getVacancyTitle() {
        return vacancyTitle;
    }
    public void setVacancyTitle(String vacancyTitle) {
        this.vacancyTitle = vacancyTitle;
    }
    public String getVacancyDescription() {
        return vacancyDescription;
    }
    public void setVacancyDescription(String vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

}
