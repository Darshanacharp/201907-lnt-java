package in.conceptarchitect.finance;

public class BankAccountCsvParser implements BankAccountParser {

	@Override
	public BankAccount parse(String line) {
		// TODO Auto-generated method stub
		String [] parts= line.split(",");
		
		String type= parts[0];
		int accountNumber= Integer.parseInt(parts[1]);
		String name=parts[2];
		String password=parts[3];
		double balance=Double.parseDouble(parts[4]);
		
		if(type.equals("SavingsAccount"))
				return new SavingsAccount(accountNumber,name,password,balance);
		else if(type.equals("CurrentAccount"))
				return new CurrentAccount(accountNumber,name,password,balance);
		else if(type.equals("OverdraftAccount")) {
			double odLimit= Double.parseDouble(parts[5]);
			OverdraftAccount a=new OverdraftAccount(accountNumber, name, password, balance);
			a.odLimit=odLimit;
			return a;
		}

		throw new AccountParseException("Unable To Parse :"+line);
		
		
	}

}
