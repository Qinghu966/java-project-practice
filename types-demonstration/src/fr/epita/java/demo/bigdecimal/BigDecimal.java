package fr.epita.java.demo.bigdecimal;

public class BigDecimal {
    public static void main(String[] args) {

        java.math.BigDecimal someBigDecimalValue = java.math.BigDecimal.valueOf(2.0);

        someBigDecimalValue = someBigDecimalValue.add(java.math.BigDecimal.ONE);

        assert someBigDecimalValue.equals(java.math.BigDecimal.valueOf((3.0)));

    }
}
