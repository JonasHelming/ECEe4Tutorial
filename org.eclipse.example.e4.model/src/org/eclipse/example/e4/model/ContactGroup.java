/**
 */
package org.eclipse.example.e4.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contact Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.example.e4.model.ContactGroup#getContacts <em>Contacts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.example.e4.model.ModelPackage#getContactGroup()
 * @model
 * @generated
 */
public interface ContactGroup extends ContactEntry {
	/**
	 * Returns the value of the '<em><b>Contacts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.example.e4.model.ContactEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contacts</em>' containment reference list.
	 * @see org.eclipse.example.e4.model.ModelPackage#getContactGroup_Contacts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContactEntry> getContacts();

} // ContactGroup
