package ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Clase que permite escribir y leer texto desde un archivo 
 */
public class Principal {

	//nombre del archivo de texto
	static String nombreArchivo = "archivo.txt";

	//ubicación donde se alojará el archivo de texto
	static String ubicacion = "F:\\chuck\\workspace\\EscritorLectorDeTexto\\src\\ejercicio\\";

	/**
     * Método principal que ejecuta las operaciones de escritura y lectura del archivo.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan).
     * @throws IOException Si ocurre un error durante la escritura o lectura del archivo.
     */
	public static void main(String[] args) throws IOException {

		metodoEscritura();

		metodoLectura();

	}

	/**
	 * Método para escribir un mensaje en el archivo de texto, 
	 * se pueden sobrescribir mensajes
	 */
	private static void metodoEscritura () {

		//el try-with-resources asegura que el recurso fw se cierre automáticamente
		try (FileWriter fw = new FileWriter(ubicacion + nombreArchivo, true)) {

			String texto = JOptionPane.showInputDialog(null, "Introduce el mensaje que deseas guardar en el " + nombreArchivo);

			fw.write(texto + "\n");

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());

		}

	}

	/**
	 * Método para leer el contenido del archivo y mostrarlo en un cuadro de diálogo
	 */
	private static void metodoLectura() {

		//el try-with-resources asegura que el recurso de lectura se cierre automáticamente
		try (BufferedReader lectura = new BufferedReader(new FileReader(ubicacion + nombreArchivo))){

			//acumula el contenido del archivo en un StringBuilder
			StringBuilder contenido = new StringBuilder();

			String linea = lectura.readLine();

			//mientras exista una línea se mostrará
			while (linea != null) {

				contenido.append(linea + "\n");
				linea = lectura.readLine(); //lee la siguiente línea

			}

			JOptionPane.showMessageDialog(null, contenido, "Contenido del archivo: ", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());

		}

	}

}
