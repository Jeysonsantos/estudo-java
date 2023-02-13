import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
        
public class App {
    
    public static void main(String[] args) 
    {
        ArrayList<String>nome_Alunos = new ArrayList<String>();
        Map<String,String[]> dici = new HashMap<>();
        Map<String,String[]> dici_diciplinas = new HashMap<>();
        Map<String,String[]> dici_notas = new HashMap<>();
        Map<String,String[]> dici_faltas = new HashMap<>();

        System.out.println("-------------- Bem vindo ao sistema de cadastro! -------------");
        System.out.println();
        while(true){
            System.out.println("-----> MENU <-----");
            System.out.println();
            System.out.println("Opções:\n"
                + "\n 1.Matricular um aluno no sistema." 
                + "\n 2.Remover um aluno."
                + "\n 3.Adicionar Nota."
                + "\n 4.Alterar Nota."
                + "\n 5.Adicionar Faltas."
                + "\n 6.Alterar dados de um aluno."
                + "\n 7.Mostrar informações de um aluno."
                + "\n 8.Alterar Faltas."
                + "\n 9.Adicionar Disciplinas. (NÚMERO DE DISCIPLINAS CADASTRADO NA OPÇÃO 1)"
                + "\n 10.Remover Disciplinas."
                + "\n 0.Sair\n");
            Scanner opt = new Scanner(System.in);
            System.out.println("Digite uma opção (Nº INTEIRO): ");
            String op = opt.nextLine();
            if(isInteger(op)){
                if(Integer.parseInt(op) == 1) // OPCAO MATRICULAR UM ALUNO
                {
                    System.out.println();
                    System.out.println("-> OPÇÃO ATUAL : 1) MATRICULAR UM ALUNO NO SISTEMA <-");
                    System.out.println();
                    Scanner matricula = new Scanner(System.in);
                    System.out.println("-----------------------");
                    System.out.println("Digite o NOME do aluno:");
                    String nome = matricula.nextLine();
                    System.out.println("-----------------------");
                    System.out.println("Digite o CPF:");
                    String cpf = matricula.nextLine();
                    System.out.println("-----------------------");
                    System.out.println("Digite o número de MATRÍCULA:");
                    String mat = matricula.nextLine();
                    System.out.println("-----------------------");
                    System.out.println("Digite o NÚMERO DE DISCIPLINAS desse aluno:");
                    String num_disciplinas = matricula.nextLine();
                    System.out.println("-----------------------");
                    System.out.println("Digite o E-MAIL desse aluno:");
                    String email = matricula.nextLine();
                    nome_Alunos.add(nome);
                    String[] dados = { cpf, mat,num_disciplinas,email};
                    String[] disciplinas = new String[Integer.parseInt(num_disciplinas)];
                    String[] notas = new String[Integer.parseInt(num_disciplinas)];
                    String[] faltas = new String[Integer.parseInt(num_disciplinas)];

                    System.out.println();
                    System.out.println("-----> DADOS SALVOS COM SUCESSO!! <-----");
                    System.out.println();
                    
                    dici.put(nome,dados);
                    dici_diciplinas.put(nome,disciplinas);
                    dici_notas.put(nome,notas);
                    dici_faltas.put(nome,faltas);

                    
                }else if(Integer.parseInt(op) == 2){ // REMOVER UM ALUNO
                    if(dici.isEmpty()){
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Realize o cadastro primeiro.");
                        System.out.println("-------------------------------");
                        System.out.println();
                    }else{
                        System.out.println();
                        System.out.println("-> OPÇÃO ATUAL : 2) REMOVER UM ALUNO <-");
                        System.out.println();
                        System.out.println("----ALUNOS CADASTRADOS:----");
                        System.out.println();
                        for(int i=0;i<nome_Alunos.size();i++){
                            int aux=i+1;
                            System.out.println(aux+")"+ nome_Alunos.get(i));
                        }
                        System.out.println("0)VOLTAR AO MENU");

                        System.out.println();
                        System.out.println("-- Escolha um aluno para REMOVER DO SISTEMA --");
                        System.out.println();
                        System.out.println("Digite um inteiro correspondente:");
                        System.out.println();
                        int op_nome3 = opt.nextInt(); // DA B.O SE O ANIMAL NAO DIGITAR INTEIRO.
                        if(op_nome3==0){continue;}
                        String aluno_removeString =nome_Alunos.get(op_nome3-1);
                        dici.remove(aluno_removeString);
                        nome_Alunos.remove(op_nome3-1);
                        dici_diciplinas.remove(aluno_removeString);
                        dici_faltas.remove(aluno_removeString);
                        dici_notas.remove(aluno_removeString);
                        System.out.println("-------------------------------");
                        System.out.println();
                        System.out.println("---ALUNO ("+aluno_removeString+") EXCLUÍDO COM SUCESSO!");
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println();
                    }
                }else if(Integer.parseInt(op) == 4){ // ALTERAR NOTA
                    if(dici.isEmpty()){
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Realize o cadastro do aluno primeiro.");
                        System.out.println("-------------------------------");
                        System.out.println();
    
                        }else{
                            System.out.println();
                            System.out.println("-> OPÇÃO ATUAL : 4) ALTERAR NOTA <-");
                            System.out.println();
                            System.out.println("----ALUNOS CADASTRADOS:----");
                            System.out.println();
                            for(int i=0;i<nome_Alunos.size();i++){
                                int aux4=i+1;
                                System.out.println(aux4+")"+ nome_Alunos.get(i));
                            }
                            System.out.println("0)VOLTAR AO MENU");
                            System.out.println();
                            System.out.println("--Escolha um aluno--");
                            System.out.println();
                            System.out.println("Digite um inteiro correspondente:");
                            System.out.println();
                            int op_nome4 = opt.nextInt();
                            if(op_nome4==0){continue;}
                            System.out.println();
                            String nome_aluno4 = nome_Alunos.get(op_nome4-1);
                            int num_disciplinas_aluno_escolhido4=Integer.parseInt((dici.get(nome_aluno4))[2]);
                            int aux4=0;
                            for(int i=0;i<num_disciplinas_aluno_escolhido4;i++){
                                if(dici_diciplinas.get(nome_aluno4)[i]!= null){aux4=1;break;}
                            }
                            if(aux4==1){
                                System.out.println("-> DISCIPLINAS MATRICULADAS DE ("+nome_aluno4+") COM NOTAS CADASTRADAS:" );  
                                System.out.println();
                                int segundo_aux_4=0;
                                for(int i=0;i<num_disciplinas_aluno_escolhido4;i++){
                                    int aux_4=i+1;
                                    if(dici_diciplinas.get(nome_aluno4)[i]!=null){
                                        if(dici_notas.get(nome_aluno4)[i]!=null){
                                            segundo_aux_4=segundo_aux_4+1;
                                            System.out.println("-------->"+aux_4+") "+ dici_diciplinas.get(nome_aluno4)[i] + " -> NOTA ATUAL CADASTRADA: "+ dici_notas.get(nome_aluno4)[i]);
                                        }
                                        
                                    }
                                }
                                if(segundo_aux_4==0){
                                    System.out.println();
                                    System.out.println("------ NÃO EXISTE NOTAS CADASTRADAS PARA ESSE ALUNO -------");
                                    System.out.println();

                                    continue;}
                                System.out.println("-------->0) VOLTAR AO MENU");
                                System.out.println();
                                System.out.println("Digite um inteiro correspondente à disciplina que deseja ALTERAR nota:");
                                int op_disciplina4 = opt.nextInt();opt.nextLine();
                                if(op_disciplina4 == 0){continue;}
                                System.out.println();
                                System.out.println("Digite a nova nota para a disciplina ("+ dici_diciplinas.get(nome_aluno4)[op_disciplina4-1]+ ") :");
                                String nova_nota = opt.nextLine();
                                System.out.println();
                                dici_notas.get(nome_aluno4)[op_disciplina4-1]=nova_nota;
                                System.out.println();
                                System.out.println("---- NOVA NOTA CADASTRADA COM SUCESSO ----");
                                System.out.println();


                            }else{
                                System.out.println();

                                System.out.println("---NECESSÁRIO CADASTRAR DISCIPLINAS NA OPÇÃO 9");
                                System.out.println();
                            }
                        }
                    
                }else if(Integer.parseInt(op) == 6){ // ALTERAR DADOS DE UM ALUNO
                    if(dici.isEmpty()){
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Realize o cadastro primeiro.");
                        System.out.println("-------------------------------");
                        System.out.println();
                    }else{
                        System.out.println();
                        System.out.println("-> OPÇÃO ATUAL : 6) ALTERAR DADOS DE UM ALUNO <-");
                        System.out.println();
                        System.out.println("----ALUNOS CADASTRADOS:----");
                        System.out.println();
                        for(int i=0;i<nome_Alunos.size();i++){
                            int aux=i+1;
                            System.out.println(aux+")"+ nome_Alunos.get(i));
                        }
                        System.out.println("0)VOLTAR AO MENU");

                        System.out.println();
                        System.out.println("--Escolha um aluno--");
                        System.out.println();
                        System.out.println("Digite um inteiro correspondente:");
                        System.out.println();
                        int op_nome6 = opt.nextInt();
                        if(op_nome6==0){continue;}
                        System.out.println();
                        System.out.println();
                        System.out.println("---------  ALUNO ATUAL: "+ nome_Alunos.get(op_nome6-1)+"  ----------");
                        System.out.println();
                        String nome_aluno6 = nome_Alunos.get(op_nome6-1);
                        System.out.println("1) CPF:" + (dici.get(nome_aluno6))[0]);
                        System.out.println();
                        System.out.println("2) MATRÍCULA:" + (dici.get(nome_aluno6))[1]);
                        System.out.println();
                        System.out.println("3) E-MAIL:" + (dici.get(nome_aluno6))[3]);
                        System.out.println();
                        System.out.println("4) NOME:" + nome_aluno6);
                        System.out.println();
                        System.out.println("0) VOLTAR AO MENU");
                        System.out.println();
                        System.out.println("--Escolha uma opção para ALTERAR--");
                        System.out.println();
                        System.out.println("Digite um inteiro correspondente:");
                        System.out.println();
                        int op_alterar = opt.nextInt();opt.nextLine();
                        if(op_alterar==0){
                            continue;
                        }else if(op_alterar==1){
                            System.out.println();
                            System.out.println("-- CPF CADASTRADO DE ("+nome_aluno6+"): "+ dici.get(nome_aluno6)[0]);
                            System.out.println();
                            System.out.println("Digite o novo CPF :");
                            String cpf = opt.nextLine();
                            dici.get(nome_aluno6)[0]=cpf;
                            System.out.println();
                            System.out.println("----CPF DE ("+nome_aluno6+") ALTERADO PARA ("+cpf+") COM SUCESSO!!!");
                            System.out.println();
                        }else if(op_alterar==2){
                            System.out.println();
                            System.out.println("-- MATRÍCULA CADASTRADA DE ("+nome_aluno6+"): "+ dici.get(nome_aluno6)[1]);
                            System.out.println();
                            System.out.println("Digite a nova MATRÍCULA :");
                            String matriculaString = opt.nextLine();
                            dici.get(nome_aluno6)[1]=matriculaString;
                            System.out.println();
                            System.out.println("----MATRÍCULA DE ("+nome_aluno6+") ALTERADA PARA ("+matriculaString+") COM SUCESSO!!!");
                            System.out.println();
                        }else if(op_alterar==3){
                            System.out.println();
                            System.out.println("-- E-MAIL CADASTRADO DE ("+nome_aluno6+"): "+ dici.get(nome_aluno6)[3]);
                            System.out.println();
                            System.out.println("Digite o novo E-MAIL :");
                            String emailString = opt.nextLine();
                            dici.get(nome_aluno6)[3]=emailString;
                            System.out.println();
                            System.out.println("----E-MAIL DE ("+nome_aluno6+") ALTERADA PARA ("+emailString+") COM SUCESSO!!!");
                            System.out.println();
                        }else if(op_alterar==4){
                            System.out.println();
                            System.out.println("-- NOME CADASTRADO : "+ nome_aluno6);
                            System.out.println();
                            System.out.println("Digite o novo NOME :");
                            String novo_nomeString = opt.nextLine();

                            dici.put(novo_nomeString,dici.get(nome_aluno6));
                            dici.remove(nome_aluno6);

                            dici_diciplinas.put(novo_nomeString,dici_diciplinas.get(nome_aluno6));
                            dici_diciplinas.remove(nome_aluno6);

                            dici_faltas.put(novo_nomeString,dici_faltas.get(nome_aluno6));
                            dici_faltas.remove(nome_aluno6);

                            dici_notas.put(novo_nomeString,dici_notas.get(nome_aluno6));
                            dici_notas.remove(nome_aluno6);

                            nome_Alunos.set(op_nome6-1,novo_nomeString);

                            System.out.println();
                            System.out.println("----NOME ALTERADO DE "+nome_aluno6+" PARA "+ novo_nomeString+" COM SUCESSO!!!");
                            System.out.println();
                        }else{
                            System.out.println();
                            System.out.println("--- OPÇÃO INVÁLIDA. ---");
                            System.out.println();
                        }
                    }
                }else if(Integer.parseInt(op) == 7){ // MOSTRAR INFORMACOES DE UM ALUNO
                    if(dici.isEmpty()){
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Realize o cadastro primeiro.");
                        System.out.println("-------------------------------");
                        System.out.println();
                    }else{
                        System.out.println();
                        System.out.println("-> OPÇÃO ATUAL : 7) MOSTRAR INFORMACOES DE UM ALUNO <-");
                        System.out.println();
                        System.out.println("----ALUNOS CADASTRADOS:----");
                        System.out.println();
                        for(int i=0;i<nome_Alunos.size();i++){
                            int aux=i+1;
                            System.out.println(aux+")"+ nome_Alunos.get(i));
                        }
                        System.out.println("0)VOLTAR AO MENU");

                        System.out.println();
                        System.out.println("--Escolha um aluno--");
                        System.out.println();
                        System.out.println("Digite um inteiro correspondente:");
                        System.out.println();
                        int op_nome7 = opt.nextInt();
                        if(op_nome7==0){continue;}
                        System.out.println();
                        System.out.println();
                        System.out.println("---------  ALUNO ATUAL: "+ nome_Alunos.get(op_nome7-1)+"  ----------");
                        System.out.println();
                        String nome_aluno7 = nome_Alunos.get(op_nome7-1);
                        System.out.println("CPF:" + (dici.get(nome_aluno7))[0]);
                        System.out.println();

                        System.out.println("MATRÍCULA:" + (dici.get(nome_aluno7))[1]);
                        System.out.println();

                        System.out.println("EMAIL:" + (dici.get(nome_aluno7))[3]);
                        System.out.println();

                        int num_disciplinas_aluno_escolhido7=Integer.parseInt((dici.get(nome_aluno7))[2]);
                        
                        System.out.println("DISCIPLINAS MATRICULADAS: " );  
                        System.out.println();

                        for(int i=0;i<num_disciplinas_aluno_escolhido7;i++){
                            if(dici_diciplinas.get(nome_aluno7)[i] != null){
                                System.out.println("--------> "+ dici_diciplinas.get(nome_aluno7)[i]);
                                if(dici_notas.get(nome_aluno7)[i]!=null){
                                    System.out.println("         NOTA : "+ dici_notas.get(nome_aluno7)[i]);
                                }else{
                                    System.out.println("         NOTA : SEM NOTA");
                                }
                                if(dici_faltas.get(nome_aluno7)[i]!=null){
                                    System.out.println("         FALTAS : "+ dici_faltas.get(nome_aluno7)[i]);
                                }else{
                                    System.out.println("         FALTAS : NÃO CADASTRADO");
                                }
                            }
                        }
                        System.out.println();

                    }
                }else if(Integer.parseInt(op) == 8){ // ALTERAR FALTAS
                    if(dici.isEmpty()){
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Realize o cadastro do aluno primeiro.");
                        System.out.println("-------------------------------");
                        System.out.println();
    
                        }else{
                            System.out.println();
                            System.out.println("-> OPÇÃO ATUAL : 8) ALTERAR FALTAS <-");
                            System.out.println();
                            System.out.println("----ALUNOS CADASTRADOS:----");
                            System.out.println();
                            for(int i=0;i<nome_Alunos.size();i++){
                                int aux8=i+1;
                                System.out.println(aux8+")"+ nome_Alunos.get(i));
                            }
                            System.out.println("0)VOLTAR AO MENU");
                            System.out.println();
                            System.out.println("--Escolha um aluno--");
                            System.out.println();
                            System.out.println("Digite um inteiro correspondente:");
                            System.out.println();
                            int op_nome8 = opt.nextInt();
                            if(op_nome8==0){continue;}
                            System.out.println();
                            String nome_aluno8 = nome_Alunos.get(op_nome8-1);
                            int num_disciplinas_aluno_escolhido8=Integer.parseInt((dici.get(nome_aluno8))[2]);
                            int aux8=0;
                            for(int i=0;i<num_disciplinas_aluno_escolhido8;i++){
                                if(dici_diciplinas.get(nome_aluno8)[i]!= null){aux8=1;break;}
                            }
                            if(aux8==1){
                                System.out.println("-> DISCIPLINAS MATRICULADAS DE ("+nome_aluno8+") COM FALTAS CADASTRADAS:" );  
                                System.out.println();
                                int segundo_aux_8=0;
                                for(int i=0;i<num_disciplinas_aluno_escolhido8;i++){
                                    int aux_8=i+1;
                                    if(dici_diciplinas.get(nome_aluno8)[i]!=null){
                                        if(dici_faltas.get(nome_aluno8)[i]!=null){
                                            segundo_aux_8=segundo_aux_8+1;
                                            System.out.println("-------->"+aux_8+") "+ dici_diciplinas.get(nome_aluno8)[i] + " -> Nº DE FALTAS CADASTRADAS: "+ dici_faltas.get(nome_aluno8)[i]);
                                        }
                                        
                                    }
                                }
                                if(segundo_aux_8==0){
                                    System.out.println();
                                    System.out.println("------ NÃO EXISTE FALTAS CADASTRADAS PARA ESSE ALUNO -------");
                                    System.out.println();

                                    continue;}
                                System.out.println("-------->0) VOLTAR AO MENU");
                                System.out.println();
                                System.out.println("Digite um inteiro correspondente à disciplina que deseja ALTERAR o nº de faltas:");
                                int op_disciplina8 = opt.nextInt();opt.nextLine();
                                if(op_disciplina8 == 0){continue;}
                                System.out.println();
                                System.out.println("Digite o novo nº de faltas para a disciplina ("+ dici_diciplinas.get(nome_aluno8)[op_disciplina8-1]+ ") :");
                                String nova_faltas = opt.nextLine();
                                System.out.println();
                                dici_faltas.get(nome_aluno8)[op_disciplina8-1]=nova_faltas;
                                System.out.println();
                                System.out.println("---- NOVO Nº DE FALTAS CADASTRADO COM SUCESSO ----");
                                System.out.println();


                            }else{
                                System.out.println();

                                System.out.println("---NECESSÁRIO CADASTRAR DISCIPLINAS NA OPÇÃO 9");
                                System.out.println();
                            }
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
                        System.out.println();
                        System.out.println("-> OPÇÃO ATUAL : 3) ADICIONAR NOTA <-");
                        System.out.println();
                        System.out.println("----ALUNOS CADASTRADOS:----");
                        System.out.println();
                        for(int i=0;i<nome_Alunos.size();i++){
                            int aux=i+1;
                            System.out.println(aux+")"+ nome_Alunos.get(i));
                        }
                        System.out.println("0)VOLTAR AO MENU");
                        System.out.println();
                        System.out.println("--Escolha um aluno--");
                        System.out.println();
                        System.out.println("Digite um inteiro correspondente:");
                        System.out.println();
                        int op_nome3 = opt.nextInt();
                        if(op_nome3==0){continue;}
                        System.out.println();
                        String nome_aluno3 = nome_Alunos.get(op_nome3-1);
                        int num_disciplinas_aluno_escolhido3=Integer.parseInt((dici.get(nome_aluno3))[2]);
                        int aux=0;
                        for(int i=0;i<num_disciplinas_aluno_escolhido3;i++){
                            if(dici_diciplinas.get(nome_aluno3)[i]!= null){aux=1;break;}
                        }
                        if(aux==1){
                            System.out.println("-> DISCIPLINAS MATRICULADAS DE ("+nome_aluno3+") SEM CADASTRO DE NOTA:" );  
                            System.out.println();

                            for(int i=0;i<num_disciplinas_aluno_escolhido3;i++){
                                int aux7=i+1;
                                if(dici_diciplinas.get(nome_aluno3)[i]!=null){
                                    if(dici_notas.get(nome_aluno3)[i]==null){
                                        System.out.println("-------->"+aux7+") "+ dici_diciplinas.get(nome_aluno3)[i]); 
                                    }  
                                }
                            }
                            System.out.println("-------->0) VOLTAR AO MENU");
                            System.out.println();
                            System.out.println("Digite um inteiro correspondente à disciplina que deseja adicionar nota:");
                            int op_disciplina3 = opt.nextInt();opt.nextLine();
                            if(op_disciplina3 == 0){continue;}
                            System.out.println();
                            System.out.println("-------> DISCIPLINA ESCOLHIDA PARA ADICIONAR NOTA : " + dici_diciplinas.get(nome_aluno3)[op_disciplina3-1]);
                            System.out.println();
                            System.out.println("Digite a nota:");
                            String notaString=opt.nextLine();
                            System.out.println();
                            dici_notas.get(nome_aluno3)[op_disciplina3-1] = notaString;
                            System.out.println("-----> NOTA ("+notaString+") ADICIONADA COM SUCESSO NA DISCIPLINA ("+dici_diciplinas.get(nome_aluno3)[op_disciplina3-1]+")");
                            System.out.println();
                        
                    }else
                    {
                        System.out.println();
                        System.out.println("--- NECESSÁRIO CADASTRAR DISCIPLINAS PARA O ALUNO ("+nome_aluno3.toUpperCase()+") !!!");
                        System.out.println();
                    }
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
                            System.out.println();
                            System.out.println("-> OPÇÃO ATUAL : 5) ADICIONAR FALTAS <-");
                            System.out.println();
                            System.out.println("----ALUNOS CADASTRADOS:----");
                            System.out.println();
                            for(int i=0;i<nome_Alunos.size();i++){
                                int aux=i+1;
                                System.out.println(aux+")"+ nome_Alunos.get(i));
                            }
                            System.out.println("0)VOLTAR AO MENU");
                            System.out.println();
                            System.out.println("--Escolha um aluno--");
                            System.out.println();
                            System.out.println("Digite um inteiro correspondente:");
                            System.out.println();
                            int op_nome5 = opt.nextInt();
                            if(op_nome5==0){continue;}
                            System.out.println();
                            String nome_aluno5 = nome_Alunos.get(op_nome5-1);
                            int num_disciplinas_aluno_escolhido5=Integer.parseInt((dici.get(nome_aluno5))[2]);
                            int aux=0;
                            for(int i=0;i<num_disciplinas_aluno_escolhido5;i++){
                                if(dici_diciplinas.get(nome_aluno5)[i]!= null){aux=1;break;}
                            }
                            if(aux==1){
                                System.out.println("-> DISCIPLINAS MATRICULADAS DE ("+nome_aluno5+") SEM CADASTRO DE FALTAS:" );  
                                System.out.println();
                                int aux_saber_se_tem_nota=0;
                                for(int i=0;i<num_disciplinas_aluno_escolhido5;i++){
                                    int aux5=i+1;
                                    if(dici_diciplinas.get(nome_aluno5)[i]!=null){
                                        if(dici_faltas.get(nome_aluno5)[i]==null){
                                            System.out.println("-------->"+aux5+") "+ dici_diciplinas.get(nome_aluno5)[i]);
                                            aux_saber_se_tem_nota=1;
                                        }  
                                    }
                                }
                                if(aux_saber_se_tem_nota==0){
                                    System.out.println();
                                    System.out.println("-- TODAS AS DISCIPLINAS DESSE ALUNO ESTÃO COM FALTAS CADASTRADAS, PARA ALTERAR VÁ NA OPÇÃO 8 (ALTERAR FALTAS) !!!");
                                    System.out.println();
                                    continue;
                                }
                                System.out.println("-------->0) VOLTAR AO MENU");
                                System.out.println();
                                System.out.println("Digite um inteiro correspondente à disciplina que deseja adicionar o Nº de faltas:");
                                int op_disciplina5 = opt.nextInt();opt.nextLine();
                                if(op_disciplina5 == 0){continue;}
                                System.out.println();
                                System.out.println("-------> DISCIPLINA ESCOLHIDA PARA ADICIONAR O Nº DE FALTAS : " + dici_diciplinas.get(nome_aluno5)[op_disciplina5-1]);
                                System.out.println();
                                System.out.println("Digite o Nº DE FALTAS:");
                                String faltasString=opt.nextLine();
                                System.out.println();
                                dici_faltas.get(nome_aluno5)[op_disciplina5-1] = faltasString;
                                System.out.println("-----> Nº DE FALTAS ("+faltasString+") ADICIONADO COM SUCESSO NA DISCIPLINA ("+dici_diciplinas.get(nome_aluno5)[op_disciplina5-1]+")");
                                System.out.println();
                            
                        }else
                        {
                            System.out.println();
                            System.out.println("--- NECESSÁRIO CADASTRAR DISCIPLINAS PARA O ALUNO ("+nome_aluno5.toUpperCase()+") !!!");
                            System.out.println();
                        }
                    }
                }else if(Integer.parseInt(op) == 9){ //ADICIONAR DISCIPLINAS
                    if(dici.isEmpty()){
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Realize o cadastro do aluno primeiro.");
                        System.out.println("-------------------------------");
                        System.out.println();
                    }else{
                        System.out.println();
                        System.out.println("-> OPÇÃO ATUAL : 9) ADICIONAR DISCIPLINAS <-");
                        System.out.println();
                        System.out.println("----ALUNOS CADASTRADOS:----");
                        System.out.println();
                        for(int i=0;i<nome_Alunos.size();i++){
                            int aux=i+1;
                            System.out.println(aux+")"+ nome_Alunos.get(i));
                        }
                        System.out.println("0)VOLTAR AO MENU");
                        System.out.println();
                        System.out.println("--Escolha um aluno--");
                        System.out.println();
                        System.out.println("Digite um inteiro correspondente:");
                        System.out.println();

                        int op_nome9 = opt.nextInt();opt.nextLine();
                        if(op_nome9==0){continue;}
                        System.out.println();
                        String nome_aluno9 = nome_Alunos.get(op_nome9-1);
                        String num_disciplinas_aluno_escolhido = (dici.get(nome_aluno9)[2]); // PODE DAR B.O SE A MULA NAO DIGITAR UM NUMERO INTEIRO
                        int num_disciplinas_aluno_escolhidoINT=Integer.parseInt(num_disciplinas_aluno_escolhido);
                        int cont=0;
                        for(int i=0;i<num_disciplinas_aluno_escolhidoINT;i++){
                            if(dici_diciplinas.get(nome_aluno9)[i]==null){
                                cont=cont+1;
                            }
                        }
                        System.out.println("ALUNO "+nome_aluno9+" TEM ("+cont+") DISCIPLINA(S) "+" PARA CADASTRAR!");
                        if(cont==0){
                            System.out.println("---------------------------------------------------------------");
                            System.out.println();
                            System.out.println("--- ALUNO JÁ POSSUI TODAS AS DISCIPLINAS CADASTRADAS ---");
                            System.out.println();
                            System.out.println("---------------------------------------------------------------");

                            continue;}
                        for(int i=0;i<num_disciplinas_aluno_escolhidoINT;i++){
                            System.out.println();
                            int aux=i+1;
                            if(dici_diciplinas.get(nome_aluno9)[i]==null){
                                System.out.println("Digite a disciplina -> "+ (aux)+" :");
                                String disciplina = opt.nextLine();
                                dici_diciplinas.get(nome_aluno9)[i] = disciplina;
                            }
                            System.out.println();

                        }
                    } 
                }else if(Integer.parseInt(op) == 10){ // REMOVER DISICPLINAS
                    if(dici.isEmpty()){
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Realize o cadastro do aluno primeiro.");
                        System.out.println("-------------------------------");
                        System.out.println();
                    }else{
                        System.out.println();
                        System.out.println("-> OPÇÃO ATUAL : 10) REMOVER DISCIPLINAS <-");
                        System.out.println();
                        System.out.println("----ALUNOS CADASTRADOS:----");
                        System.out.println();
                        for(int i=0;i<nome_Alunos.size();i++){
                            int aux=i+1;
                            System.out.println(aux+")"+ nome_Alunos.get(i));
                        }
                        System.out.println("0)VOLTAR AO MENU");
                        System.out.println();
                        System.out.println("--Escolha um aluno--");
                        System.out.println();
                        System.out.println("Digite um inteiro correspondente:");
                        System.out.println();
                        int op_nome10 = opt.nextInt();opt.nextLine();
                        if(op_nome10==0){continue;}
                        System.out.println();
                        String nome_aluno10 = nome_Alunos.get(op_nome10-1);
                        int num_disciplinas_aluno_escolhido10=Integer.parseInt((dici.get(nome_aluno10))[2]);
                        int aux=0;
                        for(int i=0;i<num_disciplinas_aluno_escolhido10;i++){
                            if(dici_diciplinas.get(nome_aluno10)[i]!= null){aux=1;break;}
                        }
                        if(aux==1){
                            System.out.println("-> DISCIPLINAS MATRICULADAS DE "+nome_aluno10+" :" );  
                            System.out.println();

                            for(int i=0;i<num_disciplinas_aluno_escolhido10;i++){
                                int aux7=i+1;
                                if(dici_diciplinas.get(nome_aluno10)[i]==null){
                                    System.out.println("-------->"+aux7+") "+ "-REMOVIDA-");
                                }else{
                                    System.out.println("-------->"+aux7+") "+ dici_diciplinas.get(nome_aluno10)[i]);   
                                }
                            }
                            System.out.println("-------->0) VOLTAR AO MENU");
                            System.out.println();
                            System.out.println("Digite um inteiro correspondente para REMOVER a disciplina:");
                            int op_disciplina10 = opt.nextInt();
                            if(op_disciplina10 == 0){continue;}
                            String disciplina_escolhida_deletar = dici_diciplinas.get(nome_aluno10)[op_disciplina10-1];
                            System.out.println();
                            dici_diciplinas.get(nome_aluno10)[op_disciplina10-1]=null;
                            dici_faltas.get(nome_aluno10)[op_disciplina10-1]=null;
                            dici_notas.get(nome_aluno10)[op_disciplina10-1]=null;

                            System.out.println("DISCIPLINA "+disciplina_escolhida_deletar + " DELETADA COM SUCESSO !!!");
                            System.out.println();
                        }else{
                            System.out.println();
                            System.out.println("-------------------------------");
                            System.out.println("Realize o cadastro de disciplinas na opção 9 primeiro.");
                            System.out.println("-------------------------------");
                            System.out.println();

                        }

                        }

                }else if(Integer.parseInt(op) == 0){
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
    private static boolean isInteger(String str) 
    {
        return str != null && str.matches("[0-9]*");
    }
}
