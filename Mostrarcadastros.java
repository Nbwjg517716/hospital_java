import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Mostrarcadastros extends JFrame {

    // Componentes da interface gráfica
    private JButton btnMostrarCadastrados;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private JButton button2;

    // Configurações do banco de dados
    private final String URL = "jdbc:mysql://localhost:3306/hospital";
    private final String USER = "root";
    private final String PASSWORD = "";

    public Mostrarcadastros() {
        // Configuração da janela principal
        setTitle("Exibir Pessoas Cadastradas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Botão para cadastrar pessoas
        button2 = new JButton("Cadastrar Pessoas");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a janela de cadastro de pessoas
                Pessoa mostrar = new Pessoa();
                mostrar.setVisible(true); // Torna visível a janela de cadastros
                dispose(); // Fecha a janela atual
            }
        });

        // Botão para mostrar pessoas cadastradas
        btnMostrarCadastrados = new JButton("Mostrar Pessoas Cadastradas");
        btnMostrarCadastrados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastros();
            }
        });

        // Configuração da tabela para exibir os dados
        String[] colunas = {"CPF", "Nome", "Medicamentos", "Sintomas", "Pressão Arterial"};
        tableModel = new DefaultTableModel(colunas, 0); // Modelo de tabela sem dados
        tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela); // Adiciona rolagem na tabela

        // Adiciona componentes à janela
        add(btnMostrarCadastrados, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(button2, BorderLayout.SOUTH); // Botão "Cadastrar Pessoas" na parte inferior

        // Torna a janela visível
        setVisible(true);
    }

    // Método que será chamado ao clicar no botão "Mostrar Pessoas Cadastradas"
    private void mostrarCadastros() {
        // Limpa os dados da tabela atual
        tableModel.setRowCount(0);

        // Conecta ao banco de dados e busca as pessoas cadastradas
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Query para buscar todos os registros da tabela "Pacientes"
            String sql = "SELECT cpf, nome, medicamentos, sintomas, pressaoArterial FROM Pacientes";
            ResultSet rs = stmt.executeQuery(sql);

            // Percorre os resultados e adiciona na tabela
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String medicamentos = rs.getString("medicamentos");
                String sintomas = rs.getString("sintomas");
                String pressaoArterial = rs.getString("pressaoArterial");

                // Adiciona cada registro como uma linha na tabela
                tableModel.addRow(new Object[]{cpf, nome, medicamentos, sintomas, pressaoArterial});
            }

            // Fecha o ResultSet
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método principal para executar a aplicação
    public static void main(String[] args) {
        // Verifica se o driver JDBC está disponível
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Para MySQL (dependendo da versão)
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Cria a janela e a exibe
        Mostrarcadastros frame = new Mostrarcadastros();
        frame.setVisible(true);
    }
}
