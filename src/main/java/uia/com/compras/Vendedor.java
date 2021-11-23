package uia.com.compras;

import java.util.ArrayList;
import java.util.HashMap;

public class Vendedor {
    private double valorUnitario=0;
    private double subtotal=0;
    private int clasificacion = 0;
    private boolean proveedor;
    private final int pedidoProveedor=0;
    private Vendedor miPeticionOC;

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    protected HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> proveedores = new HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>>();

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {this.clasificacion = clasificacion;
    }

    public HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> getProveedores() {
        return proveedores;
    }

    public void setProveedores(HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> proveedores) {
        this.proveedores = proveedores;



    }
    public void hazCotizaciones(PeticionOrdenCompra miPeticionOC ){
        validaExistencia(miPeticionOC);


    }

    private void validaExistencia(PeticionOrdenCompra miPeticionOC) {
        for (int i = 0; i < miPeticionOC.getItems().size(); i++) {
            validaUso((PeticionOrdenCompra) miPeticionOC.getItems().get(i), i);
        }
    }

    private void validaUso(PeticionOrdenCompra peticionOrdenCompra, int i) {
        switch (i % 3) {
            case 0:
                miPeticionOC.setValorUnitario(0);
                break;
            case 1:
                miPeticionOC.setValorUnitario(1);
                break;
            case 2:
                miPeticionOC.setValorUnitario(2);
                break;
        }
    }

    public void seleccionProveedor(){
        if(!proveedor){
            System.out.println("Su seleccion es afirmativa");
        }
        else{
            System.out.println("Su seleccion ha sido rechazada");
        }
    }
    public SolicitudOrdenCompra buscaProveedor(PeticionOrdenCompra miPeticionOC){
        SolicitudOrdenCompra miSolicitudOC = new SolicitudOrdenCompra();

        for (int i = 0; i < miPeticionOC.getItems().size(); i++) {
            SolicitudOrdenCompra item;
            item = new SolicitudOrdenCompra((PeticionOrdenCompra) miPeticionOC.getItems().get(i));
            if (!(buscaProveedor(item, i) == 0)) {
                if (miSolicitudOC.getItems() == null)
                    miSolicitudOC.setItems(new ArrayList<InfoComprasUIA>());
                miSolicitudOC.getItems().add(item);
            }
        }
        return miSolicitudOC;

    }
    private int buscaProveedor(SolicitudOrdenCompra solicitudOC, int i) {
        switch (i % 3) {
            case 0:
                solicitudOC.setPedidoProveedor(0);
                return i;
            case 1:
                solicitudOC.setPedidoProveedor(1);
                return i;
            case 2:
                solicitudOC.setPedidoProveedor(2);
                return i;
        }
        return -1;
    }

    public void agrupaProveedores(PeticionOrdenCompra peticionOC) {
        SolicitudOrdenCompra newItem = null;
        int key = 0;
        int keyLista = -1;

        if (proveedores == null)
            proveedores = new HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>>();

        for (int i = 0; i < peticionOC.getItems().size(); i++) {
            newItem = (SolicitudOrdenCompra) peticionOC.getItems().get(i);
            key = newItem.getVendedor();
            keyLista = i % 3;

            if (proveedores.containsKey(key)) {
                if (proveedores.get(key).containsKey(keyLista)) {
                    proveedores.get(key).get(keyLista).add(newItem);
                } else {
                    ArrayList<InfoComprasUIA> newLista = new ArrayList<InfoComprasUIA>();
                    newLista.add(newItem);
                    HashMap<Integer, ArrayList<InfoComprasUIA>> nodo = new HashMap<Integer, ArrayList<InfoComprasUIA>>();
                    nodo.put(i, newLista);
                    proveedores.put(key, nodo);
                }
            } else {
                ArrayList<InfoComprasUIA> newLista = new ArrayList<InfoComprasUIA>();
                newLista.add(newItem);
                HashMap<Integer, ArrayList<InfoComprasUIA>> nodo = new HashMap<Integer, ArrayList<InfoComprasUIA>>();
                nodo.put(keyLista, newLista);
                proveedores.put(key, nodo);
            }
        }
    }

    public void print() {
    }
}