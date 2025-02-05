

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
import javax.swing.JButton;

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
	private JTextField textField;

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
		setSize(600,500);
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
		modelo_Label.setBounds(376, 75, 57, 24);
		contentPane.add(modelo_Label);
		
		JLabel Marca_Label = new JLabel("Marca:");
		Marca_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Marca_Label.setBounds(168, 75, 57, 24);
		contentPane.add(Marca_Label);
		
		JLabel Placa_Label_1 = new JLabel("Placa:");
		Placa_Label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Placa_Label_1.setBounds(20, 75, 42, 24);
		contentPane.add(Placa_Label_1);
		
		JLabel NumMotor_Label = new JLabel("Nº do Motor:");
		NumMotor_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NumMotor_Label.setBounds(20, 135, 94, 24);
		contentPane.add(NumMotor_Label);
		
		JLabel Chassi_Label = new JLabel("Chassi:");
		Chassi_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Chassi_Label.setBounds(290, 135, 57, 24);
		contentPane.add(Chassi_Label);
		
		JLabel Tipo_Label = new JLabel("Tipo:");
		Tipo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Tipo_Label.setBounds(431, 105, 42, 24);
		contentPane.add(Tipo_Label);
		
		JLabel NumPortas_Label = new JLabel("Nº de Portas:");
		NumPortas_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NumPortas_Label.setBounds(415, 196, 101, 24);
		contentPane.add(NumPortas_Label);
		
		JLabel Acessorios = new JLabel("Acessórios");
		Acessorios.setFont(new Font("Tahoma", Font.BOLD, 16));
		Acessorios.setBounds(234, 264, 89, 24);
		contentPane.add(Acessorios);
		
		JLabel Marca_Label_1_1_2_1_1_2 = new JLabel("Cor:");
		Marca_Label_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Marca_Label_1_1_2_1_1_2.setBounds(243, 105, 38, 24);
		contentPane.add(Marca_Label_1_1_2_1_1_2);
		
		modelo_textField = new JTextField();
		modelo_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modelo_textField.setBounds(439, 75, 128, 24);
		contentPane.add(modelo_textField);
		modelo_textField.setColumns(10);
		
		marca_textField = new JTextField();
		marca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		marca_textField.setColumns(10);
		marca_textField.setBounds(222, 75, 145, 24);
		contentPane.add(marca_textField);
		
		cor_textField = new JTextField();
		cor_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cor_textField.setColumns(10);
		cor_textField.setBounds(280, 105, 147, 24);
		contentPane.add(cor_textField);
		
		placa_textField = new JTextField();
		placa_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		placa_textField.setColumns(10);
		placa_textField.setBounds(64, 75, 101, 24);
		contentPane.add(placa_textField);
		
		JComboBox tipo_comboBox = new JComboBox <> (new String[] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"});
		tipo_comboBox.setBounds(478, 108, 89, 22);
		contentPane.add(tipo_comboBox);
		
		numMotor_textField = new JTextField();
		numMotor_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numMotor_textField.setColumns(10);
		numMotor_textField.setBounds(115, 135, 167, 24);
		contentPane.add(numMotor_textField);
		
		chassi_textField = new JTextField();
		chassi_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chassi_textField.setColumns(10);
		chassi_textField.setBounds(344, 135, 223, 24);
		contentPane.add(chassi_textField);
		
		JSpinner numPortas_spinner = new JSpinner();
		numPortas_spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numPortas_spinner.setBounds(513, 200, 46, 23);
		contentPane.add(numPortas_spinner);
		
		JLabel ano_Label = new JLabel("Ano de Fabricação:");
		ano_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ano_Label.setBounds(20, 105, 143, 24);
		contentPane.add(ano_Label);
		
		ano_textField = new JTextField();
		ano_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ano_textField.setColumns(10);
		ano_textField.setBounds(161, 105, 76, 24);
		contentPane.add(ano_textField);
		
		JCheckBox ar_CheckBox = new JCheckBox("Ar-Condicionado");
		ar_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ar_CheckBox.setBounds(61, 295, 128, 26);
		contentPane.add(ar_CheckBox);
		
		JCheckBox airbag_CheckBox = new JCheckBox("Airbag");
		airbag_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		airbag_CheckBox.setBounds(61, 324, 128, 26);
		contentPane.add(airbag_CheckBox);
		
		JCheckBox alarme_CheckBox = new JCheckBox("Alarme Anti-Furto");
		alarme_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alarme_CheckBox.setBounds(61, 353, 135, 26);
		contentPane.add(alarme_CheckBox);
		
		JCheckBox banco_CheckBox = new JCheckBox("Banco de Couro");
		banco_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		banco_CheckBox.setBounds(61, 382, 135, 26);
		contentPane.add(banco_CheckBox);
		
		JCheckBox engate_CheckBox = new JCheckBox("Engate");
		engate_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		engate_CheckBox.setBounds(201, 324, 69, 26);
		contentPane.add(engate_CheckBox);
		
		JCheckBox gps_CheckBox = new JCheckBox("GPS");
		gps_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gps_CheckBox.setBounds(201, 353, 57, 26);
		contentPane.add(gps_CheckBox);
		
		JCheckBox sistSom_CheckBox = new JCheckBox("Sistema de Som");
		sistSom_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sistSom_CheckBox.setBounds(351, 324, 142, 26);
		contentPane.add(sistSom_CheckBox);
		
		JCheckBox sensor_CheckBox = new JCheckBox("Sensor de Estacionamento");
		sensor_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sensor_CheckBox.setBounds(351, 295, 189, 26);
		contentPane.add(sensor_CheckBox);
		
		JCheckBox vidro_CheckBox = new JCheckBox("Vidro Eletrico");
		vidro_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vidro_CheckBox.setBounds(351, 382, 110, 26);
		contentPane.add(vidro_CheckBox);
		
		JCheckBox trava_CheckBox = new JCheckBox("Trava Eletrica");
		trava_CheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		trava_CheckBox.setBounds(351, 353, 111, 26);
		contentPane.add(trava_CheckBox);
		
		JCheckBox trava_CheckBox_1 = new JCheckBox("Overbumper");
		trava_CheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		trava_CheckBox_1.setBounds(201, 382, 111, 26);
		contentPane.add(trava_CheckBox_1);
		
		JCheckBox trava_CheckBox_1_1 = new JCheckBox("Conexão Bluetooth");
		trava_CheckBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		trava_CheckBox_1_1.setBounds(201, 295, 151, 26);
		contentPane.add(trava_CheckBox_1_1);
		
		JLabel dadosDoVeiculo_Label = new JLabel("Dados do Veiculo");
		dadosDoVeiculo_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		dadosDoVeiculo_Label.setBounds(10, 50, 143, 24);
		contentPane.add(dadosDoVeiculo_Label);
		
		JLabel especificacaoDoVeiculo_Label = new JLabel("Especificações do Veiculo");
		especificacaoDoVeiculo_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		especificacaoDoVeiculo_Label.setBounds(10, 170, 205, 24);
		contentPane.add(especificacaoDoVeiculo_Label);
		
		JLabel combustivel_Label = new JLabel("Combustivel:");
		combustivel_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		combustivel_Label.setBounds(20, 196, 94, 24);
		contentPane.add(combustivel_Label);
		
		JComboBox combustivel_comboBox = new JComboBox <> (new String [] {"Gasolina", "Disel", "Alcool", "Eletrico", "Flex"});
		combustivel_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		combustivel_comboBox.setBounds(113, 197, 89, 23);
		contentPane.add(combustivel_comboBox);
		
		JLabel transmissao_Label = new JLabel("Transmissão:");
		transmissao_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		transmissao_Label.setBounds(212, 196, 104, 24);
		contentPane.add(transmissao_Label);
		
		JComboBox transmissao_comboBox = new JComboBox <> (new String [] {"Manual", "Automatica"});
		transmissao_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		transmissao_comboBox.setBounds(311, 197, 94, 23);
		contentPane.add(transmissao_comboBox);
		
		JLabel direcao_Label = new JLabel("Direção:");
		direcao_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		direcao_Label.setBounds(20, 226, 69, 24);
		contentPane.add(direcao_Label);
		
		JComboBox direcao_comboBox = new JComboBox <> (new String [] {"Manual", "Hidraulica", "Eletrica"});
		direcao_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		direcao_comboBox.setBounds(86, 229, 103, 23);
		contentPane.add(direcao_comboBox);
		
		JLabel numeroDeLugares_Label = new JLabel("Nº de Lugares:");
		numeroDeLugares_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numeroDeLugares_Label.setBounds(201, 226, 110, 24);
		contentPane.add(numeroDeLugares_Label);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(311, 228, 46, 23);
		contentPane.add(spinner);
		
		JLabel combustivel_Label_2_1_1 = new JLabel("Km Rodados:");
		combustivel_Label_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		combustivel_Label_2_1_1.setBounds(362, 226, 101, 24);
		contentPane.add(combustivel_Label_2_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(462, 226, 105, 24);
		contentPane.add(textField);
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cadastrarButton.setBounds(462, 415, 105, 35);
		contentPane.add(cadastrarButton);
		
		JButton limpar_Button = new JButton("Limpar");
		limpar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		limpar_Button.setBounds(20, 415, 105, 35);
		contentPane.add(limpar_Button);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
	}
}
