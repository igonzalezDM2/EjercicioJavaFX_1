package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ObiWan extends Application {
	private TextField tfNombre;
	private Stage stage;
	private Scene ventanaPrincipal;
    public static void main(String[] args) {
        Application.launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage; 
		VBox contenedor = new VBox(); //Contenedor principal
		
		//Campo de texto para el nombre
		tfNombre = new TextField();
		tfNombre.getProperties().put("microHelpText", "Inserte el nombre");
		tfNombre.textProperty().addListener((observable, oldValue, newValue) -> comprobarNombre());
		tfNombre.setOnInputMethodTextChanged((event) -> comprobarNombre());
		
		//Botón cerrar
		Button btnCerrar = new Button("Cerrar");
		btnCerrar.setOnAction((event) -> Platform.exit());
		
		contenedor.getChildren().addAll(tfNombre, btnCerrar);
		
		ventanaPrincipal = new Scene(contenedor, 400, 300);
		
//	    String url = getClass().getResource("/css/botones.css").toString();
//	    ventanaPrincipal.getStylesheets().add(url);
	
		stage.setResizable(false);
		stage.setScene(ventanaPrincipal);
		stage.setTitle("ObiWan");
		stage.show();
		
		
	}
	
	private void comprobarNombre() {
		Stage nuevoStage = new Stage();
		String nombreIntroducido = tfNombre.getText();
		if (nombreIntroducido != null && nombreIntroducido.equalsIgnoreCase("OBI WAN")) {
			VBox contenedorDeNombre = new VBox();
			Label mensaje = new Label("¡General Kenobi!");
			contenedorDeNombre.getChildren().add(mensaje);
			Scene scene = new Scene(contenedorDeNombre, 200, 200);
			mensaje.setFont(new Font(20));
			nuevoStage.setResizable(false);
			nuevoStage.setScene(scene);
			nuevoStage.setTitle("Hola Obi Wan");
			nuevoStage.show();
		}
		
		
	}
    
}
