package com.locar.ui.ajuda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.locar.ui.TelaPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelpMe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String funcao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpMe frame = new HelpMe("ADMIN");
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
	public HelpMe(String funcao) {
		this.funcao = funcao;
		setTitle("Help-me!");
		setSize(750,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel helpMe_Label = new JLabel("Help-me!");
		helpMe_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		helpMe_Label.setBounds(314, 5, 122, 29);
		contentPane.add(helpMe_Label);
		
		JLabel lblNewLabel = new JLabel("Ajuda do Sistema");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(296, 35, 196, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 61, 714, 489);
		contentPane.add(scrollPane);
		
		JTextArea helpText = new JTextArea();
		helpText.setFont(new Font("Monospaced", Font.PLAIN, 15));
		helpText.setText("1. Menu Arquivo\r\n\t>"
				+ " É onde toda nova movimentação da locadora pode ser acessada.\r\n"
				+ " 1.1. Novo Cliente\r\n"
				+ "  - Botão que permite cadastrar um novo cliente e assim iniciar uma nova locação.\r\n"
				+ "  - Clientes não Cadastrados não podem fazer locações!\r\n"
				+ " 1.2. Novo Veículo\r\n"
				+ "  - Opção que permite cadastrar um novo veiculo e o colocar disponível para locação.\r\n"
				+ "  - Só o gerente pode cadastrar novos veículos.\r\n"
				+ " 1.3. Novo Funcionário\r\n"
				+ "  - Opção que permite cadastrar um novo funcionário.\r\n"
				+ "  - Só funcionário cadastrado e logado em sua conta pode manipular o sistema.\r\n"
				+ "  - Por segurança existem restrições para funcionários.\r\n"
				+ "  - Por segurança só ao Gerente é permitido manipular todo o sistema.\r\n"
				+ " 1.4. Nova Locação\r\n"
				+ "  - Opção do sistema que conclui a locação.\r\n"
				+ "  - A locação faz a busca do Cliente cadastrado e Carro selecionado.\r\n"
				+ "  - Aperte LoCar! e veja a magia acontecer!\r\n"
				+ "  - Por segurança ao clicar em LoCar! um arquivo em PDF é gerado automaticamente.\r\n"
				+ " 1.5. Nova Reserva\r\n"
				+ "  - Opção do sistema que permite um funcionário fazer a reserva de um carro cadastrado.\r\n"
				+ "  - A opção enviar um e-mail para o cliente da reserva.\r\n"
				+ "  - Um e-mail também é enviado um dia próximo para lembrar da reserva.\r\n"
				+ " 1.6. Mudar Senha\r\n"
				+ "  - Opção do sistema que permite a mudança de senha para fazer o login.\r\n"
				+ " 1.7. Fazer Logout\r\n"
				+ "  - Opção do sistema que permite a troca de perfil de usuário sem sair do sistema. \r\n"
				+ " 1.8. Sair\r\n"
				+ "  - Opção para saída do sistema.\r\n"
				+ "  - Obrigada e volte sempre!\r\n\r\n2."
				+ ""
				+ " Menu Editar\r\n\t"
				+ "> Área do sistema que permite a edição de informações já cadastradas.\r\n"
				+ " 2.1. Gerenciar Cliente\r\n"
				+ "  - Opção do sistema que permite a edição das informações do cliente já cadastrado.\r\n"
				+ "  - Opção do sistema que permite a exclusão de dados cadastrados.\r\n"
				+ "  - Cuidado para não apagar tudo!\r\n"
				+ " 2.2. Gerenciar Veiculo\r\n"
				+ "  2.2.1. Editar/Remover Veículo\r\n"
				+ "   * Opção do sistema que permite a edição e remoção do veiculo do catalogo.\r\n"
				+ "   * Por segurança tanto a exclusão como a edição só pode ser feita pelo gerente.\r\n"
				+ "  2.2.2. Agendar Manutenção Veicular\r\n"
				+ "   * Opção do sistema que permite que manutenções sejam agendadas previamente.\r\n"
				+ "   * Por segurança só pode ser feita pelo gerente.\r\n"
				+ "   * Na data agendada o veiculo fica indisponível para locação.\r\n"
				+ "  2.2.3. Agendar Vistoria Veicular\r\n"
				+ "   * Opção do sistema que permite que vistorias sejam agendadas previamente.\r\n"
				+ "   * Por segurança só pode ser feita pelo gerente.\r\n"
				+ "   * Na data agendada o veiculo fica indisponível para locação.\r\n"
				+ " 2.3. Gerenciar Funcionário\r\n"
				+ "  - Opção do sistema que permite a edição das informações dos funcionários cadastrado.\r\n"
				+ "  - Opção do sistema que permite a exclusão do cadastro do funcionário.\r\n"
				+ "  - Por segurança só o gerente pode fazer modificações.\r\n"
				+ " 2.4. Locações\r\n"
				+ "  - Opção do sistema que permite a edição de locações feitas, sejam as em curso e as passadas.\r\n"
				+ "  - Por motivo de segurança há algumas restrições nessas modificações.\r\n"
				+ " 2.5. Reservas\r\n"
				+ "  - Opção do sistema que permite a edição de reservas.\r\n\r\n"
				+ ""
				+ "3. Menu Buscar\r\n\t"
				+ "> Área do sistema que permite exclusivamente a busca de cadastros feitos.\r\n"
				+ " 3.1. Buscar Cliente\r\n"
				+ "  - Opção do sistema que permite a busca e visualização de clientes cadastrados.\r\n"
				+ " 3.2. Buscar Veículo\r\n"
				+ "  - Opção do sistema que permite a busca e visualização de veículos cadastrados.\r\n"
				+ " 3.3. Buscar Funcionário\r\n"
				+ "  - Opção do sistema que permite a busca e visualização de escra... digo funcionários cadastrados.\r\n"
				+ " 3.4. Buscar Locação\r\n"
				+ "  - Opção do sistema que permite a busca e visualização de locações ativas e passadas.\r\n"
				+ " 3.5. Buscar Reserva\r\n"
				+ "  - Opção do sistema que permite a busca e visualização de reservas feitas e em curso.\r\n \r\n"
				+ ""
				+ "4. Menu Pagamentos\r\n\t"
				+ "> Área do sistema onde pagamentos são feitos encerrando as locações\r\n"
				+ "                   e registros financeiros podem ser acessados para controle\r\n"
				+ " 4.1. Pagar\r\n"
				+ "  - Opção do sistema que abre a opção de pagamento a conclusão da locação.\r\n"
				+ "  - A opção abre o API de pagamentos.\r\n"
				+ "  - O favorito do patrão!\r\n"
				+ " 4.2. Registro de Pagamentos\r\n"
				+ "  - Opção do sistema que permite a visualização dos pagamentos, sejam eles já quitados,\r\n"
				+ "     sejam os ainda pendentes.\r\n"
				+ "  4.2.1. Pendentes\r\n"
				+ "  4.2.2. Quitados\r\n"
				+ " 4.3. Simulador de Pagamentos\r\n"
				+ "  - Opção do sistema que abre um pequeno simulador de custos, para que o cliente\r\n"
				+ " saiba de antemão e sem muitas surpresas o valor que deverá ser pago caso faça\r\n"
				+ " uma locação.\r\n"
				+ "  - Os preços variam de acordo com o carro selecionado, os dias de locação e possíveis avarias.\r\n\r\n"
				+ "5. Menu Relatórios\r\n\t"
				+ "> Área do sistema que contém informações uteis de gerenciamento do negocio.\r\n"
				+ " 5.1. Visualizar\r\n"
				+ "  5.1.1. Locações Ativas\r\n"
				+ "   * Área do sistema em que locações ativas podem ser visualizadas.\r\n"
				+ "  5.1.2. Reservas\r\n"
				+ "   * Área do sistema onde reservas podem ser visualizadas pelo usuário.\r\n"
				+ " 5.2. Gerar Relatórios\r\n"
				+ "  5.2.1. Receita\r\n"
				+ "   * Opção do sistema onde relatórios de receita podem ser gerados.\r\n"
				+ "  5.2.2. Manutenção Veicular\r\n"
				+ "   * Opção do sistema onde relatórios sobre manutenções marcadas, executas e não executadas\r\n"
				+ " podem ser gerados.\r\n"
				+ "   * Aqui também estão descriminadas as trocas de peças e outras modificações feitas no veículo.\r\n"
				+ "  5.2.3. Vistorias\r\n"
				+ "   * Opção do sistema onde relatórios sobre vistorias marcadas, executadas e não executadas\r\n"
				+ " podem ser gerados.\r\n"
				+ "  5.2.4. Locações\r\n"
				+ "   * Opção do sistema que permite que relatórios sejam gerados acerca de locações passadas\r\n"
				+ " e em curso.\r\n"
				+ "  5.2.5. Reservas\r\n"
				+ "   * Opção do sistema que permite que relatórios sejam gerados acerca de reservas passadas\r\n"
				+ " e em curso.\r\n\r\n"
				+ "6. Menu Ajuda\r\n\t"
				+ "> Área do sistema informacional onde o usuário pode acessar para obter\r\n"
				+ " informações úteis sobre o funcionamento do sistema como um todo.\r\n"
				+ " 6.1. Help-me\r\n"
				+ "  - Área do sistema destinada a ajuda do usuário.\r\n"
				+ "  - Caso necessite de mais ajuda contate o suporte técnico.\r\n"
				+ " 6.2. Sobre\r\n"
				+ "  - Um pouco sobre nós\r\n");
		helpText.setEditable(false);
		scrollPane.setViewportView(helpText);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
                dispose();
                telaPrincipal.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 11, 98, 35);
		contentPane.add(btnNewButton);
	}
}

