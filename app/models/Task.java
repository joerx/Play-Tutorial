package models;

import play.data.validation.Constraints.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jhenning
 * Date: 10/20/12
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Task {

  public Long id;

  @Required
  public String label;

  public static List<Task> all() {
    return new ArrayList<Task>();
  }

  public static void create(Task task) {

  }

  public static void delete(Long id) {

  }
}
