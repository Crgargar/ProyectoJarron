package es.cristiangg.jarron;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {

// Guardar los datos de la informacion 
    
    public static void guardarDatosXML(Stage stage, Jarrones listaJarron){
        JAXBContext contexto;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Guardar en");
                File fileListaJarron = fileChooser.showSaveDialog(stage);
            
                contexto = JAXBContext.newInstance(Jarrones.class);
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(listaJarron, System.out);
                marshaller.marshal(listaJarron, fileListaJarron);
                
// Mensaje de posibles errores

            } catch (JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error al guardar los ficheros XML");
                alert.setContentText("Error en la aplicacion de XML");
                alert.showAndWait();
                
            }
    }

// Abrir los datos de un XML
            
    public static Jarrones abrirDatosXML(Stage stage){
        JAXBContext contexto;          
            try {
                FileChooser fileChooser1 = new FileChooser();
                fileChooser1.setTitle("abrir en");
                File fileListaJarron = fileChooser1.showOpenDialog(stage);
                
                JAXBContext context = JAXBContext.newInstance(Jarrones.class );
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Jarrones jarron = (Jarrones)unmarshaller.unmarshal(fileListaJarron);

                return jarron;
          
// Mensaje de error
                
            } catch (JAXBException e) {
            // TODO Auto-generated catch block
                e.printStackTrace();
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error al Abrir los ficheros XML");
                alert.setContentText("Error en la aplicacion de XML");
                alert.showAndWait();
                
                return null;
        }
            
    }
    
}

    