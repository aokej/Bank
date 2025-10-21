public class BusinessAccount extends Account {
    private String CompanyName;

    BusinessAccount(String An, String O, double b, String cn) {
        super(An, O, b);
        CompanyName = cn;
    }

    public String getCompanyName(){
        return CompanyName;
    }
    public void setCompanyName(String newcn){
        if(newcn != CompanyName && !newcn.isEmpty()){
            CompanyName = newcn;
        }
    }


}
