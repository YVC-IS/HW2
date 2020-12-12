package model;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Admin extends Person {
    private static Set<Admin> set = new HashSet<>();

    public Admin(int id, String name, Date birthdate, String username, String password) {
        super(id, name, birthdate, username, password);
        Admin.set.add(this);
    }

    public Admin(String name, Date birthdate, String username, String password) {
        this(Admin.set.size() + 1, name, birthdate, username, password);
    }

    public static Set<Admin> getAdmins() {
        return Admin.set;
    }

    public static void read() throws IOException {
        try (Reader reader = new FileReader("csv/admins.csv")) {
            List<Admin> admins = new CsvToBeanBuilder<Admin>(reader).withType(Admin.class).build().parse();
            Admin.set = new HashSet<>(admins);
        }
    }

    @Override
    public String toString() {
        return String.format("Admin { %s }", super.toString());
    }
}
