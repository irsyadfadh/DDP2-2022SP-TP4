public class Manager extends Employee {

    public Manager(String name, int yearsOfExperience, double salaryMultiplier) {
        super(name, yearsOfExperience, salaryMultiplier);
    }

    @Override
    public String toString() {
        // TODO
        return super.toString();
    }

    // Implementasi metode addProject untuk Manager
    @Override
    public void addProject(Project project) {
        if (getProjects().size() < 3) {
            super.addProject(project);
        } else {
            System.out.println("Manager " + getName() + " hanya dapat mengikuti tiga proyek.");
        }
    }
}
