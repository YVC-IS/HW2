package data;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class User {
    @CsvBindByName
    private String type;

    @CsvBindByName
    private String user;

    @CsvBindByName
    private String pass;

    public String getType() {
        return this.type;
    }

    public String getUser() {
        return this.user;
    }

    public String getPass() {
        return this.pass;
    }

    @Override
    public String toString() {
        return String.format("User { type: %s | user: %s | pass: %s }", this.type, this.user, this.pass);
    }

    public static List<User> read() throws IOException {
        try (Reader reader = new FileReader("users.csv")) {
            return new CsvToBeanBuilder<User>(reader).withType(User.class).build().parse();
        }
    }
}
