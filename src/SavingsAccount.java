public class SavingsAccount extends Account {
    private String CompanyName;

   SavingsAccount(String An, String O, double b, String cn) {
        super(An, O, b);
        CompanyName = cn;
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
