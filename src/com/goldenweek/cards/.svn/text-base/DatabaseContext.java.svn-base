package com.goldenweek.cards;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;


/**
 * {@link PersistenceManager}を利用可能にするクラス。
 *
 * @author Junichiro
 */
public class DatabaseContext {

	private static final PersistenceManager persistenceManager;

	static {
		PersistenceManagerFactory factory
				= JDOHelper.getPersistenceManagerFactory("transactions-optional");
		persistenceManager = factory.getPersistenceManager();
	}

	public static PersistenceManager getPersistenceManager() {
		return persistenceManager;
	}
}
