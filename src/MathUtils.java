import java.util.concurrent.Callable;

interface IBird {
    Egg Lay();
}

class Chicken implements IBird{
    public Chicken() {
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof IBird);
    }

    @Override
    public Egg Lay() {
        return new Egg(Chicken::new);
    }
}

class Egg {

    private Callable<IBird> createBird;
    boolean isHatched = false;

    public Egg(Callable<IBird> createBird)
    {
        this.createBird = createBird;

    }

    public IBird Hatch() throws Exception {
        if(isHatched) throw new IllegalStateException("egg hatched");
        isHatched = true;
        return createBird.call();
    }
}