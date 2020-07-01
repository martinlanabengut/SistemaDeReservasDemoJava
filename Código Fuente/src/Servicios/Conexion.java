package Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin Lana
 */
//Clase para conectarme a la base de datos.
public class Conexion {

    public String db = "basereserva";
    public String url = "jdbc:mysql://127.0.0.1/" + db;
    public String user = "root";
    public String pass = "";

    //Contructor vacio
    public Conexion() {
    }

    //Metodo que conecta a la base de datos
    public Connection conectar() {
        Connection link = null;

        //Capturador de errores
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }

        return link;
    }

}
