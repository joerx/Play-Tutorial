package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Model representing tasks. Uses EBean for storage
 */
@Entity
public class Task extends Model {

  /**
   * Task id
   */
  @Id
  public Long id;

  /**
   * Task label
   */
  @Required
  public String label;

  /**
   * Finder to find tasks in the repository
   */
  public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);

  /**
   * Find all tasks in the repository
   * @return the list of tasks
   */
  public static List<Task> all() {
    return find.all();
  }

  /**
   * Create a new task
   * @param task the task to store
   */
  public static void create(Task task) {
    task.save();
  }

  /**
   * Delete a task with given id
   * @param id the id of the task to delete
   */
  public static void delete(Long id) {
    find.ref(id).delete();
  }
}
