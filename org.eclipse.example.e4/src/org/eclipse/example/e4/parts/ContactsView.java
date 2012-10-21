package org.eclipse.example.e4.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.example.e4.model.Contact;
import org.eclipse.example.e4.model.ContactService;
import org.eclipse.example.e4.model.provider.SWTExampleHelper;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

public class ContactsView {

	@Inject
	ESelectionService selectionService;

	@Inject
	ContactService service;

	TreeViewer viewer;

	@Inject
	public ContactsView(Composite parent) {
		viewer = SWTExampleHelper.createTreeViewer(parent);
	}

	@PostConstruct
	void init() {
		viewer.setInput(service.getRootGroup());
		SWTExampleHelper.connectTreeViewerWithSelectionService(viewer,
				selectionService);
	}

	@PreDestroy
	void dispose() {
		SWTExampleHelper.dispose(viewer);
	}

	@Focus
	void setFocus() {
		viewer.getControl().setFocus();
	}

	@Inject
	@Optional
	void newContactAdded(@UIEventTopic("contacts/*") Contact newContact) {
		viewer.setSelection(new StructuredSelection(newContact));
	}

}
