package es.cristiangg.jarron;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaJarron {    
    private ArrayList<Jarron> listasjarron = new ArrayList();
    
    public ArrayList<Jarron> getListaJarron() {
        return listasjarron;
    }
    
    @XmlElement(name = "libro")
    public void setListaJarron(ArrayList<Jarron> listaLibros) {
        this.listasjarron = listasjarron;
    }
    
}
    

