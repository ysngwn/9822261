/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   turma 02 - Luciano Antonio Digiampietri                       **/
/**                                                                 **/
/**   Quarto Exercício-Programa                                     **/
/**                                                                 **/
/**   Sungwon Yoon                                 9822261          **/
/**                                                                 **/
/**   03-06-2020                                                    **/
/*********************************************************************/


public class Banco {
	private Gerente[] gerentes;
	private int numGerentes;
	
	/* Construtor da Classe Banco
	 * Inicializa os dois atributos do objeto que esta sendo instanciado.
	 */
	Banco(){
		gerentes = new Gerente[10];
		numGerentes = 0;
	}
	

	/* Metodo para Imprimir informacoes gerais sobre o banco atual
	 */
	void imprimir(){
		System.out.println("#########################################################################");
		System.out.println("Imprimindo informacoes do banco.");
		System.out.println("Ha " + numGerentes + " gerente(s) neste banco.");
		Gerente ger;
		for (int g=0; g < numGerentes; g++){
			ger = gerentes[g];
			System.out.println("Gerente: " + ger.nome + "\tCPF: " + ger.cpf);
			ger.imprimirClientes();
		}
		System.out.println("#########################################################################");
	}
	
	
	
	/* Metodo para adicionar um gerente no arranjo de gerentes do banco.
	 * Caso o numero de gerentes seja igual a 10, nao deve adicionar e deve retornar false.
	 * Caso contrario, ha duas situacoes: 
	 *   1a: o gerente ja consta no arranjo de gerentes (verifique isso usando o numero do cpf),
	 *       neste caso o gerente nao deve ser reinserido e o metodo deve retornar false; 
	 *   2a: o gerente passado como parametro nao consta no arranjo de gerentes: o gerente 
	 *       deve ser adicionado na posicao numGerentes, o atributo numGerentes deve ser 
	 *       incrementado em 1 e o metodo deve retornar true. 
	 */
	boolean adicionarGerente(Gerente gerente){

		if (numGerentes == 10) return false;
		if (jaEsta(gerente)) return false;

		gerentes[numGerentes] = gerente;
		numGerentes++;
		
		return true;
	}

	/* Verifica se o gerente ja foi inserido no array Gerente gerentes[]
	*  Caso o gerente passado como parametro ja se encontra no array, retorna true;
	*  Caso contrario, retorna false;
	*/ 
	boolean jaEsta(Gerente gerente){

		for (int i = 0; i < numGerentes; i++){
			if (gerente.cpf == gerentes[i].cpf) return true;
		}

		return false;
	}
	
}
