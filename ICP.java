import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class ICP 
{
    static InputStreamReader read = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(read);

    //MASTER ARRAYS
    int IC_id[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,0,0,0,0,0};
    String IC_type[]={"scoop    ", "scoop    ", "scoop    ", "bar      ", "bar      ", "bar      ", 
            "sundae   ", "sundae   ", "sundae   ", "biscuit  ", "biscuit  ", "biscuit  ", 
            "falooda  ", "falooda  ", "falooda  ", "soda     ", "soda     ", "soda     ", 
            "milkshake", "milkshake", "milkshake", "", "", "", "", ""}; 
    String IC_name[]={"Vanilla             ", "Chocolate           ", "Strawberry          ",
            "Chocolate Bar       ", "Orange Candy        ", "Magnum              ",
            "Brownie Blast       ", "Cappuccino Explosion", "Chocolate Chip      ",
            "Vanilla             ", "Chocolate           ", "Black Current       ",
            "Zafrani Falooda     ", "Mixed Fruit Falooda ", "Falooda with Noodles",
            "Orange              ", "Lemon               ", "Jaljeera            ",
            "S'mores             ", "Chocolate Blend     ", "Corn-Cereal         ", "", "", "", "", ""};
    char IC_cancel[]={'n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n',' ',' ',' ',' ',' '};
    int IC_qty[]={50 ,50 ,25 ,30 ,20 ,10 ,10 ,10 ,10 ,15 ,15 ,15, 17 ,17 ,17 ,100 ,100 ,100, 5, 7, 7,0,0,0,0,0};
    int IC_Left_Qty[]={50 ,50 ,25 ,30 ,20 ,10 ,10 ,10 ,10 ,15 ,15 ,15, 17 ,17 ,17 ,100 ,100 ,100, 5, 7, 7,0,0,0,0,0};
    int IC_PermaQty[]={50 ,50 ,25 ,30 ,20 ,10 ,10 ,10 ,10 ,15 ,15 ,15, 17 ,17 ,17 ,100 ,100 ,100, 5, 7, 7,0,0,0,0,0};
    double IC_cost[]={39.99 ,39.99 ,39.99 ,14.99 ,9.99 ,79.99 ,119.99 ,124.99 ,114.99 ,19.99 ,19.99 ,19.99 ,59.99 ,69.99 ,64.99 ,9.99 ,9.99 ,9.99 ,99.99 ,119.99 ,199.99,0,0,0,0,0};

    //TRANSACTION ARRAYS
    int cust_id[]=new int[15];
    String cust_naav[]=new String[15]; //customer name
    String cust_type[]=new String[15]; //item type
    String cust_name[]=new String[15]; //item name
    int cust_nameID[]=new int[15]; //customer id
    int cust_qty[]=new int[15]; //quantity
    double cust_amt[]=new double[15]; //amount
    String dateANDtime[]=new String[15]; 
    char cust_cancel[] = new char[15];

    int choice,choice2,choice3,choice4,choice5;
    int conti,conti2,conti3,conti4,conti5,conti6,conti7,conti8;
    int out,out1,out2,out3;
    int z,y1,y2,i,f,custno,newitem;
    String cname;    
    double temp,total_earnings;
    int counter;
    //y1 -- counter variable to check if bill is paid. 0 = not paid. 1= paid.
    //y2 -- counter variable to check if one has ordered anything. 0= no order, 1=ordered something.

    ICP() //default constructor
    {
        choice=0;choice2=0;choice3=0;choice4=0;choice5=0;
        conti=0;conti2=0;conti3=0;conti4=0;conti5=0;conti6=0;conti7=0;conti8=0;
        out=0;out1=0;out2=0;out3=0;
        newitem=22;
        f=-1;
        custno=100;
        z=0;y1=0;y2=0;i=0;
        counter=0;
        cname="";      
    }

    static void main() throws IOException
    {
        ICP ob = new ICP();
        ob.begin();
    }

    void begin() throws IOException
    {
        do
        {
            System.out.println("\u000c");
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t      :-)  Welcome to Aventon's Ice-Cream Parlour. :-)");
            System.out.println("\t\t\t\t           Shop No. 7, Carter Road,");
            System.out.println("\t\t\t\t           Bandra West, Mumbai - 400007.");
            System.out.println("\t\t\t\t           Since 1980");
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            System.out.println("\t\t\t\t||         1.Browse the Menu.          ||");
            System.out.println("\t\t\t\t||         2.Place the Order.          ||");
            System.out.println("\t\t\t\t||         3.Cancel the Order.         ||");
            System.out.println("\t\t\t\t||         4.Report                    ||");
            System.out.println("\t\t\t\t||         5.Modify Menu               ||");
            System.out.println("\t\t\t\t||         6.Help.                     ||");
            System.out.println("\t\t\t\t||         7.New Customer.             ||");
            System.out.println("\t\t\t\t||         8.Exit.                     ||");
            System.out.println("\t\t\t\t||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            while(true)
            {
                try
                {
                    System.out.print("Enter your choice. --> ");
                    choice=Integer.parseInt(in.readLine());
                    break;
                }
                catch(Exception e1)
                {
                    System.out.print("Error in inputing \nIntegers only.");
                    dl();
                }
            }

            switch(choice)
            {
                case 1:
                inquiry();
                break;

                case 2:
                if(custno==100)
                {
                    y1=1;
                    newcust();
                    y1=0;
                }
                order();
                break;

                case 3:
                cancellation();
                break;

                case 4:
                report();
                break;

                case 5:
                modify();
                break;

                case 6:
                help();
                break;

                case 7 :
                newcust();
                break;

                case 8:
                if(y2==0 || (y2==1 && y1==1))
                {
                    conti=0;
                    out=1;
                    exit();
                }
                else
                {
                    System.out.println("Please pay off the bill first and then exit the software.");
                    System.out.println();
                }
                break;

                default:
                System.out.println("Wrong Choice.");
            }

            if(out==0)
            {
                while(true)
                {
                    try
                    {
                        System.out.println();
                        System.out.print("Press 1 to go back to main menu; Any other number to exit.  --> ");
                        conti=Integer.parseInt(in.readLine());
                        if(!(conti==1))
                        {
                            if(y2==0 || (y2==1 && y1==1))
                            {
                                exit();
                                break;
                            }
                            else
                            {
                                System.out.println("Please pay off the bill first and then exit the software.");
                                System.out.println();
                                continue;
                            }                            
                        }
                        break;
                    }
                    catch(Exception e2)
                    {
                        System.out.print("Error in inputing.");
                        dl();
                    }
                }            
            }      
        }while(conti==1);
    }

    void inquiry() throws IOException
    {
        do
        {   
            while(true)
            {
                try
                {
                    counter=0;
                    System.out.println("\u000c");
                    System.out.println("\n\n\t\t\t\t\t************");
                    System.out.println("\t\t\t\t\tINQUIRY MENU");
                    System.out.println("\t\t\t\t\t************\n\n");
                    System.out.println("\t\t\t\t||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
                    System.out.println("\t\t\t\t||     Browse for :             ||");
                    System.out.println("\t\t\t\t||     1.Scoops                 ||");
                    System.out.println("\t\t\t\t||     2.Candy Bars             ||");
                    System.out.println("\t\t\t\t||     3.Sundae                 ||");
                    System.out.println("\t\t\t\t||     4.Ice Cream Biscuits     ||");
                    System.out.println("\t\t\t\t||     5.Falooda                ||");
                    System.out.println("\t\t\t\t||     6.Soda                   ||");
                    System.out.println("\t\t\t\t||     7.Milkshake              ||");
                    System.out.println("\t\t\t\t||     8.New Arrivals.          ||");
                    System.out.println("\t\t\t\t||     9.Back to Main Menu      ||");
                    System.out.println("\t\t\t\t||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
                    System.out.println("Enter your choice. --> ");
                    choice5=Integer.parseInt(in.readLine());
                    break;
                }
                catch(Exception e20)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }

            switch(choice5)
            {
                case 1:
                System.out.println("\t\t\t****SCOOPS****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=0;i<3;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 2:
                System.out.println("\t\t\t****CANDY BARS****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=3;i<6;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 3:
                System.out.println("\t\t\t****SUNDAE****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=6;i<9;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 4:
                System.out.println("\t\t\t****ICECREAM BISCUITS****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=9;i<12;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 5:
                System.out.println("\t\t\t****FALOODA****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=12;i<15;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 6:
                System.out.println("\t\t\t****SODA****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=15;i<18;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 7:
                System.out.println("\t\t\t****MILKSHAKE****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=18;i<21;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 8:
                for(i=21;i<IC_id.length;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;                        
                    }
                }

                if(counter>0)
                {
                    counter=0;
                    System.out.println("\t\t\t****NEW ARRIVALS****\n");
                    System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                    for(i=21;i<IC_id.length;i++)
                    {
                        if(IC_cancel[i]=='n')
                        {
                            counter++;
                            System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                        }
                    }
                }
                else
                {
                    System.out.println("No New Arrivals as of now.");
                }
                break;

                case 9:
                conti8=0;
                out3=1;
                break;

                default:
                System.out.println("Wrong Choice Entered.");
                dl();
            }

            if(out3==0)
            {     
                while(true)
                {
                    try
                    {
                        System.out.println();
                        System.out.println("Do you wish to stay in the Inquiry Menu?");
                        System.out.print("Press 1 for yes, 0 for no  --> ");
                        conti8=Integer.parseInt(in.readLine());
                        break;
                    }
                    catch(Exception e21)
                    {
                        System.out.print("Error in inputing.");
                        dl();
                    }
                }
            }
        }while(conti8==1);

        System.out.println("***If you want to order anything, plz proceed to the order menu from the main menu.***");
    }

    void order() throws IOException
    {
        int srno;
        boolean flag1 = false;
        boolean flag2=false;
        int qty;

        do
        {
            System.out.println("\u000c");
            System.out.println("\n\n\t\t\t\t\t**********");
            System.out.println("\t\t\t\t\tORDER MENU");
            System.out.println("\t\t\t\t\t**********\n\n");
            System.out.println("Sr.No\tDelicacy Name\t\tType \t\tCost");
            for(i=0;i<IC_id.length;i++)
            {
                if(IC_cancel[i]=='n')
                {
                    System.out.println(IC_id[i]+"\t"+IC_name[i]+"\t"+IC_type[i]+"\t"+IC_cost[i]);
                }
            }
            while(true)
            {
                try
                {
                    System.out.print("Enter the Sr.No.  --> ");
                    srno=Integer.parseInt(in.readLine());
                    break;
                }
                catch(Exception e3)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }

            flag1 = false;
            for(i=0;i<IC_id.length;i++)
            {
                if(IC_cancel[i]=='n')
                {
                    if(IC_id[i] == srno)
                    {         
                        if(flag2==false)
                        {
                                          System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 7:
                System.out.println("\t\t\t****MILKSHAKE****\n");
                System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                for(i=18;i<21;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;
                        System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                    }
                }
                break;

                case 8:
                for(i=21;i<IC_id.length;i++)
                {
                    if(IC_cancel[i]=='n')
                    {
                        counter++;                        
                    }
                }

                if(counter>0)
                {
                    counter=0;
                    System.out.println("\t\t\t****NEW ARRIVALS****\n");
                    System.out.println("Sr.No\tDelicacy Name      \tQuantity\tCost");
                    for(i=21;i<IC_id.length;i++)
                    {
                        if(IC_cancel[i]=='n')
                        {
                            counter++;
                            System.out.println(counter+"\t"+IC_name[i]+"\t"+IC_qty[i]+"\t\t"+IC_cost[i]);
                        }
                    }
                }
                else
                {
                    System.out.println("No New Arrivals as of now.");
                }
                break;

                case 9:
                conti8=0;
                out3=1;
                break;

                default:
                System.out.println("Wrong Choice Entered.");
                dl();
            }

            if(out3==0)
            {     
                while(true)
                {
                    try
                    {
                        System.out.println();
                        System.out.println("Do you wish to stay in the Inquiry Menu?");
                        System.out.print("Press 1 for yes, 0 for no  --> ");
                        conti8=Integer.parseInt(in.readLine());
                        break;
                    }
                    catch(Exception e21)
                    {
                        System.out.print("Error in inputing.");
                        dl();
                    }
                }
            }
        }while(conti8==1);

        System.out.println("***If you want to order anything, plz proceed to the order menu from the main menu.***");
    }

    void order() throws IOException
    {
        int srno;
        boolean flag1 = false;
        boolean flag2=false;
        int qty;

        do
        {
            System.out.println("\u000c");
            System.out.println("\n\n\t\t\t\t\t**********");
            System.out.println("\t\t\t\t\tORDER MENU");
            System.out.println("\t\t\t\t\t**********\n\n");
            System.out.println("Sr.No\tDelicacy Name\t\tType \t\tCost");
            for(i=0;i<IC_id.length;i++)
            {
                if(IC_cancel[i]=='n')
                {
                    System.out.println(IC_id[i]+"\t"+IC_name[i]+"\t"+IC_type[i]+"\t"+IC_cost[i]);
                }
            }
            while(true)
            {
                try
                {
                    System.out.print("Enter the Sr.No.  --> ");
                    srno=Integer.parseInt(in.readLine());
                    break;
                }
                catch(Exception e3)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }

            flag1 = false;
            for(i=0;i<IC_id.length;i++)
            {
                if(IC_cancel[i]=='n')
                {
                    if(IC_id[i] == srno)
                    {         
                        if(flag2==false)
                        {
                        }

                while(true)
                {
                    try
                    {
                        System.out.println();
                        System.out.println("Enter the id  of the item you wish to cancel from your order.");
                        cancel=Integer.parseInt(in.readLine());
                        cancel=cancel-1;
                        break;
                    }
                    catch(Exception e12)
                    {
                        System.out.print("Error in inputing.");
                        dl();
                    }
                }

                if(cust_cancel[cancel]=='n')
                {
                    while(true)
                    {
                        try
                        {
                            System.out.println("How many quantities you wish to remove from "+cust_name[cancel]);
                            cancel_qty=Integer.parseInt(in.readLine());
                            break;
                        }
                        catch(Exception e13)
                        {
                            System.out.print("Error in inputing.");
                            dl();
                        }
                    }

                    if(cancel_qty<=cust_qty[cancel])
                    {
                        if(cancel_qty==cust_qty[cancel])
                        {
                            IC_qty[cancel]=IC_qty[cancel]+cancel_qty;
                            cust_qty[cancel]=0;
                            cust_amt[cancel]=0;
                            //dateANDtime[cancel]="";
                            cust_cancel[cancel] ='y';

                        }
                        else 
                        {
                            IC_qty[cancel]=IC_qty[cancel]+cancel_qty;
                            cust_qty[cancel]=cust_qty[cancel]-cancel_qty;
                        }
                    }
                    else
                    {
                        System.out.println("incorrect \"quantity to be removed\" entered.");
                    }
                }
                else
                {
                    System.out.println("ID entered doesn't exist.");
                }

            }
            else
            {
                System.out.println("No order placed yet.");
            }  

            while(true)
            {
                try
                {
                    System.out.println();
                    System.out.println("Do you wish to remain in the Cancelation Menu?");
                    System.out.println("Press 1 for yes, 0 for no.");
                    conti5=Integer.parseInt(in.readLine());  
                    break;
                }
                catch(Exception e14)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }

        }while(conti5==1);
    }

    void report() throws IOException
    {
        do
        {
            System.out.println("\u000c");
            System.out.println("\n\n\t\t\t\t\t  ***********");
            System.out.println("\t\t\t\t\t  REPORT MENU");
            System.out.println("\t\t\t\t\t  ***********\n\n");

            while(true)
            {
                try
                {
                    System.out.println("\t\t\t\t\t*****************");
                    System.out.println("\t\t\t\t\t1.Generate Bill.");
                    System.out.println("\t\t\t\t\t2.Update stock.");
                    System.out.println("\t\t\t\t\t3.Total Earnings.");
                    System.out.println("\t\t\t\t\t4.Back.");
                    System.out.println("\t\t\t\t\t*****************");
                    System.out.print("Enter your choice. --> ");
                    choice3=Integer.parseInt(in.readLine());
                    break;
                }
                catch(Exception e11)
                {
                    System.out.print("Error in inputing.");
                    dl(); 
                }
            }

            switch(choice3)
            {
                case 1:
                bill();
                break;

                case 2:
                update();
                break;

                case 3:
                TotalEarnings();
                break;

                case 4:
                conti6=0;
                out1=1;
                break;

                default:
                System.out.println("Wrong choice entered.");
            }

            if(out1==1)
            {
                break;
            }

            while(true)
            {
                try
                {

                    System.out.println();
                    System.out.println("Do you wish to remain in the Report Menu?");
                    System.out.println("Press 1 for yes, 0 for no.");
                    conti6=Integer.parseInt(in.readLine());  
                    break;
                }
                catch(Exception e15)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }
        }while(conti6==1);
    }

    void bill()throws IOException
    {
        y1=1;
        int cno; int j=0;
        double sum = 0;
        double sv_tax=0;
        double vat=0;
        double fsum=0;
        boolean flag3=true;
        System.out.println("\u000c");
        System.out.println();

        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date=new Date();
        String date_time=dateFormat.format(date);
        z++;
        int srno=0;
        while(true)
        {
            try
            {
                System.out.print("Enter the cno.  --> ");
                cno = Integer.parseInt(in.readLine());
                break;
            }
            catch(Exception e6)
            {
                System.out.print("Error in inputing.");
                dl();
            }
        }        

        for(i=0;i<15;i++)
        {
            if(cust_cancel[i]=='n')
            {
                if(cust_id[i] == cno)
                { 
                    System.out.println("\n\n\t\t\t\t\t***********");
                    System.out.println("\t\t\t\t\t   BILL    ");
                    System.out.println("\t\t\t\t\t***********\n\n");
                    System.out.println("\t\t\t\tAventon's Ice-Cream Parlour.");
                    System.out.println("\t\t\t\tShop No. 7, Carter Road,");
                    System.out.println("\t\t\t\tBandra West, Mumbai - 400007");
                    System.out.println("\t\t\t\tContact number - +919920431260");
                    System.out.println();
                    System.out.print("Customer Name - "+cust_naav[i]+", Customer ID - "+cust_id[i]);
                    System.out.println("\t\t\t\tTime and date of Bill. "+date_time);                   
                    System.out.println("__________________________________________________________________________________________________________");
                    System.out.println("Sr.No \t\t Type \t\t Item \t\t\t Cost \t\t  Quantity \t\tTotal");
                    break;
                }
            }
        }

        for(i=0;i<15;i++)
        {
            if(cust_cancel[i]=='n')
            {
                if(cust_id[i] == cno)
                {
                    srno++;
                    for(j=0;j<IC_name.length;j++)
                    {
                        if(IC_name[j].equalsIgnoreCase(cust_name[i]))
                        {
                            break;
                        }
                    }
                    temp=TwoDecimals(cust_amt[i]);
                    System.out.println(srno + "\t\t"+ cust_type[i] + "\t" + cust_name[i] + "\t" + IC_cost[j] + "\t\t\t" + cust_qty[i] + "\t\t" + temp);
                    sum = sum + temp;
                    flag3=false;

                }
            }
        }

        sv_tax=sum*0.03;
        vat=sum*0.07;
        fsum=sum+sv_tax+vat+20;
        
        if(flag3==false)
        {
            System.out.println("__________________________________________________________________________________________________________");
            temp=TwoDecimals(sum);
            System.out.println("                                                                         Total Amount: - Rupees "+temp);
            System.out.println("__________________________________________________________________________________________________________");
            System.out.println("                                                                        Service charge - Rupees 20");
            temp=TwoDecimals(sv_tax);
            System.out.println("                                                     Service tax - 3% on total amount. - Rupees "+temp);
            temp=TwoDecimals(vat);
            System.out.println("                                                             VAT - 7% on total amount. - Rupees "+temp); 
               
            temp=TwoDecimals(fsum);
            System.out.println("                                                                            ______________________________");
            System.out.println("                                                                            FINAL BILL = Rupees " + temp);
            System.out.println("                                                                            ______________________________");
        }
        else
        {
            System.out.println("Invalid CNO.");
        }
    }

    void update()
    {
        int qty2=0;
        boolean flag4=false;
        int srno2=0;

        do
        {
            System.out.println("\u000c");
            System.out.println("\n\n\t\t\t\t\t**********");
            System.out.println("\t\t\t\t\tUPDATE MENU");
            System.out.println("\t\t\t\t\t**********\n\n");
            System.out.println("Sr.No\tDelicacy Name\t\tQuantity");
            for(i=0;i<IC_id.length;i++)
            {
                if(IC_cancel[i]=='n')
                {
                    System.out.println(IC_id[i]+"\t"+IC_name[i]+"\t"+IC_qty[i]);
                }
            }
            System.out.println();
            while(true)
            {
                try
                {
                    System.out.print("Enter the Sr.No. of the item you wish to Update --> ");
                    srno2=Integer.parseInt(in.readLine());
                    break;
                }
                catch(Exception e7)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }

            flag4 = false;
            System.out.println();
            for(i=0;i<IC_id.length;i++)
            {
                if(IC_cancel[i]=='n')
                {
                    if(IC_id[i] == srno2)
                    {
                        while(true)
                        {
                            try
                            {
                                System.out.println("You have selected "+IC_name[i]);
                                System.out.println("What do you wish to do with the quantity of "+IC_name[i]);
                                System.out.println("Current Quantity = "+IC_qty[i]);
                                System.out.println("\t\t\t\t\t*****************************");
                                System.out.println("\t\t\t\t\t1.Replenish full stock");
                                System.out.println("\t\t\t\t\t2.Replenish stock as desired.");
                                System.out.println("\t\t\t\t\t3.Back.");
                                System.out.println("\t\t\t\t\t*****************************");
                                System.out.print("Enter your choice. -->");
                                choice2=Integer.parseInt(in.readLine());
                                break;
                            }
                            catch(Exception e8)
                            {
                                System.out.print("Error in inputing.");
                                dl();
                            }
                        }
                        System.out.println();

                        switch(choice2)
                        {
                            case 1:
                            if(IC_qty[i]!=IC_PermaQty[i])
                            {
                                IC_qty[i]=IC_PermaQty[i];
                                System.out.println(IC_name[i].trim()+" has been replenished to its full quantity "+IC_qty[i]);
                            }
                            else
                            {
                                System.out.println("Stock already full.");
                            }
                            flag4=true; 
                            break;

                            case 2:
                            if(IC_qty[i]!=IC_PermaQty[i])
                            {
                                while(true)
                                {
                                    try
                                    {
                                        System.out.print("Enter how many quantities you wish to add to "+IC_name[i].trim()+"  --> ");
                                        qty2 = Integer.parseInt(in.readLine());
                                        break;
                                    }
                                    catch(Exception e9)
                                    {
                                        System.out.print("Error in inputing.");
                                        dl();
                                    }
                                }
                                if(qty2>0 && qty2<=IC_PermaQty[i]-IC_qty[i])
                                {
                                    IC_qty[i]=IC_qty[i]+qty2;
                                    System.out.println(IC_name[i].trim()+" has been replenished to its desired stock "+IC_qty[i]);    

                                }
                                else
                                {
                                    System.out.println("Stock cant be replenished with "+qty2+" items.");
                                }        
                            }
                            else
                            {
                                System.out.println("Stock already full.");
                            }
                            flag4=true;
                            break;

                            case 3:
                            flag4=true; 
                            conti3=0;
                            break;

                            default:
                            System.out.println("Wrong choice entered.");
                            flag4=true;
                        }

                    }
                }
            }

            if(flag4 == false)
            {
                System.out.println("Invalid sr.no entered ");
            }

            if(conti3!=0)
            {
                while(true)
                {
                    try
                    {
                        System.out.print("Press 1 to remain in Update menu, Any other number to exit the Update menu --> ");
                        conti3=Integer.parseInt(in.readLine()); 
                        break;
                    }
                    catch(Exception e10)
                    {
                        System.out.print("Error in inputing.");
                        dl();
                    }
                }
            }
        }while(conti3==1);
    }

    void TotalEarnings()
    {
        System.out.println("\u000c");
        System.out.println("\n\n\t\t\t\t\t***********");
        System.out.println("\t\t\t\t\t"+"Total Earnings");
        System.out.println("\t\t\t\t\t***********\n\n");

        double gtot = 0;
        int z=0;

        for(i=0;i<15;i++)
        {            
            if(cust_amt[i] > 0)
            {
                gtot = gtot + cust_amt[i];
            }
        }

        if(gtot>0)
        {
            System.out.println("Sr.No. \t Date and Time \t\t Name \t\t  Amount");
            for(i=0;i<15;i++)
            {            
                if(cust_amt[i] > 0)
                {
                    z++;
                    System.out.println(z+"\t "+dateANDtime[i]+"\t "+cust_naav[i]+"\t\t  "+cust_amt[i]);
                    gtot = gtot + cust_amt[i];
                }
            }
            temp=TwoDecimals(gtot);
            System.out.println("Total earnings --------------------------------***"+temp);
        }

        System.out.println();
        System.out.println();
        System.out.println("Delicacy Name\t\t\t"+"Delicacies sold\t\t\t"+"Delicacies left");
        for(i=0;i<IC_qty.length;i++)
        {
            if(IC_cancel[i]=='n')
            {
                System.out.println(IC_name[i]+"\t\t\t"+(IC_PermaQty[i]-IC_Left_Qty[i])+"\t\t\t"+IC_qty[i]);;
            }
        }
    }

    void modify() throws IOException
    {
        do
        {
            System.out.println("\u000c");
            System.out.println("\n\n\t\t\t\t\t************");
            System.out.println("\t\t\t\t\tMODIFY MENU");
            System.out.println("\t\t\t\t\t************\n\n");

            while(true)
            {
                try
                {
                    System.out.println("\t\t\t\t******************************");
                    System.out.println("\t\t\t\t1. Add Items to the Menu.");
                    System.out.println("\t\t\t\t2. Remove Items From the Menu.");
                    System.out.println("\t\t\t\t3. Back.");
                    System.out.println("\t\t\t\t******************************");
                    choice4=Integer.parseInt(in.readLine());
                    break;
                }
                catch(Exception e11)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }

            switch(choice4)
            {
                case 1:
                add();
                break;

                case 2:
                remove();
                break;

                case 3:
                conti7=0;
                out2=1;
                Integer.parseInt(in.readLine());  
            }

            if(out2==1)
            {
                break;
            }

            while(true)
            {
                try
                {
                    System.out.println();
                    System.out.println("Do you wish to remain in the Modify Menu?");
                    System.out.println("Press 1 for yes, 0 for no.");
                    conti7=Integer.parseInt(in.readLine());  
                    break;
                }
                catch(Exception e16)
                {
                    System.out.print("Error in inputing.");
                    dl();
                }
            }
        }while(conti7==1);
    }

    void add() throws IOException
    {
        System.out.println("\u000c");
        System.out.println("\n\n\t\t\t\t\t*********");
        System.out.println("\t\t\t\t\tADD MENU");
        System.out.println("\t\t\t\t\t*********\n\n");

        System.out.println("New item's id is "+newitem);
        IC_id[newitem-1]=newitem;
        System.out.println("Enter the type of the item.");
        IC_type[newitem-1]=in.readLine();
        while(IC_type[newitem-1].length()!=9)
        {
            IC_type[newitem-1]=IC_type[newitem-1]+" ";            
        }
        System.out.println("Enter the name of the item.");
        IC_name[newitem-1]=in.readLine();
        while(IC_name[newitem-1].length()!=20)
        {
            IC_name[newitem-1]=IC_name[newitem-1]+" ";            
        }

        while(true)
        {
            try
            {

                System.out.println("Enter the quantity of the item.");
                IC_qty[newitem-1]=Integer.parseInt(in.readLine());
                break;
            }
            catch(Exception e17)
            {
                System.out.print("Error in inputing.");
                dl();
            }
        }
        IC_Left_Qty[newitem-1]=IC_qty[newitem-1];
        IC_PermaQty[newitem-1]=IC_qty[newitem-1];

        while(true)
        {
            try
            {
                System.out.println("Enter the cost of the item.");
                IC_cost[newitem-1]=Double.parseDouble(in.readLine());
                break;
            }
            catch(Exception e18)
            {
                System.out.print("Error in inputing.");
                dl();
            }
        }
        IC_cancel[newitem-1] ='n';
        newitem++;

    }

    void remove() throws IOException
    {
        System.out.println("\u000c");
        System.out.println("\n\n\t\t\t\t\t******************");
        System.out.println("\t\t\t\t\tCANCELATIONS MENU");
        System.out.println("\t\t\t\t\t******************\n\n");

        int ICid;
        System.out.println("Sr.No.\t Item Name \t\t Status");
        for(i=0;i<IC_id.length;i++)
        {
            if(IC_cancel[i] == 'n')
            {
                System.out.println(IC_id[i] + "\t " + IC_name[i] + "\t" + IC_cancel[i]);
            }
        }

        while(true)
        {
            try
            {
                System.out.println("Enter the id to be removed");
                ICid = Integer.parseInt(in.readLine());
                break;
            }
            catch(Exception e19)
            {
                System.out.print("Error in inputing.");
                dl();
            }
        }

        for(i=0;i<IC_id.length;i++)
        {
            if(IC_id[i] == ICid)
            {
                IC_cancel[i] = 'y';
            }
        }
    }

    void help()
    {
        System.out.println("\u000c");
        System.out.println("\n\n\t\t\t\t\t*********");
        System.out.println("\t\t\t\t\tHELP MENU");
        System.out.println("\t\t\t\t\t*********\n\n");

        System.out.println("About us - "+"\n"+" -Owned by Aventon and sons."+"\n"+" -Established in 1980."+"\n"+" -Won the Ice Cream Shop of the Year 10 times."+"\n"+" -Always Trending on Facebook, Twitter and Zomato."+"\n"+" -Contact us at - +91 99204 31260 or www.facebook.com/AventonParlour or www.twitter.com/AventonIcecream");
        System.out.println();
        System.out.println("*In the 1st option - 'Menu', you can view all our delicacies and its availibility."+"\n"+
            "*Choose what you like!"+"\n"+
            "*We have a vivid menu comprising Ice Cream Scoops, Ice Cream Bars, Sundaes, Ice Cream Biscuits, Faloodas, Sodas and Milkshakes!");
        System.out.println();
        System.out.println("*Once you have decided your choice, go to the 2nd option, Order."+"\n"+
            "*And direct yourselves to the desired dish. Make the choice by confirming the quantity."+"\n"+
            "*If you want to order another delicacy, then go back to the order menu and make your choice.");
        System.out.println();
        System.out.println("*If you are done with your order, generate your bill and thank us for the delicacies served. ;-) ");
        System.out.println();
        System.out.println("*If you want to generate a report of how many delicacies have been sold and how many are left,"+"\n"+" -direct yourself to the 4th option - Report.");
        System.out.println();
        System.out.println("*If there is a new customer, kindly make use of the 6th option, New customer.");
        System.out.println();
        System.out.println("*Select Exit Option when done.");
        System.out.println();
    }

    void exit()
    {
        System.out.println("\u000c");

        System.out.print("Loading");
        dl();
        System.out.println("\u000c");
        System.out.println("   $$$$$$$$$$$$$$$$$   $$$$$         $$$$$             $$$             $$$$$$$            $$$$$  $$$$$$     $$$$$$  ");
        System.out.println("   $$$$$$$$$$$$$$$$$   $$$$$         $$$$$            $$$$$            $$$$$$$$           $$$$$  $$$$$$    $$$$$$   ");
        System.out.println("   $$$$$$$$$$$$$$$$$   $$$$$         $$$$$           $$$$$$$           $$$$$$$$$$         $$$$$  $$$$$$   $$$$$$    ");
        System.out.println("         $$$$$         $$$$$         $$$$$          $$$$ $$$$          $$$$$  $$$$$       $$$$$  $$$$$$  $$$$$$     ");
        System.out.println("         $$$$$         $$$$$$$$$$$$$$$$$$$         $$$$$  $$$$         $$$$$   $$$$$      $$$$$  $$$$$$$$$$$$       ");
        System.out.println("         $$$$$         $$$$$$$$$$$$$$$$$$$        $$$$$    $$$$        $$$$$    $$$$$     $$$$$  $$$$$$$$$$$$       ");
        System.out.println("         $$$$$         $$$$$$$$$$$$$$$$$$$       $$$$$$$$$$$$$$$       $$$$$     $$$$$    $$$$$  $$$$$$ $$$$$$      ");
        System.out.println("         $$$$$         $$$$$         $$$$$      $$$$$$$$$$$$$$$$$      $$$$$      $$$$$   $$$$$  $$$$$$  $$$$$$     ");
        System.out.println("         $$$$$         $$$$$         $$$$$     $$$$$$       $$$$$$     $$$$$       $$$$$  $$$$$  $$$$$$   $$$$$$    ");
        System.out.println("         $$$$$         $$$$$         $$$$$    $$$$$$         $$$$$$    $$$$$        $$$$$$$$$$$  $$$$$$    $$$$$$   ");
        System.out.println("         $$$$$         $$$$$         $$$$$   $$$$$$           $$$$$$   $$$$$          $$$$$$$$$  $$$$$$     $$$$$$  ");
        System.out.println("         $$$$$         $$$$$         $$$$$  $$$$$$             $$$$$$  $$$$$           $$$$$$$$  $$$$$$      $$$$$$ ");

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("   $$$$$$             $$$$$$   $$$$$$$$$$$$$$$$    $$$$$$      $$$$$$   $$$$$$   ");     
        System.out.println("    $$$$$$           $$$$$$   $$$$$$$$$$$$$$$$$$   $$$$$$      $$$$$$   $$$$$$   "); 
        System.out.println("     $$$$$$         $$$$$$    $$$$$$      $$$$$$   $$$$$$      $$$$$$   $$$$$$   ");   
        System.out.println("      $$$$$$       $$$$$$     $$$$$$      $$$$$$   $$$$$$      $$$$$$   $$$$$$   ");       
        System.out.println("       $$$$$$     $$$$$$      $$$$$$      $$$$$$   $$$$$$      $$$$$$   $$$$$$   ");     
        System.out.println("         $$$$$$$$$$$$$        $$$$$$      $$$$$$   $$$$$$      $$$$$$   $$$$$$   ");
        System.out.println("            $$$$$$$           $$$$$$      $$$$$$   $$$$$$      $$$$$$   $$$$$$   ");
        System.out.println("            $$$$$$$           $$$$$$      $$$$$$   $$$$$$      $$$$$$   $$$$$$   "); 
        System.out.println("            $$$$$$$           $$$$$$      $$$$$$   $$$$$$      $$$$$$            ");
        System.out.println("            $$$$$$$           $$$$$$      $$$$$$   $$$$$$      $$$$$$    $$$     ");    
        System.out.println("            $$$$$$$           $$$$$$$$$$$$$$$$$$   $$$$$$$$$$$$$$$$$$   $$$$$    ");          
        System.out.println("            $$$$$$$            $$$$$$$$$$$$$$$$    $$$$$$$$$$$$$$$$$$    $$$     ");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Visit Again!");
        System.out.println("-Aventon Parlour.");

    }

    void newcust()throws IOException
    {
        if(y1==1 || custno==100)
        {
            custno++;
            f++;
            System.out.println("Your cust no = " + custno+" Remember it.");
            System.out.print("Enter new customer's name.  --> ");
            cname=in.readLine();
        }
        else
        {
            System.out.println("Please pay off the bill first and then add new customer.");

        }
    }

    double TwoDecimals(double a)
    {
        double number = a;
        number = Math.round(number * 100);
        number = number/100;
        return number;
    }

    void DelayLoop()
    {
        for(long i=0;i<99999999;i++)
        {
        }
    }

    void dl()
    {
        DelayLoop();
        System.out.print(".");
        DelayLoop();
        System.out.print(".");
        DelayLoop();
        System.out.print(".");
        DelayLoop();
        System.out.print(".");
        DelayLoop();
        System.out.println(".");
    }  

}

