import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salarios = new double[5];

        //Captar inputs
        for (int i = 0; i < salarios.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º salário: ");
            salarios[i] = sc.nextDouble();
        }

        //Calculo dos salarios
        for (int i = 0; i < salarios.length; i++) {
            System.out.println(" ");
            System.out.println("\nSalário " + (i + 1) + ":");
            calculoSalario(salarios[i]);
        }
    }

    public static void calculoSalario (double salarioBruto) {
        double descontoINSS = 0d;
        double descontoIR = 0d;

        System.out.printf("\nO salário bruto é de R$%.2f", salarioBruto);

        //Calculo INSS
        if (salarioBruto > 0 && salarioBruto <= 1212) {
            descontoINSS = salarioBruto * 0.075;
        } else if (salarioBruto > 1212 && salarioBruto <= 2427.35) {
            descontoINSS = ((salarioBruto - 1212) * 0.09) + 90.90;
        } else if (salarioBruto > 2427.35 && salarioBruto <= 3641.03) {
            descontoINSS = ((salarioBruto - 2427.35) * 0.12) + 200.28;
        } else if (salarioBruto > 3641.03 && salarioBruto <= 7087.22) {
            descontoINSS = ((salarioBruto - 3641.03) * 0.14) + 345.92;
        } else if (salarioBruto > 7087.22) {
            descontoINSS = 828.39;
        }

        System.out.printf("\nFoi pago R$%.2f ao INSS.", descontoINSS);

        //Calculo IR
        if (salarioBruto <= 1903.98) {
            descontoIR = 0.00;
        } else if (salarioBruto > 1903.98 && salarioBruto<= 2826.65) {
            descontoIR = ((salarioBruto - 1903.98) * 0.075);
        } else if (salarioBruto > 2826.65 && salarioBruto <= 3751.05) {
            descontoIR = ((salarioBruto - 2826.65) * 0.15) + 69.20;
        } else if (salarioBruto > 3751.05 && salarioBruto <= 4664.68) {
            descontoIR = ((salarioBruto - 3751.05) * 0.225) + 207.86;
        } else if (salarioBruto > 4664.68) {
            descontoIR = ((salarioBruto - 4664.68) * 0.275) + 413.42;
        }

        System.out.printf("\nFoi pago R$%.2f de Imposto de Renda.", descontoIR);

        //Calculo salario liquido
        double salarioLiquido = salarioBruto - descontoINSS - descontoIR;
        System.out.printf("\nO salário líquido é de R$%.2f", salarioLiquido);
    }
}
