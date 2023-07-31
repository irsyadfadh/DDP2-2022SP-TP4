import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int yearsOfExperience;
    private double salaryMultiplier;
    private Division division;
    private List<Project> projects;

    public static final int MAX_PROJECTS = 2;

    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = salaryMultiplier;
        this.projects = new ArrayList<>();
    }

    public int calculateSalary() {
        return (int) (division.getBaseSalary() * (1 + salaryMultiplier + yearsOfExperience / 10));
    }

    public String getDivisionName() {
        if (division != null) {
            return division.getName();
        } else {
            return "Nama Divisi Tidak Diketahui";
        }
    }

    public String getProjectsString() {
        StringBuilder projectsString = new StringBuilder();
        if (!projects.isEmpty()) {
            for (Project project : projects) {
                projectsString.append(project.getName()).append(", ");
            }
            // Menghapus koma dan spasi terakhir
            projectsString.setLength(projectsString.length() - 2);
        } else {
            projectsString.append("Tidak sedang memegang proyek");
        }
        return projectsString.toString();
    }
    
    

    public String getName() {
        return name;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        if (projects.size() > MAX_PROJECTS) {
            //System.out.println("Karyawan " + name + " hanya dapat mengikuti dua proyek.");
            return;
        } else {
            projects.add(project);
        }
    }

    @Override
    public String toString() {
        return name + " - " + calculateSalary() + " - " + getProjectsString();
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project) {
    }
    
}
