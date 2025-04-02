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
 *
 */
 
@CronappSecurity
@cronapi.CronapiMetaData(type = "blockly", categoryName = "Bloco Diana")
public class MinhaClasse {

    /**
     * Validate a Brazilian CNPJ.
     * 
     * @param cnpj the CNPJ to be validated
     * @return true if the CNPJ is valid, false otherwise
     */
    @cronapi.CronapiMetaData(
        type = "function",
        name = "validarCnpj",
        nameTags = {"cnpj", "brazil", "validation", "brasil", "documento"},
        description = "Valida um CNPJ brasileiro."
    )
    public static boolean validarCnpj(java.lang.String cnpj) throws Exception {
        // Remove all non-digit characters from the CNPJ
        var cleanedCnpj = cnpj.replaceAll("\\D", "");

        // Check if the CNPJ has 14 digits
        if (cleanedCnpj.length() != 14) {
            return false;
        }

        // Calculate the first digit
        var sum = 0;
        var multiplier = new int[] {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (var i = 0; i < 12; i++) {
            sum += java.lang.Integer.parseInt(cleanedCnpj.substring(i, i + 1)) * multiplier[i];
        }
        var remainder = sum % 11;
        var firstDigit = remainder < 2 ? 0 : 11 - remainder;

        // Calculate the second digit
        sum = 0;
        multiplier = new int[] {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (var i = 0; i < 13; i++) {
            sum += java.lang.Integer.parseInt(cleanedCnpj.substring(i, i + 1)) * multiplier[i];
        }
        remainder = sum % 11;
        var secondDigit = remainder < 2 ? 0 : 11 - remainder;

        // Check if the calculated digits match the provided digits
        return java.lang.Integer.parseInt(cleanedCnpj.substring(12, 13)) == firstDigit && java.lang.Integer.parseInt(cleanedCnpj.substring(13, 14)) == secondDigit;
    }
}


