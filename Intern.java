public class Intern extends Employee {

    public Intern(String name, int yearsOfExperience, double salaryMultiplier) {
        super(name, yearsOfExperience, salaryMultiplier);
    }

    @Override
    public String toString() {
        // TODO
        return super.toString();
    }

    // Implementasi metode addProject untuk Intern
    @Override
    public void addProject(Project project) {
        if (getProjects().size() < 1) {
            super.addProject(project);
        } else {
            System.out.println("Intern " + getName() + " hanya dapat mengikuti satu proyek.");
        }
    }
}
