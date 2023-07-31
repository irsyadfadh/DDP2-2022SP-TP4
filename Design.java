public class Design extends Division {

    public Design(int baseSalary) {
        super(baseSalary);
    }

    @Override
    /*Override method untuk menambahkan karyawan ke dalam daftar karyawan divisi Design */
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        employee.setDivision(this);
    }

    @Override
    /*Override method untuk menghasilkan representasi string dari objek Design. */
    public String toString() {
        int totalEmployees = getEmployeeList().size();
        int totalManagers = 0;
        for (Employee employee : getEmployeeList()) {
            if (employee instanceof Manager) {
                totalManagers++;
            }
        }
        return "Divisi Design memiliki " + totalEmployees + " karyawan dengan " + totalManagers + " manager.";
    }

    @Override
    /*Override method untuk mendapatkan nama divisi Design. */
    public String getName() {
        return "Design";
    }
}

