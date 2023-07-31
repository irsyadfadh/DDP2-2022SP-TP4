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
    /* Method untuk menghitung gaji karyawan. */
    public int calculateSalary() {
        return (int) (division.getBaseSalary() * (1 + salaryMultiplier + yearsOfExperience / 10));
    }
    /*Method untuk mendapatkan nama divisi tempat karyawan bekerja. */
    public String getDivisionName() {
        if (division != null) {
            return division.getName();
        } else {
            return "Nama Divisi Tidak Diketahui";
        }
    }
    /*Method untuk mendapatkan string yang berisi daftar nama proyek yang dipegang oleh karyawan. */
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
    
    
    //getter nama karyawan
    public String getName() {
        return name;
    }
    //Getter untuk mendapatkan objek divisi tempat karyawan bekerja.
    public Division getDivision() {
        return division;
    }
    //Setter untuk mengatur divisi tempat karyawan bekerja.
    public void setDivision(Division division) {
        this.division = division;
    }
    //Getter untuk mendapatkan daftar proyek yang dipegang oleh karyawan.
    public List<Project> getProjects() {
        return projects;
    }
    //Method untuk menambahkan proyek ke daftar proyek yang dipegang oleh karyawan.
    public void addProject(Project project) {
        if (projects.size() > MAX_PROJECTS) {
            //System.out.println("Karyawan " + name + " hanya dapat mengikuti dua proyek.");
            return;
        } else {
            projects.add(project);
        }
    }

    @Override
    /*Override method untuk menghasilkan representasi string dari objek Employee. */
    public String toString() {
        return name + " - " + calculateSalary() + " - " + getProjectsString();
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project) {
    }
    
}
