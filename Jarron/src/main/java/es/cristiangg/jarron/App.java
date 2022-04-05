package es.cristiangg.jarron;


import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    int jarronActual = 0;

    @Override
    public void start(Stage stage) {
//        StackPane root = new StackPane();
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
              
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        HBox botonesSuperior = new HBox();
        botonesSuperior.setAlignment(Pos.TOP_CENTER);
        botonesSuperior.setSpacing(20);
        root.getChildren().add(botonesSuperior);
        
        VBox textoLabel = new VBox();
        textoLabel.setAlignment(Pos.CENTER);
        textoLabel.setSpacing(20);
        root.getChildren().add(textoLabel);
                      
        HBox botonesBajo = new HBox();
        botonesBajo.setAlignment(Pos.CENTER);
        botonesBajo.setSpacing(20);
        root.getChildren().add(botonesBajo);
        
        Jarron jarron1 = new Jarron();
        jarron1.setTitulo("Listas en Java");
        jarron1.setAutor("Juan");
        jarron1.setCodigo("numeros");
        System.out.println(jarron1.getTitulo());
        System.out.println(jarron1.getTitulo());
        
        Jarron jarron2 = new Jarron();
        jarron2.setTitulo("Listas en Clases");
        jarron2.setAutor("Luis Martin");
        jarron2.setCodigo("listanumero");
        
        Jarron jarron3 = new Jarron("XML en Java");
        jarron3.setTitulo("XML en Java 2");
        jarron3.setAutor("Luis Estilo");
        jarron3.setCodigo("as");
//        jarron3.setPrecio((float)25.10);
//        jarron3.setPrecio(25.10f);
//        jarron3.setPrecio(25.10F);
        
        Jarrones jarrones = new Jarrones();
        jarrones.getListaJarron().add(jarron1);
        jarrones.getListaJarron().add(jarron2);
        jarrones.getListaJarron().add(jarron3); 
        

//        UtilXML utilXML = new UtilXML();
        Button buttonSelecFile = new Button ("guardar xml");
        buttonSelecFile.setStyle("-fx-background-color : #FF3547;");
        botonesSuperior.getChildren().add(buttonSelecFile);
        buttonSelecFile.setOnAction((t) ->{       
            UtilXML.guardarDatosXML(stage, jarrones);
            
        });
        
//        Jarrones jarronesImport = new Jarrones();
//        jarronesImport.getListaJarron().add(jarron3);

        Button buttonSelectAbrir = new Button ("abrir xml");
        botonesSuperior.getChildren().add(buttonSelectAbrir);
        buttonSelectAbrir.setOnAction((t) ->{       
//            UtilXML.abrirDatosXML(stage, jarronesImport);
            Jarrones jarronesImport = UtilXML.abrirDatosXML(stage);
            System.out.println(jarronesImport.getListaJarron().size());
            
            jarrones.fusionarJarrones(jarronesImport);
//            Jarrones.fusionarJarrones(jarrones, jarronesImport);

        });
        
        Label label = new Label();
        Label label1 = new Label();        
        Label label2 = new Label();        
//        Label label3 = new Label();        

//        TextArea areaText = new TextArea();
////        area.setPrefColumnCount(15);
//        areaText.setPrefHeight(120);
//        areaText.setPrefWidth(300);
        textoLabel.setMaxSize(200,200);
        textoLabel.getChildren().addAll(label, label1, label2);
        
//        textoLabel.getChildren().add(label1);
//        textoLabel.getChildren().add(label2);

        
        Button buttonAnterior = new Button ("Anterior");
        botonesBajo.getChildren().add(buttonAnterior);
        buttonAnterior.setOnAction((t) ->{
            jarronActual--;
            try {
//            areaText.setText(jarrones.getListaJarron().get(jarronActual).toString());
            label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
            label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
            label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());
//            label3.setText(jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());


            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error, no existen mas XML para mostrar");
                alert.setContentText("Error, no existen mas XML para mostrar");
                ButtonType buttonTypeok = new ButtonType("OK");
                ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
                alert.getButtonTypes().setAll(buttonTypeok, buttonTypeCancelar);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    
                } else {
                    ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
                    // ... user chose CANCEL or closed the dialog
                }
            }
        });
//        
        Button buttonSiguiente = new Button ("Siguiente");
        botonesBajo.getChildren().add(buttonSiguiente);
        buttonSiguiente.setOnAction((t) ->{
            jarronActual++;
            try {
//            areaText.setText(jarrones.getListaJarron().get(jarronActual).toString());
            label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
            label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
            label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());
//            label3.setText(jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error, no existen mas XML para mostrar");
                alert.setContentText("Error, no existen mas XML para mostrar");
                alert.showAndWait();
                
            }
        });
        
            label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
            label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
            label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());

            
        label.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        label1.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        label2.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        

        
        

            
        

//        
//        root.getChildren().addAll(buttonSelectAbrir, buttonSelecFile );
//        root.getChildren().add(root);
        
        
        
        
        

        
        //int[] listaNum = new int[10];
        //Libro[] listaLibros = new Libro[10];
        
      
        
//        // Mostrar el título del tercer libro
//        System.out.println(listaLibros.get(2).getTitulo());
//        
//        // Eliminar de la lista el segundo libro
//        listaLibros.remove(1);
//        
//        // Mostrar todos los títulos de libros de la lista
//        for(int i=0; i<listaLibros.size(); i++) {
//            System.out.println(listaLibros.get(i).getTitulo());
//        }
//        
//        for(int i=0; i<listaLibros.size(); i++) {
//            System.out.println(listaLibros.get(i));
//        }


              
    }
    
    public static void main(String[] args) {
        launch();
    }

}