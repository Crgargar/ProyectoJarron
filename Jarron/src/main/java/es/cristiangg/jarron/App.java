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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
   
    //variables    
    int jarronActual = 0;

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #d5ffff;");
//        VBox root = new VBox();
//        root.setAlignment(Pos.CENTER);
//        root.setSpacing(20);
             
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
///////////////////////////////////////Borde exterior////////////////////////////////////////////////////////////
        VBox VBox = new VBox();
        VBox.setAlignment(Pos.CENTER);
        VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#5dc1b9"),
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(15))));
        VBox.setSpacing(20);

        root.getChildren().add(VBox);
       
/////////////////////////////// Mostrar por pantalla los jarrones que quiero///////////////////////////////////
////////////////Jarron 1
        Jarron jarron1 = new Jarron();
        jarron1.setTitulo("Listas en Java");
        jarron1.setAutor("Juan");
        jarron1.setCodigo("1234632");
        jarron1.setPrecio(20);
        jarron1.setFechaPublicacion("10/02/2010");
        System.out.println(jarron1.getTitulo());
        System.out.println(jarron1.getTitulo());

////////////////// Jarron 2
        Jarron jarron2 = new Jarron();
        jarron2.setTitulo("Listas en Clases");
        jarron2.setAutor("Luis Martin");
        jarron2.setCodigo("562810363");
        jarron2.setPrecio(15);
        jarron2.setFechaPublicacion("15/05/2000");

////////////// Jarron 3       
        Jarron jarron3 = new Jarron("XML en Java");
        jarron3.setTitulo("XML en Java 2");
        jarron3.setAutor("Luis Estilo");
        jarron3.setCodigo("561268363");
        jarron3.setPrecio(30);
        jarron3.setFechaPublicacion("25/05/2005");
//        jarron3.setPrecio((float)25.10);
//        jarron3.setPrecio(25.10f);
//        jarron3.setPrecio(25.10F);
       
//////////////// Mostrar por pantalla los jarrones(1,2 y 3)
        Jarrones jarrones = new Jarrones();
        jarrones.getListaJarron().add(jarron1);
        jarrones.getListaJarron().add(jarron2);
        jarrones.getListaJarron().add(jarron3);
       
/////////////////////////////////////////Boton de Guardar//////////////////////////////////////////////////////////
//        UtilXML utilXML = new UtilXML();
        Button buttonSelecFile = new Button ("Guardar xml");
        buttonSelecFile.setStyle("-fx-background-color: #5dc1b9;");
        buttonSelecFile.setMinHeight(40);
        buttonSelecFile.setMinWidth(100);
        buttonSelecFile.setMaxHeight(40);
        buttonSelecFile.setMaxWidth(100);
        root.getChildren().add(buttonSelecFile);
        buttonSelecFile.setOnAction((t) ->{      
            UtilXML.guardarDatosXML(stage, jarrones);
           
        });
       
//        Jarrones jarronesImport = new Jarrones();
//        jarronesImport.getListaJarron().add(jarron3);

///////////////////////////////////// Boton de Abrir XML////////////////////////////////////////////////////
        Button buttonSelectAbrir = new Button ("Abrir xml");
        root.getChildren().add(buttonSelectAbrir);
            buttonSelectAbrir.setStyle("-fx-background-color: #5dc1b9;");
            buttonSelectAbrir.setMinHeight(40);
            buttonSelectAbrir.setMinWidth(100);
            buttonSelectAbrir.setMaxHeight(40);
            buttonSelectAbrir.setMaxWidth(100);
        buttonSelectAbrir.setOnAction((t) ->{      
//            UtilXML.abrirDatosXML(stage, jarronesImport);
            Jarrones jarronesImport = UtilXML.abrirDatosXML(stage);
            System.out.println(jarronesImport.getListaJarron().size());
           
            jarrones.fusionarJarrones(jarronesImport);
//            Jarrones.fusionarJarrones(jarrones, jarronesImport);

        });

////////////////////////////////// Borde botones superiores//////////////////////////////////////////////////

        HBox paneScores = new HBox();
        paneScores.setAlignment(Pos.TOP_CENTER);
        paneScores.getChildren().add(buttonSelecFile);
        paneScores.getChildren().add(buttonSelectAbrir);
        paneScores.setSpacing(200);
         paneScores.setBorder(new Border(new BorderStroke(Color.valueOf("#5dc1b9"),
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(3))));
        VBox.getChildren().add(paneScores);
        
//////////////////////////////// Crear los label con el que mostraremos los textos////////////////////////////////      
        Label label = new Label();
        Label label1 = new Label();        
        Label label2 = new Label();        
        Label label3 = new Label();        
        Label label4 = new Label();        

//        TextArea areaText = new TextArea(); 
////        area.setPrefColumnCount(15);
//        areaText.setPrefHeight(120);
//        areaText.setPrefWidth(300);
//        root.setMaxSize(200,200);

/////////// Unir los label que quiero mostrar en pantalla///////
        root.getChildren().addAll(label, label1, label2, label3, label4);
       
//        textoLabel.getChildren().add(label1);
//        textoLabel.getChildren().add(label2);

//////////////////////////////////////// Boton anterior/////////////////////////////////////////////////////////

        Button buttonAnterior = new Button ("Anterior");
        root.getChildren().add(buttonAnterior);
            buttonAnterior.setStyle("-fx-background-color: #5dc1b9;");
            buttonAnterior.setMinHeight(40);
            buttonAnterior.setMinWidth(100);
            buttonAnterior.setMaxHeight(40);
            buttonAnterior.setMaxWidth(100);
        buttonAnterior.setOnAction((t) ->{
            jarronActual--;
            try {
//            areaText.setText(jarrones.getListaJarron().get(jarronActual).toString());
            label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
            label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
            label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());
            label3.setText("Precio: " + jarrones.getListaJarron().get(jarronActual).getPrecio());
            label4.setText("Fecha Publicacion: " + jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error, no existen mas XML para mostrar");
                alert.setContentText("Error, no existen mas XML para mostrar");
                ButtonType buttonTypeInicio = new ButtonType("Inicio");
                ButtonType buttonTypeFin = new ButtonType("Fin");
                ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
                alert.getButtonTypes().setAll(buttonTypeInicio, buttonTypeFin, buttonTypeCancelar);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeInicio){
                    jarronActual = 0;
                    System.out.println("objetoActual" + jarronActual);
                    label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
                    label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
                    label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());
                    label3.setText("Precio: " + jarrones.getListaJarron().get(jarronActual).getPrecio());
                    label4.setText("Fecha Publicacion: " + jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());
                } else if (result.get() == buttonTypeCancelar) {
                    jarronActual = jarrones.getListaJarron().size();
                    System.out.println("objetoActual" + jarronActual);
                    label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
                    label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
                    label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());
                    label3.setText("Precio: " + jarrones.getListaJarron().get(jarronActual).getPrecio());
                    label4.setText("Fecha Publicacion: " + jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());
                } else {
                    System.exit(0);
                }
            }
        });
//        
///////////////////////////////////Boton Siguiente//////////////////////////////////////////////////////////////////

        Button buttonSiguiente = new Button ("Siguiente");
        root.getChildren().add(buttonSiguiente);
            buttonSiguiente.setStyle("-fx-background-color: #5dc1b9;");
            buttonSiguiente.setMinHeight(40);
            buttonSiguiente.setMinWidth(100);
            buttonSiguiente.setMaxHeight(40);
            buttonSiguiente.setMaxWidth(100);
        buttonSiguiente.setOnAction((t) ->{
            jarronActual++;
            try {
//            areaText.setText(jarrones.getListaJarron().get(jarronActual).toString());
            label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
            label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
            label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());
            label3.setText("Precio: " + jarrones.getListaJarron().get(jarronActual).getPrecio());
            label4.setText("Fecha Publicacion: " + jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());
//            label3.setText(jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error, no existen mas XML para mostrar");
                alert.setContentText("Error, no existen mas XML para mostrar");
                ButtonType buttonTypeInicio = new ButtonType("Inicio");
                ButtonType buttonTypeFin = new ButtonType("Fin");
                ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
                alert.getButtonTypes().setAll(buttonTypeInicio, buttonTypeFin, buttonTypeCancelar);
                Optional<ButtonType> result = alert.showAndWait();
            }
        });
       
            label.setText("Titulo: " + jarrones.getListaJarron().get(jarronActual).getTitulo());
            label1.setText("Autor: " + jarrones.getListaJarron().get(jarronActual).getAutor());
            label2.setText("Codigo: " + jarrones.getListaJarron().get(jarronActual).getCodigo());
            label3.setText("Precio: " + jarrones.getListaJarron().get(jarronActual).getPrecio());
            label4.setText("Fecha Publicacion: " + jarrones.getListaJarron().get(jarronActual).getFechaPublicacion());

//////////////////////////////////// Contenido de los Label y cuadrado interior///////////////////////////////////////

        VBox VBox2 = new VBox();
        VBox2.setMinHeight(300);
        VBox2.setMinWidth(400);
        VBox2.setMaxHeight(300);
        VBox2.setMaxWidth(400);
        VBox2.setAlignment(Pos.CENTER);
        VBox2.setSpacing(20);
        VBox2.setStyle("-fx-background-color: #a6ebff;");
        VBox2.setBorder(new Border(new BorderStroke(Color.valueOf("#5dc1b9"),
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(8))));
        VBox2.getChildren().add(label);
        VBox2.getChildren().add(label1);
        VBox2.getChildren().add(label2);
        VBox2.getChildren().add(label3);
        VBox2.getChildren().add(label4);
        VBox.getChildren().add(VBox2);
        
////////////////////////////////////// Cuadrado exterior de los botones de Abajo/////////////////////////////////////

        HBox paneHBox = new HBox();
        paneHBox.setAlignment(Pos.BOTTOM_CENTER);
        paneHBox.getChildren().add(buttonAnterior);
        paneHBox.getChildren().add(buttonSiguiente);
        paneHBox.setSpacing(200);
        paneHBox.setBorder(new Border(new BorderStroke(Color.valueOf("#5dc1b9"),
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(3))));
        VBox.getChildren().add(paneHBox);

//// Colocar bordes punteados a los label
//        label.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
//            BorderStrokeStyle.DASHED,
//            CornerRadii.EMPTY,
//            BorderWidths.DEFAULT)));
//        label1.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
//            BorderStrokeStyle.DASHED,
//            CornerRadii.EMPTY,
//            BorderWidths.DEFAULT)));
//        label2.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
//            BorderStrokeStyle.DASHED,
//            CornerRadii.EMPTY,
//            BorderWidths.DEFAULT)));

        ///////////////////////////////////////////////////

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