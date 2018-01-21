package modelos;

public class Ruta {
    private int id;
    private int empresaId;
    private String descripcion;
    private float latitudInicio;
    private float longitudInicio;
    private float latitudFinal;
    private float longitudFinal;
    private int tiempoEstimado;

    public Ruta(){

    }

    public Ruta(int id, int empresaId, String descripcion, float latitudInicio, float longitudInicio, float latitudFinal, float longitudFinal, int tiempoEstimado) {
        this.id = id;
        this.empresaId = empresaId;
        this.descripcion = descripcion;
        this.latitudInicio = latitudInicio;
        this.longitudInicio = longitudInicio;
        this.latitudFinal = latitudFinal;
        this.longitudFinal = longitudFinal;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getLatitudInicio() {
        return latitudInicio;
    }

    public void setLatitudInicio(float latitudInicio) {
        this.latitudInicio = latitudInicio;
    }

    public float getLongitudInicio() {
        return longitudInicio;
    }

    public void setLongitudInicio(float longitudInicio) {
        this.longitudInicio = longitudInicio;
    }

    public float getLatitudFinal() {
        return latitudFinal;
    }

    public void setLatitudFinal(float latitudFinal) {
        this.latitudFinal = latitudFinal;
    }

    public float getLongitudFinal() {
        return longitudFinal;
    }

    public void setLongitudFinal(float longitudFinal) {
        this.longitudFinal = longitudFinal;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}
