package com.test.apicumpleanos.utils;



import com.test.apicumpleanos.util.Utiles;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
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



}
