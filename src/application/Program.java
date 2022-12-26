package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Nivel: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salarial: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName)); 
		
		System.out.print("Quantos contratos esse trabalhador vai ter? ");
		int n = sc.nextInt();
		
		for (int i=1; i<n; i++) {
			System.out.println("Entre com o numeto de contrato: " + i );
			System.out.print("DATA (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Dura��o do contrato (horas) : ");
			int hours = sc.nextInt();
			HourContract cotract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(cotract);
					
			
		}
		System.out.println();
		System.out.print("Entre com o m�s e ano para calcular o sal�rio: (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartament().getName());
		System.out.println("Renda: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		sc.close();

	}

}
