import java.util.LinkedList;
import java.util.Collections;

public class EstructuradeDatos extends LinkedList<Libro>
        implements Model

{
    SequentialFile repositorio;


    public EstructuradeDatos()
    {
        cargaDatosDelRepositorioALaEstructura();
    }

    /// Metodos de cargado de datos y almacenamiento de datos /////////////////

    public void cargaDatosDelRepositorioALaEstructura()
    {
        int numeroDeLineas;
        int numeroDeRegistros;
        int i;
        Libro dato;
        String nombre;
        String autor;
        String editorial;
        int ano;
        String codigo;

        repositorio = new SequentialFile("/Users/jesus/IdeaProjects/MVC_Jesus/src/","archivo","txt");
        repositorio.open();
        numeroDeLineas = repositorio.getNumberOfLines();
        numeroDeRegistros = numeroDeLineas / 5;
        i = 0;
        while(i < numeroDeRegistros)
        {
            nombre = repositorio.readString();
            autor = repositorio.readString();
            editorial = repositorio.readString();
            ano = repositorio.readInt();
            codigo = repositorio.readString();
            dato = new Libro();
            dato.setNombre(nombre);
            dato.setAutor(autor);
            dato.setEditorial(editorial);
            dato.setAno(ano);
            dato.setCodigo(codigo);
            add(dato);
            i = i + 1;
        }

    }



    public void salvaDatosDeLaEstructuraAlRepositorio()
    {
        int i;
        String nombre;
        String autor;
        String editorial;
        int ano;
        String codigo;
        ;
        ///////

        repositorio = new SequentialFile("/Users/jesus/IdeaProjects/MVC_Jesus/src/","archivo","txt");
        repositorio.create();
        i = 0;
        while(i < size())
        {
            nombre = get(i).getNombre();
            autor = get(i).getAutor();
            editorial = get(i).getEditorial();
            ano = get(i).getAno();
            codigo = get(i).getCodigo();


            repositorio.writeString(nombre);
            repositorio.writeString(autor);
            repositorio.writeString(editorial);
            repositorio.writeInt(ano);
            repositorio.writeString(codigo);



            i = i + 1;
        }
    }





    public void agregaDatosALaEstructura(int indice, Object unDato)
    {
        Libro dato;
        //
        dato = (Libro) unDato;
        add(indice, dato);
    }//end agregaDatosALaEstructura


    public void modificaDatosEnLaEstructura(int indice, Object unDato)
    {
        Libro dato;
        //
        dato = (Libro) unDato;
        remove(indice);
        add(indice, dato);
    }//end modificaDatosEnLaEstructura


    public void eliminaDatosDeLaEstructura(int indice)
    {
        if( indice < size() && indice >= 0)
            remove(indice);
        //end if
    }//end eliminaDatosDeLaEstructura


    public void ordenaLaEstructura()
    {
        Collections.sort(this);
    }//end ordenaLaEstructura



    ///////// Metodos de procesamiento de datos

    public double procesa(int indice)
    {
        //double colegiatura;
        //Libro dato;
        //double COSTO_UNIDAD = 2460.00;
        ////////////

        //dato = get(indice);
        //colegiatura = dato.getUnidades() * COSTO_UNIDAD;
        //dato.setColegiatura(colegiatura);
       return -1;
    }//end procesa



    public boolean hayDatos()
    {
        if (size()>0)
            return true;
        else
            return false;
        //end if-else
    }//end hayDatos

}//end class EstructuraDeDatos