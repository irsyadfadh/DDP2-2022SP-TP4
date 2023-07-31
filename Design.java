public class Design extends Division {

    public Design(int baseSalary) {
        super(baseSalary);
    }

    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        employee.setDivision(this);
        //System.out.println(employee.getClass().getSimpleName() + " " + employee.getName() + " berhasil ditambahkan ke divisi Design");
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
        return "Divisi Design memiliki " + totalEmployees + " karyawan dengan " + totalManagers + " manager.";
    }

    @Override
    public String getName() {
        return "Design";
    }
}

