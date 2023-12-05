
package uups._otomataodev;


public class Graph {
    State[] states;
    
    public Graph(int len,int alphLength)
    {
        states=new State[len];
        for(int i=0;i<len;i++)
            states[i]=new State(alphLength,String.valueOf(i));
    }
    
}
