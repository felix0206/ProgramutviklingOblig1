public class DateCheck {

    String dato;
    String dateRegex = "[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}";



    public DateCheck(String dato) {

        if (dato.matches(dateRegex)){
            throw new IllegalArgumentException("Ugyldig fødselsdato er oppgitt!");
        }

        else{
            this.dato = dato;
        }
    }

    public String getDato() {
        return dato;
    }
}
