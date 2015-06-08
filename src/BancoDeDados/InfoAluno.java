package BancoDeDados;


public class InfoAluno {
    private String nome, nomedomeio, sobrenome, nusp, endereco, complemento, cep;
    
    private InfoAluno Next_nome;
    private InfoAluno Next_sobrenome;
    private InfoAluno Next_nusp;
    
    protected InfoAluno(){
    }
    
    
    protected void ColocaNome(String n){
    nome=n;
    }
    
    protected String PegaNome(){
    return(nome);
    }
    
    protected void ColocaSobrenome(String n){
    sobrenome=n;
    }
    
    protected String PegaSobrenome(){
    return (sobrenome);
    }
    
    protected void ColocaNusp(String n){
    nusp=n;
    }    

    protected String PegaNusp(){
    return (nusp);
    }
    
    protected void ColocaNomeDoMeio(String n){
    nomedomeio=n;
    }

    protected String PegaNomeDoMeio(){
    return (nomedomeio);
    }
    
    protected void ColocaEndereco(String n){
    endereco=n;
    }
    
    protected String PegaEndereco(){
    return(endereco);
    }
    
    protected void ColocaComplemento(String n){
    complemento=n;
    }
    
    protected String PegaComplemento(){
    return(complemento);
    }
    
    protected void ColocaCep(String n){
    cep=n;
    }
    
    protected String PegaCep(){
    return(cep);
    }
    
    protected void ImprimeAluno(){
        System.out.print("Nome do aluno: "+nome+" "+nomedomeio+" "+sobrenome);
        System.out.println("         nUSP: "+nusp);
        System.out.println("Endereco: "+endereco+", "+complemento+"   CEP: "+cep);
        System.out.println("---------------------------------------------------------");
    }
  
    protected void ColocaNext_nome(InfoAluno Next_nome){
        this.Next_nome=Next_nome;
    }
    
    protected InfoAluno PegaNext_nome(){
        return(Next_nome);
    }
    
    protected void ColocaNext_sobrenome(InfoAluno Next_sobrenome){  
        this.Next_sobrenome = Next_sobrenome;
    }
    
    protected InfoAluno PegaNext_sobrenome(){
        return(Next_sobrenome);
    }
    
    protected void ColocaNext_nusp(InfoAluno Next_nusp){    
        this.Next_nusp = Next_nusp;
    }
    
    protected InfoAluno PegaNext_nusp(){
        return(Next_nusp);
    }

    
}
