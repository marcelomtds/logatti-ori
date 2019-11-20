package br.edu.logatti.ori;

import java.util.Random;
import java.util.Scanner;

public class Main {

	private static int vetor[];
	private static Scanner scanner;
	private static Random gerador;
	private static final int MINIMO = 1;
	private static final int MAXIMO = 10000;

	public static void main(String[] args) {
		boolean continuar = true;
		do {
			gerador = new Random();
			imprimirMenu();
			final int opcao = lerOpcao();
			long tempoInicial = 0l;
			long tempoFinal = 0l;
			switch (opcao) {
			case 1:
				System.out.println("\n-------------------- Ordenação por Bubble Sort --------------------");
				criarVetor();
				inserirNumerosVetor();
				System.out.print("\nVetor desordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				bubbleSort();
				tempoFinal = System.currentTimeMillis();
				System.out.print("\n\nVetor ordenado: ");
				imprimirNumerosVetor();
				System.out.println(String.format("\n\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 2:
				System.out.println("\n------------------ Ordenação por Selection Sort ------------------");
				criarVetor();
				inserirNumerosVetor();
				System.out.print("\nVetor desordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				selectionSort();
				tempoFinal = System.currentTimeMillis();
				System.out.print("\n\nVetor ordenado: ");
				imprimirNumerosVetor();
				System.out.println(String.format("\n\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 3:
				System.out.println("\n------------------ Ordenação por Insertion Sort ------------------");
				criarVetor();
				inserirNumerosVetor();
				System.out.print("\nVetor desordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				insertionSort();
				tempoFinal = System.currentTimeMillis();
				System.out.print("\n\nVetor ordenado: ");
				imprimirNumerosVetor();
				System.out.println(String.format("\n\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 4:
				System.out.println("\n-------------------- Ordenação por Merge Sort --------------------");
				criarVetor();
				inserirNumerosVetor();
				System.out.print("\nVetor desordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				mergeSort(vetor);
				tempoFinal = System.currentTimeMillis();
				System.out.print("\n\nVetor ordenado: ");
				imprimirNumerosVetor();
				System.out.println(String.format("\n\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 5:
				System.out.println("\n-------------------- Ordenação por Quick Sort --------------------");
				criarVetor();
				inserirNumerosVetor();
				System.out.print("\nVetor desordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				quickSort(vetor, 0, vetor.length - 1);
				tempoFinal = System.currentTimeMillis();
				System.out.print("\n\nVetor ordenado: ");
				imprimirNumerosVetor();
				System.out.println(String.format("\n\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 6:
				System.out.println("\n------------------------ Busca Sequencial ------------------------");
				criarVetor();
				inserirNumerosVetor();
				System.out.print("\nVetor desordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				buscaSequencial();
				tempoFinal = System.currentTimeMillis();
				System.out.println(String.format("\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 7:
				System.out.println("\n------------------- Busca Sequencial Ordenada -------------------");
				criarVetor();
				inserirNumerosVetor();
				mergeSort(vetor);
				System.out.print("\nVetor ordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				buscaSequencialOrdenada();
				tempoFinal = System.currentTimeMillis();
				System.out.println(String.format("\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 8:
				System.out.println("\n------------------------- Busca Binária -------------------------");
				criarVetor();
				inserirNumerosVetor();
				mergeSort(vetor);
				System.out.print("\nVetor ordenado: ");
				imprimirNumerosVetor();
				tempoInicial = System.currentTimeMillis();
				buscaBinaria();
				tempoFinal = System.currentTimeMillis();
				System.out.println(String.format("\nOperação realizada em %s ms.", tempoFinal - tempoInicial));
				break;
			case 9:
				scanner.close();
				continuar = false;
				System.out.println("\nO programa foi encerrado com sucesso.");
				break;
			case 0:
				break;
			default:
				System.out.println("\nOpção inválida. Tente novamente.");
				break;
			}

		} while (continuar);
	}

	private static void imprimirMenu() {
		System.out.println("\n\n------------------------------- Menu -------------------------------"
				+ "\n\n1 - Ordenar o vetor usando o BubbleSort"
				+ "\n2 - Ordenar o vetor usando o SelectionSort"
				+ "\n3 - Ordenar o vetor usando o InsertionSort"
				+ "\n4 - Ordenar o vetor usando o MergeSort"
				+ "\n5 - Ordenar o vetor usando o QuickSort"
				+ "\n6 - Buscar um elemento no vetor usando a Busca Sequencial"
				+ "\n7 - Buscar um elemento no vetor usando a Busca Sequencial Ordenada"
				+ "\n8 - Buscar um elemento no vetor usando a Busca Binária"
				+ "\n9 - Sair");
	}

	private static void criarVetor() {
		boolean continuar = true;
		do {
			try {
				scanner = new Scanner(System.in);
				System.out.print("\nInforme o tamanho do vetor (entre 1 e 10000): ");
				final int tamanho = scanner.nextInt();
				if (tamanho >= 1 && tamanho <= 10000) {
					vetor = new int[tamanho];
					continuar = false;
				}
			} catch (Exception e) {
				System.out.println("\nOcorreu um problema ao ler o número informado. Tente novamente.");
			}
		} while (continuar);
	}

	private static void inserirNumerosVetor() {
		for (int i = 0; i < vetor.length; i++) {
			while (true) {
				final int numero = gerarNumeroAleatorio();
				if (!isNumeroExistente(numero)) {
					vetor[i] = numero;
					break;
				}
			}
		}
	}

	private static void imprimirNumerosVetor() {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + (i < vetor.length - 1 ? ", " : "."));
		}
	}

	private static int gerarNumeroAleatorio() {
		return gerador.nextInt(MAXIMO) + MINIMO;
	}

	private static boolean isNumeroExistente(final int numero) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == numero) {
				return true;
			}
		}
		return false;
	}

	private static int lerOpcao() {
		try {
			scanner = new Scanner(System.in);
			System.out.print("\nInforme a opção desejada: ");
			return scanner.nextInt();
		} catch (final Exception e) {
			System.out.println("\nOcorreu um problema ao ler a opção informada. Tente novamente.");
		}
		return 0;
	}

	private static void bubbleSort() {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - 1; j++) {
				if (vetor[j] > vetor[j + 1]) {
					final int temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
			}
		}
	}

	private static void selectionSort() {
		int menor, temporaria;
		for (int i = 0; i < vetor.length - 1; i++) {
			menor = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[menor]) {
					menor = j;
				}
			}
			temporaria = vetor[i];
			vetor[i] = vetor[menor];
			vetor[menor] = temporaria;
		}
	}

	private static void insertionSort() {
		for (int i = 1; i < vetor.length; ++i) {
			int key = vetor[i];
			int j = i - 1;
			while (j >= 0 && vetor[j] > key) {
				vetor[j + 1] = vetor[j];
				j = j - 1;
			}
			vetor[j + 1] = key;
		}
	}

	private static void mergeSort(int vetor[]) {
		int tamanho = vetor.length;
		if (tamanho < 2) {
			return;
		}
		int meio = tamanho / 2;
		int esquerdo[] = new int[meio];
		int direito[] = new int[tamanho - meio];
		for (int i = 0; i < meio; i++) {
			esquerdo[i] = vetor[i];
		}
		for (int i = meio; i < tamanho; i++) {
			direito[i - meio] = vetor[i];
		}
		mergeSort(esquerdo);
		mergeSort(direito);
		merge(vetor, esquerdo, direito);
	}

	private static void merge(int vetor[], int vetorEsquerdo[], int vetorDireito[]) {
		int numeroEsquerdo = vetorEsquerdo.length;
		int numeroDireito = vetorDireito.length;
		int i = 0, j = 0, k = 0;
		while (i < numeroEsquerdo && j < numeroDireito) {
			if (vetorEsquerdo[i] <= vetorDireito[j]) {
				vetor[k] = vetorEsquerdo[i];
				i++;
			} else {
				vetor[k] = vetorDireito[j];
				j++;
			}
			k++;
		}
		while (i < numeroEsquerdo) {
			vetor[k] = vetorEsquerdo[i];
			i++;
			k++;
		}
		while (j < numeroDireito) {
			vetor[k] = vetorDireito[j];
			j++;
			k++;
		}
	}

	private static void quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}

	private static int separar(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	private static void buscaSequencial() {
		boolean continuar = true;
		do {
			try {
				System.out.print("\n\nInforme o número para a busca: ");
				scanner = new Scanner(System.in);
				final int numero = scanner.nextInt();
				for (int i = 0; i < vetor.length; i++) {
					if (vetor[i] == numero) {
						System.out.println(
								String.format("\nO número informado está localizado na %sª posição do vetor.", i + 1));
						continuar = false;
						break;
					}
					if (vetor.length - 1 == i) {
						System.out.println("\nO número informado não está localizado no vetor.");
						continuar = false;
						break;
					}
				}
			} catch (final Exception e) {
				System.out.println("\nOcorreu um problema ao ler o número informado. Tente novamente.");
			}
		} while (continuar);
	}

	private static void buscaSequencialOrdenada() {
		boolean continuar = true;
		do {
			try {
				System.out.print("\n\nInforme o número para a busca: ");
				scanner = new Scanner(System.in);
				final int numero = scanner.nextInt();
				for (int i = 0; i < vetor.length; i++) {
					if (vetor[i] > numero) {
						System.out.println("\nO número informado não está localizado no vetor.");
						continuar = false;
						break;
					}
					if (vetor[i] == numero) {
						System.out.println(
								String.format("\nO número informado está localizado na %sª posição do vetor.", i + 1));
						continuar = false;
						break;
					}
				}
				if (continuar) {
					System.out.println("\nO número informado não está localizado no vetor.");
					continuar = false;
					break;
				}
			} catch (final Exception e) {
				System.out.println("\nOcorreu um problema ao ler o número informado. Tente novamente.");
			}
		} while (continuar);
	}

	private static void buscaBinaria() {
		boolean continuar = true;
		do {
			try {
				System.out.print("\n\nInforme o número para a busca: ");
				scanner = new Scanner(System.in);
				final int numero = scanner.nextInt();
				int meio;
				int inicio = 0;
				int fim = vetor.length - 1;
				while (inicio <= fim) {
					meio = (inicio + fim) / 2;
					if (numero == vetor[meio]) {
						System.out.println(String
								.format("\nO número informado está localizado na %sª posição do vetor.", meio + 1));
						continuar = false;
						break;
					}
					if (numero < vetor[meio]) {
						fim = meio - 1;
					} else {
						inicio = meio + 1;
					}
				}
				if (continuar) {
					System.out.println("\nO número informado não está localizado no vetor.");
					continuar = false;
					break;
				}
			} catch (final Exception e) {
				System.out.println("\nOcorreu um problema ao ler o número informado. Tente novamente.");
			}
		} while (continuar);
	}

}
