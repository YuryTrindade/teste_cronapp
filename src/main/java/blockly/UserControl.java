package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class UserControl {

public static final int TIMEOUT = 300;

/**
 *
 * @author Yury Trindade Da Cunha
 * @since 27/03/2025, 11:02:28
 *
 */
public static Var pegarIDUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var consultaIdBanco = Var.VAR_NULL;
   private Var idUsuarioLogado = Var.VAR_NULL;

   public Var call() throws Exception {
    consultaIdBanco =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));
    idUsuarioLogado =
    cronapi.list.Operations.getFirst(consultaIdBanco);
    return idUsuarioLogado;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param email
 * @param isMobile
 *
 * @author Yury Trindade Da Cunha
 * @since 27/03/2025, 11:02:28
 *
 */
public static Var resetPassword(@ParamMetaData(description = "email", id = "53fc1de9") @RequestBody(required = false) Var email, @ParamMetaData(description = "isMobile", id = "b11110b2") Var isMobile) throws Exception {
 return new Callable<Var>() {

   private Var username = Var.VAR_NULL;
   private Var password = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.defaultResetPassword(email,
Var.valueOf("https://acesso.cronapp.io/img/header.png"),
Var.valueOf("https://acesso.cronapp.io/img/footer.png"), isMobile);
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param username
 * @param email
 * @param password
 *
 * @author Yury Trindade Da Cunha
 * @since 27/03/2025, 11:02:28
 *
 */
public static Var signUp(@ParamMetaData(description = "username", id = "b7d52451") @RequestBody(required = false) Var username, @ParamMetaData(description = "email", id = "36bc1157") Var email, @ParamMetaData(description = "password", id = "097625e0") Var password) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.defaultSignUp(
cronapi.map.Operations.createObjectMapWith(Var.valueOf("username",username) , Var.valueOf("name",username) , Var.valueOf("email",email) , Var.valueOf("password",password)));
   }
 }.call();
}

}

