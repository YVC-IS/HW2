package application;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class User {
    @CsvBindByName
    private String user;
    @CsvBindByName
    private String pass;
    @CsvBindByName
    private String type;

    @Override
    public String toString() {
        return String.format("User { user: %s | pass: %s | type: %s }", this.user, this.pass, this.type);
    }

    public static List<User> read() throws IOException {
        try (Reader reader = new FileReader("users.csv")) {
            return new CsvToBeanBuilder<User>(reader).withType(User.class).build().parse();
        }
    }
}
