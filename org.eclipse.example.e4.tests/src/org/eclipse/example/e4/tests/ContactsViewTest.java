package org.eclipse.example.e4.tests;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.example.e4.ContactsView;

public class ContactsViewTest{

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		SWTViewTestHelper swtViewTestHelper = new SWTViewTestHelper();
		Shell shell = swtViewTestHelper.createShell();
		
		new ContactsView(shell);
		
		swtViewTestHelper.runShell(shell);
	}

}
