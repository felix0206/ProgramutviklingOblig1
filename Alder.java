package sample;

public  class Alder {

    int alder;

    public Alder(int alder){
        if (alder < 0 || alder > 120){
            throw new IllegalArgumentException("Alderen er ikke gyldig!");
        }
        else{
            this.alder = alder;
        }
    }
    public int getAlder() {
        return alder;
    }
}
