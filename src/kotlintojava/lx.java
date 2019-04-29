package kotlintojava;

public class lx {
    public static final void main(String[] args) {
        Element al = new Element("铝");
        al.react(new Particle());
        al.react((Particle)(new Electron()));


        NobleGas neon = new NobleGas("氩");
        neon.react(new Particle());
        neon.react(new Electron());
    }
}


