import java.util.ArrayList;
public class Cliente{

    public String name;
    public int soma;
    public long tempoInicial;
    public long tempoTotal = 0;
    ArrayList<Integer> numeros = new ArrayList<>();

    public Cliente(String nome, long tempoInicial) {
        this.name = nome;
        this.soma = 0;
        this.tempoInicial = tempoInicial;
    }

    public long somatorio(int num){
        numeros.add(num);
        
        this.soma += num;

        if(numeros.size() == 1000000){
            tempoTotal = (System.currentTimeMillis() - tempoInicial);
            return tempoTotal;
        }
        
        return 0;    
    }

    @Override
    public String toString() {
        return "Cliente " + name + " levou " + tempoTotal + " para somar = " + soma;
    }

}