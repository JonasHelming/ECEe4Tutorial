package org.eclipse.example.e4.model.provider;



import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public abstract class SWTExampleHelper {

	public static TreeViewer createTreeViewer(Composite parent) {
		TreeViewer viewer = new TreeViewer(parent);
		AdapterFactory adapterFactory = new ModelItemProviderAdapterFactory();
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		return viewer;
	}

	public static void connectTreeViewerWithSelectionService(TreeViewer viewer,
			final ESelectionService selectionService) {
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection){
					selectionService.setSelection(((IStructuredSelection) selection).getFirstElement());
				}
				
			}
		});
		
	}

	public static void dispose(TreeViewer viewer) {
		viewer.getLabelProvider().dispose();
		viewer.getContentProvider().dispose();
		
	}
}
