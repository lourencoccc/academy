
# Practice Peer-graded Assignment: Ungraded Assignment – Adapter Pattern

**Review criteria**

You are working in an office with an old coffee machine that dispenses two different coffee flavours. However, the new boss wants to add a new coffee machine with a touchscreen that can also connect to the old coffee machine. Complete the provided code to add an adapter so that the new touchscreen will to work with the old coffee machine. 
Use the following UML class diagram for a guide:


UML Class Diagram

Use this UML class diagram to help modify the code.

![diagram](./diagram.png)


**Solution**

CoffeeMachineInterface.java

```java
public interface CoffeeMachineInterface {

    void chooseFirstSelection();

    void chooseSecondSelection();
    
}
```

OldCoffeeMachine.java

```java
public class OldCoffeeMachine {

    public void selectA() {
        System.out.println("Old Coffe Machine: Select A")
    }

    public void selectB() {
        System.out.println("Old Coffe Machine: Select B")
    }

}
```

CoffeeTouchscreenAdapter.java

```java
public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {
    
    private OldCoffeeMachine oldCoffeeMachine;

    public CoffeeTouchscreenAdapter(OldCoffeeMachine oldCoffeeMachine){
        this.oldCoffeeMachine = oldCoffeeMachine;
    }

    void chooseFirstSelection() {
        oldCoffeeMachine.selectA();
    }

    void chooseSecondSelection() {
        oldCoffeeMachine.selectB();
    }

}
```
