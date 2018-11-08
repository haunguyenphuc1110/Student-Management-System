package edu.tdt.service;

import javax.ejb.Remote;

/**
 *
 * @author HAU
 */
@Remote
public interface SystemLoginRemote {
    
    void insertUser(String userName, String userPassword);
    String getUserPassword(String username);
    void changePassword(String username, String newPassword);
    void update_State(String userName, boolean log_in);
    boolean findState(String userName);
}
