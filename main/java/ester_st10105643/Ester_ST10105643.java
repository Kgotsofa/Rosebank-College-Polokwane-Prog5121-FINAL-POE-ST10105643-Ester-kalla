package ester_st10105643;

import kanban.board.login.Login;
import kanban.board.user.data.DeveloperDetails;
import kanban.board.user.data.Task;

import javax.swing.*;
import java.util.Scanner;

public class Ester_ST10105643 {

    public static Scanner sn = new Scanner(System.in);
    public static Login login = new Login();
    public static Task task = new Task();
    public static final String errorMessage = "Username or password incorrect, please try again";
    public static final String signupErrorMessage = "Password successfully captured";

    public static void main(String[] args) {
        programLoop();
    }

    public static boolean tryToLogin() {
        boolean tryLogin = true;
        boolean loginStatus = false;

        while (tryLogin) {

            if (!loginStatus) {
                String username = getInput("Insert username:\n");
                String password = getInput("Insert password:\n");
                String message = login.returnLoginStatus(username, password);
                if (!message.equals(errorMessage)) {
                    loginStatus = true;
                    System.out.println("Welcome to EasyKanban");
                } else {
                    System.out.println(message);
                }

            } else {
                tryLogin = loggedInUser();
            }
        }
        return tryLogin;
    }

    public static boolean loggedInUser() {

        try {
            int selected = Integer.parseInt(getInput("1. Add task \n2. Show report \n3. Quit"));
            switch (selected) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    return false;
                default:
                    System.out.print("Input should be between 1 - 3");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please input only numbers");
        }
        return true;
    }

    public static void addTask() {
        int numberOfTasks = Integer.parseInt(getInput("Input number of Tasks:"));

        int i = 0;
        while (i < numberOfTasks) {
            String taskName = getInput("Input task Name:");
            String taskDescription = getInput("Input Task Description:");
            String firstName = getInput("Input developer First Name:");
            String lastName = getInput("Input developer Last Name:");
            DeveloperDetails developerDetails = new DeveloperDetails(firstName, lastName);
            int duration = Integer.parseInt(getInput("Input Task Duration:"));
            String response = task.createTask(taskName, i, taskDescription, developerDetails, duration, "To Do");
            if (response.equals("Task successfully captured")) {
                System.out.println(response);

                JFrame frame = new JFrame();
                String taskId = task.createTaskID(taskName, i++, firstName);
                JOptionPane.showMessageDialog(frame, task.printTaskDetails(taskId));
            } else {
                System.out.println(response);
            }
        }
        System.out.println("Total duration: " + task.returnTotalHours() + "hrs");
    }

    public static void showReport() {
        System.out.println("Coming Soon");
    }

    public static void tryToSignup() {
        boolean trySignup = true;
        while (trySignup) {
            String username = getInput("input Username: ");
            String password = getInput("input Password: ");
            String name = getInput("input Name: ");
            String surname = getInput("input Surname: ");
            String message = login.registerUser(username, password, name, surname);
            if (message.equals(signupErrorMessage)) {
                trySignup = false;
            }
            System.out.println(message);
        }
    }

    public static void programLoop() {
        boolean loop = true;
        while (loop) {
            try {
                int selected = Integer.parseInt(getInput("1. Login \n2. Signup \n3. exit"));
                switch (selected) {
                    case 1:
                        loop = tryToLogin();
                        break;
                    case 2:
                        tryToSignup();
                        break;
                    case 3:
                        loop = false;
                        break;
                    default:
                        System.out.print("Input should be between 1 - 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input only numbers");
            }
        }
    }

    public static String getInput(String input) {
        System.out.println(input);
        return String.valueOf(sn.nextLine());
    }
    Scanner scan = new Scanner(System.in);
         int NoOfTask;
        System.out.print("How many Task do want to store : ");
         NoOfTask = scan.nextInt();
        
         System.out.print("\n\nThank you, You may now start capturing the tasks,\n should you wish to Quit just press 3..");
         
            Task[] aa;
            aa = new Task[NoOfTask]; 
            String[] taskName = new String[NoOfTask];
            
            int [] taskDuration = new int [NoOfTask];
            
            for(int a = 0; a < NoOfTask; a++)
            {
                System.out.print("\n\n1). Add tasks");
                System.out.print("\n2). Show report");
                System.out.print("\n3). Quit\n\nPick and option : ");
                int option = scan.nextInt();
                if(option == 1)
                {
         
         
         aa= new Task[NoOfTask];
        
        {
            
            
            aa[a] = new Task();
            System.out.print("Enter name of " + (a+1) + " Developer : " );
            aa[a].Developer = scan.next();
            
            
            
            System.out.print("Enter Task " + (a+1) + "Name  : " );
            aa[a].TaskName = scan.next();
            TaskName[a] = aa[a].TaskName;
            
            
            
            System.out.print("Enter Task " + (a+1) + " ID : " );
            aa[a].TaskID= scan.nextLong();
            
            
            
            System.out.print("Enter Task " + (a+1) + "Duration : " );
            aa[a].taskDuration = scan.nextInt();
            taskDuration[a] = aa[a].TaskDuration;
            
            
            System.out.print("Enter this task status, Choose one from the below \n");
            System.out.print("\n1. To Do");
            System.out.print("\n2. Done");
            System.out.print("\n3. Doing");
            System.out.print("\nenter number before the option of your choice : ");
            
            
            
            int choice = scan.nextInt();
            while(choice < 1 || choice > 3)
            {
              System.out.print("\nRange is between 1 and 3, please try again : ");
              choice = scan.nextInt();                    
            }
            if(choice == 1)
                        Task.TaskStatus = "To Do";
                    if(choice == 2)
                        Task.TaskStatus = "Done";
                    if(choice == 3)
                        Task.TaskStatus = "Doing";
                    
                      Task.createTaskID();
                    
                   }
                    if(option == 2)
                   {
                    Task.printTaskDeveloper(NoOfTask);
                    
                }
                if(option == 3)
                {
                    a = NoOfTask;
                } 
                
                
                
                String deletetaskName;
                boolean taskNameFound = false;
                  if(!taskNameFound)
                System.out.print("\n\nNow enter the TaskName you want to delete");
                deletetaskName= scan.next();
                
                
            while(!TaskNameFound)
        {
            
            {
                if(deletetaskName == TaskName[a])
                {
                    aa[a].Developer = null;
                    aa[a].taskName = null;
                    aa[a].taskDuration = -1;
                    aa[a].taskStatus = null;
                    TaskNameFound = true;              
                }
            }
            if(!TaskNameFound)
            {
                System.out.print("The taskName you entered doesn't exist, Please try again : ");
                deletetaskName = scan.next();
            }
            
            int[]Duration =null;
            int max =Duration[0]
            int position=0;
             
             if (max < Duration[a])
             {
            max=Duration[a])
            postion=a;
            
            }
        System.out.print("\n\n\nHere are the details of all the people you captured\n");
       
        {
            System.out.print("\n\nTask "  + (a+1) + "'s Details : \n");
            System.out.println("Developer : " + aa[a].Developer);
            System.out.println("taskName : " + aa[a].TaskName);
            System.out.println("taskDuration : " + aa[a].TaskDuration);
            System.out.println("taskStatus : " + aa[a].TaskStatus);             
        } 
            
            }
          
           
        }
            
}
    
}
   


 
  
     
    
    
    
    
    
    
}
class Task
{   
     static void printTaskDeveloper(int NoOfTask)  
     {
         System.out.print("\n\nTasks saved so far....\n");
       
        for(int a = 0; a < NoOfTask; a++)
        {
                System.out.print("\n\nTask "  + (a+1) + "'s Details : \n");
                /*System.out.println("Developer : " + Developer);*/
                /*System.out.println("TaskName : " + TaskName);*/
                /*System.out.println("TaskDuration : " + TaskDuration);*/
                System.out.println("TaskStatus : " + TaskStatus);        
        
        }    
     }
    static void createTaskID() 
    {
        
      System.out.print("\n\tTaskID\tTaskName\tTaskDuration\tTaskStatus\tDeveloper\n");  
   
    }

    
   String TaskName;
   String Developer;
   Long TaskID;
   int TaskDuration;
   static String TaskStatus;
   public Task() 
   {
       TaskName = new String();
       String TaskStatus = new String();
       Developer = new String();
   }