package vista;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.*;

import javax.swing.*;

import controlador.ControladorDependientes;
import es.unican.ps.supermercadoOnline.utils.IPreparacionPedidoRemote;
import es.unican.ps.supermercadoOnline.utils.IRealizaPedidoRemote;



/**
 * Ventana principal de la aplicacion de gestion de compras.
 * 
 * @author MP
 * @version mar-2014
 */
public class VentanaDependientes extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Muestra un dialogo de error con el titulo y el mensaje deseados
	 * @param tituloDialogo titulo del dialogo
	 * @param mensaje mensaje que aparece en el dialogo
	 */
	public void mensajeError(String tituloDialogo, String mensaje) {
		JOptionPane.showMessageDialog(VentanaDependientes.this,
				mensaje, tituloDialogo, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Muestra un dialogo de informacion con el titulo y el mensaje deseados
	 * @param tituloDialogo titulo del dialogo
	 * @param mensaje mensaje que aparece en el dialogo
	 */
	public void mensajeInformacion(String tituloDialogo, String mensaje) {
		JOptionPane.showMessageDialog(VentanaDependientes.this,
				mensaje, tituloDialogo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	// controlador
	private ControladorDependientes controlador;
	private JList lstPedido = new JList(new DefaultListModel());
	private JButton btnProcesarPedido = new JButton("Procesar Pedido");
	private JPanel panel = new JPanel();
	private JTextField tIdPedido;
	private JButton btnEntregarPedido;


	/**
	 * Construye la ventana principal
	 */
	public VentanaDependientes(IPreparacionPedidoRemote preparacion,IRealizaPedidoRemote realiza) {
		
		
		super("Gesti\u00f3n de pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controlador = new ControladorDependientes(this,preparacion,realiza);
		lstPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// paneles laterales
		JPanel pOeste = new JPanel(new BorderLayout());
		JPanel pEste = new JPanel(new BorderLayout());
		pEste.add(new Label("Pedido"), BorderLayout.NORTH);
		JScrollPane spListaCarro = new JScrollPane(lstPedido,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pEste.add(spListaCarro, BorderLayout.CENTER);

		getContentPane().add(pOeste, BorderLayout.WEST);
		getContentPane().add(pEste, BorderLayout.EAST);

		// botón añade en el sur en un flow
		// JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p1 = new JPanel(new BorderLayout());

		// precio
		JPanel pp = new JPanel(new GridLayout(0, 2));
		p1.add(pp, BorderLayout.EAST);

		// añade el panel 1 en el sur
		pEste.add(p1, BorderLayout.SOUTH);

		// botones de incluir y eliminar en grid en el centro
		GridLayout gl = new GridLayout(2, 0);
		gl.setVgap(20);
		JPanel p2 = new JPanel(gl);
		p2.setBounds(217, 5, 0, 20);
		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.add(p2);
		getContentPane().add(p3, BorderLayout.CENTER);
		btnProcesarPedido.setBounds(29, 35, 163, 39);
		p3.add(btnProcesarPedido);
		
		tIdPedido = new JTextField();
		tIdPedido.setBounds(33, 225, 126, 20);
		p3.add(tIdPedido);
		tIdPedido.setText("");
		tIdPedido.setColumns(15);
		
	    btnEntregarPedido = new JButton("Entregar Pedido");
		btnEntregarPedido.setEnabled(true);
		btnEntregarPedido.setBounds(29, 261, 163, 39);
		p3.add(btnEntregarPedido);
		btnEntregarPedido.addActionListener(new ManejadorBotonEntregarPedido());
		
		JLabel lblIdPedido = new JLabel("Id Pedido");
		lblIdPedido.setBounds(29, 200, 46, 14);
		p3.add(lblIdPedido);
		btnProcesarPedido.addActionListener(new ManejadorBotonProcesarPedido());
		getContentPane().add(panel, BorderLayout.NORTH);
		// finaliza la configuración de la ventana
		setSize(473, 427);
		setVisible(true);	
	}
	
	
	private class ManejadorBotonProcesarPedido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				controlador.procesarPedido();
		}
	}
	
	private class ManejadorBotonEntregarPedido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				controlador.entregarPedido();
		}
	}

	
}

