import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class InterviewProcess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> noOfCandidates = new LinkedList<>();
        Queue<Integer> waitingList = new LinkedList<>();

        System.out.print("\nenter total number of candidates: ");
        int candidateCount = sc.nextInt();
        for(int i = 1 ; i <= candidateCount ; i++){
            noOfCandidates.add(i);
        }
        System.out.print("\nenter the number of candidates allowed in waiting list: ");
        int maxWaitingCapacity = sc.nextInt();
        System.out.print("\nlist of candidates: "+noOfCandidates);

        do{
            do{
                if(noOfCandidates.isEmpty())break;
                waitingList.add(noOfCandidates.poll());
            }while((waitingList.size() < maxWaitingCapacity));

            System.out.print("\nno of candidates in reception: " + noOfCandidates);
            System.out.print("\nno of student in waiting list: " + waitingList);
            System.out.print("\n"+waitingList.poll() + " -->out of interview room");
            System.out.println();
            System.out.println();
        }while (!waitingList.isEmpty());
        System.out.println("Interview process has ended");

    }
}