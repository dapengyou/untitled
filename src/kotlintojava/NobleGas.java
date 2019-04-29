package kotlintojava;

public class NobleGas extends Element {
    public NobleGas(String name) {
        super(name);
    }

    public void react(Particle particle, String name) {
        System.out.println(name + " 是稀有气体，不与粒子发生反应。");
    }

    public void react(Electron electron, String name) {
        System.out.println(name + " 是稀有气体，不与电子发生反应。");
    }

    public final void react(Electron particle) {
        this.react(particle, this.getName());
    }


}