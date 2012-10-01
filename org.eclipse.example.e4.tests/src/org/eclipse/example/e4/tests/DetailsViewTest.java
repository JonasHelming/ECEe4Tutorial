package org.eclipse.example.e4.tests;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.example.e4.DetailsView;
import org.eclipse.example.e4.model.Contact;
import org.eclipse.example.e4.model.ModelFactory;

public class DetailsViewTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SWTViewTestHelper swtViewTestHelper = new SWTViewTestHelper();
		Shell shell = swtViewTestHelper.createShell();
		DetailsView detailsView = new DetailsView(shell);
		Contact contact = ModelFactory.eINSTANCE.createContact();
		contact.setName("Test");
		detailsView.setInput(contact);
		swtViewTestHelper.runShell(shell);
	}

}
