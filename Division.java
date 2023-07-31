import java.util.ArrayList;
import java.util.List;

public class Division {
    // TODO: Tambahkan modifier untuk atribut
    private int baseSalary;
    private List<Employee> employeeList;

    // Constructor
    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
        this.employeeList = new ArrayList<>();
    }

    /*Method untuk menambahkan karyawan ke dalam daftar karyawan divisi ini. */
    public void addEmployee(Employee employee) {
        if (employee instanceof Manager) {
            employeeList.add(0, employee); //menambahkan manager pada indeks terdepan

        } else {
            employeeList.add(employee);
        }
    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan
    /*Getter untuk mendapatkan daftar karyawan pada divisi */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    /*Getter untuk mendapatkan gaji dasar (base salary) */
    public int getBaseSalary() {
        return baseSalary;
    }

    // Method untuk mendapatkan nama divisi
    public String getName() {
        return "";

    }
    
}
 
