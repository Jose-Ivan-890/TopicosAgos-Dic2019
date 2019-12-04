package Componets;

public class Corredor  extends Thread{
    public Corredor(String nombre){ //sobrecarga el constructor
        super(nombre);// super indica llama un metodo de la clase padre en este caso es el THREAD
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Corredor: "+getName()+"   en posicion");// get name toma el nombre que le dimos en el nmain

        for (int i = 1; i < 16; i++) {
            try {
                sleep((long) (Math.random()* 2000));
                System.out.println("Cprredor: "+getName()+"completo el kilometro: "+i);
            }catch (Exception e){

            }
        }

        System.out.println("Termino el Corredor:  "+getName());
    }
}
