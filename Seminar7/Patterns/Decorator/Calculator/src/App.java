import Calculator.CalcDecorator;
import Calculator.Calculator;
import Calculator.Logger;
import Calculator.ViewCalculator;
import Calculator.iCalculable;

public class App {
    public static void main(String[] args) throws Exception {
        iCalculable calculator = new Calculator(0);

        iCalculable newCalcLog = new CalcDecorator(calculator, new Logger());
        
        ViewCalculator view = new ViewCalculator(newCalcLog);
        view.run();
    }
}
