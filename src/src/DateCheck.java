public class DateCheck {
    String dag;
    String måned;
    String år;

    String dagRegex = "[0-3][0-9]";
    String månedRegex = "[0-1][0-9]";
    String årRegex = "[1-2][0||9][0-9][0-9]";


    public DateCheck(String dag, String måned , String år) {

        if (!dag.matches(dagRegex)){
            throw new IllegalArgumentException("Ugyldig fødselsdag oppgitt!");
        }

        else{
            this.dag = dag;
        }

        if (!måned.matches(månedRegex)){
            throw new IllegalArgumentException("Ugyldig måned oppgitt!");
        }else{
            this.måned = måned;
        }
        if (!år.matches(årRegex)){
            throw new IllegalArgumentException("Ugyldig år oppgitt!");
        }else{
            this.år = år;
        }
    }
    public String getDag() {
        return dag;
    }

    public String getMåned() {
        return måned;
    }

    public String getÅr() {
        return år;
    }
}
