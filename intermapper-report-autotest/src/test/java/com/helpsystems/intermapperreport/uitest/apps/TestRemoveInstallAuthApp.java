package com.helpsystems.intermapperreport.uitest.apps;

import com.helpsystems.intermapperreport.uitest.utils.InterMapperReportConstants;
import static com.helpsystems.intermapperreport.uitest.utils.InterMapperReportConstants.*;
import com.helpsystems.intermapperreport.uitest.base.AppsBaseTest;
import static com.helpsystems.intermapperreport.uitest.utils.LocatorsConstants.*;

/**
 * class for testing  Remove/Install IM Auth App functionality 
 * 
 * @author Lilit Grigoryan
 * 
 */
public class TestRemoveInstallAuthApp extends AppsBaseTest {

	@Override
	public void init() throws Exception {
		
		interMapperReportBaseValidator.login(DEFAULT_USERNAME, DEFAULT_PASSWORD);
	}

	@Override
	public void testBody() throws Exception {
		
		// Go to Manage Apps page
		interMapperReportBaseValidator.openManageApps();
		
		// Click Remove button		
		interMapperReportBaseValidator.clickOnItem(REMOVE_AUTH_BUTTON_XPATH);
		
		// Accept alert
		interMapperReportBaseValidator.acceptAlert();
		
	}

	@Override
	public void validation() throws Exception {
		
		// Validate the links/headers on the page.
		appsValidator.validateAuthAppRemoved();
		
		// Go to Home page
		interMapperReportBaseValidator.openHome();
		
		// Validate the links/headers on the page.
		appsValidator.validateAppsPageAuthAppRemoved();		
		
		// Go to Manage Apps page
		interMapperReportBaseValidator.openManageApps();

		// Click Install button		
		interMapperReportBaseValidator.clickOnItem(INSTALL_AUTH_BUTTON_XPATH);	
		
		// Accept alert
		interMapperReportBaseValidator.acceptAlert();
		
		// Validate the links/headers on the page.
		appsValidator.validateManageAppsPage();
		
		// Go to Home page
		interMapperReportBaseValidator.openHome();
		
		// Validate the links/headers on the page.
		appsValidator.validateAppsPage();	
		
	}

	@Override
	public void cleanUp() throws Exception {
		
		// Log out from the server
		interMapperReportBaseValidator.logout();
	}

	@Override
	public String getOwner() {
		return InterMapperReportConstants.LILIT;
	}
}
