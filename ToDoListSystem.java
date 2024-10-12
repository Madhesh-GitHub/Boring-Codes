import java.util.ArrayList;
import java.util.Scanner;


public class ToDoListSystem {
    Scanner in = new Scanner(System.in);
    ArrayList<String> Tasks = new ArrayList<>();
    ArrayList<String> CompletedTasks = new ArrayList<>();
    void AddATask(){
        System.out.println("Enter the Task: ");
        Tasks.add(in.nextLine());
        System.out.println("Task Added!");
    }
    void ViewAllTasks(){
        int index = 1;
        for(String i: Tasks){
            System.out.println(index+". "+i);
            index+=1;
        }
    }
    void MarkTheTask(){
        System.out.println("Enter the task number that you have completed: ");
        int num = in.nextInt();
        CompletedTasks.add(Tasks.get(num-1));
        Tasks.set(num-1, Tasks.get(num-1)+"❌");
        System.out.println("Task at " +num+  " has been marked as completed!");

    }
    void ViewCompletedTasks(){
        int index = 1;
        for(String i: CompletedTasks){
            System.out.println(index+". "+i);
            index+=1;
        }
    }
    void RemoveCompletedTasks(){
        for (int i = Tasks.size() - 1; i >= 0; i--) {
            if (Tasks.get(i).charAt(Tasks.get(i).length() - 1) == '❌') {
                Tasks.remove(i);
            }
        }
        System.out.println("Completed tasks have been removed!");
    }

}

class MainOfToDoList{
    public static void main(String[] args) {
        System.out.println("=====================================================================================");
        System.out.println("\n                         Welcome to Madhesh ToDoListApp\n");
        System.out.println("=====================================================================================");
        Scanner in = new Scanner(System.in);
        boolean run = true;
        int choice;
        char ch;
        ToDoListSystem T = new ToDoListSystem();
        while (run) {
            System.out.println("Enter your choice:\n1. Add a Task\n2. View all the tasks\n" +
                    "3. Mark the completed task\n4. View the completed tasks\n5. Remove the completed task\n6. Exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    T.AddATask();
                    break;
                case 2:
                    System.out.println("Your Assigned Tasks:");
                    T.ViewAllTasks();
                    break;
                case 3:
                    T.MarkTheTask();
                    break;
                case 4:
                    System.out.println("Completed Tasks:");
                    T.ViewCompletedTasks();
                    break;
                case 5:
                    T.RemoveCompletedTasks();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!!");
            }
            System.out.println("Do You Want To Continue (y/n)? ");
            ch = in.next().charAt(0);
            if (ch == 'y') {
                run = true;
            } else if (ch == 'n') {
                run = false;
            } else {
                System.out.println("Sorry! Service Unavailable!");
                run = false;
            }

        }
    }
}

