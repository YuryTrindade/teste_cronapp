package blockly;

import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;


/**
 * Função customizada para apresentar criação de bloco customizado ...
 *
 * @author Yury Trindade Da Cunha
 * @version 1.0
 * @since 2025-03-31
 *
 */

@CronapiMetaData(categoryName = "Minhas Funções")
public class BlocoTeste {

	@CronapiMetaData(type = "function", name = "HelloWorldReturn", description = "Função customizada para apresentar criação de bloco customizado")
	public static String helloWorldReturn(@ParamMetaData(description = "nome: nome a ser criado") String nome) throws Exception {
		return "Olá, " + nome;

	}

	@CronapiMetaData(type = "function", name = "HelloWorldRPrint", description = "Função customizada para apresentar criação de bloco customizado")
	public static void helloWorldPrint(@ParamMetaData(description = "nome: nome a ser criado") String nome) throws Exception {
		System.out.println( "Olá, " + nome);

	}


}