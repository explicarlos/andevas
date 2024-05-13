public class Arco {
    // campos ---------------------------------------
    private String id; // identificador
    private String nombre; // nombre
    private String origen; // nodo origen
    private String destino; // nodo destino
    private boolean esActivo; // está o no habilitado
    private double distancia; // metros
    private double tiempo; // segundos
    private double energia; // julios
    private double precio; // €
    private double fatiga; // puntos
    private double costePonderado; // coste general promediado

    // constructores ------------------------------------
    public Arco() { // constructor por omisión
        return;
    }
    public Arco( // constructor básico
                 String identificador,
                 String nombre,
                 String origen,
                 String destino,
                 boolean esActivo,
                 double distancia,
                 double tiempo,
                 double energia,
                 double precio,
                 double fatiga
    ) {
        setId(identificador);
        setNombre(nombre);
        setOrigen(origen);
        setDestino(destino);
        setActivo(esActivo);
        setDistancia(distancia);
        setTiempo(tiempo);
        setEnergia(energia);
        setPrecio(precio);
        setFatiga(fatiga);
        return;
    }

    // getters y setters -----------------------------------------------

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
        this.nombre = nombre;
        return;
    }
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
        return;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
        return;
    }
    public boolean getActivo() {
        return esActivo;
    }
    public void setActivo(boolean esActivo) {
        this.esActivo = esActivo;
        return;
    }
    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
        return;
    }
    public double getTiempo() {
        return tiempo;
    }
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
        return;
    }
    public double getEnergia() {
        return energia;
    }
    public void setEnergia(double energia) {
        this.energia = energia;
        return;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
        return;
    }
    public double getFatiga() {
        return fatiga;
    }
    public void setFatiga(double fatiga) {
        this.fatiga = fatiga;
        return;
    }
    public double getCostePonderado() {
        return costePonderado;
    }
    public void setCostePonderado(double costePonderado) {
        this.costePonderado = costePonderado;
        return;
    }
}
