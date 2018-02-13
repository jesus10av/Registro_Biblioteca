import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Color;

public class Interfaz extends Frame implements View {

    Button botonSiguiente;
    Button botonAnterior;
    Button botonSalvar;
    Button botonOrdenar;
    //Button botonBuscar;
    Button botonModificar;
    Button botonEliminar;
    Button botonLimpiar;
    Button botonAgregar;

    TextField campoNombre;
    TextField campoAutor;
    TextField campoEditorial;
    TextField campoAño;
    TextField campoCodigo;

    Label etiquetaNombre;
    Label etiquetaAutor;
    Label etiquetaEditorial;
    Label etiquetaAño;
    Label etiquetaCodigo;

    //Dialogo dialogo;

    public Interfaz ()
    {
        Color color;
        setTitle("ORGANIZACIÓN DE LIBROS");
        setBounds(200, 200, 450, 350);
        color = new Color(255,255,200);
        setBackground(color);
        setLayout(null);
        construyeComponentes();
    }


    public void construyeComponentes()
    {
        botonAnterior = new Button("Anterior");
        botonOrdenar = new Button("Ordenar");
        botonSalvar = new Button("Salvar");
        botonSiguiente = new Button("Siguiente");
        botonEliminar = new Button("Eliminar");
        botonLimpiar = new Button("Limpiar");
        botonAgregar = new Button("Agregar");
        botonModificar = new Button("Modificar");
        //botonBuscar = new Button( "Buscar");

        botonAnterior.setBounds(20, 260, 100, 30);
        add(botonAnterior);
        botonOrdenar.setBounds(120, 260, 100, 30);
        add(botonOrdenar);
        botonSalvar.setBounds(230, 260, 100, 30);
        add(botonSalvar);
        botonSiguiente.setBounds(330, 260, 100, 30);
        add(botonSiguiente);
        botonEliminar.setBounds(20, 230, 100, 30);
        add(botonEliminar);
        botonLimpiar.setBounds(120, 230, 100, 30);
        add(botonLimpiar);
        botonAgregar.setBounds(330, 230, 100, 30);
        add(botonAgregar);
        botonModificar.setBounds(230, 230, 100, 30);
        add(botonModificar);
        //botonBuscar.setBounds(330, 290, 100, 30);
        //add(botonBuscar);

        campoNombre = new TextField();
        campoAutor= new TextField();
        campoEditorial = new TextField();
        campoAño = new TextField();
        campoCodigo = new TextField();

        campoNombre.setBounds(200, 50, 150, 20);
        add(campoNombre);
        campoAutor.setBounds(200, 80, 150, 20);
        add(campoAutor);
        campoEditorial.setBounds(200, 110, 80, 20);
        add(campoEditorial);
        campoAño.setBounds(200,140, 80, 20);
        add(campoAño);
        add(campoAño);
        campoCodigo.setBounds(200,170, 150, 20);
        add(campoCodigo);

        etiquetaNombre = new Label("NOMBRE:");
        etiquetaAutor = new Label("AUTOR:");
        etiquetaEditorial = new Label("EDITORIAL:");
        etiquetaAño = new Label("AÑO:");
        etiquetaCodigo = new Label("CODIGO:");

        etiquetaNombre.setBounds(100, 50, 200, 20);
        add(etiquetaNombre);
        etiquetaAutor.setBounds(100, 80, 100, 20);
        add(etiquetaAutor);
        etiquetaEditorial.setBounds(100, 110, 200, 20);
        add(etiquetaEditorial);
        etiquetaAño.setBounds(100,140, 100, 20);
        add(etiquetaAño);
        etiquetaCodigo.setBounds(100,170, 100, 20);
        add(etiquetaCodigo);

    }

    public void setActionListener(Controller theController)
    {
        botonAnterior.addActionListener(theController);
        botonOrdenar.addActionListener(theController);
        botonSalvar.addActionListener(theController);
        botonSiguiente.addActionListener(theController);
        botonEliminar.addActionListener(theController);
        botonLimpiar.addActionListener(theController);
        botonAgregar.addActionListener(theController);
        botonModificar.addActionListener(theController);
        //botonBuscar.addActionListener(theController);
    }


    public void inicia()
    {
        setVisible(true);
    }

}



