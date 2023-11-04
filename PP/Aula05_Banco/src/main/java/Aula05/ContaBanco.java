package Aula05;

public class ContaBanco {

    private int numConta;
    private String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco() {
        this.saldo = 0f;
        this.status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(String tipoConta) {
        this.setTipo(tipoConta);
        this.setStatus(true);

        if ("CC".equals(this.tipo)) {
            this.setSaldo(50f);
        } else {
            this.setSaldo(150f);
        }
    }

    public void fecharConta() {
        if (this.getSaldo() < 0 || this.getSaldo() > 0) {
            System.out.println("Impossível fechar conta!");
        } else {
            setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float valor) {
        if (this.isStatus()) {
            this.setSaldo(this.getSaldo() + valor);
        } else {
            System.out.println("Erro!");
        }
    }

    public void tirar(float valor) {
        if (this.isStatus() == true && this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
        } else {
            System.out.println("Conta fechada ou saldo insuficiente!");
        }
    }

    
    public void pagarMensalidade(){
        float v;
        if("CC".equals(this.getTipo())){
            v = 12f;
        }else{
            v = 20f;
        }
        if(this.isStatus() == true){
            if(this.getSaldo() > v){
                this.setSaldo(this.getSaldo()- v);
            }
        }
    }  
    
    public void estaduAtual(){
        System.out.println("Conta: "+ this.getNumConta());
        System.out.println("Dono: "+ this.getDono());
        System.out.println("Tipo: "+ this.getTipo());
        System.out.println("Saldo: "+ this.getSaldo());
        System.out.println("Status: "+ this.isStatus());
        
        
        
    }
    
    
}
