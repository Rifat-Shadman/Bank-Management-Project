package BankingApplicationPackage;

public class officers {
    private String officer_code;
    private String officer_password;
    boolean check_officer_login(String code, String pass)
    {
        if(this.officer_code.equals(code) && this.officer_password.equals(pass))
        {
            return true;
        }
        return false;
    }
    officers(String code, String pass)
    {
        this.officer_code=code;
        this.officer_password=pass;
    }
}