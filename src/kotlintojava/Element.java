package kotlintojava;

public class Element {
    private final String name;

    public Element(String name) {
        super();
        this.name = name;
    }

    public void react( Particle $receiver, String name) {
        System.out.println(name + " 与粒子发生反应。");
    }

    public void react(Electron $receiver,String name) {
        System.out.println(name + " 与电子发生反应生成同位素。");
    }

    public final void react( Particle particle) {
        this.react(particle, this.name);
    }

    public final String getName() {
        return this.name;
    }


}
