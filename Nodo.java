public class Nodo {
    // campos ---------------------------------------
    private String id; // identificador
    private String nombre; // nombre
    private String zona; // zona a la que pertenece
    private boolean esActivo; // está o no habilitado
    private String ramaPreferente; // id de mejor rama calculada

    // constructores --------------------------------------
    public Nodo() { // constructor por omisión
        return;
    }
    public Nodo( // constructor básico
            String identificador,
            String nombre,
            String zona,
            boolean esActivo
    ) {
        setId(identificador);
        setNombre(nombre);
        setZona(zona);
        setActivo(esActivo);
        return;
    }

    // getters y setters --------------------------------------
    public String getId() {
        return id;
    }
    public void setId(String identificador) {
        id=identificador;
        return;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre=nombre;
        return;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona=zona;
        return;
    }
    public boolean getActivo() {
        return esActivo;
    }
    public void setActivo(boolean esActivo) {
        this.esActivo=this.esActivo;
        return;
    }
    public String getRamaPreferente() {
        return ramaPreferente;
    }
    public void setRamaPreferente(String rama) {
        ramaPreferente=rama;
        return;
    }
}
