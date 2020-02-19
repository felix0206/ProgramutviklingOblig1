
public class Person {
    String navn;
    String epost;
    String numberRegex = "(.)*(\\d)(.)*";  //For å sjekke om navnet inneholder numre.
    String emailRegex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b";
    String mobilRegex = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
    int alder;
    int tlf;
    int dag;
    int måned;
    int år;

    public String Navn(String navn){

        if (navn == null || navn.length() > 40 || navn.matches(numberRegex)){
            throw new IllegalArgumentException("Ugyldig navn er oppgitt!");
        }

        else{
            this.navn = navn;
        }

        return navn;
    }

    public String Epost(String epost){

        if (epost.matches(emailRegex)){
            this.epost = epost;
        }
        else {
            throw new IllegalArgumentException("Feil emailadresse!");
        }
        return epost;
    }

    public int Alder(int alder) {

        if (alder < 0 || alder > 120){
            throw new IllegalArgumentException("Alderen er ikke gyldig!");
        }
        else{
            this.alder = alder;
        }
        return alder;
    }

    public String Tlf(String tlf){

        if (tlf.matches(mobilRegex)){
            this.tlf = Integer.parseInt(tlf);
        }else{
            throw new IllegalArgumentException("Ugyldig mobilnummer. Det må være et nummer som inneholder " +
                    "8 sifre. Ikke mer eller mindre.");
        }
        return tlf;
    }

    public String FødselsDato(int dag, int måned, int år){

        //Sjekker om dag er mellom 31 og 1.
        if (dag < 1 || dag > 31 ){
            throw new NumberFormatException("dag må være mellom 1 og 31");
        }
        else{
            this.dag = dag;
        }

        //sjekker om måned er mellom 1 og 12.
        if (måned < 1 || måned > 12 ){
            throw new NumberFormatException("måned må være mellom 1 og 12");
        }
        //sjekker om dag er over 30 når det er en måned med bare 30 dager.
        else if ((måned == 4 || måned == 6 || måned == 9 || måned == 11) && (dag < 1 || dag > 30)){
            throw new NumberFormatException("Dag stemmer ikke overens med måned!");
        }
        //sjekker om dag er over 29 og måned er februar.
        else if (måned == 2 && (dag < 1 || dag > 29)){
            throw new NumberFormatException("Dag stemmer ikke overens med måned!");
        }
        //hvis ingen av de øvrige testene slår ut settes dag til gitt dag.
        else{
            this.måned = måned;

        }

        // sjekker om årstallet er mellom 1900 og 2020
        if (år < 1900 || år > 2020 ){
            throw new NumberFormatException("årstall må være mellom 1900 og 2020");
        }
        else{
            this.år = år;
        }

        return dag + "/" + måned + "-" + år;
    }

}