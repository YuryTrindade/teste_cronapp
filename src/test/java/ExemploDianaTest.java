import blockly.ExemploDiana;
import cronapi.CronapiMetaData;
import cronapi.Utils;
import cronapi.Var;
import cronapi.CronapiMetaData.CategoryType;
import cronapi.CronapiMetaData.ObjectType;
import cronapi.ParamMetaData;
import cronapi.rest.security.CronappSecurity;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class contains unit tests for the ExemploDiana class.
 */
public class ExemploDianaTest {

    /**
     * Test the validarCpf method with a valid CPF.
     * 
     * @throws Exception 
     */
    @org.junit.Test
    public void testValidarCpfValid() throws Exception {
        // Test a valid CPF
        String cpf = "46384263850";
        boolean result = ExemploDiana.validarCpf(cpf);
        assertTrue("The CPF " + cpf + " should be valid", result);
    }

    /**
     * Test the validarCpf method with an invalid CPF.
     * 
     * @throws Exception 
     */
    @org.junit.Test
    public void testValidarCpfInvalid() throws Exception {
        // Test an invalid CPF
        String cpf = "12345678900";
        boolean result = ExemploDiana.validarCpf(cpf);
        assertFalse("The CPF " + cpf + " should be invalid", result);
    }

    /**
     * Test the validarCpf method with a CPF that has non-digit characters.
     * 
     * @throws Exception 
     */
    @org.junit.Test
    public void testValidarCpfNonDigitCharacters() throws Exception {
        // Test a CPF with non-digit characters
        String cpf = "463.842.638-50";
        boolean result = ExemploDiana.validarCpf(cpf);
        assertTrue("The CPF " + cpf + " should be valid", result);
    }

    /**
     * Test the validarCpf method with a CPF that has less than 11 digits.
     * 
     * @throws Exception 
     */
    @org.junit.Test
    public void testValidarCpfLessThan11Digits() throws Exception {
        // Test a CPF with less than 11 digits
        String cpf = "4638426385";
        boolean result = ExemploDiana.validarCpf(cpf);
        assertFalse("The CPF " + cpf + " should be invalid", result);
    }

    /**
     * Test the validarCpf method with a CPF that has more than 11 digits.
     * 
     * @throws Exception 
     */
    @org.junit.Test
    public void testValidarCpfMoreThan11Digits() throws Exception {
        // Test a CPF with more than 11 digits
        String cpf = "463842638501";
        boolean result = ExemploDiana.validarCpf(cpf);
        assertFalse("The CPF " + cpf + " should be invalid", result);
    }

    /**
     * Test the validarCpf method with a CPF that is a sequence of the same digit.
     * 
     * @throws Exception 
     */
    @org.junit.Test
    public void testValidarCpfSequence() throws Exception {
        // Test a CPF that is a sequence of the same digit
        String cpf = "11111111111";
        boolean result = ExemploDiana.validarCpf(cpf);
        assertFalse("The CPF " + cpf + " should be invalid", result);
    }
}