public class SavingsAccount extends Account {
    private String ClientName;

   SavingsAccount(String An, String O, double b, String cn) {
        super(An, O, b);
        ClientName = cn;
    }

    public String getClientName(){
        return ClientName;
    }
    public void setClientName(String newcn){
        if(newcn != ClientName && !newcn.isEmpty()){
            ClientName = newcn;
        }
    }


}
