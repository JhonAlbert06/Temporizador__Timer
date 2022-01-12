import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Marco extends JFrame implements Runnable{

	private JTextField pantalla;
	private Tiempo tiempo;
	private Thread hilo;
/*
	private Button arribaHora;
	private Button abajoHora;

	private Button arribaMinuto;
	private Button abajoMinuto;

	private Button arribaSegundo;
	private Button abajoSegundo;
*/
	private JTextField hora;
	private JTextField minuto;
	private JTextField segundo;

	private Button inicio;
	private Button pausar;
	private Button reanudar;
	private Button limpiar;

	private int h = 0, m = 0, s = 0;

	public Marco(){

		init();

	}

	private void init(){

		setLayout(null);
		setTitle("Editor de Texto");
		setSize(500,480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground(Color.lightGray);

		inicio =  new Button("Inicio");
		inicio.setBounds(160, 150, 120, 40);
		inicio.setFont(new Font("Arial", Font.PLAIN, 18));
		add(inicio);
		inicio.addActionListener((ActionEvent e)->{

			String[] aux = pantalla.getText().split(":"); //new String[3];

			//aux[0] = hora.getText();
			this.h = Integer.parseInt(aux[0]);

			//aux[1] = minuto.getText();
			this.m = Integer.parseInt(aux[1]);

			//aux[2] = segundo.getText();
			this.s = Integer.parseInt(aux[2]);

			tiempo = new Tiempo(h, m, s);

			hilo = new Thread(this);
			hilo.start();

		});

		pausar = new Button("Pausar");
		pausar.setBounds(160, 200, 120, 40);
		pausar.setFont(new Font("Arial", Font.PLAIN, 18));
		add(pausar);
		pausar.addActionListener((ActionEvent e) ->{
			
			hilo.suspend();

		});

		reanudar = new Button("Reanudar");
		reanudar.setBounds(160, 250, 120, 40);
		reanudar.setFont(new Font("Arial", Font.PLAIN, 18));
		add(reanudar);
		reanudar.addActionListener((ActionEvent e) ->{
			
			hilo.resume();

		});


		hora = new JTextField("00");
		hora.setBounds(60, 350, 60, 40);
		hora.setFont(new Font("Arial", Font.PLAIN, 18));
		add(hora);


		minuto = new JTextField("00");
		minuto.setBounds(200, 350, 60, 40);
		minuto.setFont(new Font("Arial", Font.PLAIN, 18));
		add(minuto);


		segundo = new JTextField("00");
		segundo.setBounds(330, 350, 60, 40);
		segundo.setFont(new Font("Arial", Font.PLAIN, 18));
		add(segundo);

		pantalla = new JTextField();
		pantalla.setText("00:00:00");
		pantalla.setBounds(95,70,250,70);
		pantalla.setFont(new Font("Arial", Font.PLAIN, 56));
		add(pantalla);
/*
		arribaHora = new Button(" | ↑ | ");
		arribaHora.setBounds(60, 20, 60, 40);
		arribaHora.setFont(new Font("Arial", Font.PLAIN, 18));
		add(arribaHora);

		abajoHora = new Button(" | ↓ | ");
		abajoHora.setBounds(60, 150, 60, 40);
		abajoHora.setFont(new Font("Arial", Font.PLAIN, 18));
		add(abajoHora);

		arribaMinuto = new Button(" | ↑ | ");
		arribaMinuto.setBounds(200, 20, 60, 40);
		arribaMinuto.setFont(new Font("Arial", Font.PLAIN, 18));
		add(arribaMinuto);

		abajoMinuto = new Button(" | ↓ | ");
		abajoMinuto.setBounds(200, 150, 60, 40);
		abajoMinuto.setFont(new Font("Arial", Font.PLAIN, 18));
		add(abajoMinuto);

		arribaSegundo = new Button(" | ↑ | ");
		arribaSegundo.setBounds(330, 20, 60, 40);
		arribaSegundo.setFont(new Font("Arial", Font.PLAIN, 18));
		add(arribaSegundo);

		abajoSegundo = new Button(" | ↓ | ");
		abajoSegundo.setBounds(330,150, 60, 40);
		abajoSegundo.setFont(new Font("Arial", Font.PLAIN, 18));
		add(abajoSegundo);
*/


		//hilo = new Thread(this);
		//hilo.start();

	}

	@Override
	public void run(){

		while(true){

			tiempo.desSegundo(1);
			pantalla.setText(tiempo.toString());

			try{

				hilo.sleep(1000);
			}
			catch(InterruptedException e){}
		}
	}


}