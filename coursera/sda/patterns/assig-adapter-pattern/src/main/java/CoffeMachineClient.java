public class CoffeMachineClient {

    public enum Flavor {A, B}

    private CoffeeMachineInterface coffeMachine;

    public CoffeMachineClient(CoffeeMachineInterface coffeMachine) {
        this.coffeMachine =  coffeMachine; 
    }

    public void makeCoffe(Flavor flavor) {
        if(Flavor.A ==  flavor) {
            coffeMachine.chooseFirstSelection();
        } else if(Flavor.B ==  flavor) {
            coffeMachine.chooseSecondSelection();
        } else {
            System.out.println("Flavor not found! :(");
        }
    }
}