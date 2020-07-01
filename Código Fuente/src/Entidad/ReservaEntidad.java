package Entidad;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Martin Lana
 */
public class ReservaEntidad {

//Atributos
    private int idReserva;
    private String nombreCliente;
    private String apellidoCliente;
    private String documentoCliente;
    private String emailCliente;
    private String salaReservada;
    private Date fechaReserva;
    private String horaInicioReserva;
    private String horaFinReserva;

    //Constructor vacio
    public ReservaEntidad() {
    }

    //Constructor lleno
    public ReservaEntidad(int idReserva, String nombreCliente, String apellidoCliente, String documentoCliente, String emailCliente, String salaReservada, Date fechaReserva, String horaInicioReserva, String horaFinReserva) {
        this.idReserva = idReserva;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.documentoCliente = documentoCliente;
        this.emailCliente = emailCliente;
        this.salaReservada = salaReservada;
        this.fechaReserva = fechaReserva;
        this.horaInicioReserva = horaInicioReserva;
        this.horaFinReserva = horaFinReserva;
    }

    //Metodos SET Y GET
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSalaReservada() {
        return salaReservada;
    }

    public void setSalaReservada(String salaReservada) {
        this.salaReservada = salaReservada;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraInicioReserva() {
        return horaInicioReserva;
    }

    public void setHoraInicioReserva(String horaInicioReserva) {
        this.horaInicioReserva = horaInicioReserva;
    }

    public String getHoraFinReserva() {
        return horaFinReserva;
    }

    public void setHoraFinReserva(String horaFinReserva) {
        this.horaFinReserva = horaFinReserva;
    }

}
