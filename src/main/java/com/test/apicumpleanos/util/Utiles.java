package com.test.apicumpleanos.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class Utiles {

    public int calculaEdad(Date fecha){

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fecha);
        LocalDate hoy = LocalDate.now();

        LocalDate cumpleano = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        Period periodo = Period.between(cumpleano, hoy);
        return periodo.getYears();
    }

    public Boolean esCumpleanos(Date fecha){

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fecha);
        LocalDate hoy = LocalDate.now();

        if (hoy.getMonthValue() == calendar.get(Calendar.MONTH) && hoy.getDayOfMonth() == calendar.get(Calendar.DAY_OF_MONTH)){

            return true;
        }

        return false;
    }

}
