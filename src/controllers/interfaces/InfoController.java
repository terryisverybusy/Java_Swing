package controllers.interfaces;

import dao.impl.file.*;
import dao.model.Policy;
import dao.model.User;

import java.util.List;

public interface InfoController {
    List<Policy> getPolicies(User u);
}
