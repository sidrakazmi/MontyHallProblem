public class Box {

        private final Win win;

       // Hiding a prize behide a door
       public Box(Win win){
            this.win = win;
        }

        public Win getHiddenObject() {
            return win;
        }

    @Override
    public String toString() {
        return
                " " + win ;
    }
}
