import java.util.List;

public class Project {
    // TODO: Tambahkan modifier untuk atribut
    private String name;
    private Manager projectLeader;
    private List<Employee> memberList;

    // TODO: Lengkapi constructor
    public Project(String name) {
        this.name = name;
    }

    // TODO: Lengkapi logika menambahkan anggota proyek
    public void addMember(Employee employee) {
        if (employee instanceof Manager) {
            if (projectLeader == null) {
                projectLeader = (Manager) employee;
            } else {
                System.out.println("Manager " + employee.getName() + " tidak dapat menjadi leader proyek karena sudah menjadi leader di proyek lain.");
                return;
            }
        }
        memberList.add(employee);
    }

    // TODO: Lengkapi logika menghapus anggota proyek
    public void removeMember(Employee employee) {
        if (employee.equals(projectLeader)) {
            System.out.println("Manager " + employee.getName() + " tidak dapat dihapus dari proyek karena merupakan project leader.");
            return;
        }
        memberList.remove(employee);
    }
}
