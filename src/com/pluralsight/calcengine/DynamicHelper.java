package com.pluralsight.calcengine;

import java.util.DoubleSummaryStatistics;

public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers) {
        this.handlers = handlers;
    }

    public String process(String statement) {
    // IN: add 1.0 2.0
        //OUT: 1.0 + 2.0 = 3.0
        String[] pars = statement.split(MathProcessing.SEPARATOR);
        String keyword = pars[0]; //add

        MathProcessing theHandler = null;

        for(MathProcessing handler:handlers) {
            if (keyword.equalsIgnoreCase(handler.getKeyword())) {
                theHandler = handler;
                break;
            }
        }

        double leftVal = Double.parseDouble(pars[1]);
        double rightVal = Double.parseDouble(pars[2]);

        double result = theHandler.doCalculation(leftVal, rightVal);

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }

}
