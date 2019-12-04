package Componets;

import Models.TblProductos;
import Views.Producto;
import Views.ProductosBD;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<TblProductos,String> {
    /*
    en esta clase se crea los botones de ProductosBD


     */
    Button btnCelda;
    int opc;
    TblProductos objtp;
    Producto objprod;
    public ButtonCell(int opc){
        this.opc=opc;
        if (opc == 1) {
            btnCelda=new Button("Editar");
            btnCelda.setOnAction(Event -> editar());
        }else{
            btnCelda=new Button("Eliminar");
            btnCelda.setOnAction(Event -> eliminar());
        }
    }

    private void eliminar() {
        objtp = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
        objtp.delproducto();
       ButtonCell.this.getTableView().setItems(objtp.selallproducto());
       ButtonCell.this.getTableView().refresh();

    }

    private void editar() {

        objprod= new Producto(ButtonCell.this.getTableView()); //sirve para mostrar la tabla
        objtp = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
        objprod.txtID.setText(objtp.getIdproductos()+"");
        objprod.txtNombre.setText(objtp.getDscproductos());
        objprod.txtCant.setText(objtp.getCantidad()+"");
        objprod.txtPrecio.setText(objtp.getPrecio()+"");
        objprod.txtCosto.setText(objtp.getCosto()+"");
        objprod.txtTalla.setText(objtp.getTalla());
        objprod.isEdit=true;



    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty ){
            setGraphic(btnCelda);
        }
    }
}
