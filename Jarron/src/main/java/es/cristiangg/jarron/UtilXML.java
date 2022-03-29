package es.cristiangg.jarron;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    
    public static void guardarDatosXML(Stage stage, ListaJarron listaJarron){
        JAXBContext contexto;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Guardar en");
                File fileListaJarron = fileChooser.showSaveDialog(stage);
            
//            File fileListaLibros = new File("ListaLibros.xml");
                contexto = JAXBContext.newInstance(Jarron.class);
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(listaJarron, System.out);
                marshaller.marshal(listaJarron, fileListaJarron);
            } catch (JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
            }
    }
            
    public static void abrirDatosXML(Stage stage, ListaJarron listaJarron){
        JAXBContext contexto;          
            try {
                FileChooser fileChooser1 = new FileChooser();
                fileChooser1.setTitle("abrir en");
                File fileListaJarron = fileChooser1.showSaveDialog(stage);
                
                JAXBContext context = JAXBContext.newInstance(Jarron.class );
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Jarron jarron = (Jarron)unmarshaller.unmarshal(
                new File("src/Jarron.xml") );
             
                System.out.println(jarron.getTitulo());
//            System.out.println(jarron.getPaginas());
             
            } catch (JAXBException e) {
            // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    
}

    