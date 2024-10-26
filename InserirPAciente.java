import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class InserirPAciente {
    //método para inserir paciente no banco de dados

    public void inserirPAciente(String cpf, String medicamentos, String sintomas, String pressaoArterial, String nome){

        String sql = "INSERT INTO Pacientes (cpf, medicamentos, sintomas, pressaoArterial, nome) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conexao= ConexaoMySQL.getConexao();
             PreparedStatement stmt= conexao.prepareStatement(sql)){

                //definindo os parâmetros da query
                stmt.setString(1,cpf);
                stmt.setString(2,medicamentos);
                stmt.setString(3,sintomas);
                stmt.setString(4,pressaoArterial);
                stmt.setString(5,nome);
                
                //Executando a inserção
                stmt.executeUpdate();
                System.out.println("Dados inseridos com sucesso!");
             } catch (SQLException ex){
                System.out.println("Erro ao inserir pessoa");
                ex.printStackTrace();            

               
                
   }
      
   }
   }
   

