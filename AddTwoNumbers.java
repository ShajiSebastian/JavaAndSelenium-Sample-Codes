import javax.swing.JOptionPane;


public class AddTwoNumbers {

	public static void main(String[] args) {
		String FirstNo = JOptionPane.showInputDialog("enter first no:");
		String SecNo = JOptionPane.showInputDialog("enter Second no:");
		Integer sum =Integer.parseInt( FirstNo) +Integer.parseInt( SecNo);
		System.out.println("Sum1 is "+sum);
	
	}

}
