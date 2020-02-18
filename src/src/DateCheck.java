public class DateCheck {
    String dag;
    String måned;
    String år;

    String dagRegex = "(0?[1-9]|[12][0-9]|3[01])";
    String månedRegex = "(0?[1-9]|1[012])";
    String årRegex = "((19|20)\\d\\d)";


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
