package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.Admin;

import java.sql.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class Main extends Application {
	private static Stage stage;
	private static Scene login;
	private static Scene admin;
	private static Scene lecturer;
	private static Scene practitioner;
	private static Scene student;

	@Override
	public void start(Stage stage) throws Exception {
		Main.stage = stage;
		Main.load(this.getClass());
		Main.load("Login");
		Main.stage.show();
	}

	private static void load(final Class<?> cls) throws IOException {
		Parent login = FXMLLoader.load(cls.getResource("/view/Login.fxml"));
		Main.login = new Scene(login);
		Main.login.getStylesheets().add("/application/application.css");

//		Parent admin = FXMLLoader.load(cls.getResource("/view/Admin.fxml"));
//		Main.admin = new Scene(admin);
//		Main.admin.getStylesheets().add("/application/application.css");

		Parent lecturer = FXMLLoader.load(cls.getResource("/view/Lecturer.fxml"));
		Main.lecturer = new Scene(lecturer);
		Main.lecturer.getStylesheets().add("/application/application.css");

		Parent practitioner = FXMLLoader.load(cls.getResource("/view/Lecturer.fxml"));
		Main.practitioner = new Scene(practitioner);
		Main.practitioner.getStylesheets().add("/application/application.css");

		Parent student = FXMLLoader.load(cls.getResource("/view/Student.fxml"));
		Main.student = new Scene(student);
		Main.student.getStylesheets().add("/application/application.css");
	}

	public static void load(String key) {
		switch (key) {
			case "Login" -> {
				Main.stage.setTitle("Login");
				Main.stage.setScene(Main.login);
			}
			case "Admin" -> {
				Main.stage.setTitle("Admin");
				Main.stage.setScene(Main.admin);
			}
			case "Lecturer" -> {
				Main.stage.setTitle("Lecturer");
				Main.stage.setScene(Main.lecturer);
			}
			case "Practitioner" -> {
				Main.stage.setTitle("Practitioner");
				Main.stage.setScene(Main.practitioner);
			}
			case "Student" -> {
				Main.stage.setTitle("Student");
				Main.stage.setScene(Main.student);
			}
		}
	}

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2020,7,24);
		System.out.println(localDate);
//		try {
//			Admin.read();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		System.out.println(Arrays.toString(Admin.getAdmins().toArray()));
		Application.launch(args);
	}
}
