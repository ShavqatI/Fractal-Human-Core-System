package com.fractal.domain.utility.converter;

public class NumberToWordConverter {

    public static String convert(long number) {
        if (number == 0) {
            return "сифр";
        }
        return convertNumber(number).trim();
    }
    private static final String[] units = {
            "сифр", "як", "ду", "се", "чор", "панҷ",
            "шаш", "ҳафт", "ҳашт", "нӯҳ"
    };

    private static final String[] tens = {
            "", "даҳ", "бист", "си", "чил", "панҷоҳ",
            "шаст", "ҳафтод", "ҳаштод", "навад"
    };

    private static final String[] teens = {
            "даҳ", "ёздаҳ", "дувоздаҳ", "сенздаҳ", "чордаҳ",
            "понздаҳ", "понздаҳ", "ҳабдаҳ", "ҳаждаҳ", "нуздаҳ"
    };

    private static String convertNumber(long number) {
        StringBuilder result = new StringBuilder();

        if (number >= 1_000_000_000) {
            result.append(convertNumber(number / 1_000_000_000)).append(" миллиард ");
            number %= 1_000_000_000;
        }
        if (number >= 1_000_000) {
            result.append(convertNumber(number / 1_000_000)).append(" миллион ");
            number %= 1_000_000;
        }
        if (number >= 1000) {
            result.append(convertNumber(number / 1000)).append(" ҳазор ");
            number %= 1000;
        }
        if (number >= 100) {
            result.append(convertNumber(number / 100)).append(" сад ");
            number %= 100;
        }
        if (number >= 20) {
            result.append(tens[(int) (number / 10)]).append(" ");
            number %= 10;
        }
        if (number >= 10) {
            result.append(teens[(int) (number - 10)]).append(" ");
            number = 0;
        }
        if (number > 0) {
            result.append(units[(int) number]).append(" ");
        }

        return result.toString();
    }
}
