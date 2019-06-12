public class Contestant {
    private  boolean changesMind;
int winCounter;

    public Contestant (){
        this.changesMind = false;
    }

    public boolean changesMind(){
        return changesMind = true;
    }

   public void incrementWinCounter() {
        winCounter = winCounter + 1;
       System.out.println(winCounter);
    }
    int getWinCounter(){
        return winCounter;
    }
}
