package Controllers;

import static spark.Spark.get;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;


/**
 * Created by Leonardo on 28/05/2016.
 */
public class Main {

    public static void main(String[] args) {
//indicando los recursos publicos.
        staticFiles.location("/public");

        //Linea para agregar la pantalla de debug. En productivo se debe quitar.
        enableDebugScreen();

        new TemplatesController().ietemplates();
        get("/", (request, response) -> "Hola");

    }


}
