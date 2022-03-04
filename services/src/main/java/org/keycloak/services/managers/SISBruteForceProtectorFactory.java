/*
 * create SIS brute force protector
 */

package org.keycloak.services.managers;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

/**
 * @author <a href="mailto:nalin.nik@gmail.com">Nalin Kularathna</a>
 * @version $Revision: 1 $
 */
public class SISBruteForceProtectorFactory implements BruteForceProtectorFactory {
    SISBruteForceProtector protector;

    @Override
    public BruteForceProtector create(KeycloakSession session) {
        return protector;
    }

    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        protector = new SISBruteForceProtector(factory);
        protector.start();

    }

    @Override
    public void close() {
        protector.shutdown();

    }

    @Override
    public String getId() {
        return "default-brute-force-detector";
    }
}
