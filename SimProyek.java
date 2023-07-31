import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimProyek {
    List<Project> projectList = new ArrayList<>();
    List<Employee> employeeList = new ArrayList<>();
    List<Division> divisionList = new ArrayList<>();

    public static void main(String[] args) {
        SimProyek app = new SimProyek();
    app.mockDivisionData();

        // Gunakan ini jika ingin menggunakan data awalan
        // Tidak wajib digunakan
        app.mockData();

        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Selamat datang di SimProyek. Berikut adalah daftar proyek yang terdaftar dalam sistem.");
        
        // TODO: Tampilkan daftar proyek, lengkapi kode di dalam method printProjectList()
        app.printProjectList();

        do {
            app.printMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            int nomorPilihan;
            int nomorAnggota;
            String namaKaryawan;
            String jabatan;
            int lamaBekerja;
            double bonusGaji;
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama proyek: ");
                    String projectName = scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.createProject(projectName);

                    System.out.println();
                    break;
                case 2:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan nama karyawan yang ingin ditambahkan: ");
                    namaKaryawan = scanner.nextLine();
                    
                    // TODO: Kerjakan di dalam method ini
                    app.addProjectMember(nomorPilihan, namaKaryawan);

                    System.out.println();
                    break;
                case 3:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    app.printDivisionDetail(nomorPilihan);

                    System.out.print("Masukkan nomor anggota yang ingin dihapus: ");
                    nomorAnggota = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.deleteProjectMember(nomorPilihan, nomorAnggota);

                    System.out.println();
                    break;
                case 4:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.projectDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 5:
                    System.out.println("Daftar proyek pada sistem SimProyek");
                    app.printProjectList();

                    System.out.println();
                    break;
                case 6:
                    System.out.print("Nama karyawan: ");
                    namaKaryawan = scanner.nextLine();

                    System.out.print("Jabatan: ");
                    jabatan = scanner.nextLine();

                    System.out.print("Lama bekerja (tahun): ");
                    lamaBekerja = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Bonus gaji: ");
                    bonusGaji = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Divisi:");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");

                    System.out.print("Pilih divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.addEmployee(namaKaryawan, jabatan, lamaBekerja, bonusGaji, nomorPilihan);

                    System.out.println();
                    break;
                case 7:
                    System.out.println("Daftar karyawan pada sistem SimProyek ");
                    System.out.println("Nama - Divisi - Gaji - Proyek ");
                    for (int i = 0; i < app.employeeList.size(); i++) {
                        System.out.printf("%d. %s - Divisi %s - %d - %s \n", 
                            i+1, 
                            // TODO: lengkapi logika di masing-masing method
                            app.employeeList.get(i).getName(),
                            app.employeeList.get(i).getDivisionName(),
                            app.employeeList.get(i).calculateSalary(),
                            app.employeeList.get(i).getProjectsString()
                        );
                    }

                    System.out.println();
                    break;

                case 8:
                    System.out.println("Berikut adalah daftar divisi pada sistem SimProyek: ");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");


                    System.out.print("Pilih nomor divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: tampilkan detail divisi
                    app.printDivisionDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 99:
                    System.out.println("Terima kasih telah menggunakan SimProyek.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 99);
        scanner.close();
    }

    // Silahkan tambahkan method lain yang dirasa dapat membantu
    // Method untuk menampilkan daftar proyek beserta nomor urutannya tanpa menampilkan informasi detail seperti leader dan jumlah anggota proyek.
    private void printProjectListNumberOnly() {
        int projectNumber = 1;
        for (Project project : projectList) {
            System.out.println(projectNumber + ". " + project.getName());
            projectNumber++;
        }
    }
    /*Method untuk menampilkan detail divisi berdasarkan pilihan nomor divisi yang diberikan pengguna. */
    private void printDivisionDetail(int nomorPilihan) {
        if (nomorPilihan >= 1 && nomorPilihan <= divisionList.size()) {
            Division selectedDivision = divisionList.get(nomorPilihan - 1);
            System.out.println("Divisi " + selectedDivision.getName() + " memiliki " + (selectedDivision.getEmployeeList().size() - countManagers(selectedDivision)) +
                    " karyawan dan " + countManagers(selectedDivision) + " manager.");
    
            int employeeNumber = 1;
            for (Employee employee : selectedDivision.getEmployeeList()) {
                System.out.print(employeeNumber + ". " + employee.getName() + " - " + employee.calculateSalary() + " - ");
                List<Project> employeeProjects = getEmployeeProjects(employee);
                if (!employeeProjects.isEmpty()) {
                    System.out.print("Proyek ");
                    for (Project project : employeeProjects) {
                        System.out.print(project.getName() + ", ");
                    }
                    System.out.println();
                } else {
                    //System.out.println("Tidak memiliki proyek");
                }
                employeeNumber++;
            }
        } else {
            System.out.println("Input invalid. Kembali ke menu utama.");
        }
    }
    
    /*Method untuk menambahkan karyawan baru ke dalam sistem SimProyek.  */
    private void addEmployee(String namaKaryawan, String jabatan, int lamaBekerja, double bonusGaji, int nomorDivisi) {
        Employee newEmployee;
        if (jabatan.equalsIgnoreCase("Manager")) {
            newEmployee = new Manager(namaKaryawan, lamaBekerja, bonusGaji);
        } else if (jabatan.equalsIgnoreCase("Employee")) {
            newEmployee = new Employee(namaKaryawan, lamaBekerja, bonusGaji);
        } else if (jabatan.equalsIgnoreCase("Intern")) {
            newEmployee = new Intern(namaKaryawan, lamaBekerja, bonusGaji);
        } else {
            System.out.println("Jabatan tidak valid. Karyawan " + namaKaryawan + " tidak dapat ditambahkan.");
            return;
        }

        Division selectedDivision;
        switch (nomorDivisi) {
            case 1:
                selectedDivision = divisionList.get(0); // HRD
                break;
            case 2:
                selectedDivision = divisionList.get(1); // Marketing
                break;
            case 3:
                selectedDivision = divisionList.get(2); // Design
                break;
            case 4:
                selectedDivision = divisionList.get(3); // Engineer
                break;
            default:
                System.out.println("Divisi tidak valid. Karyawan " + namaKaryawan + " tidak dapat ditambahkan.");
                return;
        }
        selectedDivision.addEmployee(newEmployee);
        employeeList.add(newEmployee);
        System.out.println("Karyawan " + namaKaryawan + " berhasil ditambahkan ke divisi " + selectedDivision.getName() + ".");
    } 

    /*Method untuk menampilkan daftar proyek beserta informasi detailnya seperti leader dan jumlah anggota proyek. */
    private void printProjectList() {
        int projectNumber = 1;
        for (Project project : projectList) {
            System.out.println(projectNumber + ". " + project.getName());
            if (project.getProjectLeader() != null) {
                System.out.println("   Leader: " + project.getProjectLeader().getName());
            } else {
                System.out.println("   Leader: Tidak memiliki leader");
            }
            System.out.println("   Jumlah anggota: " + project.getMemberList().size());
            projectNumber++;
        }
    }
    /*Method untuk menampilkan detail proyek berdasarkan pilihan nomor proyek yang diberikan pengguna.  */
    private void projectDetail(int nomorPilihan) {
        if (projectList.isEmpty()) {
            System.out.println("Sistem SimProyek belum memiliki proyek.");
            return;
        }
        
        if (nomorPilihan >= 1 && nomorPilihan <= projectList.size()) {
            Project selectedProject = projectList.get(nomorPilihan - 1);
            System.out.println(selectedProject.getName());
            
            // Menampilkan leader dari proyek
            Employee projectLeader = selectedProject.getProjectLeader();
            if (projectLeader != null) {
                System.out.println("Leader: " + projectLeader.getName() + " - " + "Divisi " + projectLeader.getDivisionName());
            } else {
                System.out.println("Leader: Tidak memiliki leader");
            }
            
            // Menampilkan anggota dari proyek
            List<Employee> projectMembers = selectedProject.getMemberList();
            if (!projectMembers.isEmpty()) {
                System.out.println("Anggota:");
                int memberNumber = 1;
                for (Employee member : projectMembers) {
                    System.out.println(memberNumber + ". " + member.getName() + " - " + "Divisi " + member.getDivisionName());
                    memberNumber++;
                }
            } else {
                System.out.println("Anggota: Tidak memiliki anggota");
            }
        } else {
            System.out.println("Nomor proyek tidak valid.");
        }
    }
    
    /*Method untuk menghapus anggota proyek berdasarkan nomor proyek dan nomor anggota yang diberikan pengguna. */
    private void deleteProjectMember(int nomorPilihan, int nomorAnggota) {
        if (nomorPilihan >= 1 && nomorPilihan <= projectList.size()) {
            Project project = projectList.get(nomorPilihan - 1);
            // Periksa apakah nomorAnggota valid (antara 1 dan jumlah anggota proyek)
            try {
                Employee employeeToRemove = project.getMemberList().get(nomorAnggota - 1);
                project.removeMember(employeeToRemove);
                employeeToRemove.removeProject(project); 
                System.out.println("Anggota " + employeeToRemove.getName() + " berhasil dihapus dari proyek " + project.getName() + ".");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Gagal: Proyek " + project.getName() + " sudah tidak memiliki anggota.");
            }
            
        } else {
            System.out.println("Pilihan proyek tidak valid.");
        }
    }
    
    
    /*Method untuk menambahkan anggota ke proyek berdasarkan nomor proyek dan nama karyawan yang diberikan pengguna.  */
    private void addProjectMember(int nomorPilihan, String namaKaryawan) {
        if (nomorPilihan >= 1 && nomorPilihan <= projectList.size()) {
            Project project = projectList.get(nomorPilihan - 1);
            Employee existingEmployee = null;
            for (Employee employee : employeeList) {
                if (namaKaryawan.equalsIgnoreCase(employee.getName())) {
                    existingEmployee = employee;
                    break;
                } 
            }
    
            if (existingEmployee != null) {
                int jumlahMaksimumProject = 0;
                if (existingEmployee instanceof Manager) {
                    // Jika Manager belum menjadi leader di proyek lain miliknya, maka Manager tersebut akan menjadi leader
                    boolean isLeaderInOtherProject = false;
                    for (Project employeeProject : existingEmployee.getProjects()) {
                        if (employeeProject.getProjectLeader() == existingEmployee) {
                            isLeaderInOtherProject = true;
                            break;
                        }
                    }
                    if (!isLeaderInOtherProject && existingEmployee.getProjects().size() < Manager.MAX_PROJECTS) {
                        // Jika Manager belum menjadi leader di proyek lain dan masih dapat mengikuti proyek
                        project.setProjectLeader((Manager) existingEmployee);
                    }
                    jumlahMaksimumProject = Manager.MAX_PROJECTS;
                } else if (existingEmployee instanceof Employee) {
                    jumlahMaksimumProject = Employee.MAX_PROJECTS;
                } else if (existingEmployee instanceof Intern) {
                    jumlahMaksimumProject = Intern.MAX_PROJECTS;
                }
    
                if (countProjectsForEmployee(existingEmployee) > jumlahMaksimumProject) {
                    // Sudah mencapai batas maksimum proyek yang dapat diikuti
                    System.out.println("Gagal: Karyawan " + existingEmployee.getName() + " hanya dapat mengikuti " + jumlahMaksimumProject + " proyek.");
                } else if (project.getMemberList().contains(existingEmployee)) {
                    // Sudah merupakan anggota proyek
                    System.out.println("Gagal: Karyawan " + existingEmployee.getName() + " sudah merupakan anggota dari proyek " + project.getName() + ".");
                } else {
                    // Bisa ditambahkan ke proyek
                    project.addMember(existingEmployee);
                    existingEmployee.addProject(project);
                    System.out.println("Karyawan " + existingEmployee.getName() + " berhasil ditambahkan ke proyek " + project.getName() + ".");
                }
            } else {
                System.out.println("Gagal: Karyawan dengan nama " + namaKaryawan + " tidak ditemukan.");
            }
        } else {
            // Pilihan proyek tidak valid
            System.out.println("Input invalid. Kembali ke menu utama.");
        }
    }
    
    
    /*Method untuk membuat proyek baru berdasarkan nama proyek yang diberikan pengguna.  */
    private void createProject(String projectName) {
        boolean projectExist = false;
        for (Project project : projectList) {
            if (project.getName().equalsIgnoreCase(projectName)) {
                System.out.println("Gagal: " + projectName + " telah terdaftar di dalam sistem");
                projectExist = true;
                break;
            }
        }
        if (projectExist == false) {
            Project newProject = new Project(projectName);
            projectList.add(newProject);
            System.out.println("Proyek " + projectName + " berhasil ditambahkan ke dalam sistem.");
        }
    }
    // method tambahan
    // Metode untuk menghitung jumlah proyek yang telah diikuti oleh suatu karyawan
    private int countProjectsForEmployee(Employee employee) {
        int count = 0;
        for (Project project : projectList) {
            if (project.getProjectLeader() != null && project.getProjectLeader().equals(employee)) {
                count++;
            }
            for (Employee member : project.getMemberList()) {
                if (member.equals(employee)) {
                    count++;
                }
            }
        }
        return count;
    }
    /*Method untuk menghitung jumlah manajer dalam suatu divisi. */
    private int countManagers(Division division) {
        int count = 0;
        for (Employee employee : division.getEmployeeList()) {
            if (employee instanceof Manager) {
                count++;
            }
        }
        return count;
    }
    /*Method untuk mendapatkan daftar proyek yang diikuti oleh suatu karyawan. */
    private List<Project> getEmployeeProjects(Employee employee) {
        List<Project> employeeProjects = new ArrayList<>();
        for (Project project : projectList) {
            if (project.getProjectLeader() == employee || project.getMemberList().contains(employee)) {
                employeeProjects.add(project);
            }
        }
        return employeeProjects;
    }

    
    /*Method print menu */
     private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah proyek        ");
        System.out.println("2. Tambah anggota proyek");
        System.out.println("3. Hapus anggota proyek ");
        System.out.println("4. Detail proyek        ");
        System.out.println("5. Daftar proyek        ");
        System.out.println("6. Tambah karyawan      ");
        System.out.println("7. Daftar karyawan      ");
        System.out.println("8. Detail divisi        ");
        System.out.println("99. Keluar              ");
        System.out.print("Pilih menu: ");
    }
    /*Method untuk menginisialisasi daftar divisi dalam sistem SimProyek. */
    private void mockDivisionData() {
        Division hrd = new HRD(5000000);
        Division marketing = new Marketing(7000000);
        Division design = new Design(6000000);
        Division engineering = new Engineering(8000000);

        divisionList.add(hrd);
        divisionList.add(marketing);
        divisionList.add(design);
        divisionList.add(engineering);
    }
    /*Method untuk menginisialisasi data awalan dalam sistem SimProyek.  */
    // Method ini digunakan untuk menambahkan karyawan dan proyek-proyek ke dalam sistem sebagai contoh data awal
    private void mockData() {
        Division hrd = this.divisionList.get(0);
        Division marketing = this.divisionList.get(1);
        Division design = this.divisionList.get(2);

        Manager budi = new Manager("Budi", 3, 0.2);
        Manager ica = new Manager("Ica", 5, 0.3);
        Manager andi = new Manager("Andi", 4, 0.25);

        Employee udin = new Employee("Udin", 2, 0.1);
        Employee fira = new Employee("Fira", 1, 0.05);
        Employee opet = new Employee("Opet", 3, 0.15);
        Employee mirna = new Employee("Mirna", 4, 0.2);
        Employee asep = new Employee("Asep", 2, 0.1);
        Employee yudi = new Employee("Yudi", 1, 0.05);
        Employee deni = new Employee("Deni", 3, 0.15);
        Employee tina = new Employee("Tina", 2, 0.1);

        this.employeeList.add(budi);
        this.employeeList.add(ica);
        this.employeeList.add(andi);
        this.employeeList.add(udin);
        this.employeeList.add(fira);
        this.employeeList.add(opet);
        this.employeeList.add(mirna);
        this.employeeList.add(asep);
        this.employeeList.add(yudi);
        this.employeeList.add(deni);
        this.employeeList.add(tina);
        
        hrd.addEmployee(budi);
        hrd.addEmployee(udin);
        hrd.addEmployee(fira);
        hrd.addEmployee(opet);

        marketing.addEmployee(ica);
        marketing.addEmployee(mirna);
        marketing.addEmployee(asep);
        marketing.addEmployee(yudi);

        design.addEmployee(andi);
        design.addEmployee(deni);
        design.addEmployee(tina);

        Project ufoProject = new Project("Proyek UFO");
        Project saladProject = new Project("Proyek Franchise Salad Buah Tanpa Semangka dan Melon");
        Project compfestProject = new Project("Website COMPFEST");

        ufoProject.addMember(budi);
        ufoProject.addMember(udin);
        ufoProject.addMember(fira);
        ufoProject.addMember(opet);

        saladProject.addMember(ica);
        saladProject.addMember(mirna);
        saladProject.addMember(asep);
        saladProject.addMember(yudi);

        compfestProject.addMember(andi);
        compfestProject.addMember(deni);
        compfestProject.addMember(tina);

        this.projectList.add(ufoProject);
        this.projectList.add(saladProject);
        this.projectList.add(compfestProject);
    }
}
