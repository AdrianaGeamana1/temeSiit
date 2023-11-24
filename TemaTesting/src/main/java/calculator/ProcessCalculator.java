package calculator;

import scanner.ConsoleScanner;
import splitter.SentenceSplitter;
import units.MetricUnits;

public class ProcessCalculator {
    private double metricDistanceValue;
    private String metricDistanceUnit;
    private final ConsoleScanner consoleScanner;
    private final Calculator calculator;
    private final SentenceSplitter sentenceSplitter;

    public ProcessCalculator() {
        this.consoleScanner = new ConsoleScanner();
        this.calculator = new Calculator();
        this.sentenceSplitter = new SentenceSplitter();
    }

    public ProcessCalculator(double metricDistanceValue, String metricDistanceUnit, ConsoleScanner consoleScanner, Calculator calculator, SentenceSplitter sentenceSplitter) {
        this.metricDistanceValue = metricDistanceValue;
        this.metricDistanceUnit = metricDistanceUnit;
        this.consoleScanner = consoleScanner;
        this.calculator = calculator;
        this.sentenceSplitter = sentenceSplitter;
    }

    public void setMetricDistanceValue(double metricDistanceValue) {
        this.metricDistanceValue = metricDistanceValue;
    }

    public void setMetricDistanceUnit(String metricDistanceUnit) {
        this.metricDistanceUnit = metricDistanceUnit;
    }

    public double getMetricDistanceValue() {
        return metricDistanceValue;
    }

    public String getMetricDistanceUnit() {
        return metricDistanceUnit;
    }

    public void getMetricDistance() {
        String sentence = consoleScanner.readLine();
        String[] mySymbols = sentenceSplitter.split(sentence);
        double resultValue = 0;
        String resultUnit = "";
        double n =Double.parseDouble(mySymbols[0]);
        String unitSymbol = mySymbols[1];
        int i = 2;
        while (i < mySymbols.length) {
            consoleScanner.verifyMetricUnits(unitSymbol);
            String computeSymbol=mySymbols[i];
            double m = Double.parseDouble(mySymbols[i+1]);
            String unitSymbol2 = mySymbols[i + 2];
            consoleScanner.verifyMetricUnits(unitSymbol2);
            MetricUnits object1 = consoleScanner.choseInstances(unitSymbol);
            MetricUnits object2 = consoleScanner.choseInstances(unitSymbol2);
            if (object1.getValue() < object2.getValue()) {
                double m2 = object2.transformValue(unitSymbol, m);
                resultValue = calculator.compute(computeSymbol, n, m2);
                resultUnit = unitSymbol;

            } else {
                double n2 = object1.transformValue(unitSymbol2, n);
                resultValue = calculator.compute(computeSymbol, n2, m);
                resultUnit = unitSymbol2;
            }
            n = resultValue;
            unitSymbol = resultUnit;
            i = i + 3;

        }
        metricDistanceValue =n;
        metricDistanceUnit = unitSymbol;
        System.out.println(sentence + " = " + metricDistanceValue + " " + metricDistanceUnit);
    }
}


