
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;


public class Mediador implements Controller
{
    EstructuradeDatos model;
    Interfaz view;
    //
    //Dialogo dialogo;
    int indice;
    boolean interfazEstaLimpia;
    ///////////////////////////


    public Mediador(EstructuradeDatos theModel, Interfaz theView)
    {
        model = theModel;
        view = theView;
        indice = 0;
        interfazEstaLimpia = false;
    }



    public Libro obtieneDatoDelModel(int indice)
    {
        Libro dato;

        dato = null;
        if(model.hayDatos())
            dato = model.get(indice);

        return dato;
    }



    public Libro obtieneDatoDelView()
    {
        Libro dato;
        //
        String nombre;
        String autor;
        String editorial;
        int ano;
        String codigo;
        //
        String anoTexto;
        Integer objetoInteger;
        /////////////////

        nombre = view.campoNombre.getText();
        autor = view.campoAutor.getText();
        editorial = view.campoEditorial.getText();
        anoTexto = view.campoAño.getText();
        objetoInteger = new Integer(anoTexto);
        ano = objetoInteger.intValue();
        codigo = view.campoCodigo.getText();

        dato = new Libro();
        dato.setNombre(nombre);
        dato.setAutor(autor);
        dato.setEditorial(editorial);
        dato.setAno(ano);
        dato.setCodigo(codigo);
        return dato;
    }

    private double procesamientoPorParteDelModel(int unIndice)
    {
        return model.procesa(unIndice);
    }



    public void actualizaElView()
    {
        Libro dato;
        String nombre;
        String autor;
        String editorial;
        int ano;
        String codigo;

        Integer objetoInteger;

        dato = obtieneDatoDelModel(indice);
        if(dato != null)
        {
            view.campoNombre.setText(dato.getNombre());
            view.campoAutor.setText(dato.getAutor());
            view.campoEditorial.setText(dato.getEditorial());
            ano = dato.getAno();
            objetoInteger = new Integer(ano);
            view.campoAño.setText(objetoInteger.toString());
            view.campoCodigo.setText(dato.getCodigo());

            interfazEstaLimpia = false;
        }//end if
        else
        {
            limpiaInterfaz();
        }//end else
    }//end actualizaElView


    private void limpiaInterfaz()
    {
        view.campoNombre.setText("");
        view.campoAutor.setText("");
        view.campoEditorial.setText("");
        view.campoAño.setText("");
        view.campoCodigo.setText("");
        interfazEstaLimpia = true;
    }//end limpiaInterfaz


    ///////// Metodos de actualizacion del Model /////////////

    public void solicitaActualizacionDelModel(String accion)
    {
        Libro dato;
        /////////////////
        if(accion.equals("agregar"))
        {
            dato = obtieneDatoDelView();
            indice = indice + 1;
            model.agregaDatosALaEstructura(indice, dato);
        }//end if

        if(accion.equals("eliminar"))
        {
            model.eliminaDatosDeLaEstructura(indice);
        }//end if

        if(accion.equals("modificar"))
        {
            dato = obtieneDatoDelView();
            model.modificaDatosEnLaEstructura(indice, dato);
        }//end if

        if(accion.equals("ordenar"))
        {
            model.ordenaLaEstructura();
        }//end if

    }//end actualizaElModel




    ///////// Metodos de control  /////////////

    private void decrementaApuntador()
    {
        if(indice == 0)
            indice = model.size()-1;
        else
            indice = indice - 1;
        //end if else
    }//end decrementaApuntador


    private void incrementaApuntador()
    {
        if(indice == model.size()-1)
            indice = 0;
        else
            indice = indice  + 1;
        //end if else
    }//end incrementaApuntador



    public void actionPerformed(ActionEvent evento)
    {
        Button botonAccionado;
        ///////////////////////

        botonAccionado = (Button) evento.getSource();

        if(botonAccionado == view.botonAnterior)
        {
            decrementaApuntador();
            actualizaElView();
        }//end if


        if(botonAccionado == view.botonSiguiente)
        {
            incrementaApuntador();
            actualizaElView();
        }//end if


        if(botonAccionado == view.botonAgregar)
        {
            if(interfazEstaLimpia)
            {
                solicitaActualizacionDelModel("agregar");
                actualizaElView();
            }//end if
        }//end if


        if(botonAccionado == view.botonEliminar)
        {
            solicitaActualizacionDelModel("eliminar");
            decrementaApuntador();
            actualizaElView();

        }//end if


        if(botonAccionado == view.botonModificar)
        {
            solicitaActualizacionDelModel("modificar");
            actualizaElView();
        }//end if


        if(botonAccionado == view.botonOrdenar)
        {
            solicitaActualizacionDelModel("ordenar");
            indice = 0;
            actualizaElView();
        }//end if


        if(botonAccionado == view.botonSalvar)
        {
            model.salvaDatosDeLaEstructuraAlRepositorio();


            //end if
        }//end if


        if(botonAccionado == view.botonLimpiar)
        {
            limpiaInterfaz();
        }//end if
    }//end actionPerformed

}//end class Mediator
