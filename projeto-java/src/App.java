
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
        
public class App {
    
    public static void main(String[] args) {
        ArrayList<String>nome_Alunos = new ArrayList<String>();
        //ArrayList<String>dados = new ArrayList<String>();
        Map<String,String[]> dici = new HashMap<>();
        Map<String,String[]> dici_diciplinas = new HashMap<>();

        System.out.println("Seja bem vindo ao sistema de cadastro!");
        while(true){
            System.out.println("Opções:"
                + "\n 1.Matricular um aluno no sistema." 
                + "\n 3.Adicionar Nota. - (FALTA CONCLUIR)"
                + "\n 5.Adicionar Faltas. - (FALTA CONCLUIR)"
                + "\n 7.Mostrar informações de um aluno do sistema."
                + "\n 9.Adicionar Disciplinas."
                + "\n 0.Sair");
            Scanner opt = new Scanner(System.in);
            String op = opt.nextLine();
        if(isInteger(op)){
            if(Integer.parseInt(op) == 1) // OPCAO MATRICULAR UM ALUNO
            {
                Scanner matricula = new Scanner(System.in);
                System.out.println("-----------------------");
                System.out.println("Digite o nome do aluno:");
                String nome = matricula.nextLine();
                System.out.println("-----------------------");
                System.out.println("Digite o CPF:");
                String cpf = matricula.nextLine();
                System.out.println("-----------------------");
                System.out.println("Digite o número de matricula:");
                String mat = matricula.nextLine();
                System.out.println("-----------------------");
                System.out.println("Digite o numero de disciplinas desse aluno:");
                String num_disciplinas = matricula.nextLine();
                System.out.println("-----------------------");
                nome_Alunos.add(nome);
                String[] dados = { cpf, mat,num_disciplinas};
                String[] disciplinas = new String[Integer.parseInt(num_disciplinas)];
                dici.put(nome,dados);
                dici_diciplinas.put(nome,disciplinas);
                
            }else if(Integer.parseInt(op) == 7){ //Mostrar informações de um aluno do sistema.
                if(dici.isEmpty()){
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.println("Realize o cadastro primeiro.");
                    System.out.println("-------------------------------");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("----ALUNOS CADASTRADOS:----");
                    System.out.println();
                    for(int i=0;i<nome_Alunos.size();i++){
                        System.out.println(i+")"+ nome_Alunos.get(i));
                    }
                    System.out.println();
                    System.out.println("--Escolha um aluno--");
                    System.out.println();
                    System.out.println("Digite um inteiro correspondente:");
                    System.out.println();
                    //System.out.println((nome_Alunos.size()) +")" + "VOLTAR");
                    int op_nome7 = opt.nextInt();
                    System.out.println();
                    System.out.println();
                    System.out.println("---------  ALUNO ATUAL: "+ nome_Alunos.get(op_nome7)+"  ----------");
                    System.out.println();
                    String nome_aluno = nome_Alunos.get(op_nome7);
                    System.out.println("CPF:" + (dici.get(nome_aluno))[0]);
                    System.out.println();

                    System.out.println("MATRÍCULA:" + (dici.get(nome_aluno))[1]);
                    System.out.println();

                    int num_disciplinas_aluno_escolhido7=Integer.parseInt((dici.get(nome_aluno))[2]);
                    System.out.println("DISCIPLINAS MATRICULADAS: " );  
                    System.out.println();

                    for(int i=0;i<num_disciplinas_aluno_escolhido7;i++){
                        int aux7=i+1;
                        System.out.println("-------->"+aux7+") "+ dici_diciplinas.get(nome_aluno)[i]);
                    }
                    System.out.println();

                }
            }else if(Integer.parseInt(op) == 3){ // ADICIONAR NOTA
                if(dici.isEmpty()){
                System.out.println();
                System.out.println("-------------------------------");
                System.out.println("Realize o cadastro do aluno primeiro.");
                System.out.println("-------------------------------");
                System.out.println();

                }else{
                    System.out.println();
                    System.out.println("----ALUNOS CADASTRADOS:----");
                    System.out.println();
                    for(int i=0;i<nome_Alunos.size();i++){
                        System.out.println(i+")"+ nome_Alunos.get(i));
                    }
                    System.out.println();
                    System.out.println("--Escolha um aluno--");
                    System.out.println();
                    System.out.println("Digite um inteiro correspondente:");
                    System.out.println();
                    int op_nome3 = opt.nextInt();opt.nextLine();
                    System.out.println();
                    System.out.println("Digite a nota:");
                    String nota = opt.nextLine();
                    //String aux_disciplina = dici.get(nome_Alunos.get(op_nome2)).get(2);
                    //dici.get(nome_Alunos.get(op_nome2)).set(2,aux_disciplina+" \n NOTA :  "+"("+nota+")");
                }
            }else if(Integer.parseInt(op) == 5){ // ADICIONAR FALTAS
                if(dici.isEmpty()){
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.println("Realize o cadastro do aluno primeiro.");
                    System.out.println("-------------------------------");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("----ALUNOS CADASTRADOS:----");
                    System.out.println();
                    for(int i=0;i<nome_Alunos.size();i++){
                        System.out.println(i+")"+ nome_Alunos.get(i));
                    }
                    System.out.println();
                    System.out.println("--Escolha um aluno--");
                    System.out.println();
                    System.out.println("Digite um inteiro correspondente:");
                    System.out.println();
                    System.out.println();
                    System.out.println("Digite a quantidade de faltas(Int):");
                    String num_faltas = opt.nextLine();
                    //String aux_disciplina = dici.get(nome_Alunos.get(op_nome3)).get(2);
                    //dici.get(nome_Alunos.get(op_nome3)).set(2,aux_disciplina+" \n"+"FALTAS : ("+num_faltas+")");
                }
            }else if(Integer.parseInt(op) == 9){
                if(dici.isEmpty()){
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.println("Realize o cadastro do aluno primeiro.");
                    System.out.println("-------------------------------");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("----ALUNOS CADASTRADOS:----");
                    System.out.println();
                    for(int i=0;i<nome_Alunos.size();i++){
                        System.out.println(i+")"+ nome_Alunos.get(i));
                    }
                    System.out.println();
                    System.out.println("--Escolha um aluno--");
                    System.out.println();
                    System.out.println("Digite um inteiro correspondente:");
                    System.out.println();

                    int op_nome9 = opt.nextInt();opt.nextLine();
                    System.out.println();
                    String nome_aluno = nome_Alunos.get(op_nome9);
                    String num_disciplinas_aluno_escolhido = (dici.get(nome_aluno)[2]);
                    System.out.println("ALUNO "+nome_aluno+" TEM "+num_disciplinas_aluno_escolhido+" DISCIPLINAS "+" PARA CADASTRAR!");
                    for(int i=0;i<Integer.parseInt(num_disciplinas_aluno_escolhido);i++){
                        System.out.println();
                        int aux=i+1;
                        System.out.println("Digite a disciplina - "+ (aux)+" :");
                        String disciplina = opt.nextLine();
                        dici_diciplinas.get(nome_aluno)[i] = disciplina;
                        System.out.println();

                    }
                 } }
            else if(Integer.parseInt(op) == 0){
                break;
            }
            else{
                System.out.println();
                System.out.println("-----------ERROR------------");
                System.out.println();
                System.out.println();
                System.out.println("Digite uma opção válida!");
                System.out.println();
                System.out.println();

            }
    }else{
        System.out.println();
        System.out.println();
        System.out.println("------------Opção Inválida!------------");
        System.out.println();
    }
    }
    }
    private static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
}
