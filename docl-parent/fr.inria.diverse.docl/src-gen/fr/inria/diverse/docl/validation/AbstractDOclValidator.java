/*
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.docl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractDOclValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(fr.inria.diverse.docl.docl.DoclPackage.eINSTANCE);
		return result;
	}
	
}
