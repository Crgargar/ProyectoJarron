package es.cristiangg.jarron;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Jarron jarron1 = new Jarron("Ficheros en Java", "Luisa Pérez");
        System.out.println(jarron1.getTitulo());
        jarron1.setTitulo("Listas en Java");
        System.out.println(jarron1.getTitulo());
        
        Jarron jarron2 = new Jarron();
        Jarron jarron3 = new Jarron("XML en Java");
        jarron3.setTitulo("XML en Java 2");
        jarron3.setPrecio((float)25.10);
        jarron3.setPrecio(25.10f);
        jarron3.setPrecio(25.10F);
        
        ListaJarron Listajarron = new ListaJarron();
        Listajarron.getListaJarron().add(jarron1);
        Listajarron.getListaJarron().add(jarron2);
        Listajarron.getListaJarron().add(jarron3); 
        
        HBox hbox = new HBox(100);

//        UtilXML utilXML = new UtilXML();
        Button buttonSelecFile = new Button ("guardar xml");
//        root.getChildren().add(buttonSelecFile);
        buttonSelecFile.setOnAction((t) ->{       
            UtilXML.guardarDatosXML(stage, Listajarron);
        });
        
        
        Button buttonSelectAbrir = new Button ("abrir xml");
//        root.getChildren().add(buttonSelectAbrir);
        buttonSelectAbrir.setOnAction((t) ->{       
            UtilXML.abrirDatosXML(stage, Listajarron);
        });
        
        hbox.getChildren().addAll(buttonSelectAbrir, buttonSelecFile );
        root.getChildren().add(hbox);
        
        
        
        
        

        
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