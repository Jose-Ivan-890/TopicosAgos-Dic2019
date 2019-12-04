package Evento;

import Models.TblProductos;
import Views.ProductosBD;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BuscarProducto implements EventHandler<KeyEvent> {
TblProductos objp =null;
ProductosBD objbd = null;

public BuscarProducto(ProductosBD objbd){
    this.objbd=objbd;
}
    @Override
    public void handle(KeyEvent keyEvent) {

        if (keyEvent.getCode().isLetterKey()||keyEvent.getCode().isWhitespaceKey()||keyEvent.getCode()== KeyCode.BACK_SPACE){
            objp=new TblProductos();

           objp.setDscproductos(objbd.txtBusqueda.getText());

            objbd.tbvTabla.setItems(objp.selallproductobyname());
            objbd.tbvTabla.refresh();
        }

    }
}
