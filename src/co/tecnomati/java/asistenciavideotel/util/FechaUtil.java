/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author joel
 */
public class FechaUtil {

    // moemento del dia
    static final int finMañana = 11;  // mañana de 00:60 a 11:59
    static final int finTarde = 18; // mañana de 12:00 a 18:59
    static final int finNoche = 5;// mañana de 19:00 a 05:59
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
     * @param d date
     * @return un entero que indica el numero de dia de la semana 1- domingo..
     * 2- lunes....7-sabado
     */
    public static int getDiaDeLaSemana(Date d) {
        Calendar c = getCalendar(d);
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
//    public static String getHora_Formato_HHMM(Calendar c) {
//        System.err.println("hora 24 hs " + getHoraDelDia_24hs(c));
//        System.err.println("min  " + getMin(c));
//        return getHoraDelDia_24hs(c) + ":" + getMin(c);
//
//    }
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
     * @return la hora en formato hh:mm en String Ej : 20:30
     */
    public static String getHora_HHMM(Date fechaHoy) {
        String fecha = "";
        if (fechaHoy!=null) {
         SimpleDateFormat df = new SimpleDateFormat("HH:mm");    
         fecha= df.format(fechaHoy);
        }
        
        return fecha;
    }

    /**
     *
     * @param fechaHoy
     * @return obtine String que representa la Hora de un Date en formato HH Ej:
     * 20:30 ...> return 20
     */
    public static String getHH(Date fechaHoy) {
//        Calendar c = getCalendar(fechaHoy);
//        String hora = String.valueOf(getHoraDelDia_24hs(c));
//
//        if (getHoraDelDia_24hs(c) <= 9) {
//            hora = "0" + hora;
//        }

        SimpleDateFormat df = new SimpleDateFormat("HH");

        return df.format(fechaHoy);
    }

    /**
     *
     * @param fechaHoy
     * @return obtiene un String que representa los minutos de una Fecha en
     * formato MM Ej: 20:30 hs ...> return 30
     */
    public static String getMM(Date fechaHoy) {
        Calendar c = getCalendar(fechaHoy);
        String min = String.valueOf(getMin(c));

        if (getMin(c) <= 9) {
            min = "0" + min;
        }
        return min;
    }

    public static String getFecha_Dia_DD_De_MM_De_AAAA(Date fecha) {
        Calendar c = getCalendar(fecha);


        String fechaActual = getDiaDeLaSemana_String(c) + " " + getDiaDelMes(c) + " DE " + getMes_String(c) + " DE " + getAnio(c);
        return fechaActual;
    }

    /**
     *
     * @param date
     * @return //
     */
//    public static String getMomentoDelDia(Date date) {
//        String momento = "";
//        Date fMañana = new Date(date.getYear(), date.getDate(), 11, 59, 59);
//        Date fTarde = new Date(date.getYear(), date.getDate(), 18, 59, 59);
//        Date fNoche = new Date(date.getYear(), date.getDate(), 05, 59, 59);
//       
//        System.err.println("hora mañ "+ getHora_HHMM(fMañana));
//        if (date.before(fMañana) && date.after(fNoche)) {
//            // la hora pertenece a la mañana
//            System.err.println("mañana");
//        } else if (date.before(fTarde) && date.after(fMañana)) {
//            // turno tarde
//            System.err.println("tarde");
//        } else if (date.before(fNoche) && date.after(fTarde)) {
//             // turno noche
//            System.err.println("noche");
//        }
//
//        return momento;
//
//    }
    /**
     *
     * @param date fecha
     * @return Retorna la fecha de hoy Ej: Viernes 26 de Septiembre de 2014
     */
    public String getFecha_Dia_N_de_Mes_de_Anio(Date date) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);

        return df.format(date);
    }

    /**
     *  CORREGIR ESTO NO FUNCIONA 
     * @param desde
     * @param hasta
     * @return Calcula la cantidad de dias entre dos fechas
     */
    public static long getNumeroDeDias(Date desde, Date hasta) {

        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
      
      
        Calendar c = getCalendar(desde);
//        Calendar calendar = new GregorianCalendar(año, mes - 1, dia);
        java.sql.Date fecha = new java.sql.Date(c.getTimeInMillis());

        long diferencia = (hasta.getTime() - fecha.getTime()) / MILLSECS_PER_DAY;
        System.out.println(diferencia);
        return diferencia;

    }
    
    /**
     * 
     * @param desde
     * @param hasta
     * @return  retorna la cantidad de minutos transcurrido entre dos fechas
     */
    public static int getCantidadDeMinutos(Date desde , Date hasta){
        int cant=0;
         int horaInicio= Integer.parseInt(getHH(desde));
         int horaFin= Integer.parseInt(getHH(hasta));
         
         int minInicio= Integer.parseInt(getMM(desde));
         int minFin= Integer.parseInt(getMM(hasta));
         
        int difHora= horaFin - horaInicio;
        int difmin= minFin - minInicio;
        cant= difHora*60 + difmin; 
        return cant;
        
    }
    
    
   /**
    * 
    * @param d fecha
    * @return la fecha del prier dia semanal dado una fecha
    * El primier dia de la smena es LUNES. 
    * EJ: si estamos en jueves 25..--> retorna Lunes 22
    */
    public static Date getPrimerDiaSemana(Date d ){
        
        // 1 es domingo
        Calendar c = getCalendar(d);
        int numDia = getDiaDeLaSemana(d);
        if (numDia==1) {
            // si es domingo
            numDia=6;
            c.add(Calendar.DAY_OF_MONTH, -numDia);
        } else {
            c.add(Calendar.DAY_OF_MONTH, -numDia+2);
        }
             
        
    
        return c.getTime();
}
}