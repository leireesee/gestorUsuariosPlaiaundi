package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	
	//VARIABLES
	private int id;
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contrasena;
	private boolean activo;
	
	
	//GETTERS / SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	//CONSTRUCTOR SIN PARAMETROS
	public Usuario() {}
	
	
	//CONSTRUCTOR CON PARAMETROS
	public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasena, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activo = activo;
	}
	
	
	//TO STRING
	public String toString() {
		return this.id + ";" + this.nombre + ";" + this.apellido + ";" + this.nombreUsuario + ";" + this.contrasena + ";" + (this.activo==true?"1":"0");
	}
	
	
	//CARGAR DATOS (METODO ESTATICO)
	public static ArrayList<Usuario> cargarUsuarios(String nombre_fichero) throws FileNotFoundException{
		ArrayList <Usuario> usuarios = new ArrayList<>();
		File file = new File("src/datos/usuarios.txt");
		Scanner scFile = new Scanner(file);
		String linea;
		String[] partes;
		for (int i = 0; scFile.hasNextLine(); i++) {
			linea=scFile.nextLine();
			partes=linea.split(";");
			
			Usuario usuario = new Usuario (Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4], partes[5].equals("1")?true:false);
			usuarios.add(usuario);
		}
		return usuarios;
	}
	
	//GUARDAR DATOS (METODO ESTATICO)
	public static void guardarDatos(ArrayList<Usuario> usuarios, String nombreFichero) throws FileNotFoundException {
		File file = new File(nombreFichero);
		PrintWriter writer = new PrintWriter(file);
		for (Usuario usuario : usuarios) {
			writer.println(usuario);
		}
		writer.close();
	}
	
}
