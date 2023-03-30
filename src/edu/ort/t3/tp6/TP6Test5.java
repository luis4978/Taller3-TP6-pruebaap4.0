package edu.ort.t3.tp6;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class TP6Test5 {
	String name = "c:\\windows\\temp"; // Asigna un path a la variable name..
	String token = "~"; // Asigna un valor a un token..

	// clase que se utiliza para implementar metodos de la clase FilenameFilter para filtrar nombre de archivos...
	public class Filtro implements FilenameFilter {
		String extension;

		Filtro(String extension) {
			this.extension = extension;
		}

		// m�todo que verifica si la extension del archivo name termina con la extension ...
		public boolean accept(File dir, String name) {//pasada por parametro al constructor de la clase.
			return name.endsWith(extension);
		}
	}

	public void demoList() {
		File f = new File(name);
		if (!f.exists()) {
			System.out.println("El archivo" + name + " no existe");
			return;
		}
		if (f.isDirectory())
			System.out.println(name + " es un directorio");
		if (f.isFile())
			System.out.println(name + "Es un archivo");

		String[] lista;
		lista = f.list();//carga el nombre de los archivos o directorios del directorio de f en una lista ...
		// Lista los archivos o directorios que se encuentran en el directorio del archivo f...
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
		System.out.println("--------------------------");
		// Filtrados por archivos que tengan extension .temp...
		lista = f.list(new Filtro(".tmp"));
		// ...
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}

		System.out.println("--------------------------");

		// Este es un ejemplo de una clase anonima la misma se crea sin
		// necesidad de declarala recordando que es obligatorio implementar
		// el m�todo acccept de la interfaz FilenameFilter
		// es una forma de crear una clase directamente al necesitarla
		File[] listaArchivos = f.listFiles(new FileFilter() {
			@Override
			// devuelve true si el nombre del archivo empieza con'~' y la posicion dentro de la lista de...
			public boolean accept(File dir) {//archivos y directorios es mayor a 4096
				return dir.getName().startsWith(token) && dir.length() > 4096;
			}
		});

		System.out.println("Encontrados: " + listaArchivos.length);
		// Lista los archivos instanciados por FileFilter...
		for (int i = 0; i < listaArchivos.length; i++) {
			System.out.println(listaArchivos[i] + "{"
					+ listaArchivos[i].length() + "}"+listaArchivos[i].isFile());
		}
	}

	public static void main(String[] args) {
		TP6Test5 l = new TP6Test5();
		l.demoList();
	}

}
