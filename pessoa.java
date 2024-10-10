import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//componentes do form
public class Pessoa extends JFrame implements ActionListener{
        private JLabel cpfLabel, nomeLabel, pressaoArterialLabel, sintomasLabel, medicamentosLabel; 
        private JTextField cpfField, nomeField, pressaoArterialField, sintomasField, medicamentosField;
        private JButton enviarButton;
        private JTextArea resultadoArea;
        private InserirPAciente inseridor;
      
        
        


        //Construtor para criar interface gráfica 
        public Pessoa(){
                //janela
                // Criando o primeiro JFrame (Interface 1)
             
                setTitle("Formulário do paciente");
                setSize(300, 250);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new FlowLayout());
 

                //inciando componetes
                nomeLabel= new JLabel("Nome: ");
                cpfLabel = new JLabel("cpf: ");
                sintomasLabel = new JLabel("sintomas: ");
                pressaoArterialLabel= new JLabel("Pressão arterial: ");
                medicamentosLabel = new JLabel("Medicamento: ");
                medicamentosField = new JTextField(15);
                nomeField = new JTextField( 15);
                cpfField = new JTextField(15);
                sintomasField = new JTextField( 20);
                pressaoArterialField = new JTextField(4);
                enviarButton = new JButton("Enviar");
                JButton button = new JButton("ver pessoas cadastradas");
                resultadoArea = new JTextArea( 5, 20);
                //JButton openButton = new JButton("Interface ");
                
                

                //adicionando coponetes à janela 
                add(nomeLabel);
                add(nomeField);
                add(cpfLabel);
                add(cpfField);
                add(sintomasLabel);
                add(sintomasField);
                add(medicamentosLabel);
                add(medicamentosField);
                add(pressaoArterialLabel);
                add(pressaoArterialField);
                add(enviarButton);
                add(new JScrollPane(resultadoArea));
                //adicionar ação no botão
                enviarButton.addActionListener(this);
                
                //criar instancia InserirPaciente
                inseridor = new InserirPAciente();
                //tornando visível
                setVisible(true);
                add(button); // coloca botão no Jframe
                setVisible(true); //torna o Jframe visivel
        
    
        //chamado quando o botão é clicado
        button.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                //quando o botão for clicado, fecha a Interface  e abre a consulta
               Mostrarcadastros mostrar = new Mostrarcadastros();
               mostrar.setVisible(true); 
               dispose();
               
                


            }
        });
         
       
        setVisible(true);
    
      
        }

        @Override
         public void actionPerformed(ActionEvent e){
                String cpf = cpfField.getText();
                String medicamentos = medicamentosField.getText();
                String sintomas = sintomasField.getText();
                String pressaoArterial = pressaoArterialField.getText();
                String nome = nomeField.getText();
                resultadoArea.setText("Nome: "+ nome + "\ncpf:"+ cpf + "\nmedicamentos: " + medicamentos + "\nsintomas: "+ sintomas + "\npressaoArterial: " + pressaoArterial);
                //inserir os dados no banco de dados 
                inseridor.inserirPAciente(cpf, medicamentos, sintomas, pressaoArterial, nome);
            }
         

     
        
         
         
    
  
                  
            
        
            public static void main(String[] args) {
                new Pessoa();
  
         

            
      
            }
        }
        

        
 