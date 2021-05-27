package BankingApplicationPackage;
import java.util.*;

public class client {
    private String name;
    private int Id;
    private String password;
    private int ballance;
    String get_name()
    {
        return this.name;
    }
    boolean check_password(String st)
    {
        if(st.equals(password))
        {
            return true;
        }
        else
        {
            // System.out.println("The actual password is: "+password+" and given password is: "+st);
            return false;
        }
    }
    client(String name, int id, String password)
    {
        this.name=name;
        this.Id=id;
        this.password=password;
    }
    client()
    {
        this.ballance=0;
    }
    void creat_account(String name, int id, String password)
    {
        this.name=name;
        this.Id=id;
        this.password=password;
    }
    public int check_balance()
    {
        return this.ballance;
    }
    public void cash_in(int amount){
        this.ballance += amount;

    }

    public boolean cash_out(int amount){
        if(check_balance()>=amount)
        {
            this.ballance-=amount;
            System.out.println(name+", your Cash out request was Successfull."
                    + " Your current ballance is : "+check_balance());
            return true;
        }
        else{
            System.out.println(name+", you do not have enough ballance in your account to cash out."
                    + " Your current ballance is : "+check_balance());
            return false;
        }
    }
}