public class Engineering extends Division {

    public Engineering(int baseSalary) {
        super(baseSalary);
    }

    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        System.out.println(employee.getPosition() + " " + employee.getName() + " berhasil ditambahkan ke divisi Engineering");
    }

    @Override
    public String toString() {
        int totalEmployees = getEmployeeList().size();
        int totalManagers = 0;

        // Count the number of managers in the division
        for (Employee employee : getEmployeeList()) {
            if (employee.getPosition().equalsIgnoreCase("Manager")) {
                totalManagers++;
            }
        }

        return "Divisi Engineering memiliki " + totalEmployees + " karyawan dengan " + totalManagers + " manager.";
    }
}
