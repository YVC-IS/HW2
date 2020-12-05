package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	private static Stage stage;
	private static Scene login;
	private static Scene admin;

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

		Parent admin = FXMLLoader.load(cls.getResource("/view/AdminPage.fxml"));
		Main.admin = new Scene(admin);
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
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
