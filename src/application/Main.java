package application;
	
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	private static Stage stage;
	private static Scene menuLogin;
	private static Scene adminLogin;
	private static Scene teacherLogin;
	private static Scene studentLogin;

	@Override
	public void start(Stage primaryStage) throws Exception {


		stage = primaryStage;
		primaryStage.setTitle("Main Login");
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		menuLogin = new Scene(fxmlLogin);
		Parent fxmlAdminLogin = FXMLLoader.load(getClass().getResource("/view/AdminPage.fxml"));
		adminLogin = new Scene(fxmlAdminLogin);
		Parent fxmlTeacherLogin = FXMLLoader.load(getClass().getResource("/view/TeacherPage.fxml"));
		teacherLogin = new Scene(fxmlTeacherLogin);
		Parent fxmlStudentLogin = FXMLLoader.load(getClass().getResource("/view/StudentPage.fxml"));
		studentLogin = new Scene(fxmlStudentLogin);
		stage.setScene(menuLogin); 
		stage.show();
	}

	public static void menuSwitch(String request)
	{
		switch (request) {
			case "Menu" -> stage.setScene(menuLogin);
			case "Admin" -> stage.setScene(adminLogin);
			case "Teacher" -> stage.setScene(teacherLogin);
			case "Student" -> stage.setScene(studentLogin);
		}
	}
	
	public static void main(String[] args) {
		try {
			List<User> users = User.read();

			for (User user : users)
				System.out.println(user);

			launch(args);
		}
		catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
