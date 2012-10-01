package org.eclipse.example.e4.tests;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTViewTestHelper {

	private Display display;

	public Shell createShell(){
		display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		return shell;
	}

	public  void runShell(Shell shell){
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	

}
