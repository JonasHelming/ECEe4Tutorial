package org.eclipse.example.services;

import org.eclipse.example.e4.model.ContactGroup;
import org.eclipse.example.e4.model.ContactService;
import org.eclipse.example.e4.model.ModelFactory;

public class ContactsServiceImpl implements ContactService {
	ContactGroup model = ModelFactory.eINSTANCE.createExampleModel();

	@Override
	public ContactGroup getRootGroup() {
		return model;
	}
}
