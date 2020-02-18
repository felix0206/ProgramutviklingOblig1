public class NameCheck {

    String name;
    String numberRegex = "(.)*(\\d)(.)*";



    public NameCheck(String name) {

        if (name == "" || name.length() > 40 || name.matches(numberRegex)){
            throw new IllegalArgumentException("Ugyldig navn er oppgitt!");
        }

        else{
            this.name = name;
        }


    }
    public String getName() {
        return name;
    }
}
