package Views;

        import Componets.ButtonCell;
        import Models.TblProductos;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;

public class Producto extends Stage {
    private Label[] lbCampos;
    private TextField txtID,txtNombre,txtCant,txtCosto,txtPrecio,txtTalla;
    private ComboBox cbxMarca;
    private VBox vFormulario;
    private HBox [] hBoxes;
    private Button guardar;
    private Scene scene;
    private  TblProductos objp ;
    private TableView tbvTabla;




    public Producto(TableView tbvTabla){
        CrearGUI();
        this.tbvTabla= tbvTabla;

        this.setTitle("Gestionar Producto");
        this.setScene(scene);
        this.show();
    }

    public void CrearGUI(){
        lbCampos = new Label[7];
        hBoxes =new HBox[7];
        vFormulario = new VBox();
        guardar=new Button("Guardar");
        guardar.setOnAction(event -> Guardar_Producto());
        objp = new TblProductos();


        String[] textos={"No","Nombre","Cantidad","Costos","Precio","Talla","MARCA"};
        for (int i = 0; i < lbCampos.length; i++) {
            lbCampos[i]=new Label(textos[i]);
            hBoxes[i]=new HBox();
            hBoxes[i].getChildren().add(lbCampos[i]);

        }
        txtID =new TextField();
        hBoxes[0].getChildren().add(txtID);
        txtNombre =new TextField();
        hBoxes[1].getChildren().add(txtNombre);
        txtCant =new TextField();
        hBoxes[2].getChildren().add(txtCant);
        txtCosto =new TextField();
        hBoxes[3].getChildren().add(txtCosto);
        txtPrecio =new TextField();
        hBoxes[4].getChildren().add(txtPrecio);
        txtTalla =new TextField();
        hBoxes[5].getChildren().add(txtTalla);
        cbxMarca =new ComboBox();
        hBoxes[6].getChildren().add(cbxMarca);

        vFormulario.getChildren().addAll(hBoxes[0],hBoxes[1],hBoxes[2],hBoxes[3],hBoxes[4],hBoxes[5],hBoxes[6],guardar);
        scene= new Scene(vFormulario,300,200);



    }

    private void Guardar_Producto(){

        try {// aqui se recibe el error de Producto TblProducto linea 65
            objp.setDscproductos(txtNombre.getText());
            objp.setCantidad(Integer.parseInt(txtCant.getText()));
            objp.setCosto(Float.parseFloat(txtCosto.getText()) );
            objp.setPrecio(Float.parseFloat(txtPrecio.getText()) );
            objp.setTalla(txtTalla.getText() );


            objp.insproducto();

            Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensaje del sistema");
            alert.setHeaderText("Confimacion de operacion");
            alert.setContentText("se ha agregado un registro :)");
            alert.showAndWait();
            tbvTabla.setItems(objp.selallproducto());
            tbvTabla.refresh();
            this.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
