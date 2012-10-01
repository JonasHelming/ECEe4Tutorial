package org.eclipse.example.e4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.example.e4.model.ContactService;
import org.eclipse.example.e4.model.ModelFactory;
import org.eclipse.example.e4.model.provider.SWTExampleHelper;


public class ContactsView {

	@Inject
	ESelectionService selectionService;
	
	@Inject
	ContactService contactService;
	
	private TreeViewer viewer;
	
	
	@Inject
	public ContactsView(Composite parent){
		viewer = SWTExampleHelper.createTreeViewer(parent);
	}
	
	@PostConstruct
	void init(){
		viewer.setInput(contactService.getRootGroup());
		SWTExampleHelper.connectTreeViewerWithSelectionService(viewer, selectionService);
	}
	
	@PreDestroy
	void dispose(){
		SWTExampleHelper.dispose(viewer);
	}
	

	
	
}
