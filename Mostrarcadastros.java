import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;


public class Mostrarcadastros extends JFrame {
    
    //componente da interface gráfica
    private JButton btnMostrarCadastrados;
    private JTextArea areaTexto;
    

    private final String URL = "jdbc:mysql://localhost:3306/hospital";
    private final String USER = "root";
    private final String PASSWORD = "";


    public Mostrarcadastros(){
        //janela principal
        setTitle("Exibir pessoas do Banco de Dados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JButton button2 = new JButton("Cadastrar pessoas");

         // Configurações do botão de abrir a janela "Mostrarcadastros"
         button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão for clicado, fecha a janela atual e abre a janela "Mostrarcadastros"
                Pessoa mostrar = new Pessoa();
                mostrar.setVisible(true);  // Torna visível a janela de cadastros
                dispose();  // Fecha a janela atual
            }});
               // Torna a janela visível
        setVisible(true);


        //configuração do botçao
        btnMostrarCadastrados = new JButton("Mostrar pessoas cadastradas");
        btnMostrarCadastrados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mostrarCadastros();
            }
            
        });

        //Área de texto para mostrar pessoas cadastradas
        areaTexto= new JTextArea();
        areaTexto.setEditable(false);



        //Adiciona o botãon e a árae de texto à janela
        add(btnMostrarCadastrados, BorderLayout.NORTH);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
    //    add(button2);



    }
    //método que sera chamado ao clicra no botão
    private void mostrarCadastros(){
        // Limpa o texto atual
        areaTexto.setText("");

        //verifica se há cadastrados
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement()) {

       // Query para buscar todos os registros da tabela
       String sql = "SELECT cpf, medicamentos, sintomas, pressaoArterial, nome FROM Pacientes";
       ResultSet rs = stmt.executeQuery(sql);

       // Percorre os resultados  e exibe na área de texto
       while ( (rs.next())) {
            String cpf = rs.getString("cpf");
            String medicamentos = rs.getString("medicamentos");
            String sintomas = rs.getString("sintomas");
            String pressaoArterial = rs.getString("pressaoArterial");
            String nome = rs.getString("nome");

            

        //exibe o resultado na área de texto
        areaTexto.append("CPF"+ cpf + "\n");
        areaTexto.append("NOME"+ nome + "\n");
        areaTexto.append("MEDCAMENTOS"+ medicamentos + "\n");
        areaTexto.append("SINTOMAS"+ sintomas + "\n");
        areaTexto.append("PRESSAO ARTERIAL"+ pressaoArterial + "\n");
        areaTexto.append("----------------------");

        
       }
       //fecha o ResultSet
       rs.close();

            } catch (SQLException e){
                e.printStackTrace();
                areaTexto.setText("erro ao conectar no banco de dados");

                

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
        



    
    

