package es.cristiangg.jarron;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// ArrayList de Jarrones

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

// Fusionar la informacion
    
    public void fusionarJarrones(Jarrones jarronesNuevo){
        this.getListaJarron().addAll(listasjarron);
        
    }
    
}
    

