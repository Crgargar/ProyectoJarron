package es.cristiangg.jarron;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jarrones {    
    private ArrayList<Jarron> listasjarron = new ArrayList();
    
    public ArrayList<Jarron> getListaJarron() {
        return listasjarron;
    }
    
    @XmlElement(name = "jarron")
    public void setListaJarron(ArrayList<Jarron> listajarron) {
        this.listasjarron = listasjarron;
    }
    
    public void UnirJarrones(){
        Jarrones jarrones = new Jarrones;
    }
    
}
    

