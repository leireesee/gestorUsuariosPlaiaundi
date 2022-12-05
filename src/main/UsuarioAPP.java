package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class UsuarioAPP {

	public static void main(String[] args) throws FileNotFoundException {
		
		//File file = new File("src/datos/usuarios.txt");
		//Scanner scFile = new Scanner(file);
		
		Scanner teclado = new Scanner(System.in);
		
		//CARGAR DATOS
		ArrayList<Usuario> usuarios = Usuario.cargarUsuarios("src/datos/usuarios.txt");
		
		//VARIABLES MODIFICAR DATOS
		int contBuscador = 0;
		
		//VARIABLES MENU
		final int mostrar_usuarios = 1;
		final int eliminar_usuario = 2;
		final int crear_usuario = 3;
		final int modificar_usuario = 4;
		final int SALIR = 0;
		int opcion_menu;
		
		
		//MENU
		do {
			System.out.println("------MENU-------");
			System.out.println(mostrar_usuarios + ". Mostrar Usuarios");
			System.out.println(eliminar_usuario + ". Eliminar Usuario");
			System.out.println(crear_usuario + ". Crear Usuario");
			System.out.println(modificar_usuario + ". Modificar Usuario");
			System.out.println(SALIR + ". Salir");
			System.out.println("Elije una de las opciones");
			opcion_menu = Integer.parseInt(teclado.nextLine());

			switch (opcion_menu) {
			case mostrar_usuarios:
				mostrarUsuarios(usuarios);
			 	break;
			case eliminar_usuario:
				System.out.println("Has elegido eliminar un usuario.");
				eliminarUsuario(teclado, usuarios);
				break;
			case crear_usuario:
				System.out.println("Has elegido crear usuario.");
				crearUsuario(teclado, usuarios);
				break;
			case modificar_usuario:
				System.out.println("Has elegido crear usuario.");
				modificarUsuario(teclado, usuarios, contBuscador);
				break;
			case SALIR:
				System.out.println("ADIOS");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (opcion_menu != SALIR);
		teclado.close();
		
		Usuario.guardarDatos(usuarios, "src/datos/usuarios.txt");
		
	}

	private static void modificarUsuario(Scanner teclado, ArrayList<Usuario> usuarios, int contBuscador) {
		System.out.println("Introduce el dni del usuario a modificar");
		int dniBuscado = Integer.parseInt(teclado.nextLine());
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == dniBuscado) {
				System.out.println("Usuario encontrado:");
				System.out.println(usuario);
				System.out.println("Introduce el nuevo nombre de usuario");
				String nuevoNombreDeUsuario = teclado.nextLine();
				System.out.println("Introduce la nueva contraseña");
				String nuevoContrasena = teclado.nextLine();
				usuario.setNombreUsuario(nuevoNombreDeUsuario);
				usuario.setContrasena(nuevoContrasena);
			} 
			if (contBuscador > 0) {
				System.out.println("Usuario no encontrado");
			}
		}
				
	}

	private static void crearUsuario(Scanner teclado, ArrayList<Usuario> usuarios) {
		System.out.println("Introduce tu DNI");
		int dniIntroducidoPorUsuario = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce tu nombre");
		String nombreIntroducidoPorUsuario = teclado.nextLine();
		System.out.println("Introduce tu apellido");
		String apellidoIntroducidoPorUsuario = teclado.nextLine();
		System.out.println("Introduce tu nombre de usuario");
		String nombreUsuarioIntroducidoPorUsuario = teclado.nextLine();
		System.out.println("Introduce una contrasena");
		String contrasenaIntroducidoPorUsuario = teclado.nextLine();
		boolean estadoUsuario = true;
		
		Usuario nuevoUsuario = new Usuario(dniIntroducidoPorUsuario, nombreIntroducidoPorUsuario, apellidoIntroducidoPorUsuario, nombreUsuarioIntroducidoPorUsuario, contrasenaIntroducidoPorUsuario, estadoUsuario);
		
		usuarios.add(nuevoUsuario);
		
	}

	private static void eliminarUsuario(Scanner teclado, ArrayList<Usuario> usuarios) {
		
		System.out.println("Introduce el dni a eliminar");
		int dniBuscado = Integer.parseInt(teclado.nextLine());
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()) {
			int nombreBuscado = it.next().getId();
			if (nombreBuscado == dniBuscado) {
				it.remove();
				System.out.println("Eliminado con éxito");
			}
		}
	}

	private static void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		System.out.println("Mostrando todos los usuarios...");
		//for (int i = 0; i < usuarios.size(); i++) {
		//	System.out.println(usuarios.get(i));
		//}
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}
	
}
