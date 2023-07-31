public class Intern extends Employee {

    public static final int MAX_PROJECTS = 1;

    public Intern(String name, int yearsOfExperience, double salaryMultiplier) {
        super(name, yearsOfExperience, salaryMultiplier);
    }

    @Override
    /*Override method untuk menghasilkan representasi string dari objek Intern. */
    public String toString() {
        // TODO
        return super.toString();
    }

    //tambahan
    /*Method untuk menambahkan proyek ke daftar proyek yang dipegang oleh intern. */
    public void addProject(Project project) {
        // Periksa apakah intern sudah mengikuti 1 proyek
        if (getProjects().size() > MAX_PROJECTS) {
            //System.out.println("Intern " + getName() + " hanya dapat mengikuti satu proyek.");
            return;
        } else {
            // Tambahkan proyek ke dalam daftar proyek intern
            super.addProject(project);
        }

    }
}
