package BankingApplicationPackage;

import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {

        client [] user=new client[2000];

        int serial_no=0, code=170600;
        user[0]=new client("Rifat Shadman",code+ serial_no, "12345");
        for(int i=1; i<=1000; i++)
        {
            user[i]=new client("Rifat Shadman", code+serial_no, "12345");
            user[i].cash_in((100000*i)%12347);
        }
        serial_no++;
        user[0].cash_in(10000);


        officers officer=new officers("officer","password");

        //=====================================================================================
        //officer code is "officer" and password is "password"............................................
        //=====================================================================================

        System.out.println("=========Log in as a bank officer=========");
        while(true)//Bank officer Login.................................................
        {
            Scanner sc=new Scanner(System.in);
            boolean success=false;
            System.out.print("Enter your officer code: ");
            String Officer_code=sc.nextLine();
            System.out.print("Enter password: ");
            String Officer_pass=sc.nextLine();
            if(officer.check_officer_login(Officer_code, Officer_pass)){
                System.out.println("Login attempt successful!!");
                success=true;
            }
            else{
                System.out.println("Wrong Officer code or officer password. please try again.");
            }
            if(success)
            {
                break;
            }
        }

        while(true)
        {
            System.out.println("\n============================================================================");
            System.out.println("        Enter corresponding number to select an option from the Menu                     ");
            System.out.println("============================================================================");
            System.out.println(" 1. Create new account. \n 2. Cash In. \n 3. Cash Out. \n 4. Check Balance. \n 5. Terminate.");
            System.out.println("\n============================================================================");
            Scanner si=new Scanner(System.in);
            Scanner ss=new Scanner(System.in);
            int operation=si.nextInt();

            //================Creating New Account=============
            if(operation==1)
            {
                System.out.print("Enter Account name: ");
                String name=ss.nextLine();
                System.out.print("Enter Password for this account: ");
                String pass=ss.nextLine();
                user[serial_no]=new client(name, code+serial_no, pass);

                System.out.println("Successfully created an account for "+name+"\n. Your ID number is "
                        +(code+serial_no)+"\n. Always remember this ID number."+
                        " And use this ID number for further transaction.");
                serial_no++;

            }

            //==============Cash In======================
            else if(operation == 2)
            {
                boolean found_id=false;
                int id=0;
                for(int i=1; i<8; i++)
                {
                    System.out.print("Enter your ID no: ");
                    id=si.nextInt();
                    id-=code;
                    if(id>=serial_no || id<0)
                    {
                        System.out.print("Invalid ID!! you have "+(7-i)+
                                " attempt left.\n");
                    }
                    else {
                        found_id=true;
                        break;
                    }
                }
                if(found_id){
                    boolean success=false;
                    for(int i=1; i<8; i++)
                    {
                        System.out.print("Enter your password: ");
                        String pass=ss.nextLine();
                        if(user[id].check_password(pass))
                        {
                            System.out.print("Enter amount of money to Cash In: ");
                            int amount=si.nextInt();
                            user[id].cash_in(amount);
                            System.out.println("Successfully cashed in!!.\nYour current balance is : "
                                    +user[id].check_balance());
                            success=true;
                            break;
                        }
                        else{
                            System.out.print("Wrong Password!! you have "+(7-i)+
                                    " attempt left.\n");
                        }
                    }
                    if(!success)
                    {
                        System.out.println("Cash In attempt failed!! Try again later.");
                    }
                }
                else{
                    System.out.println("Could not find user Account. Try again later");
                }

            }//=============Cash Out==============
            else if(operation == 3)
            {
                boolean found_id=false;
                int id=0;
                for(int i=1; i<6; i++)
                {
                    System.out.print("Enter your ID number: ");
                    id=si.nextInt();
                    id-=code;
                    if(id>=serial_no || id<0)
                    {
                        System.out.print("Invalid ID!! you have "+(5-i)+
                                " attempt left.\n");
                    }
                    else {
                        found_id=true;
                        break;
                    }
                }
                if(found_id){
                    boolean success=false, possible=false;
                    for(int i=1; i<8; i++)
                    {
                        System.out.print("Enter your password: ");
                        String pass=ss.nextLine();
                        if(user[id].check_password(pass))
                        {
                            System.out.print("Enter amount of money to Cash Out: ");
                            int amount=si.nextInt();
                            possible=user[id].cash_out(amount);
                            success=true;
                            break;
                        }
                        else{
                            System.out.print("Wrong Password!! you have "+(7-i)+
                                    " attempt left.\n");
                        }
                    }
                    if(!success)
                    {
                        System.out.println("Cash out attempt failed!! Try again latter.");
                    }
                    else if(!possible)
                    {
                        System.out.println("Please try again latter.");
                    }
                }
                else{
                    System.out.println("Could not find user Account. Try again latter.");
                }

            }//===========Check Balance===========
            else if(operation==4)
            {
                boolean found_id=false;
                int id=0;
                for(int i=1; i<8; i++)
                {
                    System.out.print("Enter user ID : ");
                    id=si.nextInt();
                    id-=code;
                    if(id>=serial_no || id<0)
                    {
                        System.out.print("Invalid ID!! you have "+(7-i)+
                                " attempt left.\n");
                    }
                    else {
                        found_id=true;
                        break;
                    }
                }
                if(found_id){
                    boolean success=false;
                    //possible=false;
                    for(int i=1; i<8; i++)
                    {
                        System.out.print("Enter your password: ");
                        String pass=ss.nextLine();
                        if(user[id].check_password(pass))
                        {
                            System.out.println("Mr. "+user[id].get_name()+" you have "+user[id].check_balance()+
                                    " Taka in your account.");
                            success=true;
                            break;
                        }
                        else{
                            System.out.print("Wrong Password!! you have "+(7-i)+
                                    " attempt left.\n");
                        }
                    }
                    if(!success)
                    {
                        System.out.println("Balance Checking attempt failed!! Try again latter.");
                    }
                }
                else{
                    System.out.println("Could not find user Account. Try again latter.");
                }
            }
            else if(operation == 5)
            {
                System.out.println("Logging out....");
                break;
            }
            else{
                System.out.println("You entered a invalid operation number. Please select a valid input.");
            }
        }
    }


}