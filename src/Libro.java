
public class Libro  implements Comparable<Libro>
{

    private String Nombre;

    private String Autor;

    private String Editorial;

    private int Ano;

    private String Codigo;

    public Libro()
    {
        Nombre = "";
        Autor = "";
        Editorial = "";
        Ano = -1;
        Codigo = "";

    }


    public String getNombre()
    {
        return Nombre;
    }



    public String getAutor()
    {
        return Autor;
    }


    public String getEditorial()
    {
        return Editorial;
    }

    public int getAno ()
    {
        return Ano;
    }

    public  String getCodigo ()
    {
       return Codigo;
    }



    public void setNombre(String unNombre)
    {
        Nombre = unNombre;
    }

    public void setAutor(String unAutor)
    {
        Autor = unAutor;
    }

    public void setEditorial(String unaEditorial)
    {
        Editorial = unaEditorial;
    }

    public void setAno(int unAno)
    {
        Ano = unAno;
    }

    public void setCodigo(String unCodigo) {
        Codigo = unCodigo;

    }


        public int compareTo (Libro otroLibro){
            int otroAno;

            otroAno = otroLibro.getAno();

            if (Ano > otroAno)
                return 1;
            else if (Ano < otroAno)
                return -1;
            else
                return 0;

        }


    }