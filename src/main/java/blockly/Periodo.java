package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Periodo {

public static final int TIMEOUT = 300;

/**
 *
 * @param Periodo<app.entity.Periodo>
 *
 * @author Yury Trindade Da Cunha
 * @since 26/03/2025, 12:45:07
 *
 */
public static Var antesDeInserir(@ParamMetaData(description = "Periodo", id = "43b492fd") @RequestBody(required = false) Var Periodo) throws Exception {
 return new Callable<Var>() {

   private Var nomePeriodoGerado = Var.VAR_NULL;
   private Var consultaPeriodoGerado = Var.VAR_NULL;
   private Var periodoAtivo = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    Var.valueOf(!
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("dataInicial"))).equals(
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("dataFinal"))))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Períodos precisam começar e terminar no mesmo mês.")));
    }
    nomePeriodoGerado =
    Var.VAR_NULL;
    if (
    Var.valueOf(
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("periodo")).compareTo(
    Var.valueOf(1)) >= 0).getObjectAsBoolean() &&
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("periodo")).compareTo(
    Var.valueOf(12)) <= 0).getObjectAsBoolean()).getObjectAsBoolean()) {
        nomePeriodoGerado =
        Var.valueOf(
        cronapi.object.Operations.getObjectField(Periodo,
        Var.valueOf("periodo")).getObjectAsString() +
        Var.valueOf("/").getObjectAsString() +
        cronapi.dateTime.Operations.getYear(
        cronapi.object.Operations.getObjectField(Periodo,
        Var.valueOf("dataFinal"))).getObjectAsString());
        cronapi.database.Operations.updateField(Periodo,
        Var.valueOf("periodo"), nomePeriodoGerado);
    } else {
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Períodos precisam estar entre 1 e 12, apenas.")));
    }
    consultaPeriodoGerado =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.periodo = :periodo"),Var.valueOf("periodo",nomePeriodoGerado));
    if (
    cronapi.database.Operations.hasElement(consultaPeriodoGerado).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf(
        Var.valueOf("O período :").getObjectAsString() +
        nomePeriodoGerado.getObjectAsString() +
        Var.valueOf("Já existe, tente outro.").getObjectAsString())));
    }
    periodoAtivo =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p.ativo \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"));
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(periodoAtivo,
    Var.valueOf("this[0]")).getObjectAsBoolean() &&
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("ativo")).getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf(
        Var.valueOf("O período :").getObjectAsString() +
        cronapi.database.Operations.getField(periodoAtivo,
        Var.valueOf("this[0]")).getObjectAsString() +
        Var.valueOf("Já está ativo !").getObjectAsString())));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

