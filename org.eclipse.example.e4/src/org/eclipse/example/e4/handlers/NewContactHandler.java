package org.eclipse.example.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.example.e4.model.Contact;
import org.eclipse.example.e4.model.ContactEntry;
import org.eclipse.example.e4.model.ContactService;
import org.eclipse.example.e4.model.ModelFactory;
import org.eclipse.example.e4.parts.DetailsView;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class NewContactHandler {

	@Execute
	void execute(Shell shell, ContactService service, IEventBroker broker) {
		final Contact newContact = ModelFactory.eINSTANCE.createContact();
		TitleAreaDialog dialog = new TitleAreaDialog(shell) {

			private DetailsView v;

			@Override
			protected Control createDialogArea(Composite parent) {
				setTitle("Create New Contact");
				setMessage("Enter new contact's details");
				v = new DetailsView(parent);
				v.setInput(newContact);
				Control control = v.getControl();
				control.setLayoutData(new GridData(GridData.FILL_BOTH));
				return control;
			}

			@Override
			protected void okPressed() {
				v.save();
				super.okPressed();
			}
		};
		if (dialog.open() == Dialog.OK) {
			EList<ContactEntry> contacts = service.getRootGroup().getContacts();
			contacts.add(newContact);
			broker.post("contacts/new", newContact);
		}
	}
}