package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TesteAPI {

public static final int TIMEOUT = 300;

/**
 *
 * @author Yury Trindade Da Cunha
 * @since 01/04/2025, 11:38:36
 *
 */
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/x-www-form-urlencoded"),
    Var.valueOf("https://pokeapi.co/api/v2/pokemon/"), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));
    System.out.println(
    Var.valueOf("abc").getObjectAsString());
    return
cronapi.json.Operations.getJsonOrMapField(item,
Var.valueOf("results"));
   }
 }.call();
}

}

