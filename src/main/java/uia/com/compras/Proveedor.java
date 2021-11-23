package uia.com.compras;

import java.util.Map;

public class Proveedor {
    private Object proveedores;

    public PeticionOrdenCompra buscaProveedor(PeticionOrdenCompra miPeticionOC) {
        return miPeticionOC;
    }

    public void agrupaProveedores(PeticionOrdenCompra miSolicituOC) {
    }

    public Map<Object, Object> getProveedores() {
        return (Map<Object, Object>) proveedores;
    }

    public void setProveedores(Map<Object, Object> proveedores) {

        this.proveedores = proveedores;
    }
}
