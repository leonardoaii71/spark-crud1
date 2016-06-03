package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by Leonardo on 30/05/2016.
 */
public class EstudianteServices {

    public List<Estudiante> listaEstudiantes() {

        List<Estudiante> lista = new ArrayList<>();
        Connection con = null;
        try {

            String query = "select * from ESTUDIANTES";
            con = DataBaseServices.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Estudiante est = new Estudiante();
                est.setMatricula(rs.getString("matricula"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellidos"));
                est.setTelefono(rs.getString("telefono"));

                lista.add(est);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    /**
     *
     * @param matricula
     * @return
     */
    public Estudiante getEstudiante(String matricula) {
        Estudiante est = null;
        Connection con = null;
        try {

            String query = "select * from ESTUDIANTES where matricula = ?";
            con = DataBaseServices.getInstancia().getConexion();

            PreparedStatement prepareStatement = con.prepareStatement(query);

            prepareStatement.setString(1, matricula);

            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                est = new Estudiante();
                est.setMatricula(rs.getString("matricula"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellidos"));
                est.setTelefono(rs.getString("telefono"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return est;
    }

    public boolean crearEstudiante(Estudiante est){
        boolean ok = false;

        Connection con = null;
        try {

            String query = "insert into ESTUDIANTES (MATRICULA, NOMBRE, APELLIDOS, TELEFONO) values(?,?,?,?)";
            con = DataBaseServices.getInstancia().getConexion();

            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, est.getMatricula());
            prepareStatement.setString(2, est.getNombre());
            prepareStatement.setString(3, est.getApellido());
            prepareStatement.setString(4, est.getTelefono());

            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public boolean actualizarEstudiante(Estudiante est){
        boolean ok = false;

        Connection con = null;
        try {

            String query = "update ESTUDIANTES set nombre = ?, APELLIDOS = ?, telefono=? where matricula = ?";
            con = DataBaseServices.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, est.getNombre());
            prepareStatement.setString(2, est.getApellido());
            prepareStatement.setString(3, est.getTelefono());

            //Indica el where...
            prepareStatement.setString(4, est.getMatricula());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public boolean borrarEstudiante(String matricula){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "delete from ESTUDIANTES where matricula = ?";
            con = DataBaseServices.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);

            //Indica el where...
            prepareStatement.setString(1, matricula);
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }


}
