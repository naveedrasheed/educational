package jhtp.ch_10.console;

import jhtp.ch_10.console.*;

public class PayRoll_Test
{
	public static void main (String[] args)
	{
		SalariedEmployee salariedEmployee=new SalariedEmployee("N","R","333",800);
		
		HourlyEmployee hourlyEmployee=new HourlyEmployee("P","K","111",16.75,40);
		
		CommissionEmployee commissionEmployee=new CommissionEmployee("A","D","222",10000,.06);
		
		BasePlusCommissionEmployee basePluseCommissionEmployee=new BasePlusCommissionEmployee
			("h","g","777",500,.04,300);
			
			Employee employees[]={salariedEmployee,hourlyEmployee,commissionEmployee,basePluseCommissionEmployee};
			
			System.out.println ("Process undergoing Polymorphically\n");
			
			for(Employee currentEmployee : employees)
			{
				System.out.println (currentEmployee);
				
				if(currentEmployee instanceof BasePlusCommissionEmployee)
				{
					BasePlusCommissionEmployee employee=(BasePlusCommissionEmployee)currentEmployee;
					
					double oldBaseSalary=employee.getBaseSalary();
					
					employee.setBaseSalary(1.10*oldBaseSalary);
					System.out.printf ("Increased Salary by 10%% is %.2f\n",employee.getBaseSalary());
				}
				System.out.printf ("Earned :\t$%,.2f\n",currentEmployee.earnings());
			}
			
			for (int i = 0; i<employees.length; i++)
				System.out.printf ("Employee %d: is a %s\n",i,employees[i].getClass().getName());
	}
}