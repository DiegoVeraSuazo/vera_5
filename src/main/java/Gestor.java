import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Gestor {


    private List<Zapatilla> zapatillas;

    public List<Zapatilla> getZapatillas() {
        return zapatillas;
    }

    public void agregarTexto(String textoAgregado, String ruta){
        Path archivo = Paths.get(ruta);
        String texto;
        System.out.println("Ingrese un nuevo usuario");
        try {
            String textoAnterior = new String(Files.readAllBytes(archivo));
            texto = textoAnterior+"\n"+textoAgregado;
            Files.write(archivo, texto.getBytes());
            System.out.println("Se ha guardado el archivo");
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser guardado");
        }
    }


    /**
     * Metodo que permite ver lo escrito en el archivo
     * @param ruta es el archivo donde se encuentra lo escrito
     */
    public String obtenerTextoArchivo(String ruta){
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            return texto;
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
            return texto;
        }
    }

    public Zapatilla deserializar(String json){

        Gson gson = new GsonBuilder().create();
        Zapatilla zapatilla = gson.fromJson(json, Zapatilla.class);

        System.out.println(zapatilla.toString());
        return zapatilla;
    }

    public String agregarZapatilla(){
        String zapatillaNueva = "{\"marca\":\"Nike\",\"modelo\":\"AirForce1\",\"color\":\"Black\"}";
        Gson gson = new GsonBuilder().create();
        Zapatilla newZapatilla = gson.fromJson(zapatillaNueva, Zapatilla.class);
        return zapatillaNueva;
    }

}
