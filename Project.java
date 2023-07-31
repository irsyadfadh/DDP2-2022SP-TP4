import java.util.ArrayList;
import java.util.List;

public class Project {
    // TODO: Tambahkan modifier untuk atribut
    private String name;
    private Manager projectLeader;
    private List<Employee> memberList;

    // TODO: Lengkapi constructor
    public Project(String name) {
        this.name = name;
        this.memberList = new ArrayList<>();
    }

    /*Method untuk menambahkan anggota proyek. */
    public void addMember(Employee employee) {
        if (employee instanceof Manager && projectLeader == null) {
            projectLeader = (Manager) employee;
            employee.addProject(new Project(name));
            //System.out.println(employee.getName() + " di-assign sebagai Project Leader untuk proyek " + name);
        } else {
            memberList.add(employee);
            employee.addProject(new Project(name));
            //System.out.println(employee.getName() + " berhasil ditambahkan ke proyek " + name);
        }
    }


    /*Method untuk menghapus anggota proyek. */
    public void removeMember(Employee employee) {
        if (employee instanceof Manager && employee.equals(projectLeader)) {
            projectLeader = null;
            System.out.println(employee.getName() + " dihapus sebagai Project Leader dari proyek " + name);
        } else {
            if (memberList.remove(employee)) {
                System.out.println(employee.getName() + " berhasil dihapus dari proyek " + name);
            } else {
                System.out.println(employee.getName() + " tidak ditemukan di proyek " + name);
            }
        }
    }

    // tambahan
    // Method untuk mendapatkan nama proyek
    public String getName() {
        return name;
    }

    // Getter untuk mendapatkan objek projectLeader
    public Manager getProjectLeader() {
        return projectLeader;
    }

    // Setter untuk mengatur objek projectLeader
    public void setProjectLeader(Manager projectLeader) {
        this.projectLeader = projectLeader;
    }

    // Getter untuk mendapatkan list memberList
    public List<Employee> getMemberList() {
        return memberList;
    }
    // Setter untuk mengatur daftar anggota proyek
    public void setMemberList(List<Employee> memberList) {
        this.memberList = memberList;
    }
    
}
