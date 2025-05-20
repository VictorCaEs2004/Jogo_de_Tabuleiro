public class Estr_Pilha{

    private Elemento_Pilha topo;

    public Estr_Pilha(){
        this.topo = null;
    }

    public void Inserir(Elemento_Pilha elmntAInserir){
        elmntAInserir.getProx() = topo;
        topo = elmntAInserir;
    }

    public Elemento_Pilha Pop(){
        Elemento_Pilha elmPop = topo;
        topo = topo.getProx();
        return elmPop;
    }

    public Elemento_Pilha Peek(){
        return topo;
    }

    public boolean EstaVazio(){
        if(topo == null){
            return true;
        }
        return false;
    }

    public int Tamanho(){
        int tamanho = 0;
        if(!this.EstaVazio()){
            tamanho++;
            Elemento_Pilha elementoContado = topo;
            while(topo.getProx() != null){
                tamanho++;
            }
        }
        return tamanho;
    }
}