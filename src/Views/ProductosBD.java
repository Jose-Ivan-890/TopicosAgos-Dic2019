package Views;

import Componets.ButtonCell;
import Models.TblMarca;
import Models.TblProductos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.PropertyPermission;

public class ProductosBD extends Stage {

    private TextField txtBusqueda;
    private Scene scene;
    private VBox vFormulario;
    private HBox hboxBuscar;
    private Button btnBuscar,btnAgregar;
    private TableView tbvTabla;


public ProductosBD(){
    CreateGUI();
    this.setTitle("Tienda");
    this.setScene(scene);
    this.show();
    }

    private void CreateGUI() {

        hboxBuscar = new HBox();
        btnBuscar = new Button("Buscar");
        txtBusqueda = new TextField();
        btnAgregar = new Button("Agregar");
        vFormulario = new VBox();
        tbvTabla = new TableView();
        scene = new Scene(vFormulario);

        hboxBuscar.getChildren().addAll(txtBusqueda, btnBuscar);
        vFormulario.getChildren().addAll(hboxBuscar, tbvTabla, btnAgregar);


        CrearTabla();
/*
btnAgregar.setOnAction(event ->  Abrir_Producto());

}

    private void Abrir_Producto() {
    Producto ventana =new Producto();
    }
 */  //sirve lo mismo que el de abajo

        btnAgregar.setOnAction(event -> new Producto());

    }

    private void CrearTabla() {
        TableColumn<TblProductos,Integer> tcID= new TableColumn<>("Id");
        tcID.setCellValueFactory(new PropertyValueFactory<>("idproductos"));

        TableColumn<TblProductos,String> tcDSC = new TableColumn<>("Descripcion");
        tcDSC.setCellValueFactory(new PropertyValueFactory<>("dscproductos"));

        TableColumn<TblProductos,Float> tcCosto  = new TableColumn<>("Costo");
        tcCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        TableColumn<TblProductos,Float> tcPrecio  = new TableColumn<>("Precio");
        tcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<TblProductos,Integer> tcCantidad  = new TableColumn<>("Cantidad") ;
        tcCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<TblProductos,String> tcTalla  = new TableColumn<>("Talla");
        tcTalla.setCellValueFactory(new PropertyValueFactory<>("talla"));

        //estos son los demas
        TableColumn<TblProductos,String> tcEditar  = new TableColumn<>("Editar");
        tcEditar.setCellFactory(new Callback<TableColumn<TblProductos, String>, TableCell<TblProductos, String>>() {
            @Override
            public TableCell<TblProductos, String> call(TableColumn<TblProductos, String> param) {
                return new ButtonCell(1);
            }
        });
        TableColumn<TblProductos,String> tcEliminar  = new TableColumn<>("Eliminar");
        tcEliminar.setCellFactory(new Callback<TableColumn<TblProductos, String>, TableCell<TblProductos, String>>() {
            @Override
            public TableCell<TblProductos, String> call(TableColumn<TblProductos, String> param) {
                return new ButtonCell(2);
            }
        });



        tbvTabla.getColumns().addAll(tcID,tcDSC,tcCosto,tcPrecio,tcCantidad,tcTalla,tcEditar,tcEliminar);

        TblProductos objP =new TblProductos();

        tbvTabla.setItems(objP.selallproducto());
        System.out.println("bien");
    }


}
