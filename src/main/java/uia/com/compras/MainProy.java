package uia.com.compras;


import java.io.IOException;

public class MainProy {
    public static void main(String[] args) {
        System.out.println("Hola Usuario de Compras");

        GestorCompras migestor = null;
        try {
            migestor = new GestorCompras();
        } catch (IOException e) {
            e.printStackTrace();
        }

        migestor.print();
    }
}
