package org.eclipse.example.e4.parts;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.example.e4.model.ContactEntry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DetailsView {

	@Inject
	MDirtyable part;

	Composite container;
	Text text;

	ContactEntry entry;

	@Inject
	public DetailsView(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		new Label(container, SWT.NONE).setText("Name:");
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				setDirty(true);
			}
		});
	}

	private void setDirty(boolean newValue) {
		if (part != null)
			part.setDirty(newValue);
	}

	@Inject
	@Optional
	public void setInput(
			@Named(IServiceConstants.ACTIVE_SELECTION) ContactEntry entry) {
		this.entry = entry;
		String newValue = (entry == null || entry.getName() == null) ? "" : entry
				.getName();
		text.setText(newValue);
		setDirty(false);
	}

	@Focus
	public void setFocus() {
		text.setFocus();
	}

	@Persist
	public void save() {
		if (entry == null)
			return;
		entry.setName(text.getText());
		setDirty(false);
	}

	public Control getControl() {
		return container;
	}
}
