package com.test.apicumpleanos.utils;



import com.test.apicumpleanos.util.Utiles;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class UtilesTest {


    private Utiles utiles = new Utiles();

    @Test
    public void testEsCumpleanos() throws ParseException {

        Boolean esCumple = false;
        Date fecha = new Date();
         Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DATE, -1);
        fecha = c.getTime();

        esCumple = utiles.esCumpleanos(fecha);

        assertNotNull(esCumple);
        assertTrue(esCumple);
     }

     @Test
    public void testNoEsCumpleanos() throws ParseException {

        Boolean esCumple = false;
        Date fecha = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DATE, 20);
        fecha = c.getTime();

        esCumple = utiles.esCumpleanos(fecha);

        assertNotNull(esCumple);
        assertFalse(esCumple);
    }


    @Test
    public void testCalculaEdad() throws ParseException {

        int edadUno = 0;
        int edadDos = 0;
        int edadTres = 0;

        String fechaTUno = "1976-08-24";
        String fechaTDos = "2010-02-10";
        String fechaTTres = "1994-03-10";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaUno =  df.parse(fechaTUno);
        Date fechaDos =  df.parse(fechaTDos);
        Date fechaTres =  df.parse(fechaTTres);

        edadUno = utiles.calculaEdad(fechaUno);
        edadDos = utiles.calculaEdad(fechaDos);
        edadTres = utiles.calculaEdad(fechaTres);

        assertNotNull(edadUno);
        assertNotNull(edadDos);
        assertNotNull(edadTres);
        assertTrue(edadUno == 43);
        assertTrue(edadDos == 10);
        assertTrue(edadTres == 25);
    }





}
