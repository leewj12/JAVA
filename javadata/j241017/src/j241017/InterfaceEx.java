package j241017;

public class InterfaceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamsungPhone phone = new SamsungPhone();
		
		phone.printLogo();
		phone.sendCall();
		phone.receiveCall();
		phone.receiveMsg();
		phone.flash();
		
		SamsungPhone sphone = new SamsungPhone();
		
		int sum = sphone.calculate(100, 200);
		System.out.println(sum);
		
		sphone.printLogo();
		sphone.sendCall();
		sphone.receiveCall();
		sphone.receiveMsg();
		sphone.flash();
	}

}
