package es.cristiangg.jarron;

public class Jarron {
    
    private String titulo;
    private String autor;
    private String Codigo;
    private float precio;
    private String fechaPublicacion;
    
    public Jarron() {        
    }
    
    public Jarron(String titulo) {
        this.titulo = titulo.toUpperCase();
    }
    
    public Jarron(String titulo, String autor) {
        this.titulo = titulo.toUpperCase();
        this.autor = autor;
    }
    
    public String getTitulo() {        
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getCodigo() {
        return Codigo;
    }
    
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    public float getPrecio() {
        return precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    @Override
    public String toString() {
        String r = "";
        r += "Titulo: " + titulo + "\n";
        r += "Autor: " + autor + "\n";
        return r;
    }
}

    

