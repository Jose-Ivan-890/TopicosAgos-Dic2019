package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class TblProductos {
    private String dscproductos,talla;
    private int idproductos,cantidad,idmarca;
    private float costo,precio;


    public String getDscproductos() {
        return dscproductos;
    }

    public void setDscproductos(String dscproductos) {
        this.dscproductos = dscproductos;
    }

    public int getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }



    public void insproducto()throws Exception{  //ya no se utiliza el try catch por que throws Exception lo manda a donde lo piden "Producto"
        String query = "INSERT INTO tblproductos(dscproducto,cantidad,costo,precio,talla,idmarca) VALUES ('"+dscproductos+"',"+cantidad+","+costo+","+precio+",'"+talla+"',"+idmarca+"2) ";

        Statement stm=Conexion.conexion.createStatement();
        stm.executeUpdate(query) ;

     /*   try {    //se utiliza un try y catch por que es un elemento fuera de este programa
            Statement stm=Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }*/
    }

    //actulizar tabla
    public void upproducto(){
        String query = "UPDATE tblproductos SET dcproducto = '"+dscproductos+"',cantidad = "+cantidad+",costo="+costo+",precio="+precio+",talla= '"+talla+"',  WHERE  idproducto="+idproductos;
        try {    //se utiliza un try y catch por que es un elemento fuera de este programa
            Statement stm=Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }
    }
    public void delproducto(){
        String query = "DELETE FROM tblproductos WHERE  idproducto="+idproductos;
        try {    //se utiliza un try y catch por que es un elemento fuera de este programa
            Statement stm=Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }
    }


    public ObservableList<TblProductos> selallproducto(){
        String query = "Select  * from tblproductos";
        ObservableList<TblProductos> ListProductos= FXCollections.observableArrayList();

        try {
            TblProductos objp =null;
            Statement stm=Conexion.conexion.createStatement();
            ResultSet res = stm.executeQuery(query); //consultamos la tabla todo dependiendo el query
            while (res.next()){
                objp = new TblProductos();
                objp.setIdproductos(res.getInt("idproducto"));
                objp.setDscproductos(res.getString("dscproducto")); // ver si es con N o sin ella
                objp.setCantidad(res.getInt("cantidad"));
                objp.setCosto(res.getFloat("costo"));
                objp.setPrecio(res.getFloat("precio"));
                objp.setTalla(res.getString("talla"));

                ListProductos.add(objp);// se van almacenando



            }

        }catch (Exception e){

        }

        return ListProductos;
    }

    //realizar los demas inset


}

