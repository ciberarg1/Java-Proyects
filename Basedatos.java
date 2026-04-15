import java.sql.*; // Se utiliza para hablar con la base de datos.
import javax.swing.*;  // Nos da la interfaz grafica.
import java.awt.FlowLayout; // Es un administrador de diseño para la interfaz grafica.
import java.awt.event.ActionListener; //Permite que el programa entienda las acciones.
import java.awt.event.ActionEvent; // Transporta los datos de la accion
 
public class Basedatos extends JFrame {  // Con el extends JFrame le damos una ventana, para tener botones, bordes, etc.
    
    JTextField campoNombre; 
    JTextArea areaResultados;
    JButton botonBuscar;

    public Basedatos() {  // Este es el codigo que se va a ejecutar cuando se abre la ventana.
        setTitle("Buscador de Personas"); 
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para que el usuario cierre el programa, no siga corriendo por detras.

        campoNombre = new JTextField(20); // Hace referencia al tamaño del campo, donde vamos a escribir.
        add(campoNombre);

        botonBuscar = new JButton("Buscar en Mysql"); // Con new creamos el boton buscar, el texto entre () es lo que el usuario leera.
        add(botonBuscar);

        areaResultados = new JTextArea(10, 30); // Esto es donde apareceran los resultados.
        add(new JScrollPane(areaResultados));  // Muy importante "JScrollpane, por si devuelve mas datos, poder leer todos sin problemas.

        
        botonBuscar.addActionListener(new ActionListener() { // " addActionListener" escucha las acciones.
            public void actionPerformed(ActionEvent e) { // Esto se despierta solo cuando hacemos clic
                buscarPersona(campoNombre.getText()); // Lee lo que escribimos y se lo pasa como un paquete a la funcion "Buscarpersonas".
            }
        });
    }

    public void buscarPersona(String nombreABuscar) {
        String url = "jdbc:mysql://localhost:3306/trabajossql"; // "jdbc:mysql java usa esto para conectar con mysql
        String usuario = "root"; 
        String password = "(YOUR PASSWORD)"; 

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            
            String sql = "SELECT * FROM Personas WHERE nombre LIKE ?";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, "%" + nombreABuscar + "%");

            ResultSet rs = st.executeQuery();
            areaResultados.setText(""); 

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                areaResultados.append("Persona Encontrada: " + nombre + "\n");
            }

            conexion.close();
        } catch (SQLException e) {
            areaResultados.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) { 
        Basedatos ventana = new Basedatos();
        ventana.setVisible(true);
    } 
}

