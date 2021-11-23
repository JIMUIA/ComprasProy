package uia.com.compras;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cotizaciones extends PeticionOrdenCompra {
    private int proveedor = -1;

    @JsonCreator
    public Cotizaciones (@JsonProperty("id") int id, @JsonProperty("name") String name,
                         @JsonProperty("codigo") String codigo, @JsonProperty("unidad") String unidad,
                         @JsonProperty("cantidad") int cantidad, @JsonProperty("proveedor") int proveedor)
    {
        super(id, name, codigo, unidad, cantidad);
        this.proveedor=proveedor;

    }

    public Cotizaciones(PeticionOrdenCompra info)
    {
        super(info.getId(), info.getName(), info.getCodigo(), info.getUnidad(), info.getCantidad());
        this.setPedidoProveedor(info.getPedidoProveedor());
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

}