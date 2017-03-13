/**
 * Created by Gleb88 on 12.03.2017.
 */
public class Nod implements INod {

    String result;
    INod leftPart;
    INod rightPart;
    INod bracketPart;
    String operation;


    public Nod() {
    }

    public Nod(String src) {

        src = processBrackets(src);

        if(src.contains(Operation.ADDITION)){
            String[] addParts = src.split(Operation.REGEXP_ADDITION,2);
            leftPart = new Nod(addParts[0]);
            rightPart = new Nod(addParts[1]);
            operation = Operation.ADDITION;
            return;
        }
        if(src.contains(Operation.SUBSTRACION)){
            String[] addParts = src.split(Operation.SUBSTRACION,2);
            leftPart = new Nod(addParts[0]);
            rightPart = new Nod(addParts[1]);
            operation = Operation.SUBSTRACION;
            return;
        }
        if(src.contains(Operation.MULTIPLICATION)){
            String[] addParts = src.split(Operation.REGEXP_MULTIPLICATION,2);
            leftPart = new Nod(addParts[0]);
            rightPart = new Nod(addParts[1]);
            operation = Operation.MULTIPLICATION;
            return;
        }
        if(src.contains(Operation.DIVISION)){
            String[] addParts = src.split(Operation.REGEXP_DIVISION,2);
            leftPart = new Nod(addParts[0]);
            rightPart = new Nod(addParts[1]);
            operation = Operation.DIVISION;
            return;
        }


        /////
        result = src;
    }

    private String processBrackets(String src) {

        while (src.contains("("))
        {
            char searchChar1 = '(';
            char searchChar2 = ')';
            int count = 0;
            int starti = src.indexOf("(");
            int endI = 0;

            for (int i = starti; i < src.length(); ++i)
            {
                if (src.charAt(i) == searchChar1) {
                    count++;
                }
                if (src.charAt(i) == searchChar2) {
                    count--;
                }
                if (count == 0) {
                    endI = i;
                    break;
                }
            }
            String substring = src.substring(starti+1, endI);
            bracketPart = new Nod(substring);
            double bracketPartResult = bracketPart.calculate();
            src = src.substring(0, starti).concat(String.valueOf(bracketPartResult)).concat(src.substring(endI+1,src.length()));
            /*substring = "("+substring.concat(")");
            src.replaceAll(substring, String.valueOf(bracketPartResult));*/
        }
        return src;
    }


    public INod getLeftPart() {
        return leftPart;
    }

    public void setLeftPart(INod leftPart) {
        this.leftPart = leftPart;
    }

    public INod getRightPart() {
        return rightPart;
    }

    public void setRightPart(INod rightPart) {
        rightPart = rightPart;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public double calculate() {

        if (result != null){
            return Double.parseDouble(result);
        }


        double leftN = leftPart.calculate();
        double rightN = rightPart.calculate();
        return simpleCalc(leftN, rightN, operation);

    }

    private double simpleCalc(double leftN, double rightN, String operation) {
        if(operation.equals(Operation.ADDITION)){
            return leftN + rightN;
        }
        if(operation.equals(Operation.SUBSTRACION)){
            return leftN - rightN;
        }
        if(operation.equals(Operation.MULTIPLICATION)){
            return leftN * rightN;
        }
        if(operation.equals(Operation.DIVISION)){
            return leftN / rightN;
        }
        return 0;
    }

}
