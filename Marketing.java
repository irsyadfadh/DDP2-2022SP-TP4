public class Marketing extends Division {

    public Marketing(int baseSalary) {
        super(baseSalary);
    }

    @Override
    /*Override method untuk menambahkan karyawan ke dalam daftar karyawan divisi Marketing */
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        employee.setDivision(this);
        //System.out.println(employee.getClass().getSimpleName() + " " + employee.getName() + " berhasil ditambahkan ke divisi Marketing");
    }

    @Override
    /* Override method untuk menghasilkan representasi string dari objek Marketing. */
    public String toString() {
        int totalEmployees = getEmployeeList().size();
        int totalManagers = 0;
        for (Employee employee : getEmployeeList()) {
            if (employee instanceof Manager) {
                totalManagers++;
            }
        }
        return "Divisi Marketing memiliki " + totalEmployees + " karyawan dengan " + totalManagers + " manager.";
    }

    @Override
    public String getName() {
        return "Marketing";
    }
}
