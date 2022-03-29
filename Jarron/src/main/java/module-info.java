module es.cristiangg.jarron {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.cristiangg.jarron;
    opens es.cristiangg.jarron to java.xml.bind;

}
