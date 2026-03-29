import java.util.Scanner;

class Game {
    protected String team1;
    protected String team2;

    Game(String t1, String t2) {
        team1 = t1;
        team2 = t2;
    }
}

class CricketGame extends Game {
    private int score1;
    private int score2;

    CricketGame(String t1, String t2, int s1, int s2) {
        super(t1, t2);
        score1 = s1;
        score2 = s2;
    }

    void displayMatch() {
        System.out.println("Match: " + team1 + " vs " + team2);
    }

    void displayResult() {
        if (score1 > score2) {
            System.out.println(team1 + " is the Winner");
        } else if (score2 > score1) {
            System.out.println(team2 + " is the Winner");
        } else {
            System.out.println("Match Tied");
        }
    }
}

public class Problem5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Team: ");
        String t1 = sc.nextLine();

        System.out.print("Enter Second Team: ");
        String t2 = sc.nextLine();

        System.out.print("Enter Runs of " + t1 + ": ");
        int s1 = sc.nextInt();

        System.out.print("Enter Runs of " + t2 + ": ");
        int s2 = sc.nextInt();

        CricketGame match = new CricketGame(t1, t2, s1, s2);

        System.out.println();
        match.displayMatch();
        match.displayResult();

        sc.close();
    }
}