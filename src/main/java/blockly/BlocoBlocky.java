package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BlocoBlocky {

public static final int TIMEOUT = 300;

/**
 *
 * @author Yury Trindade Da Cunha
 * @since 31/03/2025, 12:53:20
 *
 */
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    Var.valueOf(blockly.BlocoTeste.helloWorldReturn(
    Var.valueOf("Eu").getTypedObject(String.class))));
    blockly.BlocoTeste.helloWorldPrint(
    Var.valueOf("Eu").getTypedObject(String.class));
    return Var.VAR_NULL;
   }
 }.call();
}

}

