import models.Persona;
import models.genericos.Caja;
import models.genericos.Par;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Crear objetos Caja
        Caja<String> cajaString = new Caja<>();
        Caja<Integer> cajaInteger = new Caja<>();
        Caja<Persona> cajaPersona = new Caja<>();

        
        cajaString.guardar("Guardado sin String");
        cajaInteger.guardar(10);

        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setEdad("50");
        cajaPersona.guardar(persona);

        // Obtener valores de las cajas
        System.out.println(cajaString.obtener());
        System.out.println(cajaInteger.obtener());
        System.out.println(cajaPersona.obtener());

        Persona[] personas = new Persona[10];
        for (int i = 0; i < personas.length; i++) {
            Persona p = new Persona();
            p.setNombre("Persona" + (i + 1));
            p.setEdad(String.valueOf(10 + (i * 2))); 
            personas[i] = p;
        }


        List<Par<String, String>> mayores = new ArrayList<>();
        List<Par<String, String>> menores = new ArrayList<>();

        
        for (Persona p : personas) {
            int edad = Integer.parseInt(p.getEdad());
            if (edad >= 18) {
                mayores.add(new Par<>(p.getNombre(), p.getEdad())); 
            } else {
                menores.add(new Par<>(p.getEdad(), p.getNombre())); 
            }
        }

        // Imprimir arreglos de mayores y menores
        System.out.println("\nMayores de edad:");
        for (Par<String, String> par : mayores) {
            System.out.println("Clave: " + par.getClave() + ", Valor: " + par.getValor());
        }

        System.out.println("\nMenores de edad:");
        for (Par<String, String> par : menores) {
            System.out.println("Clave: " + par.getClave() + ", Valor: " + par.getValor());
        }
    }
}

