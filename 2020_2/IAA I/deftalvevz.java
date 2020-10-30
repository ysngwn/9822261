import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class test {


	public static int BinarySearch(double arr[], double valor, int inf, int sup){
		int mid;

		while( inf <= sup){
			mid = (inf + sup) / 2;
			if(arr[mid] > valor) sup = mid - 1;
			else inf = mid + 1;
		}
		return inf;
	}

	public static void BinaryInsertionSort(double arr[], int tam){

		int i, j, index;
		double chave;

		for(i = 1; i < tam; i++){
			chave = arr[i];
			index = BinarySearch(arr, chave, 0, i-1);
			for(j = i; j > index; j--){
				arr[j] = arr[j-1];
			}
			arr[index] = chave;
		}
	}

	public static int BinarySearchR(double arr[], double valor, int inf, int sup){
		int mid;

		if(inf <= sup){
			mid = (inf + sup) / 2;

			if (arr[mid] == valor) return mid;

			if (arr[mid] > valor) return BinarySearchR(arr, valor, inf, sup-1);
			return BinarySearchR(arr, valor, mid+1, sup);
		}

		return inf;
	}

	public static void BinaryInsertionSortR(double arr[], int tam){
		int i, j, index;
		double chave;

		for(i = 1; i < tam; i++){
			chave = arr[i];
			index = BinarySearchR(arr, chave, 0, i);
			for(j = i; j > index; j--){
				arr[j] = arr[j-1];
			}
			arr[index] = chave;
		}
	}

	public static void imprimir(double arr[], int tam){
		for(int i = 0; i < tam; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public static void linhas(String fileName, int opcao){

		long startTime = 0, endTime = 0, timeElapsed = 0, timeTotal = 0;


		BufferedReader bR = null;
		String[] vetor1 = null;// Vetor de dados para 1 fila do arquivo
		
		try{

			bR = new BufferedReader(new FileReader(fileName));
			String row = "";
			while((row = bR.readLine()) != null){

				// cria novo vetor de float a partir de cada linha
				vetor1 = row.split(" ");
				double vetor[] = new double[vetor1.length];
				for (int i = 0; i < vetor1.length; i++){
					double temp = Double.parseDouble(vetor1[i]);
					vetor[i] = temp;
				}

				// extrai quantidade de vetor
				String quantidade = fileName.replaceAll("\\D+", "");
				int qntde = Integer.parseInt(quantidade);

				// ordena e calcula o tempo
				// 1 - iterativa, 2 - recursiva
				if(opcao == 1){

					startTime = System.nanoTime();
					BinaryInsertionSort(vetor, qntde);
					endTime = System.nanoTime();
				} 

				else if(opcao == 2){

					startTime = System.nanoTime();
					BinaryInsertionSortR(vetor, qntde);
					endTime = System.nanoTime();
				}

				timeElapsed = endTime - startTime;

			//	imprimir(vetor, qntde);
				timeTotal += timeElapsed;
			}
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.printf("Tempo media : %dns\n", timeTotal/50);

	}





	public static void main(String[] args){


		Scanner sc = new Scanner(System.in);

		int opcao = -1;
		System.out.print("Digite: \n '1' para ordenacao iterativa\n '2' para ordenacao recursiva\n '0' para sair do programa\n");

		
		do {

			System.out.print("opcao : "); opcao = sc.nextInt();
			sc.nextLine();

			if(opcao == 1 || opcao == 2){

				System.out.print("Digite o nome do arquivo : ");
				String fileName = sc.nextLine();
				linhas(fileName, opcao);

				System.out.printf("\n\n\n");
			} 
			else if (opcao == 0){
				System.exit(0);
			}
			else{
				System.out.println("Opcao invalida, digite novamente");
			}

		} while (opcao != 0);



	}
}
