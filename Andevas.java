// programa calculador de ruta mínima en sistema de transporte
// versión: 20240513
// autor: Carlos Grasa Lambea

import java.io.Serializable;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Andevas implements Serializable {

	// campos -----------------------------------------------
	private static boolean esProbando=true; // realiza o no comentarios de seguimiento
	private static boolean esInstanciado=false; // asegura instancia única
	private SortedMap<String, Nodo> nodos; // datos de nodos
	private SortedMap<String, Arco> arcos; // datos de arcos

	// constructores ----------------------------------------
	public Andevas() { // constructor por omisión
		return;
	}

	// método main -------------------------------------------
	public static void main(String[] args) {
		try {
			if (esInstanciado) {
				if (esProbando)
					K.escribir("[probando] - Ya está ejecutándose una instancia. Solo se permite una.\n");
			} else {
				if (esProbando)
					K.escribir("[probando] - Instanciando aplicación.\n");
				Andevas app = new Andevas();
				esInstanciado=true;
				app.controlar();
				K.escribir("- Programa terminado normalmente.\n");
				System.exit(0);
			}
		} catch (Exception exc) {
			K.escribir("- Error durante ejecución. Abortando programa.\n");
			K.escribir(exc.getMessage()+"\n");
			exc.printStackTrace();
			System.exit(1);
		}
		return;
	}

	// métodos -------------------------------------------------
	public void controlar() {
		nodos=new TreeMap<>();
		arcos=new TreeMap<>();
		nodos=(TreeMap) K.obtenerObjeto("nodos.dat");
		if (esProbando && nodos==null)
			K.escribir("- No se han obtenido los nodos.\n");
		arcos=(TreeMap) K.obtenerObjeto("arcos.dat");
		if (esProbando && arcos==null)
			K.escribir("- No se han obtenido los arcos.\n");
		menuPrincipal();
		return;
	}
	public void menuPrincipal() {
		char opcion;
		do {
			K.limpiarConsola();
			K.escribir("---------------------------------------------------------\n");
			K.escribir("Andevás - Cálculo de ruta óptima en sistema de transporte\n");
			K.escribir("---------------------------------------------------------\n");
			K.escribir("a - listar nodos del sistema\n");
			K.escribir("b - listar Arcos del sistema\n");
			K.escribir("c - generar nuevo nodo\n");
			K.escribir("d - generar nuevo arco\n");
			K.escribir("e - actualizar nodo existente\n");
			K.escribir("f - actualizar arco existente\n");
			K.escribir("g - eliminar nodo existente\n");
			K.escribir("h - eliminar arco existente\n");
			K.escribir("z - salir\n");
			K.escribir("---------------------------------------------------------\n");
			opcion=K.preguntarChar("elija su opción", "abcdefghz");
			switch (opcion) {
				case 'a' -> listarNodos();
				case 'b' -> listarArcos();
				case 'c' -> generarNodo();
				case 'd' -> generarArco();
				case 'e' -> actualizarNodo();
				case 'f' -> actualizarArco();
				case 'g' -> eliminarNodo();
				case 'h' -> eliminarArco();
				case 'z' -> K.escribir("\n- Finalizando programa.\n ");
				default -> K.escribir("\n- Error seleccionando comando de menú.\n");
			}
		} while (opcion!='z');
		K.pausarConsola();
		return;
	}
	public void listarNodos() {
		Object clave;
		K.limpiarConsola();
		K.escribir("--------------------------------------------------------------\n");
		K.escribir("listado de identificadores de nodos:\n");
		K.escribir("--------------------------------------------------------------\n");
		if (nodos.isEmpty())
			K.escribir("Actualmente no hay nodos en el sistema.\n");
		else {
			clave=nodos.firstKey();
			int n=0;
			while (clave!=null) {
				n--;
				if (n>25) {
					K.pausarConsola();
					n = 0;
				}
				K.escribir("[" + clave + "] ");
				clave=((TreeMap) nodos).higherKey(clave);
			}
			K.escribir("--------------------------------------------------------------\n");
			K.escribir("Hay " + nodos.size() + " nodos en el sistema.\n");
		}
		K.pausarConsola();
		return;
	}
	public void listarArcos() {
		return;
	}
	public void generarNodo() {
		return;
	}
	public void generarArco() {
		return;
	}
	public void actualizarNodo() {
		return;
	}
	public void actualizarArco() {
		return;
	}
	public void eliminarNodo() {
		return;
	}
	public void eliminarArco() {
		return;
	}
/*

		public void visualizarEjercicio() {
			String clave;
			limpiarPantalla();
			K.escribir("---------------------------------------------\n");
			K.escribir("visualizar ejercicio existente:\n");
			if (ejercicios.isEmpty())
				K.escribir("Actualmente no hay ejercicios cargados.\n");
			else {
				clave=K.preguntar("Introduzca la clave del ejercicio");
				if (ejercicios.containsKey(clave))
					mostrarEjercicioEnPantalla(clave);
				else
					K.escribir("Clave de ejercicio no encontrada.\n");
			}
			pausar();
			return;
		}
		public void generarEjercicio() {
			String clave;
			limpiarPantalla();
			K.escribir("---------------------------------------------\n");
			K.escribir("generar nuevo ejercicio:\n");
			clave=K.preguntar("Introduzca clave del ejercicio a generar");
			if (ejercicios.containsKey(clave))
				K.escribir("La clave \'"+clave+"\' ya existe.\n");
			else {
				Ejercicio ejercicio=new Ejercicio();
				pedirDatosEjercicio(ejercicio);
				if (ejercicios.containsValue(ejercicio))
					K.escribir("Ese ejercicio está repetido. Anexión cancelada.\n");
				else {
					ejercicios.put(clave, ejercicio);
					K.escribir("Ejercicio de clave \'"+clave+"\' anexado.\n");
					K.escribir("Actualmente hay "+ejercicios.size()+" ejercicios.\n");
				}
			}
			pausar();
			return;
		}
		public void actualizarEjercicio() {
			String clave;
			Ejercicio ejercicio;
			limpiarPantalla();
			K.escribir("---------------------------------------------\n");
			K.escribir("actualizando ejercicio existente:\n");
			if (ejercicios.isEmpty())
				K.escribir("Actualmente no hay ejercicios cargados.\n");
			else {
				clave=K.preguntar("Introduzca la clave del ejercicio");
				if (ejercicios.containsKey(clave)) {
					ejercicio=ejercicios.get(clave);
					K.escribir("Comentario actual: "+ejercicio.getComentario()+"\n");
					K.escribir("Código FEN actual: "+ejercicio.getCodigoFen()+"\n");
					K.escribir("Objetivo actual: "+ejercicio.getObjetivo()+"\n");
					K.escribir("Solución actual: "+ejercicio.getSolucion()+"\n");
					K.escribir("Número actual de movimientos: "+ejercicio.getCuantosMovimientos()+"\n");
					K.escribir("Turno actual de juego: "+ejercicio.getEsTurnoBlancas()+"\n");
					pedirDatosEjercicio(ejercicio);
					K.escribir("Ejercicio de clave \'"+clave+"\' actualizado.\n");
				} else
					K.escribir("Clave de ejercicio no encontrada.\n");
			}
			pausar();
			return;
		}
		public void eliminarEjercicio() {
			String clave;
			limpiarPantalla();
			K.escribir("---------------------------------------------\n");
			K.escribir("eliminar ejercicio existente:\n");
			if (ejercicios.isEmpty())
				K.escribir("Actualmente no hay ejercicios cargados.\n");
			else {
				clave=K.preguntar("Introduzca clave del ejercicio a eliminar");
				if (ejercicios.containsKey(clave)) {
					ejercicios.remove(clave);
					K.escribir("Eliminado ejercicio de clave \'"+clave+"\'.\n");
				} else
					K.escribir("Clave de ejercicio no encontrada.\n");
			}
			pausar();
			return;
		}
		public void listarEjercicios() {
			Object clave;
			limpiarPantalla();
			K.escribir("---------------------------------------------\n");
			K.escribir("listado de claves de ejercicios presentes:\n");
			if (ejercicios.isEmpty())
				K.escribir("Actualmente no hay ejercicios cargados.\n");
			else {
				clave=ejercicios.firstKey();
				while (clave!=null) {
					K.escribir("\tclave: " + clave + "\n");
					clave=siguienteClave(clave);
				}
				K.escribir("Hay " + ejercicios.size() + " ejercicios.\n");
			}
			pausar();
			return;
		}
		public Object siguienteClave(Object obj) {
			return ((TreeMap) ejercicios).higherKey(obj);
		}
		public void mostrarEjercicioEnPantalla(String clave) {
			Ejercicio ejercicio=ejercicios.get(clave);
			limpiarPantalla();
			K.escribir("---------------------------------------------\n");
			K.escribir("mostrando ejercicio de clave \'"+clave+"\':\n");
			K.escribir(ejercicio.getComentario()+"\n");
			K.escribir("código FEN: "+ejercicio.getCodigoFen()+"\n");
			K.escribir((ejercicio.getEsTurnoBlancas() ? "Blancas " : "Negras ")+ejercicio.getObjetivo()+"\n");
			if (ejercicio.getCuantosMovimientos()>0)
				K.escribir("(Considerar "+ejercicio.getCuantosMovimientos()+(ejercicio.getCuantosMovimientos()==1 ? " movimiento" : " movimientos")+")\n");
			K.preguntar("Pulse INTRO para ver la solución...");
			K.escribir("solución: "+ejercicio.getSolucion()+"\n");
			return;
		}
		public void pedirDatosEjercicio(Ejercicio ejercicio) {
			K.escribir("---------------------------------------------\n");
			K.escribir("introduzca los nuevos datos del ejercicio:\n");
			ejercicio.setComentario(K.preguntar("Introduzca el comentario"));
			ejercicio.setCodigoFen(K.preguntar("Introduzca el código FEN"));
			ejercicio.setObjetivo(K.preguntar("Introduzca el objetivo"));
			ejercicio.setSolucion(K.preguntar("Introduzca la solución"));
			ejercicio.setCuantosMovimientos((int) K.preguntarLong("Introduzca el número de movimientos", 0));
			ejercicio.setEsTurnoBlancas(K.preguntarChar("¿Es turno de las blancas?", "sn")=='s');
			return;
		}
 */
}
