package me.osama;

/**
 * Created by Osama Rao on 17-Feb-16.
 */
public interface INode {
    public void call();
    public int getF();
    public Node nextState(Action action);

}
