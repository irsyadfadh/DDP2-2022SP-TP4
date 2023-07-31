public class HRD extends Division {
    public HRD(int baseSalary) {
        super(baseSalary);
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setDivision(this);
        super.addEmployee(employee);
        //System.out.println(employee.getClass().getSimpleName() + " " + employee.getName() + " berhasil ditambahkan ke divisi HRD");
    }

    @Override
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
    public String getName() {
        return "HRD";
    }
}
