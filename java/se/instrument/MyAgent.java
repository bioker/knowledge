import java.lang.instrument.Instrumentation;

class MyAgent {
    public static void premain(String args, Instrumentation inst) {
        System.out.println("Hello Agent!");
    }
}
