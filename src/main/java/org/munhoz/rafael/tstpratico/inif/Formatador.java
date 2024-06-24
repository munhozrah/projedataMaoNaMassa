package org.munhoz.rafael.tstpratico.inif;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatador {
    public static String formatarData(LocalDate date) {
        var fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fmt.format(date);
    }

    public static String formatarCurrency(BigDecimal valor) {
        return NumberFormat.getCurrencyInstance().format(valor);
    }
}
