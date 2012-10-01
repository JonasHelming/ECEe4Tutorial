package org.eclipse.example.services;

import org.eclipse.example.e4.model.ContactGroup;
import org.eclipse.example.e4.model.ContactService;
import org.eclipse.example.e4.model.ModelFactory;

public class ContactsServiceImpl implements ContactService{

	@Override
	public ContactGroup getRootGroup() {
		return ModelFactory.eINSTANCE.createExampleModel();
	}
	
}
