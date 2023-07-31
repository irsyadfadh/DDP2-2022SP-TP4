import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int yearsOfExperience;
    private double salaryMultiplier;
    private Division division;
    private List<Project> projects;
    private String position;

    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = salaryMultiplier;
        this.projects = new ArrayList<>();
    }

    public int calculateSalary() {
        int baseSalary = this.division.getBaseSalary();
        int experienceBonus = (int) (baseSalary * (0.1 * yearsOfExperience));
        int positionBonus = (int) (baseSalary * salaryMultiplier);
        return baseSalary + experienceBonus + positionBonus;
    }

    public String getDivisionName() {
        return division.getClass().getSimpleName();
    }

    public String getProjectsString() {
        StringBuilder projectListString = new StringBuilder();
        for (Project project : projects) {
            projectListString.append(project.getName()).append(", ");
        }
        if (projectListString.length() > 2) {
            projectListString.setLength(projectListString.length() - 2);
        }
        return projectListString.toString();
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Metode untuk menambahkan proyek ke dalam projects
    public void addProject(Project project) {
        if (projects.size() < 2) {
            projects.add(project);
        } else {
            System.out.println("Karyawan " + name + " hanya dapat mengikuti dua proyek.");
        }
    }
}
