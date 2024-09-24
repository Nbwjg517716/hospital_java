import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//componentes do form
public class Pessoa extends JFrame implements ActionListener{
        private JLabel cpfLabel, nomeLabel, pressaoArterialLabel, sintomasLabel, medicamentosLabel; 
        private JTextField cpfField, nomeField, pressaoArterialField, sintomasField, medicamentosField;
        private JButton enviarButton;
        private JTextArea resultadoArea;


        //Construtor para criar interface gráfica 
        public Pessoa(){
                //janela
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
                resultadoArea = new JTextArea( 5, 20);


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

                //tornando visível
                setVisible(true);

        }
        //chamado quando o botão é clicado
         @Override
         public void actionPerformed(ActionEvent e){
                String cpf = cpfField.getText();
                String medicamentos = medicamentosField.getText();
                String sintomas = sintomasField.getText();
                String pressaoArterial = pressaoArterialField.getText();
                String nome = nomeField.getText();
                resultadoArea.setText("Nome: "+ nome + "\ncpf:"+ cpf + "\nmedicamentos: " + medicamentos + "\nsintomas: "+ sintomas + "\npressaoArterial: " + pressaoArterial);
        }
        /*public pessoa extends Jframe (String cpf, String medicamentos, String sintomas, String pressaoArterial, String nome) {
                this.cpf = cpf;
                this.medicamentos = medicamentos;
                this.sintomas = sintomas;
                this.pressaoArterial =pressaoArterial;
                this.nome = nome;
        } */
        // Método do principal para rodar o formulário

        public static void main(String[] args) {
                // Criando um objeto da classe MinhaClasse
                new Pessoa();
            }
        }

      /*  getters e setters
        public String  getNome(){
                return nome;
        }        

        public void  setNome(String nome){
                this.nome = nome;

        }

        public String getMedicamentos(){
                return medicamentos;
        }
        public void setMedicamentos(String medicamentos){
                this.medicamentos = medicamentos;
        }

        public String  getPressaoArterial(){
                return pressaoArterial;
        }
        public void setPressaoArterial(String pressaoArterial){
                this.pressaoArterial =pressaoArterial;

        }
        public String getSintomas(){
                return sintomas;
        }
        public void setSintomas(String sintomas){
                this.sintomas= sintomas;
        }
        public String getCpf(){
                return cpf;
        } */
       // public void setCpf(String cpf){
       //         this.cpf= cpf;
        //}




    // Método main


 //       System.out.println("ddescrição da situação do paciente" +p.getDescricao_paciente());
 //       System.out.println("Idade" +p.getnome());
 
 //
 //       System.out.println(("Marca do produto"+p.getIdade));

   //     paciente nf = new Paciente();
     //   nf.adicionarPessoa(p);
    //}
//}

//nome: String
//cpf: String
//pressaoArterial: String
//sintomas: String
//diagnostico: String
//medicamentos: String



        
 //   }
//}