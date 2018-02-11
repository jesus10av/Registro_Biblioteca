/*
 * Created by gerardoayala on 1/21/16.
 */
public class Main
{
    public static void main(String[] args)
    {
        Interfaz view;
        EstructuradeDatos model;
        Mediador controller;
        /////////////////////////////////////

        //Se crea el model.
        model = new EstructuradeDatos();

        // Se crea el view.
        view = new Interfaz();

        // Se crea el controller,
        controller = new Mediador(model, view);
        // y se asocia al view.
        view.setActionListener(controller);

        // se inicia el contenido del view
        controller.actualizaElView();

        // Se inicia la ejecucion de la aplicacion.
        view.inicia();
    }//end main

}//end class MVCProjectMain

