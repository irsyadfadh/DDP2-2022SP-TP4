public class Engineering extends Division {

    public Engineering(int baseSalary) {
        super(baseSalary);
    }

    @Override
    /*Override method untuk menambahkan karyawan ke dalam daftar karyawan divisi Engineering. */
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        employee.setDivision(this);
        //System.out.println(employee.getClass().getSimpleName() + " " + employee.getName() + " berhasil ditambahkan ke divisi Engineering");
    }

    @Override
    /*Override method untuk menghasilkan representasi string dari objek Engineering. */
    public String toString() {
        int totalEmployees = getEmployeeList().size();
        int totalManagers = 0;
        for (Employee employee : getEmployeeList()) {
            if (employee instanceof Manager) {
                totalManagers++;
            }
        }
        return "Divisi Engineering memiliki " + totalEmployees + " karyawan dengan " + totalManagers + " manager.";
    }

    @Override
    /*Override method untuk mendapatkan nama divisi Engineering. */
    public String getName() {
        return "Engineering";
    }
}
