package uia.com.compras;

public class SolicitudPeticionCompra extends PeticionOrdenCompra{
        PeticionOrdenCompra peticion = new PeticionOrdenCompra();

        public SolicitudPeticionCompra(int id, String name, String codigo, String unidad, int cantidad, String tipo) {
                super(id, name, codigo, unidad, cantidad, tipo);
        }

        @Override
        public int getCantidad() {
                return super.getCantidad();
        }

        @Override
        public void setCantidad(int cantidad) {
                super.setCantidad(cantidad);
        }

        @Override
        public String getUnidad() {
                return super.getUnidad();
        }

        @Override
        public void setUnidad(String unidad) {
                super.setUnidad(unidad);
        }

        @Override
        public String getCodigo() {
                return super.getCodigo();
        }

        @Override
        public void setCodigo(String codigo) {
                super.setCodigo(codigo);
        }

        public SolicitudPeticionCompra() {
                super();
        }

        @Override
        public void agregaItems(ListaReportesNivelStock miReporteNS) {
                super.agregaItems(miReporteNS);
        }
}
