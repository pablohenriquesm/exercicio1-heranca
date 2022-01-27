/*Uma empresa possui funcion�rios pr�prios e terceirizados.
Para cada funcion�rio, deseja-se registrar nome, horas
trabalhadas e valor por hora. Funcion�rios terceirizado
possuem ainda uma despesa adicional.
O pagamento dos funcion�rios corresponde ao valor da hora
multiplicado pelas horas trabalhadas, sendo que os
funcion�rios terceirizados ainda recebem um b�nus
correspondente a 110% de sua despesa adicional.
Fazer um programa para ler os dados de N funcion�rios (N
fornecido pelo usu�rio) e armazen�-los em uma lista. Depois
de ler todos os dados, mostrar nome e pagamento de cada
funcion�rio na mesma ordem em que foram digitados*/

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Emter the number of employees: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			
			if(ch == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				list.add( new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS");
		for(Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		
		sc.close();

	}

}
