package application;
	
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.Data;

public class Main extends Application {
	private static Stage stage;
	private static Scene login;
	private static Scene admin;
	private static Scene studentPage;
	private static Scene lecturerPage;
	private static StackPane pane = new StackPane();
	private static List <Data> data;


	@Override
	public void start(Stage stage) throws Exception {
		Main.stage = stage;
		Main.load(this.getClass());
		Main.load("Login", null);
		Main.stage.show();
	}

	private static void load(final Class<?> cls) throws IOException {

		// -- -- -- -- -- This is a Pages creator

		Parent login = FXMLLoader.load(cls.getResource("/view/Login.fxml"));
		Main.login = new Scene(login);
		Main.login.getStylesheets().add("/application/application.css");


		Parent admin = FXMLLoader.load(cls.getResource("/view/AdminPage.fxml"));
		Main.admin = new Scene(admin);
		Main.admin.getStylesheets().add("/application/application.css");


		Parent student = FXMLLoader.load(cls.getResource("/view/StudentPage.fxml"));
		Main.studentPage = new Scene(student);
		Main.studentPage.getStylesheets().add("/application/application.css");


		Parent lecturer = FXMLLoader.load(cls.getResource("/view/LecturerPage.fxml"));
		Main.lecturerPage = new Scene(lecturer);
		Main.lecturerPage.getStylesheets().add("/application/application.css");
	}

	public static void load(String key, List<Data> data) {
		switch (key) {
			case "Login" -> {
				Main.stage.setTitle("Login");
				Main.stage.setScene(Main.login);
			}
			case "Admin" -> {
				Main.stage.setTitle("Admin");
				Main.stage.setScene(Main.admin);
			}
			case "Student" -> {
				Main.stage.setTitle("Student's page");
				Main.stage.setScene(Main.studentPage);
			}
			case "Lecturer" -> {
				Main.stage.setTitle("Lecturer's Page");
				Main.stage.setScene(Main.lecturerPage);
			}



		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
