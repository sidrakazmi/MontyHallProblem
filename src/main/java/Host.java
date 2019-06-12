import java.util.Scanner;

public class Host {
    public static void main(String[] args) {
        Host host = new Host();
        host.startGame();
    }

    private void startGame () {
        Contestant contestant = new Contestant();
        Game game = new Game();

        System.out.println("Welcome to the Game Show!\nHow many times would you like to play the game?");
        Scanner input = new Scanner(System.in);
        int numberOfRounds = input.nextInt();

        for (int i = 1; i <= numberOfRounds; i ++){
            System.out.println("Round no: "+i);
            play(contestant, game, numberOfRounds);
        }
    changeAverage(contestant,numberOfRounds);
        System.out.println("Thankyou for playing!");
    }

    private void play(Contestant contestant, Game game, int numberOfRounds) {
      Box selectedBox=  roundOne(game);
        // he then asks contestant if he wants to change his mind
        System.out.println("Now you have 2 options :\n1. Change the box (Press 1)\n2. Keep the same box (Press 2)\n");
        Scanner input = new Scanner(System.in);
        int newChoice = input.nextInt();

        switch (newChoice){
            case 1 : // Change
                contestant.changesMind();
                selectedBox = game.newBox(selectedBox);
                if (selectedBox.getHiddenObject().equals(Win.MONEY)) {
                    contestant.incrementWinCounter();
                    System.out.println("number of changes that led to win : "+contestant.getWinCounter());
                }
                break;
            case 2 : //Keep
               // Box selectedBox= game.openSelectedBox();
                System.out.println("case2 : "+selectedBox);
                break;
            default:
                System.out.println("Incorrect option");


        }

        /*if (contestant.changesMind()) {
            game.newBox();//newChoice);
            if (game.newBox().getHiddenObject().equals(Win.MONEY)) {
                contestant.incrementWinCounter();
                System.out.println("number of changes that led to win : "+contestant.getWinCounter());
            }
        }else game.openSelectedBox();*/
    }

    private float changeAverage(Contestant contestant, int numberOfRounds){
        float avgWin = contestant.getWinCounter()/numberOfRounds;
        System.out.println("Average wins by changing box = "+avgWin);
        return avgWin;
    }

    private Box roundOne ( Game game) {
        // at the start of game host asks the contestant to choose a door
        System.out.println("Please Choose a box: (Type '0', or '1',or  '2')\n");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        Box selectedBox = game.chooseBox(choice);

        // Then he opens an empty box
        System.out.println("Opening an empty box for you......");
        Box emptyBox = game.openEmptyBox();
        return selectedBox;
    }

}

