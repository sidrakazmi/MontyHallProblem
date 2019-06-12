import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {

    private List<Box> boxList = null;
    private Box selectedBox;
    private Box newBox;
    private Box openedBox;
    private final int numberOfBoxes =3;
    private  Random rndGenerator;
    private int winCounter;

    public Game() {
        populateBoxes();
    }

    public void  populateBoxes(){
        rndGenerator = new Random();
        final int randomNumber = rndGenerator.nextInt(numberOfBoxes);
        System.out.println("random no : "+randomNumber);
        boxList = new ArrayList<Box>() ;
        for (int i = 0; i < numberOfBoxes; i ++) {
            boxList.add(new Box(Win.EMPTY));
        }
        boxList.set(randomNumber, new Box(Win.MONEY));
        // TODO : it can give index out of bound exception here
        System.out.println(boxList);
    }

    // asking the user to input a box of his choice
    public Box chooseBox(int choice){
        try {
            if (choice==0 ||  choice==1 || choice==2){
                // the box of players choice sets to be selected box for this round
                selectedBox = boxList.get(choice);
                // System.out.println("selected box : "+ selectedBox.getHiddenObject());
            } else {
                System.out.println("You have entered a wrong choice Please try again");
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
         return selectedBox;
    }

    public Box openEmptyBox(){
        //iterating over the populated boxes list and checking if the door to open is not the selected one and is empty
        // for my solution i would like to open the empty door first
        for (Box box : boxList ) {
            if ((box != selectedBox) && (box.getHiddenObject() == Win.EMPTY)){
                openedBox = box;
            }
        } System.out.println("One "+openedBox.getHiddenObject()+" box opened!!");
        return openedBox;
    }

   /*public Box openSelectedBox(){
        //iterating over the populated boxes list and checking if the door to open is not the selected one and is empty
        // for my solution i would like to open the empty door first
        for (Box box : boxList ) {
            //fix if
            if (box != openedBox && box==selectedBox){
                selectedBox = box;
            }

        } System.out.println("Final Result "+selectedBox.getHiddenObject());
        return selectedBox;
    }*/

    public Box newBox(Box alreadySelectedBox){
                for (Box box : boxList ) {
                    if ((box != openedBox) && (box != alreadySelectedBox)){
                     newBox = box;
                }}
                System.out.println("new Box= "+ newBox.getHiddenObject());
        return newBox;
    }

}
