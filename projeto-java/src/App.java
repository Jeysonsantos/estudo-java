
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
        
public class App {
    
    public static void main(String[] args) {
        ArrayList<String>nome_Alunos = new ArrayList<String>();
        ArrayList<String>dados = new ArrayList<String>();
        Map<String,ArrayList<String>> dici = new HashMap<>();
        ArrayList<String>notas = new ArrayList<String>();

        System.out.println("Seja bem vindo ao sistema de cadastro!");
        while(true){
            System.out.println("Opções:"
                + "\n 1.Matricular um aluno no sistema."
                + "\n 2.Mostrar informações de um aluno do sistema."
                + "\n 3.Adicionar nota."
                + "\n 4.Adicionar Faltas."
                + "\n 0.Sair");
            Scanner opt = new Scanner(System.in);

            String op = opt.nextLine();
            if(op == "0"){break;}
        
        if(op == "1")
        {
            Scanner matricula = new Scanner(System.in);
            System.out.println("Digite o nome do aluno:");
            String nome = matricula.nextLine();
            System.out.println("Digite o CPF");
            String cpf = matricula.nextLine();
            System.out.println("Digite o numero de matricula:");
            String mat = matricula.nextLine();
            System.out.println("Digite o nome da disciplina:");
            String disciplina = matricula.nextLine();
            nome_Alunos.add(nome);
            dados.add(cpf);
            dados.add(mat);
            dados.add(disciplina);
            dici.put(nome,dados);
        }else if(op=="2"){
            System.out.println();
            System.out.println("--Selecione um aluno--");
            System.out.println("Digite um inteiro correspondente:");
            System.out.println();
            for(int i=0;i<nome_Alunos.size();i++){
                System.out.println(i+")"+ nome_Alunos.get(i));
            }
            int op_nome = opt.nextInt();
            System.out.println();
            System.out.println();
            System.out.println("CPF:" + dici.get(nome_Alunos.get(op_nome)).get(0));
            System.out.println("MATRÍCULA:" + dici.get(nome_Alunos.get(op_nome)).get(1));
            System.out.println("DISCIPLINA MATRICULADA:" + dici.get(nome_Alunos.get(op_nome)).get(2));
            System.out.println();
            System.out.println();
        }else if(op=="3"){
            System.out.println();
            System.out.println("--Selecione um aluno--");
            System.out.println("Digite um inteiro correspondente:");
            System.out.println();
            for(int i=0;i<nome_Alunos.size();i++){
                System.out.println(i+")"+ nome_Alunos.get(i));
            }
            int op_nome2 = opt.nextInt();opt.nextLine();
            System.out.println();
            System.out.println("Digite a nota:");
            String nota = opt.nextLine();
            String aux_disciplina = dici.get(nome_Alunos.get(op_nome2)).get(2);
            dici.get(nome_Alunos.get(op_nome2)).set(2,aux_disciplina+" \n NOTA :  "+"("+nota+")");
            
        }else if(op=="4"){
            System.out.println();
            System.out.println("--Selecione um aluno--");
            System.out.println("Digite um inteiro correspondente:");
            System.out.println();
            for(int i=0;i<nome_Alunos.size();i++){
                System.out.println(i+")"+ nome_Alunos.get(i));
            }
            int op_nome3 = opt.nextInt();opt.nextLine();
            System.out.println();
            System.out.println("Digite a quantidade de faltas(Int):");
            String num_faltas = opt.nextLine();
            String aux_disciplina = dici.get(nome_Alunos.get(op_nome3)).get(2);
            dici.get(nome_Alunos.get(op_nome3)).set(2,aux_disciplina+" \n"+"FALTAS : ("+num_faltas+")");
        }else{
            System.out.println();
            System.out.println("ERROR");
            System.out.println("Digite uma opção válida!");
            System.out.println();

        }

                
        }
    }
}
