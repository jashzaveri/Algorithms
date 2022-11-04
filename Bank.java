import java.io.*;
import java.lang.*;
import java.util.*;

class Account
{
    int acc;
    int bal;
    String name;
    String add;
    String stat;
    Account(int acc, int bal, String name , String add)
    {
        this.acc = acc ;
        this.bal = bal;
        this.name = name;
        this.add = add;
        stat = "";
    }
}
class Bank
{
    static HashMap<Integer,Account> map = new HashMap<Integer,Account>();
    static int lastNum = 1;
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println(" 1 for Account Opening  - \n 2 for Deposit    - \n 3 for Withdraw  - \n 4   for Money  Transfer  - \n 5 Balance - \n 6 Statement - \n 7 Exit - "  );
            int get = Integer.parseInt(br.readLine());
            if(get == 1)
            {
                System.out.println("Pl provide your name address and initial balance");
                String[] getVal= br.readLine().split(" ");
                int acc_no = createAcc(getVal[0],getVal[1],Integer.parseInt(getVal[2]));
                System.out.println("Your Account No is " + Integer.toString(acc_no));
            }
            else if(get == 2)
            {
                // this is for Deposit
                System.out.println("Pl provide your Account no and amount you want to deposit");
                String[] gets = br.readLine().split(" ");
                boolean check = deposit(Integer.parseInt(gets[0]),Integer.parseInt(gets[1]));
                if(check)
                {
                    System.out.println("Amount Deposited Successfully");
                    
                }
            }
            else if(get == 3)
            {
                System.out.println("Pl provide your Account no and amount you want to withdraw");
                String[] getV = br.readLine().split(" ");
                boolean check = withdraw(Integer.parseInt(getV[0]),Integer.parseInt(getV[1]));
                if(check)
                {
                    System.out.println("Amount withdrawn successfully");
                }
            }
            else if(get == 4)
            {
                System.out.println("Pl provide the Account no of the Transferer , the Benificary and the amount");
                String[] gets = br.readLine().split(" ");
                boolean check = transfer(Integer.parseInt(gets[0]),Integer.parseInt(gets[1]),Integer.parseInt(gets[2]));
                if(check)
                {
                    System.out.println("Amount transfered Succesfully");
                }
            }
            else if(get == 5)
            {
                System.out.println("Pl provide your Account no");
                int acc_no = Integer.parseInt(br.readLine());
                int balance = getBalance(acc_no);
                if(balance != -1)
                {
                    System.out.println("The balance for account no " + Integer.toString(acc_no) + " is " + Integer.toString(balance));
                }
            }
            else if(get == 6)
            {
                System.out.println("pl provide the acc no");
                int acc_no = Integer.parseInt(br.readLine());
                if(!map.containsKey(acc_no))
                {
                    System.out.println("Account no " + Integer.toString(acc_no) + " does not exist");
                }
                else
                {
                    System.out.println(map.get(acc_no).stat);
                }
            }
            else
            {
                break;
            }
        }
    }
    
    public static int createAcc(String name , String add , int bal)
    {
        Account cre = new Account(lastNum,bal , name , add);
        cre.stat = "Account Created with balance " +  Integer.toString(bal) + "\n";
        map.put(lastNum,cre);
        lastNum++;
        return lastNum -1;
    }
    
    public static boolean withdraw(int acc , int amount)
    {
        if(!map.containsKey(acc))
        {
            System.out.println("Account no " + Integer.toString(acc) + " does not exist");
            return false;
        }
        Account che = map.get(acc);
        if(che.bal >= amount)
        {
            che.bal -= amount;
            che.stat += " Amount withdrawn - " + Integer.toString(amount) + " \n";
            map.put(acc,che);
            return true;
        }
        else
        {
            System.out.println("Insufficient Balance in Account " + Integer.toString(acc));
            return false;
        }
    }
    
    public static boolean deposit(int acc , int amount)
    {
        if(!map.containsKey(acc))
        {
            System.out.println("Account no " + Integer.toString(acc) + " does not exist");
            return false;
        }
        else
        {
            Account che = map.get(acc);
            che.bal += amount;
            che.stat += " Amount deposited - " + Integer.toString(amount) + " \n";
            return true;
        }
    }
    
    public static boolean transfer(int accFrom , int accTo , int amount)
    {
        if(!map.containsKey(accFrom))
        {
            System.out.println("Your Account no is invalid");
            return false;
        }
        else if(!map.containsKey(accTo))
        {
            System.out.println("Account no " + Integer.toString(accTo) + " does not exist");
            return false;
        }
        boolean check = withdraw(accFrom,amount);
        if(check)
        {
            boolean checks = deposit(accTo,amount);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static int getBalance(int acc)
        {
            if(!map.containsKey(acc))
            {
                System.out.println("Account no " + Integer.toString(acc) + " does not exist");
                return -1;
            }
            else
                return map.get(acc).bal;
        }
}
