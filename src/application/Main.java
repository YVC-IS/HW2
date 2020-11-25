package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stage;
	private static Stage newStage;
	
	private static Scene menuLogin;
	private static Scene adminLogin;
	private static Scene loginScene;


	@Override
	/*
	 * public void start(Stage primaryStage) { try { BorderPane root = new
	 * BorderPane(); root =
	 * (BorderPane)FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
	 * Scene scene = new Scene(root);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); }
	 * catch(Exception e) { e.printStackTrace(); } }
	 */
	
	
	
public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
		primaryStage.setTitle("Main Login");
		
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		menuLogin = new Scene(fxmlLogin);
		
		Parent fxmlAdminLogin = FXMLLoader.load(getClass().getResource("/view/AdminLogin.fxml"));
		adminLogin = new Scene(fxmlAdminLogin);
		
		stage.setScene(menuLogin); 
		stage.show();
	}
	
	
	
	public static void menuSwitch(String request)
	{
		switch (request) {
		
		case "Admin":
			stage.setScene(adminLogin);
			break;		
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void newStage() {
		
		newStage = new Stage();
		newStage.initModality(Modality.APPLICATION_MODAL);
	}

	
}
