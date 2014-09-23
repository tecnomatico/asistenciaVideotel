/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author joel
 */
public class FechaUtil {

    static final int anioCualquiera = 2010;
    static final int mesCualquiera = 2;
    static final int diaCualquiera = 29;

    public static String getFechaString10DDMMAAAA(Date fecha) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    public static String getFechaString10AAAAMMDD(Date fecha) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(fecha);
    }

    /**
     *
     * @return La fecha de hoy .. incluye fecha , hora , min, segundo
     */
    public static Calendar getAhora() {
        return java.util.Calendar.getInstance();
    }

    /**
     *
     * @param c
     * @return un entero que indica el numero de dia de la semana 1- domingo..
     * 2- lunes....7-sabado
     */
    public static int getDiaDeLaSemana(Calendar c) {
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     *
     * @param c
     * @return El dia del mes de una fecha determinada
     */
    public static int getDiaDelMes(Calendar c) {
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     *
     * @param c
     * @return devuelve el año de un fecha
     */
    public static int getAnio(Calendar c) {
        return c.get(Calendar.YEAR);
    }

    /**
     *
     * @param c
     * @return un entero que indica el numero de mes del año 0- enero ..
     * 1-febrero.....11-diciembre
     */
    public static int getMes_Int(Calendar c) {
        return c.get(Calendar.MONTH);
    }

    /**
     *
     * @param c
     * @return obtiene la hora 0 a 23 hs
     */
    public static int getHoraDelDia_24hs(Calendar c) {
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     *
     * @param c
     * @return obtiene la hora 1 a 12 hs
     */
    public static int getHoraDelDia_12hs(Calendar c) {
        return c.get(Calendar.HOUR);
    }

    /**
     *
     * @param c
     * @return obtiene el minuto
     */
    public static int getMin(Calendar c) {
        return c.get(Calendar.MINUTE);
    }
   
    
    public static int getMin(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
       
        return c.get(Calendar.MINUTE);
    }

    /**
     *
     * @param c
     * @return obtiene los segundos
     */
    public static int getSegundos(Calendar c) {
        return c.get(Calendar.SECOND);
    }

    /**
     *
     * @param c
     * @return devuelve el dia de la semana Ej: lunes, martes, .....domingo
     */
    public static String getDiaDeLaSemana_String(Calendar c) {
        String dia = "";

        switch (getDiaDeLaSemana(c)) {

            case 1:
                dia = "DOMINGO";
                break;
            case 2:
                dia = "LUNES";
                break;
            case 3:
                dia = "MARTES";
                break;
            case 4:
                dia = "MIERCOLES";
                break;
            case 5:
                dia = "JUEVES";
                break;
            case 6:
                dia = "VIERNES";
                break;
            case 7:
                dia = "SABADO";
                break;

            default:
                break;
        }


        return dia;
    }
    
    
    public static String getDiaDeLaSemana_String(int idDia) {
        String dia = "";

        switch (idDia) {

            case 1:
                dia = "DOMINGO";
                break;
            case 2:
                dia = "LUNES";
                break;
            case 3:
                dia = "MARTES";
                break;
            case 4:
                dia = "MIERCOLES";
                break;
            case 5:
                dia = "JUEVES";
                break;
            case 6:
                dia = "VIERNES";
                break;
            case 7:
                dia = "SABADO";
                break;

            default:
                break;
        }


        return dia;
    }
    
    

    /**
     *
     * @param c
     * @return devuelve el nombre del mes del año Ej: enero ,
     * febrero,....diciembre
     */
    public static String getMes_String(Calendar c) {
        String dia = "";

        switch (getMes_Int(c)) {

            case 0:
                dia = "ENERO";
                break;
            case 1:
                dia = "FEBRERO";
                break;
            case 2:
                dia = "MARZO";
                break;
            case 3:
                dia = "ABRIL";
                break;
            case 4:
                dia = "MAYO";
                break;
            case 5:
                dia = "JUNIO";
                break;
            case 6:
                dia = "JULIO";
                break;

            case 7:
                dia = "AGOSTO";
                break;

            case 8:
                dia = "SETIEMBRE";
                break;

            case 9:
                dia = "OCTUBRE";
                break;

            case 10:
                dia = "NOVIEMBRE";
                break;

            case 11:
                dia = "DICIEMBRE";
                break;

            default:
                break;
        }


        return dia;
    }

    /**
     *
     * @param hora
     * @param min
     * @param segundo
     * @return REtorna un objeto tipo Date que contiene la hora pasada por
     * paramentro
     */
    public static Date getHoraenDATE(int hora, int min, int segundo) {
        Calendar c = getAhora();
        c.set(anioCualquiera, mesCualquiera, diaCualquiera, hora, min, segundo);

        return c.getTime();
    }

    /**
     *
     * @param date
     * @return Convierte el date a un Calendar
     */
    public static Calendar getCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     *
     * @param c
     * @return obtiene la hora en formato HH:MM Ej. 20:30 , 00:15
     */
    public static String getHora_Formato_HHMM(Calendar c) {
        System.err.println("hora 24 hs " + getHoraDelDia_24hs(c));
        System.err.println("min  " + getMin(c));
        return getHoraDelDia_24hs(c) + ":" + getMin(c);

    }

    public static String getMomentoDelDia(int momento) {
        String dia = "";
        switch (momento) {

            case 1:
                dia = "MAÑANA";
                break;

            case 2:
                dia = "TARDE";
                break;

            case 3:
                dia = "NOCHE";
                break;

            case 4:
                dia = "MADRUGADA";
                break;

            default:
                break;
        }


        return dia;

    }

    /**
     *
     * @param fechaHoy una fecha ingresada
     * @return la hora en formato hh:mm en String
     * Ej : 20:30
     */
    public static String getHora_HHMM(Date fechaHoy) {
        Calendar c = Calendar.getInstance();
        c.setTime(fechaHoy);
        String hora = String.valueOf(getHoraDelDia_24hs(c));
        String min = String.valueOf(getMin(c));

//           String hora= String.valueOf(fechaHoy.getHours()) ;
//           String min= String.valueOf(fechaHoy.getMinutes());
//           
        if (getHoraDelDia_24hs(c) <= 9) {
            hora = "0" + hora;
        }
        if (getMin(c) <= 9) {
//               min= "0"+ fechaHoy.getMinutes();
            min = "0" + min;
        }
        String horaEnString = hora + ":" + min;
        return horaEnString;
    }

   /**
    * 
    * @param fechaHoy
    * @return obtine String que representa la Hora de un Date en formato HH
    * Ej: 20:30  ...> return  20
    */
    public static String getHH(Date fechaHoy) {
        Calendar c = getCalendar(fechaHoy);
        String hora = String.valueOf(getHoraDelDia_24hs(c));

        if (getHoraDelDia_24hs(c) <= 9) {
            hora = "0" + hora;
        }

        return hora;
    }

   
    /**
     * 
     * @param fechaHoy
     * @return obtiene un String  que representa los minutos de una Fecha  en formato MM
     * Ej: 20:30 hs   ...>  return  30
     */
    public static String getMM(Date fechaHoy) {
        Calendar c = getCalendar(fechaHoy);
        String min = String.valueOf(getMin(c));

        if (getMin(c) <= 9) {
            min = "0" + min;
        }
        return min;
    }
}
