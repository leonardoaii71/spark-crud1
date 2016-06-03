package Controllers;

/**
 * Created by Leonardo on 29/05/2016.
 */



import java.util.HashMap;
import java.util.Map;


import Models.DataBaseServices;
import Models.Estudiante;
import Models.EstudianteServices;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

public class TemplatesController {

    public static void ietemplates() {

        //Indicando la carpeta por defecto.
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(TemplatesController.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

    //Get Methods
        get("/formulario/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario en FreeMarker");
            return new ModelAndView(attributes, "CrearEstudiante.ftl");
        }, freeMarkerEngine);




    //Post Methods

        post("/procesarFormulario/", (request, response) -> {


            String matricula = request.queryParams("matricula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono  = request.queryParams("telefono");


            Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
            DataBaseServices.getInstancia().testConexion();
            EstudianteServices estudianteServices = new EstudianteServices();

        if(estudianteServices.getEstudiante(estudiante.getMatricula())==null){
            estudianteServices.crearEstudiante(estudiante);
        }

            HashMap<String, Object> lista = new HashMap<String, Object>();
            lista.put("estudiantes", estudianteServices.listaEstudiantes());

                return new ModelAndView(lista, "ListStudents.ftl");}
            , freeMarkerEngine);


        get("/update/:matricula", (request, response) -> {
                    HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("matricula", request.params(":matricula"));

                    return new ModelAndView(data, "editStudents.ftl");}
                , freeMarkerEngine);

        get("/ListStudents/", (request, response) -> {
                    DataBaseServices.getInstancia().testConexion();
                    EstudianteServices estudianteServices = new EstudianteServices();

                    HashMap<String, Object> lista = new HashMap<String, Object>();
                    lista.put("estudiantes", estudianteServices.listaEstudiantes());

                    return new ModelAndView(lista, "ListStudents.ftl");}
                , freeMarkerEngine);



        get("/delete/:matricula", (request, response) -> {
                    DataBaseServices.getInstancia().testConexion();
                    EstudianteServices estudianteServices = new EstudianteServices();


                    estudianteServices.borrarEstudiante(request.params(":matricula"));

                    HashMap<String, Object> lista = new HashMap<String, Object>();
                    lista.put("estudiantes", estudianteServices.listaEstudiantes());

                    return new ModelAndView(lista, "ListStudents.ftl");}
                , freeMarkerEngine);

        post("/update/m/", (request, response) -> {

                    String matricula = request.queryParams("matricula");
                    String nombre = request.queryParams("nombre");
                    String apellido = request.queryParams("apellido");
                    String telefono  = request.queryParams("telefono");


                    Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
                    DataBaseServices.getInstancia().testConexion();
                    EstudianteServices estudianteServices = new EstudianteServices();
                    estudianteServices.actualizarEstudiante(estudiante);

                    response.redirect("/ListStudents/");

                    return 0; }
        );

    }
}