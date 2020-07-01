package Servicios;

import Entidad.ReservaEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin Lana
 */
public class ReservaServicio {

    //Instancio a la clase Conexion
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

//Variable donde se almacenará mi cadena de conexion
    private String sSQL = "";

    //Cuenta los registros obtenidos de la consulta mostrar
    public Integer totalRegistros;

    //Metodo para mostrar los registros de reservas almacenados en la base de datos
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        //Titulos de la tabla
        String[] titulos = {"ID", "Nombre", "Apellido", "Documento", "Email", "Sala Reservada", "Fecha de reserva", "Desde", "Hasta"};

        //Array donde se almacenaran los registros de cada uno de los titulos
        String[] registro = new String[9];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        //Comienzo con el llenado de mi tabla SQL
        //Me ordena la lista de reservas segun fecha. Si utilizo el buscador, buscara por id de reserva.
        sSQL = "select * from reserva where apellido_cliente  like '%" + buscar + "%' order by idreserva";

        //Capturador de erorres
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            //Recorro todos los registros con un while
            while (rs.next()) {

                registro[0] = rs.getString("idreserva");
                registro[1] = rs.getString("nombre_cliente");
                registro[2] = rs.getString("apellido_cliente");
                registro[3] = rs.getString("documento_cliente");
                registro[4] = rs.getString("email_cliente");
                registro[5] = rs.getString("sala_reserva");
                registro[6] = rs.getString("fecha_reserva");
                registro[7] = rs.getString("hora_inicio_reserva");
                registro[8] = rs.getString("hora_fin_reserva");

                totalRegistros = totalRegistros + 1;

                //Agrego a la variable modelo el vector registro
                modelo.addRow(registro);

            }
            return modelo;

            //Capturador de errores. Si aparece un error, muestro un Panel y no retorno nada a la variable modelo.
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    //Insertar datos en la tabla
    public boolean insertar(ReservaEntidad datos) {

        sSQL = " INSERT into reserva (nombre_cliente, apellido_cliente, documento_cliente, email_cliente, sala_reserva, fecha_reserva, hora_inicio_reserva, hora_fin_reserva) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            //Preparo la consulta 
            PreparedStatement pst = cn.prepareStatement(sSQL);
            //Envio todos los valores a mi variable pst
            pst.setString(1, datos.getNombreCliente());
            pst.setString(2, datos.getApellidoCliente());
            pst.setString(3, datos.getDocumentoCliente());
            pst.setString(4, datos.getEmailCliente());
            pst.setString(5, datos.getSalaReservada());
            pst.setDate(6, datos.getFechaReserva());
            pst.setString(7, datos.getHoraInicioReserva());
            pst.setString(8, datos.getHoraFinReserva());

            //Esta variable almacenara el resultado de la ejecucion del statement
            int n = pst.executeUpdate();

            //Condicion para ver si se cumple la introduccion de datos en mi tabla
            //n = 0 indica que no se han insertado registros, caso contrario, si se han insertado.
            if (n != 0) {
                return true;
            } else {
                return false;
            }

            //Si salta un error, tambien retorno falso.
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    //Metodo para editar una reserva de mi lista de reserva
    public boolean editar(ReservaEntidad datos) {
        //En esta consulta indico que edite los datos de la reserva donde el idreserva sea igual a la variable que le enviaré.
        sSQL = " update reserva set nombre_cliente = ?, apellido_cliente = ?, documento_cliente = ?, email_cliente = ?, sala_reserva = ?, fecha_reserva = ?, hora_inicio_reserva = ?, hora_fin_reserva = ? where idreserva = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, datos.getNombreCliente());
            pst.setString(2, datos.getApellidoCliente());
            pst.setString(3, datos.getDocumentoCliente());
            pst.setString(4, datos.getEmailCliente());
            pst.setString(5, datos.getSalaReservada());
            pst.setDate(6, datos.getFechaReserva());
            pst.setString(7, datos.getHoraInicioReserva());
            pst.setString(8, datos.getHoraFinReserva());
            pst.setInt(9, datos.getIdReserva());

            //Esta variable almacenara el resultado de la ejecucion del statement
            int n = pst.executeUpdate();

            //Condicion para ver si se cumple la introduccion de datos en mi tabla
            //n = 0 indica que no se han insertado registros, caso contrario, si se han insertado.
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    //metodo eliminar, para eliminar una reserva de mi lista de reservas
    public boolean eliminar(ReservaEntidad datos) {

        //Le indico que borre la reserva donde el idreserva que le paso por parametro coincide.
        sSQL = "delete from reserva where idreserva = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            //Solo necesito el id de la reserva para borrarla.
            pst.setInt(1, datos.getIdReserva());

            //Esta variable almacenara el resultado de la ejecucion del statement
            int n = pst.executeUpdate();

            //Condicion para ver si se cumple la introduccion de datos en mi tabla
            //n = 0 indica que no se han insertado registros, caso contrario, si se han insertado.
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

}
