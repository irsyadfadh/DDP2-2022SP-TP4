import java.util.ArrayList;
import java.util.List;

public class Division {
    // TODO: Tambahkan modifier untuk atribut
    private int baseSalary;
    private List<Employee> employeeList;

    // TODO: Lengkapi constructor
    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
        this.employeeList = new ArrayList<>();
    }

    // TODO: Lengkapi logika untuk menambahkan karyawan
    public void addEmployee(Employee employee) {
        if (employee instanceof Manager) {
            employeeList.add(0, employee); //menambahkan manager pada indeks terdepan
                        System.out.println("aadaa");

        } else {
            employeeList.add(employee);
            System.out.println("adaa");
        }
    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    // Method untuk mendapatkan nama divisi
    public String getName() {
        return "";

    }
    
}
 
