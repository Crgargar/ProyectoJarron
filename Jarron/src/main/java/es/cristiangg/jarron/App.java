package es.cristiangg.jarron;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
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
        root.getChildren().add(buttonSelecFile);
        buttonSelecFile.setOnAction((t) ->{       
            UtilXML.guardarDatosXML(stage, jarrones);
            
        });
        
//        Jarrones jarronesImport = new Jarrones();
//        jarronesImport.getListaJarron().add(jarron3);

        Button buttonSelectAbrir = new Button ("abrir xml");
        root.getChildren().add(buttonSelectAbrir);
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
        Label label3 = new Label();        

//        TextArea areaText = new TextArea();
////        area.setPrefColumnCount(15);
//        areaText.setPrefHeight(120);
//        areaText.setPrefWidth(300);
        root.getChildren().add(label);
        
        Button buttonAnterior = new Button ("Anterior");
        root.getChildren().add(buttonAnterior);
        buttonAnterior.setOnAction((t) ->{
            jarronActual--;
            try {
//            areaText.setText(jarrones.getListaJarron().get(jarronActual).toString());
            label.setText(jarrones.getListaJarron().get(jarronActual).getAutor());
            label1.setText(jarrones.getListaJarron().get(jarronActual).getTitulo());
            label2.setText(jarrones.getListaJarron().get(jarronActual).getCodigo());
            label3.setText(jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());


            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error, no existen mas XML");
                alert.setContentText("Error en la aplicacion de XML");
                alert.showAndWait();
            }
        });
//        
        Button buttonSiguiente = new Button ("Siguiente");
        root.getChildren().add(buttonSiguiente);
        buttonSiguiente.setOnAction((t) ->{
            jarronActual++;
            try {
//            areaText.setText(jarrones.getListaJarron().get(jarronActual).toString());
            label.setText(jarrones.getListaJarron().get(jarronActual).getAutor());
            label1.setText(jarrones.getListaJarron().get(jarronActual).getTitulo());
            label2.setText(jarrones.getListaJarron().get(jarronActual).getCodigo());
            label3.setText(jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error, no existen mas XML");
                alert.setContentText("Error en la aplicacion de XML");
                alert.showAndWait();
            }
        });
        
        label.setText(jarrones.getListaJarron().get(jarronActual).toString());

        
        

            
        

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