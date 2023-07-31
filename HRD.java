public class HRD extends Division {
    public HRD(int baseSalary) {
        super(baseSalary);
    }

    @Override
    /*Override method untuk menambahkan karyawan ke dalam daftar karyawan divisi HRD. */
    public void addEmployee(Employee employee) {
        employee.setDivision(this);
        super.addEmployee(employee);
        //System.out.println(employee.getClass().getSimpleName() + " " + employee.getName() + " berhasil ditambahkan ke divisi HRD");
    }

    @Override
    /*Override method untuk menghasilkan representasi string dari objek HRD. */
    public String toString() {
        int totalEmployees = getEmployeeList().size();
        int totalManagers = 0;
        for (Employee employee : getEmployeeList()) {
            if (employee instanceof Manager) {
                totalManagers++;
            }
        }
        return "Divisi HRD memiliki " + totalEmployees + " karyawan dengan " + totalManagers + " manager.";
    }

    @Override
    /*override method untuk mendapatkan nama divisi HRD */
    public String getName() {
        return "HRD";
    }
}
