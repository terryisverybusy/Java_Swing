package dao.interfaces;

import dao.model.Policy;

import java.util.List;

/**
 * Created by Rico on 6/13/15.
 */
public interface PolicyDao {
    boolean addPolicy(Policy u);

    boolean updatePolicy(Policy u);

    boolean deletePolicy(Policy u);

    Policy getPolicyByPolicyId(long id);

    List<Policy> getPolicyByUserId(long uid);

    List<Policy> getPolicyByVehicleId(long vid);
}
