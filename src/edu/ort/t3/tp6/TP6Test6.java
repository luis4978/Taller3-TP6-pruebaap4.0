package edu.ort.t3.tp6;
import java.io.FileNotFoundException;


public class TP6Test6 {
	public static void main(String[] args) {
		try {
			ListadoDirectorioOrdenado l = new ListadoDirectorioOrdenado("src\\edu\\ort\\t3\\tp69");
			//l.listar();
			l.listar(".java");
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
