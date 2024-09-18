import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Paciente {
    public static void main(String[] args){
        Pessoa p = new Pessoa();
        String Descrição_paciente = JOptionPane.sowInputDialog(null,"Simtomas do passiente");
        float idade = Float.parseFloat(JOptionPane.showInputDialog(null,"Idade do paciente"));
        String nome =JOptionPane.showInputDialog(null, "Digite o nome do pacinte");

        p.setDescrição_paciente(descicao);
        p.setidade(valor);
        p.setMarca(marrca);

        System.out.println("ddescrição da situação do paciente" +p.getDescricao_paciente());
        System.out.println("Idade" +p.getnome());
        System.out.println(("Marca do produto"+p.getIdade));

        paciente nf = new Paciente();
        nf.adicionarPessoa(p);
    }
}




        
    }
}