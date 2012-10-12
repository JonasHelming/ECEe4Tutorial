package org.eclipse.example.e4;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.example.e4.model.ContactEntry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("restriction")
public class DetailsView {
	
	private Text text;

	@Inject
	public DetailsView(Composite parent){
		text = new Text(parent, SWT.NONE);
	}
	
	@Inject
	public void setInput(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional ContactEntry contactEntry){
		if(contactEntry== null){
			return;
		}
		if(contactEntry.getName()==null){
			text.setText("");
		}
		else{
			text.setText(contactEntry.getName());
		}
	}
	

}
