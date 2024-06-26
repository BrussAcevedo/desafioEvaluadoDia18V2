package desafioEvaluado18V2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		// Archivo (entrada.txt) de entrada ubicado en la carpeta src/desafioEvaluado18V2
		ArrayList<String> lista = listaEntrada("src/desafioEvaluado18V2/entrada.txt");
		
		System.out.println("Porfavor indica el elemento a buscar;");
		String busqueda = scan.nextLine();
		scan.close();

		String directorio = ("src/" + "directorio");
		String fichero = (directorio + "/" + "fichero.txt");
		crearArchivo(directorio, fichero, lista);
		
		int contador = buscarTexto(fichero, busqueda);
		if (contador > 0) {
			System.out.println("cantidad de repeticiones del texto -> " + contador);
		} else {
			System.out.println("No se encuentra el dato solicitado");
		}

	}

	public static ArrayList<String> listaEntrada(String ubicacionDelArchivo) {
		ArrayList<String> lista = new ArrayList<String>();
		File dir = new File(ubicacionDelArchivo);
		if (dir.exists()) {

			try (FileReader fr = new FileReader(dir); BufferedReader br = new BufferedReader(fr);) {
				String leerLinea = br.readLine();
				while (leerLinea != null) {
					lista.add(leerLinea);
					leerLinea = br.readLine();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lista;
	}

	public static void crearArchivo(String directorio, String fichero, ArrayList<String> lista) {
		File dir = new File(directorio);

		if (dir.exists() == false) {
			dir.mkdir();
		} else {
			System.out.println("Error al crear directorio");
		}

		if (dir.exists()) {
			File file = new File(fichero);
			if (file.exists() == false) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error al crear el directorio.");
				}
			}

		} else {
			System.out.println("El directorio no existe.");
		}

		try (FileWriter fw = new FileWriter(fichero); BufferedWriter bw = new BufferedWriter(fw);) {

			Iterator<String> iterador = lista.iterator();

			while (iterador.hasNext()) {
				String elemento = iterador.next();
				bw.write(elemento);
				bw.newLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int buscarTexto(String fichero, String texto) {
		ArrayList<String> listaBusqueda = new ArrayList<String>();
		File file = new File(fichero);
		int contador = 0;
		if (file.exists()) {

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String leerLinea = br.readLine();

				while (leerLinea != null) {
					listaBusqueda.add(leerLinea);
					leerLinea = br.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<String> listaFiltrada = listaBusqueda.stream().filter(x -> x.equalsIgnoreCase(texto)).collect(Collectors.toList());
			contador = listaFiltrada.size();

		} else {
			System.out.println("El fichero ingresado no existe.");
		}
		return contador;
	}

}
