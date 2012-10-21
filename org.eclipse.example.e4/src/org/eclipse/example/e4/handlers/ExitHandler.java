package org.eclipse.example.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

public class ExitHandler {

	@Execute
	// make sure param is a e4(!).ui.workbench.IWorkbench here!
	void execute(org.eclipse.e4.ui.workbench.IWorkbench wb) {
		wb.close();
	}
}