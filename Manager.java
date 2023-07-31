public class Manager extends Employee {

    public static final int MAX_PROJECTS = 3;
    
    public Manager(String name, int yearsOfExperience, double salaryMultiplier) {
        super(name, yearsOfExperience, salaryMultiplier);
    }

    @Override
    public String toString() {
        // TODO
        return super.toString();
    }

    //tambahan
    public void addProject(Project project) {
        // Periksa apakah manager sudah mengikuti 3 proyek
        if (getProjects().size() > MAX_PROJECTS) {
            //System.out.println("Manager " + getName() + " hanya dapat mengikuti tiga proyek.");
            return;
        } else {
            // Tambahkan proyek ke dalam daftar proyek manager (mengambil method dari employee.java)
            super.addProject(project);  
        }

    }
}