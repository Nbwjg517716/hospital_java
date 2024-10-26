import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pessoa extends JFrame implements ActionListener {
    private JLabel cpfLabel, nomeLabel, pressaoArterialLabel, sintomasLabel, medicamentosLabel;
    private JTextField cpfField, nomeField, pressaoArterialField, sintomasField, medicamentosField;
    private JButton enviarButton;
    private JTextArea resultadoArea;
    private InserirPAciente inseridor;

    // Construtor para criar interface gráfica
    public Pessoa() {
        // Janela
        setTitle("Formulário do Paciente");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurando layout para organizar os componentes de forma mais bonita
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Iniciando componentes
        nomeLabel = new JLabel("Nome:");
        cpfLabel = new JLabel("CPF:");
        sintomasLabel = new JLabel("Sintomas:");
        pressaoArterialLabel = new JLabel("Pressão Arterial:");
        medicamentosLabel = new JLabel("Medicamentos:");

        nomeField = new JTextField(15);
        cpfField = new JTextField(15);
        sintomasField = new JTextField(15);
        pressaoArterialField = new JTextField(10);
        medicamentosField = new JTextField(15);

        enviarButton = new JButton("Enviar");
        JButton button = new JButton("Ver Pessoas Cadastradas");

        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setEditable(false); // Para evitar edição no campo de resultados
        resultadoArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Adicionando os componentes com o layout adequado
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nomeLabel, gbc);
        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cpfLabel, gbc);
        gbc.gridx = 1;
        add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(sintomasLabel, gbc);
        gbc.gridx = 1;
        add(sintomasField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(pressaoArterialLabel, gbc);
        gbc.gridx = 1;
        add(pressaoArterialField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(medicamentosLabel, gbc);
        gbc.gridx = 1;
        add(medicamentosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(enviarButton, gbc);

        gbc.gridy = 6;
        add(new JScrollPane(resultadoArea), gbc);

        gbc.gridy = 7;
        add(button, gbc);

        // Adicionando ação ao botão de enviar
        enviarButton.addActionListener(this);

        // Instanciando InserirPaciente
        inseridor = new InserirPAciente();

        // Ação para o botão "Ver Pessoas Cadastradas"
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mostrarcadastros mostrar = new Mostrarcadastros();
                mostrar.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        // Tornando a janela visível
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cpf = cpfField.getText();
        String medicamentos = medicamentosField.getText();
        String sintomas = sintomasField.getText();
        String pressaoArterial = pressaoArterialField.getText();
        String nome = nomeField.getText();

        // Exibe as informações no JTextArea
        resultadoArea.setText("Nome: " + nome + "\nCPF: " + cpf + "\nMedicamentos: " + medicamentos +
                "\nSintomas: " + sintomas + "\nPressão Arterial: " + pressaoArterial);

        // Inserir os dados no banco de dados
        inseridor.inserirPAciente(cpf, medicamentos, sintomas, pressaoArterial, nome);
    }

    public static void main(String[] args) {
        new Pessoa();
    }
}
