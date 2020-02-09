package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
/*Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
N funcionários. Não deve haver repetição de id.
Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
conforme exemplos.
Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
aumento por porcentagem dada.*/

import entities.Funcionario;
public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <Funcionario> lista = new ArrayList<>();
		
		
		System.out.print("How many employees will be registered?");
		int n = sc.nextInt();
		boolean teste = false;
		
		for(int i=0;i<n;i++) {
			System.out.printf("Emplyoee #%d:%n",i+1);
			System.out.print("Id: ");
			int id = sc.nextInt();

			for(Funcionario x: lista) {
				if(x.getId() == id) {
				teste = true;
				}
				else {
					teste = false;
				}
			}
			
			while(teste == true) {
				System.out.println("Id existente, favor digitar um novo!");
				System.out.print("Id: ");
				id = sc.nextInt();
				for(Funcionario x: lista) {
					if(x.getId() == id) {
					teste = true;
					}
					else {
						teste = false;
					}
				}
			}
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salario = sc.nextDouble();
			
			lista.add(new Funcionario(id,name,salario));
		}
		
		System.out.print("Enter the employee id that will have salary increase :");
		int newid = sc.nextInt();
		Funcionario teste2 = lista.stream().filter(x -> x.getId() == newid).findFirst().orElse(null);
		if(teste2 == null) {
			System.out.println("Id não existente, favor digitar um novo!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			teste2.aumentarSalario(percentage);
		}

		System.out.println("List of employees: ");
		for(Funcionario list : lista) {
			System.out.println(list);
		}
		
		
		sc.close();

	}

}
