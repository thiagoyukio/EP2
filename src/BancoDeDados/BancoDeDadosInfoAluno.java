
package BancoDeDados;

public class BancoDeDadosInfoAluno {
    private int NumeroDeAlunos; // Numero de alunos ja inseridos
    
    private InfoAluno Head_nome;
    private InfoAluno Head_sobrenome;
    private InfoAluno Head_nusp;
    
    public BancoDeDadosInfoAluno(){
        NumeroDeAlunos=0;
        Head_nome = null;
        Head_sobrenome = null;
        Head_nusp = null;
    }
    
    public BancoDeDadosInfoAluno(String nomearquivo){
        //inserir metodo que pega informacoes de um arquivo externo        
    }
    
    private void IncremetaNumeroDeAlunos(){
        NumeroDeAlunos++;
    }
    private void DecrementaNUmeroDeAlunos(){
        NumeroDeAlunos--;
    }
    
    private void ColocaHead_nome(InfoAluno Head_nome){
        this.Head_nome= Head_nome;
    }
    
    private InfoAluno PegaHead_nome(){
        return (this.Head_nome);
    }
    
    private void ColocaHead_sobrenome(InfoAluno Head_sobrenome){
        this.Head_sobrenome = Head_sobrenome;
    }
    
    private InfoAluno PegaHead_sobrenome(){
        return (this.Head_sobrenome);
    }
    
    private void ColocaHead_nusp(InfoAluno Next_nusp){
        this.Head_nusp = Next_nusp;
    }
    
    private InfoAluno PegaHead_nusp(){
        return (this.Head_nusp);
    }
    
    public void InsereAluno(String nome,String nomedomeio,String sobrenome,String nusp,String endereco,String complemento,String cep){
        InfoAluno aluno = new InfoAluno();
        InfoAluno correr;
        this.IncremetaNumeroDeAlunos();
        aluno.ColocaNome(nome);
        aluno.ColocaSobrenome(sobrenome);
        aluno.ColocaNomeDoMeio(nomedomeio);
        aluno.ColocaEndereco(endereco);
        aluno.ColocaComplemento(complemento);
        aluno.ColocaCep(cep);
        aluno.ColocaNusp(nusp);
        
        correr = this.PegaHead_nome();
        while(correr != null){
            if((correr.PegaNome()).compareTo(nome)<0) break;
            correr = correr.PegaNext_nome();
        }
        if(correr==null){
            aluno.ColocaNext_nome(PegaHead_nome());
            this.ColocaHead_nome(aluno);
        } else {
            aluno.ColocaNext_nome(correr.PegaNext_nome());
            correr.ColocaNext_nome(aluno);
        }
        
        correr = Head_nusp;
        while(correr != null){
            //System.out.println("nusp da busca: "+Integer.parseInt(correr.PegaNusp())+ "  nusp do aluno: "+Integer.parseInt(nusp));
            if(Integer.parseInt(correr.PegaNusp()) > Integer.parseInt(nusp)) break;
            System.out.println("Correr :"+correr.PegaNome());
            correr = correr.PegaNext_nusp();
            //System.out.println("Correr :"+correr.PegaNome());
            
        }
        if(correr==null){
            aluno.ColocaNext_nusp(PegaHead_nusp());
            this.ColocaHead_nusp(aluno);
        } else {
            System.out.println("Correr :"+correr.PegaNome());
            aluno.ColocaNext_nusp(correr.PegaNext_nusp());
            correr.ColocaNext_nusp(aluno);
        }
        
        aluno.ColocaNext_sobrenome(PegaHead_sobrenome());
        this.ColocaHead_sobrenome(aluno);
        /*
        aluno.ColocaNext_nusp(PegaHead_nusp());
        this.ColocaHead_nusp(aluno);
          */   
    }
    
    public InfoAluno BuscaAluno(String tipo, String x){
        InfoAluno alunobuscado;
        
        switch(tipo){
            
            case "nome":
                alunobuscado = Head_nome;

                while(alunobuscado!=null){
                    if(alunobuscado.PegaNome().equals(x)) break;
                    alunobuscado=alunobuscado.PegaNext_nome();
                }
                if(alunobuscado==null){
                    System.out.println("Aluno nao encontrado!");
                    return null;
                }
                break;
                
            case "sobrenome":
                alunobuscado = Head_sobrenome;

                while(alunobuscado!=null){
                    if(alunobuscado.PegaSobrenome().equals(x)) break;
                    alunobuscado=alunobuscado.PegaNext_sobrenome();
                }
                if(alunobuscado==null){
                    System.out.println("Aluno nao encontrado!");
                    return null;
                }
                break;
                
            case "nusp":
                alunobuscado = Head_nusp;

                while(alunobuscado!=null){
                    if(alunobuscado.PegaNusp().equals(x)) break;
                    alunobuscado=alunobuscado.PegaNext_nusp();
                }
                if(alunobuscado==null){
                    System.out.println("Aluno nao encontrado!");
                    return null;
                }
                break;
                
            default:
                System.out.println("Criterio de busca invalido!");
                alunobuscado = null;
                break;
            }
        
        return alunobuscado;
    }
    
    public void ImprimeBanco(String criterioOrdenacao){
        InfoAluno aluno;
        
        switch(criterioOrdenacao){
            
            case "nome":
                aluno = Head_nome;
                while(aluno!=null){
                    aluno.ImprimeAluno();
                    aluno=aluno.PegaNext_nome();
                }
                break;
             
            case "sobrenome":
                aluno = Head_sobrenome;
                while(aluno!=null){
                    aluno.ImprimeAluno();
                    aluno=aluno.PegaNext_sobrenome();
                }
                break;
             
            case "nusp":
                aluno = Head_nusp;
                while(aluno!=null){
                    aluno.ImprimeAluno();
                    aluno=aluno.PegaNext_nusp();
                }
                break;
             
            default: 
                System.out.println("Criterio de impressao invalido!");
        }
       
    }
    
    public static void main(String[] args){
        BancoDeDadosInfoAluno Database = new BancoDeDadosInfoAluno();
        Database.InsereAluno("Joao","dos Santos","Pereira", "0000000", "Rua da Vila 44", "11 Bloco A", "24857693");
        Database.InsereAluno("Pedro","","Amaral", "9999998", "Rua Azul 754", "311", "2458293");
        Database.InsereAluno("Zurg","Will","Alves", "8999995", "Rua Amaral 4", "", "2464653");
        Database.InsereAluno("Amanda","Rodrigues","Lima", "9999995", "Rua Amaral 4", "", "2464653");
        Database.InsereAluno("Beto","Russo","Martin", "8799995", "Rua Amaral 4", "", "2464653");
        Database.InsereAluno("Ana","Messi","Nunes", "8899995", "Rua Amaral 4", "", "2464653");
        
        Database.ImprimeBanco("nusp");
        
    }
    

}
