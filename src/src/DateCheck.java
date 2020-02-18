public class DateCheck {

    String dato;
    String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";



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
