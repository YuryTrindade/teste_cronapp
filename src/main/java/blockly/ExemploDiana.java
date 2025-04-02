package blockly;

import cronapi.CronapiMetaData;
import cronapi.Utils;
import cronapi.Var;
import cronapi.CronapiMetaData.CategoryType;
import cronapi.CronapiMetaData.ObjectType;
import cronapi.ParamMetaData;
import cronapi.rest.security.CronappSecurity;

/**
 * @author Yury Trindade Da Cunha
 * @version 1.0
 * @since 2025-04-01
 */

@CronappSecurity
@cronapi.CronapiMetaData(type = "blockly", categoryName = "Bloco Diana")
public class ExemploDiana {

    /**
     * Valida um CPF brasileiro.
     *
     * @param cpf CPF a ser validado
     * @return true se o CPF for válido, false caso contrário
     */
    @cronapi.CronapiMetaData(
        type = "function",
        name = "validarCpf",
        nameTags = {"cpf", "brazil", "validation", "brasil", "documento"},
        description = "Valida um CPF brasileiro."
    )
    public static boolean validarCpf(String cpf) throws Exception {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }

        // Remove todos os caracteres não numéricos do CPF
        String cpfDigits = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpfDigits.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cpfDigits.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpfDigits.charAt(i)) * (10 - i);
        }
        int remainder = sum % 11;
        int firstCheckDigit = (remainder < 2) ? 0 : 11 - remainder;

        // Verifica o primeiro dígito verificador
        if (Character.getNumericValue(cpfDigits.charAt(9)) != firstCheckDigit) {
            return false;
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpfDigits.charAt(i)) * (11 - i);
        }
        remainder = sum % 11;
        int secondCheckDigit = (remainder < 2) ? 0 : 11 - remainder;

        // Verifica o segundo dígito verificador
        return Character.getNumericValue(cpfDigits.charAt(10)) == secondCheckDigit;
    }
}