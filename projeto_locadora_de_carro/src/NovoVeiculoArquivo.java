package test5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class NovoVeiculoArquivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField modelo_textField;
	private JTextField marca_textField;
	private JTextField cor_textField;
	private JTextField placa_textField;
	private JTextField numMotor_textField;
	private JTextField chassi_textField;
	private JTextField ano_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoVeiculoArquivo frame = new NovoVeiculoArquivo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoVeiculoArquivo() {
		setTitle("Novo Veículo");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo_Label = new JLabel("Cadastro de Veículo");
		Titulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Titulo_Label.setBounds(168, 11, 236, 35);
		contentPane.add(Titulo_Label);
		
		JLabel modelo_Label = new JLabel("Modelo:");
		modelo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		modelo_Label.setBounds(64, 75, 57, 24);
		contentPane.add(modelo_Label);
		
		JLabel Marca_Label = new JLabel("Marca:");
		Marca_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Marca_Label.setBounds(277, 75, 57, 24);
		contentPane.add(Marca_Label);
		
		JLabel Placa_Label_1 = new JLabel("Placa:");
		Placa_Label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Placa_Label_1.setBounds(224, 110, 42, 24);
		contentPane.add(Placa_Label_1);
		
		JLabel NumMotor_Label = new JLabel("Nº do Motor:");
		NumMotor_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NumMotor_Label.setBounds(64, 145, 94, 24);
		contentPane.add(NumMotor_Label);
		
		JLabel Chassi_Label = new JLabel("Chassi:");
		Chassi_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Chassi_Label.setBounds(310, 145, 57, 24);
		contentPane.add(Chassi_Label);
		
		JLabel Tipo_Label = new JLabel("Tipo:");
		Tipo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Tipo_Label.setBounds(379, 110, 42, 24);
		contentPane.add(Tipo_Label);
		
		JLabel NumPortas_Label = new JLabel("Nº de Portas:");
		NumPortas_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NumPortas_Label.setBounds(64, 180, 101, 24);
		contentPane.add(NumPortas_Label);
		
		JLabel Acessorios = new JLabel("Acessórios");
		Acessorios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Acessorios.setBounds(224, 215, 82, 24);
		contentPane.add(Acessorios);
		
		JLabel Marca_Label_1_1_2_1_1_2 = new JLabel("Cor:");
		Marca_Label_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Marca_Label_1_1_2_1_1_2.setBounds(64, 110, 38, 24);
		contentPane.add(Marca_Label_1_1_2_1_1_2);
		
		modelo_textField = new JTextField();
		modelo_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modelo_textField.setBounds(122, 75, 145, 24);
		contentPane.add(modelo_textField);
		modelo_textField.setColumns(10);
		
		marca_textField = new JTextField();
		marca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		marca_textField.setColumns(10);
		marca_textField.setBounds(326, 75, 182, 24);
		contentPane.add(marca_textField);
		
		cor_textField = new JTextField();
		cor_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cor_textField.setColumns(10);
		cor_textField.setBounds(97, 110, 117, 24);
		contentPane.add(cor_textField);
		
		placa_textField = new JTextField();
		placa_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		placa_textField.setColumns(10);
		placa_textField.setBounds(268, 110, 101, 24);
		contentPane.add(placa_textField);
		
		JComboBox tipo_comboBox = new JComboBox <> (new String[] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"});
		tipo_comboBox.setBounds(419, 113, 89, 22);
		contentPane.add(tipo_comboBox);
		
		numMotor_textField = new JTextField();
		numMotor_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numMotor_textField.setColumns(10);
		numMotor_textField.setBounds(162, 145, 145, 24);
		contentPane.add(numMotor_textField);
		
		chassi_textField = new JTextField();
		chassi_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chassi_textField.setColumns(10);
		chassi_textField.setBounds(363, 145, 145, 24);
		contentPane.add(chassi_textField);
		
		JSpinner numPortas_spinner = new JSpinner();
		numPortas_spinner.setBounds(168, 184, 46, 20);
		contentPane.add(numPortas_spinner);
		
		JLabel ano_Label = new JLabel("Ano de Fabricação:");
		ano_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ano_Label.setBounds(224, 180, 143, 24);
		contentPane.add(ano_Label);
		
		ano_textField = new JTextField();
		ano_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ano_textField.setColumns(10);
		ano_textField.setBounds(363, 180, 145, 24);
		contentPane.add(ano_textField);
		
		JCheckBox ar_CheckBox = new JCheckBox("Ar-Condicionado");
		ar_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ar_CheckBox.setBounds(61, 241, 128, 26);
		contentPane.add(ar_CheckBox);
		
		JCheckBox airbag_CheckBox = new JCheckBox("Airbag");
		airbag_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		airbag_CheckBox.setBounds(61, 267, 128, 26);
		contentPane.add(airbag_CheckBox);
		
		JCheckBox alarme_CheckBox = new JCheckBox("Alarme Anti-Furto");
		alarme_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alarme_CheckBox.setBounds(61, 293, 135, 26);
		contentPane.add(alarme_CheckBox);
		
		JCheckBox banco_CheckBox = new JCheckBox("Banco de Couro");
		banco_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		banco_CheckBox.setBounds(61, 319, 135, 26);
		contentPane.add(banco_CheckBox);
		
		JCheckBox engate_CheckBox = new JCheckBox("Engate");
		engate_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		engate_CheckBox.setBounds(212, 267, 69, 26);
		contentPane.add(engate_CheckBox);
		
		JCheckBox gps_CheckBox = new JCheckBox("GPS");
		gps_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gps_CheckBox.setBounds(212, 293, 57, 26);
		contentPane.add(gps_CheckBox);
		
		JCheckBox sistSom_CheckBox = new JCheckBox("Sistema de Som");
		sistSom_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sistSom_CheckBox.setBounds(363, 267, 142, 26);
		contentPane.add(sistSom_CheckBox);
		
		JCheckBox sensor_CheckBox = new JCheckBox("Sensor de Estacionamento");
		sensor_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sensor_CheckBox.setBounds(363, 241, 189, 26);
		contentPane.add(sensor_CheckBox);
		
		JCheckBox vidro_CheckBox = new JCheckBox("Vidro Eletrico");
		vidro_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vidro_CheckBox.setBounds(363, 319, 110, 26);
		contentPane.add(vidro_CheckBox);
		
		JCheckBox trava_CheckBox = new JCheckBox("Trava Eletrica");
		trava_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		trava_CheckBox.setBounds(363, 293, 111, 26);
		contentPane.add(trava_CheckBox);
		
		JCheckBox trava_CheckBox_1 = new JCheckBox("Overbumper");
		trava_CheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		trava_CheckBox_1.setBounds(212, 319, 111, 26);
		contentPane.add(trava_CheckBox_1);
		
		JCheckBox trava_CheckBox_1_1 = new JCheckBox("Conexão Bluetooth");
		trava_CheckBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		trava_CheckBox_1_1.setBounds(212, 241, 151, 26);
		contentPane.add(trava_CheckBox_1_1);
	}
}
