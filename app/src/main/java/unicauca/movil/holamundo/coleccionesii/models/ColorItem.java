package unicauca.movil.holamundo.coleccionesii.models;

/**
 * Created by DarioFernando on 01/07/2015.
 */
public class ColorItem {

    String nombre, url, nombreHex;

    public ColorItem(String nombre, String url, String nombreHex) {
        this.nombre = nombre;
        this.url = url;
        this.nombreHex = nombreHex;
    }

    public ColorItem() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreHex() {
        return nombreHex;
    }

    public void setNombreHex(String nombreHex) {
        this.nombreHex = nombreHex;
    }
}
