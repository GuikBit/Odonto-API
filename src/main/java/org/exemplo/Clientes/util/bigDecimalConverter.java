package org.exemplo.Clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class bigDecimalConverter {

    public BigDecimal converter (String value)
    {
        if(value == null)
            return null;

        value = value.replace(".", "").replace(",", ".");
        return  new BigDecimal(value);
    }

}
