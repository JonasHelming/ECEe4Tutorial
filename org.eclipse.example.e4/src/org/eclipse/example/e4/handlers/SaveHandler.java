package org.eclipse.example.e4.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SaveHandler {

	@Inject
	EPartService partService;

	@Execute
	void execute() {
		partService.saveAll(false);
	}

	@CanExecute
	boolean canExecute() {
		return !partService.getDirtyParts().isEmpty();
	}
}