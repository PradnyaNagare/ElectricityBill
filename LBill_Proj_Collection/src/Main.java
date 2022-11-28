import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) throws SQLException {
		ElectricityBoard electricityBoard = new ElectricityBoard();

		List<ElectricityBill> billList = electricityBoard.generateBill("ElectricityBill.txt");

		System.out.println("Bills parsed from file...");
		for (ElectricityBill bill : billList) {
			System.out.println(String.format("id: %s, name: %s, address: %s, units: %d, bill: %f",
					bill.getConsumerNumber(),
					bill.getConsumerName(),
					bill.getConsumerAddress(),
					bill.getUnitsConsumed(),
					bill.getBillAmount())
					);
		}

		// Adding bills to the database
		electricityBoard.addBill(billList);


		System.out.println("Bills retrieved from file ElectricityBill...");

		ArrayList<ElectricityBill> al = new ArrayList<>();
		for (ElectricityBill bill : billList) {

			System.out.println("id : " + bill.getConsumerNumber() 
			+ "  name : " + bill.getConsumerName() 
			+ "  address : " + bill.getConsumerAddress() 
			+ "  units : " + bill.getUnitsConsumed()
			+ "  bill : " + bill.getBillAmount());
		}


	}
}