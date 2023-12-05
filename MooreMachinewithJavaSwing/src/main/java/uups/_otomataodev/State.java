package uups._otomataodev;

public class State {
    int output;
    String state;
    Transition[] transitions;
    
    public State(int alf,String s)
    {
        transitions=new Transition[alf];
        state=s;
    }
}
