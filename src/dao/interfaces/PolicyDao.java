package dao.interfaces;

import dao.model.Policy;

/**
 * Created by Rico on 6/13/15.
 */
public interface PolicyDao {
    boolean addPolicy(Policy u);
    boolean updatePolicy(Policy u);
    boolean deletePolicy(Policy u);
    Policy getPolicyByPolicyId(int id);
}
