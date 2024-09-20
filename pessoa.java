//import javax.swing.JOptionPane;
//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Pessoa{
        private String cpf;
        String medicamentos;
        String sintomas;
        String pressaoArterial;
        String nome;

        //construtor
        public Pessoa(String cpf, String medicamentos, String sintomas, String pressaoArterial, String nome) {
                this.cpf = cpf;
                this.medicamentos = medicamentos;
                this.sintomas = sintomas;
                this.pressaoArterial =pressaoArterial;
                this.nome = nome;
        }

        //getters e setters
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
        }
        public void setCpf(String cpf){
                this.cpf= cpf;
        }




    // Método main
    public static void main(String[] args) {
        // Criando um objeto da classe MinhaClasse
        Pessoa Nicolas = new Pessoa("51936960826","dipirona", "dor de cabeça", "9", "Nicolas");

        // Exibindo os valores dos atributos
        System.out.println("Nome: " + Nicolas.getNome());
        System.out.println("ID: " + Nicolas.getCpf());

        // Modificando os valores usando os setters
        Nicolas.setNome("Nicolas");
        Nicolas.setCpf("51936960826");
        Nicolas.setMedicamentos("dipironas");
        Nicolas.setPressaoArterial("9");
        

        // Exibindo os valores atualizados
        System.out.println("Nome atualizado: " + Nicolas.getNome());
        System.out.println("cpf atualizado: " + Nicolas.getCpf());
    }
}


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