package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class TblMarca {
        private int idmarca;
        private String dscmarca;

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getDscmarca() {
        return dscmarca;
    }

    public void setDscmarca(String dscmarca) {
        this.dscmarca = dscmarca;
    }

    public void insmarca(){
     String query = "INSERT INTO tblmarca(dscmarca) VALUES ('"+dscmarca+"') ";
        try {    //se utiliza un try y catch por que es un elemento fuera de este programa
            Statement stm=Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }
    }
    public void upmarca(){
        String query = "UPDATE tblmarca SET dscmarca = '"+dscmarca+"' WHERE  idmarca="+idmarca;
        try {    //se utiliza un try y catch por que es un elemento fuera de este programa
            Statement stm=Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }
    }
    public void delmarca(){
        String query = "DELETE FROM tblmarca WHERE  idmarca="+idmarca;
        try {    //se utiliza un try y catch por que es un elemento fuera de este programa
            Statement stm=Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }
    }
    public ObservableList<TblMarca> selallmarca(){
        String query = "Select  * from tblmarca";
        ObservableList<TblMarca> ListMarca= FXCollections.observableArrayList();
        try {
    TblMarca objm =null;
    Statement stm=Conexion.conexion.createStatement();
   ResultSet res = stm.executeQuery(query); //consultamos la tabla todo dependiendo el query
while (res.next()){
    objm = new TblMarca();
    objm.setIdmarca(res.getInt("idmarca"));
    objm.setDscmarca(res.getString("dscmarca")); // ver si es con N o sin ella
    ListMarca.add(objm);// se van almacenando



}

}catch (Exception e){

}

        return ListMarca;
    }
    public TblMarca selidmarca(){
    String query = "SELECT * FROM tblmarca WHERE idmarca="+idmarca; //variable de clase "idmarca"
        TblMarca objm=null;
try {
    Statement stmid =Conexion.conexion.createStatement();
    ResultSet resultSet=stmid.executeQuery(query);



    if (resultSet.next() ) {
        objm = new TblMarca();
        objm.setIdmarca(resultSet.getInt("idmarca"));
        objm.setDscmarca(resultSet.getString("dscmarca"));
    }

}catch (Exception e){}

    return objm;
    }

}
